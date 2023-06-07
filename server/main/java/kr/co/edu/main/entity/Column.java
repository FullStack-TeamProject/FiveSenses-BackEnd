package kr.co.edu.main.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Column implements Serializable {
    //칼럼 테이블
    private Long idx;
    private Database database;
    private String columnOrigin;
    private String columnName;
    private String columnKoreaName;
    private String columnType;
    private Long columnMinSize;
    private Long columnMaxSize;
    private String columnTurn;
    private Long domainId;

    private Long databaseId;
    private Domain domain;

}
