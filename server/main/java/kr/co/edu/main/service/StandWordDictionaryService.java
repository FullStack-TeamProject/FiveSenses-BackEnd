package kr.co.edu.main.service;

import kr.co.edu.main.mapper.OriginalFileMapper;
import kr.co.edu.main.mapper.StandWordDictionaryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class StandWordDictionaryService {

    private final StandWordDictionaryMapper standWordDictionaryMapper;

    public StandWordDictionaryService(StandWordDictionaryMapper standWordDictionaryMapper) {
        this.standWordDictionaryMapper = standWordDictionaryMapper;
    }

    @PostConstruct
    public void init() {
        standWordDictionaryMapper.createTable();
    }
}
