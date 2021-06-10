package com.collegemanagementsystem.Controller.CollegeController;

import com.collegemanagementsystem.Dto.SubjectTeacherDto;
import com.collegemanagementsystem.Service.SubjectTeacherService;
import com.collegemanagementsystem.Service.interfaceClass.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/college/subject")
public class SubjectController {
    @Autowired
    private SubjectTeacherService subjectTeacherService;
    @RequestMapping(value="/subjectTeacher/add",method = RequestMethod.POST)
    @ResponseBody
    public Map subjectTeacherAdd(@RequestBody SubjectTeacherDto subjectTeacherDto){

        return subjectTeacherService.saveSubjectTeacher(subjectTeacherDto);

    }
    @RequestMapping(value="/subjectTeacher/get/{userId}/{flag}",method = RequestMethod.GET)
    @ResponseBody
    public List subjectTeacherGet(@PathVariable(value = "userId") Long userId, @PathVariable(value = "flag") String flag){
        return subjectTeacherService.getSubject(userId,flag);
    }
}
