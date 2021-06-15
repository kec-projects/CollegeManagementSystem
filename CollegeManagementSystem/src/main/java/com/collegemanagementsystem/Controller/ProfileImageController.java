package com.collegemanagementsystem.Controller;

import com.collegemanagementsystem.Dto.ProfileImageDto;
import com.collegemanagementsystem.Service.ProfileImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/users/profile")
public class ProfileImageController {
    @Autowired
    private ProfileImageService profileImageService;

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)/*,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)*/
    public Map uplaodImage(@RequestBody @Valid ProfileImageDto profileImageDto ) throws IOException {
      return  profileImageService.saveImage(profileImageDto);
    }

    @ResponseBody
    @RequestMapping(value="/get/{id}",method=RequestMethod.GET)
    public Map getImage(@PathVariable("id") Long id){
       return profileImageService.getImage(id);
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public  Map updateImage(@RequestBody @Valid ProfileImageDto profileImageDto){
        return profileImageService.updateImage(profileImageDto);
    }
}
