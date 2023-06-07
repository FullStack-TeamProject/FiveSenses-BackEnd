package kr.co.edu.main.service;

import kr.co.edu.main.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @PostConstruct
    public void init() {
        userMapper.createTable();
    }
}
