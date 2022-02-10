package an.challenge.entelgy;

import an.challenge.entelgy.models.Data;
import an.challenge.entelgy.models.ResponseAPI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EntelgyRestTests {

    @Mock
    List<String> responseMock;
    @Mock
    StringBuilder dataUserMock;
    @Mock
    ResponseAPI resultMock;


    @Test
    public void restructure() {

    }


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
}
