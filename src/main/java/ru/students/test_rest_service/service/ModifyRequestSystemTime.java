package ru.students.test_rest_service.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.students.test_rest_service.model.Request;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ModifyRequestSystemTime implements ModifyRequestService{
    @Override
    public void modifyRq(Request request){
        Date date = new Date();
        SimpleDateFormat dateObject = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss-ms") ;
        request.setSystemTime("s2 : " + dateObject.format(date));
        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        new RestTemplate().exchange("http://localhost:8082/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>(){
                });
    }
}
