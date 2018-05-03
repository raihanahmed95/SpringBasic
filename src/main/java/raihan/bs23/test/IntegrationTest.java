package raihan.bs23.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Created by Raihan on 7/20/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config/spring-config.xml","classpath:spring-config/spring-security-config.xml"})
@WebAppConfiguration
public class IntegrationTest {
    @Autowired
    WebApplicationContext wac;

    @Autowired
    MockHttpSession session;

    @Autowired
    MockHttpServletRequest request;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getAccount() throws Exception {
//        UserDomain user = new UserDomain();
//        user.setFirstName("johnny");
//
//        session.setAttribute("sessionParm",user);
        this.mockMvc.perform(get("/").session(session)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void registerUser() throws Exception {
        this.mockMvc.perform(post("/register")
                .param("username", "raihan123")
                .param("password", "1234"))
                .andExpect(view().name("registersuccess"));
//                .andExpect(status().isOk());
//                .andExpect(redirectedUrl("/home"));
//                .andExpect(model().attributeHasFieldErrors("signupForm", "email"));
    }

}
