package raihan.bs23.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import raihan.bs23.model.BaseResponse;
import raihan.bs23.model.UserEntity;
import raihan.bs23.service.RegistrationService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by Raihan on 6/21/2017.
 */
@Controller
public class RegistrationController  extends BaseController{

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(@ModelAttribute("userEntity") UserEntity userEntity) {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("userEntity") @Valid UserEntity userEntity, BindingResult result, RedirectAttributes redirectAttributes, Model model) {
        if (result.hasErrors()) {
            return "register";
        }

        if(!registrationService.isInfoUsernameUnique(userEntity.getUsername())){
            FieldError usernameError =new FieldError("userEntity","username",messageSource.getMessage("non.unique.username", new String[]{userEntity.getUsername()}, Locale.getDefault()));
            result.addError(usernameError);
            return "register";
        }

        BaseResponse response = registrationService.doRegistration(userEntity);

        if (response.getResponseCode() == 100) {

            model.addAttribute("userEntity", userEntity);
            model.addAttribute("message", "You have successfully registered!");

            return "registersuccess";
        }
        model.addAttribute("message","Invalid attemp!");
        return "register";
    }
}
