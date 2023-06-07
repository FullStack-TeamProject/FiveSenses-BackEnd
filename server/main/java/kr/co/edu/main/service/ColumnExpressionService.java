package kr.co.edu.main.service;

import kr.co.edu.main.mapper.ColumnExpressionMapper;
import kr.co.edu.main.mapper.ColumnMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ColumnExpressionService {

    private final ColumnExpressionMapper columnExpressionMapper;

    public ColumnExpressionService(ColumnExpressionMapper columnExpressionMapper) {
        this.columnExpressionMapper = columnExpressionMapper;
    }

    @PostConstruct
    public void init() {
        columnExpressionMapper.createTable();
    }
}
