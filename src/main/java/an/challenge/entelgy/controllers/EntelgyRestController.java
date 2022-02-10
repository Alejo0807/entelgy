package an.challenge.entelgy.controllers;

import an.challenge.entelgy.models.Data;
import an.challenge.entelgy.service.EntelgyRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class EntelgyRestController {

    @Autowired
    EntelgyRestService entelgyRestService;

    @PostMapping("/")
    public Map<String, List<String>> restructure() {
        return entelgyRestService.restructure(entelgyRestService.callAPI());
    }

}
