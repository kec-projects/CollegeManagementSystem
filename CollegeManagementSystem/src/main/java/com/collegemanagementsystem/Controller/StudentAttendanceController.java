package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Dto.StudentAttendanceDto;
import com.collegemanagementsystem.Service.AttendanceService;
import com.collegemanagementsystem.Service.CsvGeneration;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/student/attendance")
public class StudentAttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private CsvGeneration csvGeneration;

    @RequestMapping(value = "/takeAttendance", method = RequestMethod.POST)
    @ResponseBody
    public void takeAttendance(@RequestBody @Valid StudentAttendanceDto studentAttendanceDto) {
        attendanceService.takeAttendence(studentAttendanceDto);
    }

    @RequestMapping(value = "/getClassAttendance/{classId}", method = RequestMethod.GET)
    @ResponseBody
    public Map getClassAttendance(@PathVariable(value = "classId") Long classId) {
        return attendanceService.getClassAttendance(classId);
    }

    @RequestMapping(value = "/getStudentAttendance/{classId}/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public Map getStudentAttendance(@PathVariable(value = "classId") Long classId, @PathVariable(value = "userId") Long userId) throws IOException {

        return attendanceService.getStudentAttendance(userId, classId);
    }

    @RequestMapping(value = "/getClassStudentAttendance/{classId}/{email}", method = RequestMethod.GET)
    @ResponseBody
    public Map getClassStudentAttendance(@PathVariable(value = "classId") Long classId, @PathVariable(value = "email") String email) throws DocumentException, IOException, MessagingException {
        return attendanceService.classStudentAttendance(classId, email);

    }
}
