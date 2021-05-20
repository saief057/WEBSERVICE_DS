package com.example.webservice_ds.service;

import com.example.webservice_ds.data.DbTest;
import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.ExamListResponse;
import de.tekup.soap.models.whitetest.ObjectFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {
    public ExamListResponse TestExam(){
        ExamListResponse examListResponse = new ObjectFactory().createExamListResponse();
        List<Exam> examsResponse = examListResponse.getExamList();
        List<Exam> exams = DbTest.listOfExam;
        exams.stream()
                .filter(x->x.isDisponible())
                .forEach(x->examsResponse.add(x));
        return examListResponse;

    }
}
