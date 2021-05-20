package com.example.webservice_ds.endpoint;

import com.example.webservice_ds.service.ExamService;
import com.example.webservice_ds.service.WhiteTestService;
import de.tekup.soap.models.whitetest.ExamListResponse;
import de.tekup.soap.models.whitetest.ExamRequest;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

public class WtEnPn {
    public static final String nameSpace="http://www.tekup.de/soap/models/whitetest";

    @Autowired
    private WhiteTestService WhiteTestservice;

    @Autowired
    private ExamService Examservice;


    // student, date and test information
    @PayloadRoot(namespace = nameSpace, localPart = "StudentRequest")
    @ResponsePayload
    public WhiteTestResponse getTestStatus(@RequestPayload StudentRequest customerRequest) {

        WhiteTestResponse whiteTestResponse =WhiteTestservice.checkWhiteTest(customerRequest);
        return whiteTestResponse;
    }

    //list of exam available
    @PayloadRoot(namespace = nameSpace, localPart = "ExamRequest")
    @ResponsePayload
    public ExamListResponse getListDisponible(@RequestPayload ExamRequest examRequest){
        return Examservice.TestExam();
    }
}
