package com.example.webservice_ds.data;

import de.tekup.soap.models.whitetest.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;

public class DbTest {
    public  static List<WhiteTestResponse> listOfdata = new ArrayList<>();
    public static List<Student> listOfStudent = new ArrayList<>();
    public static List<Exam> listOfExam = new ArrayList<>();


    static {


        // create an object factory
        ObjectFactory of = new ObjectFactory();

        //creating address
        Address add1 = of.createAddress();
        add1.setCity("Gabes");
        add1.setPostCode(6080);
        add1.setStreet("Rue Mohamed VX 35 beb bhar ");
        Address add2 = of.createAddress();
        add2.setCity("Sfax");
        add2.setPostCode(6005);
        add2.setStreet("15 Rue Fadhel ben achour ");

        // create list of student
        Student s1 = of.createStudent();
        s1.setId(1);
        s1.setName("Saief");
        s1.setAddress(add1);
        Student s2 = of.createStudent();
        s2.setId(2);
        s2.setName("Yahia");
        s2.setAddress(add2);
        Student s3 = of.createStudent();


        // create two exam
        Exam e1 = of.createExam();
        e1.setCode("1z0-808");
        e1.setName("OCA");
        e1.setDisponible(true);
        Exam e2 = of.createExam();
        e2.setCode("1z0-809");
        e2.setName("OCP");
        e2.setDisponible(true);

        // add object created to exam ans student list
        listOfExam.add(e1);
        listOfExam.add(e2);
        listOfStudent.add(s1);
        listOfStudent.add(s2);
        listOfStudent.add(s3);

        // create of three date

        XMLGregorianCalendar xmlGregorianCalendar1 = null;
        XMLGregorianCalendar xmlGregorianCalendar2=null;
        XMLGregorianCalendar xmlGregorianCalendar3=null;
        try {
            xmlGregorianCalendar1 =
                    DatatypeFactory.newInstance().newXMLGregorianCalendar();

            xmlGregorianCalendar2 =
                    DatatypeFactory.newInstance().newXMLGregorianCalendar();

            xmlGregorianCalendar3 =
                    DatatypeFactory.newInstance().newXMLGregorianCalendar();
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        // create three instance of WhiteTestResponse
        // added it to list
        if(xmlGregorianCalendar1 != null){
            WhiteTestResponse wt1 = of.createWhiteTestResponse();
            wt1.setStudent(s1);
            wt1.setExam(e1);
            xmlGregorianCalendar1.setYear(2019);
            xmlGregorianCalendar1.setTime(18,30,15);
            xmlGregorianCalendar1.setDay(9);
            xmlGregorianCalendar1.setMonth(5);
            wt1.setDate(xmlGregorianCalendar1);
            listOfdata.add(wt1);
        }

        if(xmlGregorianCalendar2 != null){
            WhiteTestResponse wt2 = of.createWhiteTestResponse();
            wt2.setStudent(s2);
            wt2.setExam(e2);
            xmlGregorianCalendar2.setYear(2021);
            xmlGregorianCalendar2.setTime(16,28,5);
            xmlGregorianCalendar2.setDay(30);
            xmlGregorianCalendar2.setMonth(1);
            wt2.setDate(xmlGregorianCalendar2);
            listOfdata.add(wt2);
        }

        if(xmlGregorianCalendar3 != null){
            WhiteTestResponse wt3 = of.createWhiteTestResponse();
            wt3.setStudent(s3);
            wt3.setExam(e1);
            xmlGregorianCalendar3.setYear(2020);
            xmlGregorianCalendar3.setTime(12,2,5);
            xmlGregorianCalendar3.setDay(1);
            xmlGregorianCalendar3.setMonth(1);
            wt3.setDate(xmlGregorianCalendar3);
            listOfdata.add(wt3);
        }
    }
}
