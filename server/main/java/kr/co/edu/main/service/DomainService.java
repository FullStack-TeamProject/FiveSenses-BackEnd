package kr.co.edu.main.service;

import kr.co.edu.main.mapper.DomainMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DomainService {
    private final DomainMapper domainMapper;

    public DomainService(DomainMapper domainMapper) {
        this.domainMapper = domainMapper;
    }

    @PostConstruct
    public void init() {domainMapper.createTable();}
}
