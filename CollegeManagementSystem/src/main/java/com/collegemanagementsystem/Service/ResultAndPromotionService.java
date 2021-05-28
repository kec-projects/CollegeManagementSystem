package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Entity.ResultEntity.PracticalEntity;
import com.collegemanagementsystem.Entity.ResultEntity.SgpaEntity;
import com.collegemanagementsystem.Entity.ResultEntity.TheoryEntity;
import com.collegemanagementsystem.Repository.ResultRepository.PracticalRepository;
import com.collegemanagementsystem.Repository.ResultRepository.SgpaRepository;
import com.collegemanagementsystem.Repository.ResultRepository.TheoryRepository;
import com.collegemanagementsystem.Repository.StudentRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResultAndPromotionService {
    @Autowired
    private SgpaRepository sgpaRepository;
    @Autowired
    private TheoryRepository theoryRepository;
    @Autowired
    private PracticalRepository practicalRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;


    public void resultScrap(String url, String sem) throws IOException {
        String finalSem = "";
        String finalUrl = "";
        switch (sem) {
            case "1":
                finalSem = "I";
                break;
            case "2":
                finalSem = "II";
                break;
            case "3":
                finalSem = "III";
                break;
            case "4":
                finalSem = "IV";
                break;
            case "5":
                finalSem = "V";
                break;
            case "6":
                finalSem = "VI";
                break;
            case "7":
                finalSem = "VII";
                break;
            case "8":
                finalSem = "VIII";
                break;
        }
        List regList = studentService.getRegistrationNo(sem);
        for (Object reg : regList) {
            try {
                finalUrl = url + "?Sem=" + finalSem + "&RegNo=" + reg;
                Document doc = Jsoup.connect(finalUrl).get();
                Elements noRecord = doc.select("table[id=ctl00_ContentPlaceHolder1_GridView3]");
                if (!(noRecord.text().equals("No Record Found !!!"))) {

                    Elements examinationYear = doc.select("table[id=ctl00_ContentPlaceHolder1_DataList2]");
                    Elements examYear = examinationYear.select("td[class=style5]");
                    Elements theories = doc.select("table[id=ctl00_ContentPlaceHolder1_GridView1]");
                    Elements practical = doc.select("table[id=ctl00_ContentPlaceHolder1_GridView2]");
                    Elements sgpa = doc.select("span[id=ctl00_ContentPlaceHolder1_DataList5_ctl00_GROSSTHEORYTOTALLabel]");

                    //Examination Year
                    String year = examYear.text().substring(26);

                    Long millis = System.currentTimeMillis();
                    java.sql.Date date = new java.sql.Date(millis);
                    List<String> tempMarkList = new ArrayList<>();


                    //Sgpa Entry
                    SgpaEntity sgpaEntity = new SgpaEntity();
                    sgpaEntity.setSgpa((sgpa.text()));
                    sgpaEntity.setSem(sem);
                    sgpaEntity.setReg(reg.toString());
                    sgpaEntity.setYear(year);
                    sgpaEntity.setTimeStamp(date);
                    sgpaRepository.save(sgpaEntity);


                    //Theory Data Entry

                    for (Element theory : theories) {
                        Elements subjects = theory.select("tr");
                        for (Element sub : subjects) {
                            tempMarkList.clear();
                            Elements marks = sub.select("td");
                            for (Element mark : marks) {
                                tempMarkList.add(mark.text());
                            }
                            if (tempMarkList.size() != 0) {
                                TheoryEntity theoryEntity = new TheoryEntity();
                                theoryEntity.setSubCode(tempMarkList.get(0));
                                theoryEntity.setSubName(tempMarkList.get(1));
                                theoryEntity.setEse(tempMarkList.get(2));
                                theoryEntity.setIa(tempMarkList.get(3));
                                theoryEntity.setTotal(tempMarkList.get(4));
                                theoryEntity.setGrade(tempMarkList.get(5));
                                theoryEntity.setCredit(tempMarkList.get(6));
                                theoryEntity.setTimeStamp(date);
                                theoryEntity.setYear(year);
                                theoryEntity.setSem(sem);
                                theoryEntity.setRegistrationNo(reg.toString());
                                theoryRepository.save(theoryEntity);
                            }
                        }
                    }

                    // practical data entry


                    for (Element theory : practical) {
                        Elements subjects = theory.select("tr");
                        for (Element sub : subjects) {
                            tempMarkList.clear();
                            Elements marks = sub.select("td");
                            for (Element mark : marks) {
                                tempMarkList.add(mark.text());
                            }
                            if (tempMarkList.size() != 0) {
                                PracticalEntity practicalEntity = new PracticalEntity();
                                practicalEntity.setYear(year);
                                practicalEntity.setSem(sem);
                                practicalEntity.setRegistrationNo(reg.toString());
                                practicalEntity.setSubCode(tempMarkList.get(0));
                                practicalEntity.setSubName(tempMarkList.get(1));
                                practicalEntity.setEse(tempMarkList.get(2));
                                practicalEntity.setIa(tempMarkList.get(3));
                                practicalEntity.setTotal(tempMarkList.get(4));
                                practicalEntity.setGrade(tempMarkList.get(5));
                                practicalEntity.setCredit(tempMarkList.get(6));
                                practicalEntity.setTimeStamp(date);
                                practicalRepository.save(practicalEntity);
                            }
                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    // promote service
    public void promote(String sem) {
        int semester = Integer.parseInt(sem);
        List studentList = studentService.getRegistrationNo(sem);
        if (semester % 2 == 0) {
            for(Object student:studentList){
                String sgpa1=sgpaRepository.getSgpa(student.toString(),sem);
                String sgpa2=sgpaRepository.getSgpa(student.toString(),((semester-1)+""));
                if(sgpa1!=null&&sgpa2!=null){
                    Double total=Double.parseDouble(sgpa1)+Double.parseDouble(sgpa2);
                    if(total>=10.0){
                        if(semester==8){
                            studentRepository.promoteStudent(student.toString(), ("Graduated"));
                        }
                        else{
                            studentRepository.promoteStudent(student.toString(), ((semester + 1) + ""));
                        }
                    }
                    else{
                        studentRepository.promoteStudent(student.toString(), ((semester - 1) + ""));
                    }
                }
            }
           } else {
            for (Object student : studentList) {
                studentRepository.promoteStudent(student.toString(), ((semester + 1) + ""));

            }
        }
    }
}
