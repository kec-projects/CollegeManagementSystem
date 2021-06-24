package com.collegemanagementsystem.Service;

import com.collegemanagementsystem.Dto.StudentAttendanceDto;
import com.collegemanagementsystem.Dto.StudentDto;
import com.collegemanagementsystem.Entity.AttendanceEntity.ClassAttendanceEntity;
import com.collegemanagementsystem.Entity.AttendanceEntity.StudentAttendanceEntity;
import com.collegemanagementsystem.Repository.ClassAttendanceRepository;
import com.collegemanagementsystem.Repository.StudentAttendanceRepository;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.IOException;
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
    @Autowired
    private SendEmailService emailService;
    @Autowired
    private ConstantService constantService;
    @Autowired
    private PdfGeneration pdfGeneration;

    //function to take attendance and save it to database
    public void takeAttendence(StudentAttendanceDto studentAttendanceDto) {

        //class attendance recorded
        ClassAttendanceEntity classAttendanceEntity = new ClassAttendanceEntity();
        classAttendanceEntity.setClassId(studentAttendanceDto.getClassId());
        classAttendanceEntity.setDate(constantService.getLocalDate());
        classAttendanceEntity.setTime(constantService.getLocalTime());
        classAttendanceRepository.save(classAttendanceEntity);

        // student attendance
        for (Object student : studentAttendanceDto.getPresentStudent()) {
            StudentAttendanceEntity studentAttendanceEntity = new StudentAttendanceEntity();
            studentAttendanceEntity.setStatus("P");
            studentAttendanceEntity.setDate(constantService.getLocalDate());
            studentAttendanceEntity.setTime(constantService.getLocalTime());
            studentAttendanceEntity.setClassId(studentAttendanceDto.getClassId());
            studentAttendanceEntity.setUserId(Long.parseLong(student.toString()));
            studentAttendanceRepository.save(studentAttendanceEntity);
        }
        for (Object student : studentAttendanceDto.getAbsentStudent()) {
            StudentAttendanceEntity studentAttendanceEntity = new StudentAttendanceEntity();
            studentAttendanceEntity.setStatus("A");
            studentAttendanceEntity.setDate(constantService.getLocalDate());
            studentAttendanceEntity.setTime(constantService.getLocalTime());
            studentAttendanceEntity.setClassId(studentAttendanceDto.getClassId());
            studentAttendanceEntity.setUserId(Long.parseLong(student.toString()));
            studentAttendanceRepository.save(studentAttendanceEntity);
        }

    }

    // fn return class attendance
    public Map getClassAttendance(Long classId) {
        Map msg = new HashMap();
        List<ClassAttendanceEntity> count = classAttendanceRepository.getClassAttendanceCount(classId);
        msg.put("id", classId);
        msg.put("totalClass", count.size());
        List totalCls = new ArrayList();
        for (ClassAttendanceEntity cls : count) {
            Map temp = new HashMap();
            temp.put("date", cls.getDate());
            temp.put("time", cls.getTime());
            totalCls.add(temp);
        }
        msg.put("desc", totalCls);
        return msg;
    }

    //fn to return student attendance
    public Map getStudentAttendance(Long userId, Long classId) {
        Map msg = new HashMap();
        List<StudentAttendanceEntity> list = studentAttendanceRepository.getStudentAttendance(classId, userId);
        msg.put("totalClass", list.size());
        msg.put("userId", userId);
        msg.put("classId", classId);
        List present = new ArrayList();
        List absent = new ArrayList();
        for (StudentAttendanceEntity stud : list) {
            if (stud.getStatus().equals("P")) {
                Map temp = new HashMap();
                temp.put("date", stud.getDate());
                temp.put("time", stud.getTime());
                present.add(temp);
            } else {
                Map temp = new HashMap();
                temp.put("date", stud.getDate());
                temp.put("time", stud.getTime());
                absent.add(temp);
            }
        }
        msg.put("present_Desc", present);
        msg.put("absent_Desc", absent);
        msg.put("present_Days", present.size());
        msg.put("absent_Days", absent.size());
        msg.put("percentage", (present.size() / list.size() * 100.0));

        return msg;
    }

    public Map classStudentAttendance(Long classId, String email) throws DocumentException, IOException, MessagingException {
        List<ClassAttendanceEntity> count = classAttendanceRepository.getClassAttendanceCount(classId);
        Map subDetails = subjectTeacherService.getSubjectDetails(classId);
        List<Long> studentList = studentService.getUserId((String) subDetails.get("Semester"));
        subDetails.put("Total Class", count.size());
        String[] details = new String[100];
        List<String[]> completeDetails = new ArrayList<>();
        int i = 0;
        details[i++] = "UserId";
        details[i++] = "Student Name";
        details[i++] = "Registration No";

        for (ClassAttendanceEntity c : count) {
            details[i++] = String.valueOf(c.getDate());
        }
        details[i++] = "Total Present";
        details[i++] = "Total Abesent";
        details[i++] = "Percentage";
        completeDetails.add(details);
        for (Long student : studentList) {
            List<StudentAttendanceEntity> li = studentAttendanceRepository.getStudentAttendance(classId, student);
            details = new String[1000];
            i = 0;
            details[i++] = (student.toString());
            StudentDto studentDetails = studentService.FindById(student);
            details[i++] = studentDetails.getName();
            details[i++] = studentDetails.getRegistrationNo();
            int absentCount = 0;
            int presentCount = 0;
            for (StudentAttendanceEntity l : li) {
                if (l.getStatus().equals("A")) {
                    absentCount++;
                } else {
                    presentCount++;
                }
                details[i++] = l.getStatus();
            }
            details[i++] = presentCount + "";
            details[i++] = absentCount + "";
            details[i++] = ((presentCount / (count.size() * 1.0)) * 100.0) + "%";

            completeDetails.add(details);
        }
        csv.createCsv(subDetails, completeDetails);
        //  csvToPdf.csvToPdf();
     //   emailService.sendEmail(email, "attendance report", "Please find the attachment", "attendance.csv", "C:\\Users\\MonAmour\\Desktop\\attendance.csv");
        Map msg = new HashMap();
        msg.put("message", "Report Generated and Emailed");
        msg.put("status", "Successful");
      pdfGeneration.generatePdf(subDetails,completeDetails);
        System.out.println(completeDetails.get(0)[1]);
        return msg;
    }
}
