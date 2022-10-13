package ru.students.test_rest_service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.students.test_rest_service.model.Response;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Qualifier("ModifySystemTime")
public class ModifySystemTime implements MyModifyService{
    @Override
    public Response modify (Response response){
        Date date = new Date();
        SimpleDateFormat dateObject = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss-ms") ;
        response.setSystemTime(dateObject.format(date));
        return response;
    }
}
