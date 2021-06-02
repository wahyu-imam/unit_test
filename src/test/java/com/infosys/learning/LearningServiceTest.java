package com.infosys.learning;

import com.infosys.learning.dto.Data;
import com.infosys.learning.dto.Person;
import com.infosys.learning.dto.UserRequest;
import com.infosys.learning.model.User;
import com.infosys.learning.repository.UserRepository;
import com.infosys.learning.service.LearningService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearningServiceTest {

    @Autowired private LearningService learningService;

    @MockBean
    @Autowired private UserRepository userRepository;

    @Before
    public void init(){
        Mockito.when(userRepository.findByUserName(anyString())).thenReturn(new User());
        Mockito.when(userRepository.findByUserNameAndPassWord(anyString(), anyString())).thenReturn(new User());
    }

    @Test
    public void getName_shouldSuccess(){
        Assert.assertEquals("John", learningService.getName("man"));
    }

    @Test
    public void getName_shouldNotSuccess(){
        Assert.assertEquals("John", learningService.getName("female"));
    }

    @Test
    public void getNameV2_shouldSuccess(){
        Assert.assertEquals("John", learningService.getNameV2("man").getName());
    }

    @Test
    public void getNameV2_shouldNotSuccess(){
        Assert.assertEquals("John", learningService.getNameV2("female").getName());
    }

    @Test
    public void getNameV3_shouldSuccess(){
        Assert.assertEquals("John Doe", learningService.getNameV3("John"));
    }

    @Test
    public void getNameV3_shouldNotSuccess(){
        Assert.assertEquals("John Doe", learningService.getNameV3("Jane"));
    }

    @Test
    public void getPerson_shouldSuccess(){
        Assert.assertNotNull(learningService.getPersonUmur("Nana", 1998));
    }

    @Test
    public void getPerson_shouldNotSuccess(){
        Object ob = new Object();
        Data data = new Data();
        Person person = new Person();
        person.setName("Nana");
        person.setYearOfBirth(1998);
        data.setAge(24);
        person.setData(data);
        ob = person;
        Assert.assertEquals(ob, learningService.getPersonUmur("Nana", 1998));
    }

    @Test
    public void register_shouldSuccess(){
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("Argus");
        userRequest.setPassword("123Argus");
        Assert.assertEquals("Register Success!", learningService.register(userRequest));
    }

    @Test
    public void login_shouldSuccess(){
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("Argus");
        userRequest.setPassword("123Argus");
        Assert.assertNotNull(learningService.login(userRequest));
    }
}
