package com.infosys.learning;

import com.infosys.learning.model.User;
import com.infosys.learning.repository.UserRepository;
import com.infosys.learning.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    @Autowired
    private UserRepository userRepository;

    @Before
    public void init() {
        Mockito.when(userRepository.getOne(anyInt())).thenReturn(new User());
//        Mockito.when(userRepository.getOne(anyInt())).thenReturn(null);
    }

    @Test
    public void getUser_shouldNotNull() {
        User user = userService.getUser(12);
        Assert.assertNotNull(userService.getUser(1));
    }
}
