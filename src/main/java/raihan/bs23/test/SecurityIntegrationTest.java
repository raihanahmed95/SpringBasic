package raihan.bs23.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import raihan.bs23.model.UserEntity;

import javax.servlet.Filter;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Raihan on 7/23/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config/spring-config.xml","classpath:spring-config/spring-security-config.xml"})
@WebAppConfiguration
public class SecurityIntegrationTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;
    @Autowired
    private Filter springSecurityFilterChain;
    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(this.context)
                .addFilters(this.springSecurityFilterChain)
                .build();
    }

    @Test
    public void unauthorizedAccessIsntAThing() throws Exception {
        mvc.perform(
                get("/projectProfile")
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isMovedTemporarily());
    }

    @Test
    public void authorizedAccess() throws Exception{
        mvc.perform(
                get("/projectProfile")
                        .with(user("admin")
                                .password("123")
//                                .roles("USER"))) //forbidden access 403
                                .roles("ADMIN")))
                .andExpect(status().isOk());
    }

    @Test
    public void testLoginPostController() throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("admin");
        userEntity.setPassword("123");

        this.mvc.perform(post("/j_spring_security_check")
                    .param("j_username", userEntity.getUsername())
                    .param("j_password", userEntity.getPassword()))
                .andExpect(status().is3xxRedirection())
                .andExpect(authenticated())
                .andExpect(redirectedUrl("/home"));
    }

    @Test
    public void testLogoutPostController() throws Exception{
        this.mvc.perform(post("/j_spring_security_logout"))
                .andExpect(status().is3xxRedirection())
                .andExpect(unauthenticated())
                .andExpect(redirectedUrl("/logout"));
    }
}
