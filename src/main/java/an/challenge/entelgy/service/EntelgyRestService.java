package an.challenge.entelgy.service;

import an.challenge.entelgy.models.Data;
import an.challenge.entelgy.models.ResponseAPI;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class EntelgyRestService {

    public Map<String, List<String>> restructure(ResponseAPI result) {

        List<String> response = new ArrayList<>();
        StringBuilder dataUser = new StringBuilder("");
        for (Data data : result.getData()) {
            dataUser.append(data.getId());
            dataUser.append("|");
            dataUser.append(data.getLast_name());
            dataUser.append("|");
            dataUser.append(data.getEmail());
            response.add(dataUser.toString());
            dataUser = new StringBuilder("");
        }

        HashMap<String, List<String>> data = new HashMap<>();
        data.put("data", response);
        return data;

    }

    public ResponseAPI callAPI() {
        try {
            String uri = getUrl();
            RestTemplate restTemplate = new RestTemplate();
            return restTemplate.getForObject(uri, ResponseAPI.class);
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


