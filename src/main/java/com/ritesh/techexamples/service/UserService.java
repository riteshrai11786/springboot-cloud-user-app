package com.ritesh.techexamples.service;

import com.ritesh.techexamples.dto.Department;
import com.ritesh.techexamples.dto.ResponseTemplateDTO;
import com.ritesh.techexamples.entity.User;
import com.ritesh.techexamples.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public List<User> findAll() {
        log.info("Inside findAll of UserService");
        return (List<User>) userRepository.findAll();
    }

    public User findUserById(Long id) {
        log.info("Inside findUserById of UserService");
        return userRepository.findByUserId(id);
    }

    public ResponseTemplateDTO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");
        ResponseTemplateDTO vo = new ResponseTemplateDTO();
        User user = userRepository.findByUserId(userId);

        /*Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId()
                        ,Department.class);*/
        Department department =
                restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId()
                        ,Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return  vo;
    }

}
