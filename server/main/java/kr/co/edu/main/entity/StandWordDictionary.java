package kr.co.edu.main.entity;

import lombok.Data;

@Data
public class StandWordDictionary {
    //새로 저장할 테이블
    private Long idx;
    private Long standWordDictionaryNo;
    private Long standWordDictionaryWordName;
    private Long standWordDictionaryWordEnglish;
}
