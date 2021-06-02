package com.infosys.learning.service;

import com.infosys.learning.dto.Data;
import com.infosys.learning.dto.Person;
import com.infosys.learning.dto.UserRequest;
import com.infosys.learning.model.User;
import com.infosys.learning.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class LearningService {
    @Autowired
    UserRepository userRepository;

    public String getName(String gender){
        Person person = new Person();

        if ("man".equals(gender)){
            person.setName("John");
        }else{
            person.setName("Jane");
        }
        return person.getName();
    }

    public Person getNameV2(String gender){
        Person person = new Person();
        if ("man".equals(gender)){
            person.setName("John");
        }else{
            person.setName("Jane");
        }
        return person;
    }

    public String getNameV3(String name){
        String fullName = "not identified";

        if ("John".equals(name)){
            fullName = "John Doe";
        }else if ("Jane".equals(name)) {
            fullName = "Jane Done";
        }
        return fullName;
    }

    public Object getPersonUmur(String name, int yearOfBirth){
        Data data = new Data();
        Person person = new Person();
        Object ob = new Object();

        person.setYearOfBirth(yearOfBirth);
        person.setName(name);
        int age = Year.now().getValue() - person.getYearOfBirth();
        data.setAge(age);
        person.setData(data);
        ob = person;
        return ob;
    }

    public String register(UserRequest userRequest){
        User existUser = userRepository.findByUserName(userRequest.getUsername());
        if (existUser != null){
            return "Register failed, username is already exist";
        }
        User user = new User();
        user.setUserName(userRequest.getUsername());
        user.setPassWord(userRequest.getPassword());
        userRepository.save(user);

        return "Register Success !";
    }

    public Object login(UserRequest userRequest){
        User existUser = userRepository.findByUserNameAndPassWord(userRequest.getUsername(), userRequest.getPassword());
        if (existUser != null){
            Object ob = new Object();
            ob = existUser;
            return ob;
        }
        return "";
    }
}
