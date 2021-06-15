package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.StudentAttendanceDto;
import com.collegemanagementsystem.Entity.AttendanceEntity.ClassAttendanceEntity;
import com.collegemanagementsystem.Entity.AttendanceEntity.StudentAttendanceEntity;
import com.collegemanagementsystem.Entity.SubjectTeacherEntity;
import com.collegemanagementsystem.Repository.ClassAttendanceRepository;
import com.collegemanagementsystem.Repository.StudentAttendanceRepository;
import com.google.api.client.util.ArrayMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AttendanceService {
    @Autowired
    private ClassAttendanceRepository classAttendanceRepository;
    @Autowired
    private StudentAttendanceRepository studentAttendanceRepository;
    @Autowired
    private SubjectTeacherService subjectTeacherService;
    @Autowired
            private StudentService studentService;
    @Autowired
            private CsvGeneration csv;

    Long millis = System.currentTimeMillis();
    java.sql.Date date = new java.sql.Date(millis);
    java.sql.Time time = new java.sql.Time(millis);

    //function to take attendance and save it to database
    public Map takeAttendence(StudentAttendanceDto studentAttendanceDto) {
        Map msg=new HashMap();
        ClassAttendanceEntity classAttendanceEntity = new ClassAttendanceEntity();
        classAttendanceEntity.setClassId(studentAttendanceDto.getClassId());
        classAttendanceEntity.setDate(date);
        classAttendanceEntity.setTime(time);
        classAttendanceRepository.save(classAttendanceEntity);
        for (Object student : studentAttendanceDto.getPresentStudent()) {
            Long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            java.sql.Time time = new java.sql.Time(millis);
            StudentAttendanceEntity studentAttendanceEntity = new StudentAttendanceEntity();
            studentAttendanceEntity.setStatus("present");
            studentAttendanceEntity.setDate(date);
            studentAttendanceEntity.setTime(time);
            studentAttendanceEntity.setClassId(studentAttendanceDto.getClassId());
            studentAttendanceEntity.setUserId(Long.parseLong(student.toString()));
            studentAttendanceRepository.save(studentAttendanceEntity);
        }
        for (Object student : studentAttendanceDto.getAbsentStudent()) {
            Long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            java.sql.Time time = new java.sql.Time(millis);
            StudentAttendanceEntity studentAttendanceEntity = new StudentAttendanceEntity();
            studentAttendanceEntity.setStatus("absent");
            studentAttendanceEntity.setDate(date);
            studentAttendanceEntity.setTime(time);
            studentAttendanceEntity.setClassId(studentAttendanceDto.getClassId());
            studentAttendanceEntity.setUserId(Long.parseLong(student.toString()));
            studentAttendanceRepository.save(studentAttendanceEntity);
        }
        msg.put("status","Successfull");
        msg.put("message","Attendance successfully taken");
        return msg;
    }

    // fn return class attendance
    public Map getClassAttendance(Long classId) {
        Map msg=new HashMap();
        List<ClassAttendanceEntity> count = classAttendanceRepository.getClassAttendanceCount(classId);
        msg.put("id",classId);
        msg.put("totalClass",count.size());
        List totalCls=new ArrayList();
        for(ClassAttendanceEntity cls:count){
            Map temp=new HashMap();
            temp.put("date",cls.getDate());
            temp.put("time",cls.getTime());
            totalCls.add(temp);
        }
        msg.put("desc",totalCls);
        return msg;
    }

    //fn to return student attendance
    public Map getStudentAttendance(Long userId,Long classId){
       Map msg=new HashMap();
       List<StudentAttendanceEntity> list = studentAttendanceRepository.getStudentAttendance(classId,userId);
       msg.put("totalClass",list.size());
       msg.put("userId",userId);
       msg.put("classId",classId);
       List present=new ArrayList();
       List absent=new ArrayList();
       for(StudentAttendanceEntity stud:list){
           if(stud.getStatus().equals("present")){
               Map temp=new HashMap();
               temp.put("date",stud.getDate());
               temp.put("time",stud.getTime());
               present.add(temp);
           }
           else{
               Map temp=new HashMap();
               temp.put("date",stud.getDate());
               temp.put("time",stud.getTime());
               absent.add(temp);
           }
       }
       msg.put("present_Desc",present);
       msg.put("absent_Desc",absent);
       msg.put("present_Days",present.size());
       msg.put("absent_Days",absent.size());
       msg.put("percentage",(present.size()/list.size()*100.0));

        return msg;
    }
    public Map classStudentAttendance(Long classId){
        List<ClassAttendanceEntity> count= classAttendanceRepository.getClassAttendanceCount(classId);
        Map subDetails= subjectTeacherService.getSubjectDetails(classId);
        List<Long> studentList= studentService.getUserId((String) subDetails.get("Semester"));
        System.out.println(studentList);
        System.out.println(subDetails);
        System.out.println(count);
        subDetails.put("Total Class",count.size());
        String[] details = new String[100];
        List<String[]> completeDetails = new ArrayList<>();
        int i=0;
        details[i++]="UserId";
        details[i++]="Student Name";
        details[i++]="Registration No";

        for(ClassAttendanceEntity c:count){
            details[i++]= String.valueOf(c.getDate());
        }
        details[i++]="Total";
        details[i++]="Percentage";
        completeDetails.add(details);
        for(Long student:studentList){
            List<StudentAttendanceEntity> li= studentAttendanceRepository.getStudentAttendance(classId,student);
            for(StudentAttendanceEntity l:li){
            }
       //     System.out.println(cls.getDate());
        }
        csv.createCsv(subDetails,completeDetails);
        return null;
    }
}
