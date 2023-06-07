package kr.co.edu.main.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class Database implements Serializable {
    //데이터베이스화 시킬 테이블
    private long idx;
    private String databaseName;
    private String databaseKorean;
    private String databaseStandWehter;
    private OriginalFile originalFile;
    private Long originalFileIdx;
}
