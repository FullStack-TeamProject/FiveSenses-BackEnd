package kr.co.edu.main.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Dictionary implements Serializable {
    //용어 테이블
    private Long idx;
    private String dictionaryFine;
    private String dictionaryCreateDate;
    private String dictionaryCreateName;
    private String dictionaryModifyDate;
    private String dictionaryModifyName;
    private String dictionaryKorean;
    private String dictionaryEnglish;
    private String dictionaryEnglishAb;
}
