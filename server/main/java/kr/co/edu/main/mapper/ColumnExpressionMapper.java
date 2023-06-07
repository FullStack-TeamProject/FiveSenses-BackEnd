package kr.co.edu.main.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ColumnExpressionMapper {

    @Update("CREATE TABLE IF NOT EXISTS ColumnExpression ( id SERIAL PRIMARY KEY, ColumnExpressionId Int NOT NULL, ColumnExpressionOrder INT NOT NULL, DatabaseId INT NOT NULL CONSTRAINT fk_spring_DatabaseId REFERENCES Database(id))")
    void createTable();
}
