package kr.co.edu.main.entity;

import lombok.Data;

@Data
public class DatabaseDefine {
    //테이블 이름을 정의할 테이블
    private Database database;
    private Long idx;
    private String databaseDirectionExpressId;
    private Long databaseOrder;
    private Long databaseIdx;
}
