package kr.co.edu.main.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DatabaseDefineMapper {

    @Update( "CREATE TABLE IF NOT EXISTS DatabaseDefine (idx SERIAL PRIMARY KEY, DatabaseDirectionExpressId VARCHAR(255) NOT NULL, DatabaseOrder INT NOT NULL, DatabaseIdx INT NOT NULL CONSTRAINT fk_spring_DatabaseIdx REFERENCES Database(id))")
    void createTable();
}
