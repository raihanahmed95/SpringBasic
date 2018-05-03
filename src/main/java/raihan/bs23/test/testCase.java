package raihan.bs23.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import raihan.bs23.encryptor.TextEncryptor;
import raihan.bs23.model.UserEntity;
import raihan.bs23.repository.UserRepository;

import javax.transaction.Transactional;


/**
 * Created by Raihan on 7/13/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config/spring-config.xml","classpath:spring-config/spring-security-config.xml"})
@TransactionConfiguration
@Transactional
public class testCase   {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TextEncryptor textEncryptor;

    @Test
    public void testUsers() throws Exception {
        UserEntity entity=userRepository.getUser(3);
        Assert.assertEquals(entity.getUsername(),"raihan");
    }

    @Test
    public void testPassword() throws Exception{
        String pass = "123";
        String encryptedPass = textEncryptor.encrypt(pass);
        Assert.assertEquals(textEncryptor.dycrypt(encryptedPass),pass);
    }
//    @Autowired
//    private WebApplicationContext wac;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup() {
//        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
//        this.mockMvc = builder.build();
//    }
//
//    @Test
//    public void testMyMvcController() throws Exception {
//        ResultMatcher ok = MockMvcResultMatchers.status().isOk();
//        ResultMatcher msg = MockMvcResultMatchers.model()
//                .attribute("msg", "Spring quick start!!");
//
//        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/");
//        this.mockMvc.perform(builder)
//                .andExpect(ok)
//                .andExpect(msg);
//    }
}
