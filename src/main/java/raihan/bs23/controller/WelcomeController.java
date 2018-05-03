package raihan.bs23.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Raihan on 6/21/2017.
 */
@Controller
public class WelcomeController extends BaseController {

    @RequestMapping(value = "/")
    public String welcome() {
        return "index";
    }

}