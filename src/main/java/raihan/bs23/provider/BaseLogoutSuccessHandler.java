package raihan.bs23.provider;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Raihan on 6/23/2017.
 */
public class BaseLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException{
        String redirectUrl = "/logout";

        if(authentication!=null){
            request.getSession().invalidate();
        }
        response.sendRedirect(redirectUrl);
        super.onLogoutSuccess(request,response,authentication);
    }
}
