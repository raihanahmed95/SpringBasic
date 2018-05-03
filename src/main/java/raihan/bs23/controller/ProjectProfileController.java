package raihan.bs23.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Raihan on 7/3/2017.
 */
@Controller
public class ProjectProfileController {

    @RequestMapping("/projectProfile")
    public String profile(){return "profile";}
}
