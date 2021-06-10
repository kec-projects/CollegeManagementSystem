package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Dto.StudentAttendanceDto;
import com.collegemanagementsystem.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/student/attendance")
public class StudentAttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping(value="/takeAttendance",method = RequestMethod.POST)
    @ResponseBody
    public void takeAttendance(@RequestBody @Valid StudentAttendanceDto studentAttendanceDto){
        attendanceService.takeAttendence(studentAttendanceDto);
    }

    @RequestMapping(value="/getClassAttendance/{classId}",method = RequestMethod.GET)
    @ResponseBody
    public Map getClassAttendance(@PathVariable(value = "classId") Long classId){
       return attendanceService.getClassAttendance(classId);
    }

    @RequestMapping(value="/getStudentAttendance/{classId}/{userId}",method = RequestMethod.GET)
    @ResponseBody
    public Map getStudentAttendance(@PathVariable(value = "classId") Long classId,@PathVariable(value = "userId")Long userId){
        return attendanceService.getStudentAttendance(userId,classId);
    }
}