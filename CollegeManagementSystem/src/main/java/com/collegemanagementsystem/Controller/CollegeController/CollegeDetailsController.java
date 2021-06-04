package com.collegemanagementsystem.Controller.CollegeController;

import com.collegemanagementsystem.Dto.CollegeDetailsDto;
import com.collegemanagementsystem.Entity.collegeDetailsEntity.CollegeDetails;
import com.collegemanagementsystem.Service.interfaceClass.CollegeDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/college/details")
public class CollegeDetailsController {
    @Autowired
    private CollegeDetailsService collegeDetailsService;
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public Map addCollege(@RequestBody @Valid CollegeDetailsDto collegeDetailsDto)
    {
        return collegeDetailsService.save(collegeDetailsDto);
    }

    @RequestMapping(value="/getAll",method = RequestMethod.GET)
    @ResponseBody
    public List<CollegeDetailsDto> getAll()
    {
        return collegeDetailsService.collegeList();
    }

    @RequestMapping(value="/getCollege",method = RequestMethod.POST)
    @ResponseBody
    public CollegeDetails getCollege(@RequestBody @Valid CollegeDetailsDto collegeDetailsDto)
    {
        return collegeDetailsService.findById(collegeDetailsDto.getId());
    }


}