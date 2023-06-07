package kr.co.edu.main.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Domain implements Serializable {
    //도메인 테이블
    private Long idx;
    private String domainType;
    private Long domainMinSize;
    private Long domainMaxSize;
    private String domainFirst;

    private Long dictionaryId;
    private Dictionary dictionary;
}
