package raihan.bs23.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Raihan on 6/23/2017.
 */
@Controller
public class AuthenticationController extends BaseController {
    @RequestMapping("/login")
    public String login(){return "login";}

    @RequestMapping("/logout")
    public String logout(){return "logout";}

    @RequestMapping("/home")
    public String home(){return "home"; }

    @RequestMapping("/403")
    public String accessDenied(){return "403";}

}
