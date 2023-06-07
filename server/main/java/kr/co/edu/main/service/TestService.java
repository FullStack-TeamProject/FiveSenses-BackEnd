package kr.co.edu.main.service;


import kr.co.edu.main.entity.Test;
import kr.co.edu.main.mapper.TestMapper;
import kr.co.edu.main.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TestService {

    private final TestMapper testMapper;

    public TestService(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    @PostConstruct
    public void init() {
        testMapper.createTable();
    }
}
