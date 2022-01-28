package an.challenge.entelgy.service;

import an.challenge.entelgy.models.Data;
import an.challenge.entelgy.models.ResponseAPI;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@Service
public class EntelgyRestService {

    public Map<String, List<Data>> restructure() {
        try {
            String uri = getUrl();
            RestTemplate restTemplate = new RestTemplate();
            ResponseAPI result = restTemplate.getForObject(uri, ResponseAPI.class);

            HashMap<String, List<Data>> data = new HashMap<>();
            data.put("data", result.getData());
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getUrl() {
        InputStream iStream = null;
        Properties properties = new Properties();
        try {
            iStream = new FileInputStream("src/main/resources/application.properties");
            properties.load(iStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(iStream != null){
                    iStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties.getProperty("url");
    }
}
