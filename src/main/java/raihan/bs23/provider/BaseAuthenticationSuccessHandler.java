package raihan.bs23.provider;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Raihan on 6/23/2017.
 */
public class BaseAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String redirectUrl = "/home";

        if(auth != null)
            response.sendRedirect(redirectUrl);
        super.onAuthenticationSuccess(request,response,authentication);
    }
}
