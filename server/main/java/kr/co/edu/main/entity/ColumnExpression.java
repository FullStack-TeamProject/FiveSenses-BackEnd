package kr.co.edu.main.entity;

import lombok.Data;

@Data
public class ColumnExpression {
    //칼럼 용어 테이블
    private Long idx;
    private Database database;
    private Long columnExpressionId;
    private Long columnExpressionOrder;

    private Long databaseId;
}
