package kr.co.edu.main.service;

import kr.co.edu.main.mapper.DictionaryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DictionaryService {
    private final DictionaryMapper dictionaryMapper;

    public DictionaryService(DictionaryMapper dictionaryMapper) {
        this.dictionaryMapper = dictionaryMapper;
    }

    @PostConstruct
    public void init() {
        dictionaryMapper.createTable();
    }
}
