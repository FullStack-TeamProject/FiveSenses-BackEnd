package kr.co.edu.main.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DomainMapper {


    @Update("CREATE TABLE IF NOT EXISTS DomainTable(id SERIAL PRIMARY KEY, DomainType VARCHAR(255) NOT NULL, DomainMinSize INT NOT NULL, DomainMaxSize INT NOT NULL, DomainFirst VARCHAR(255) NOT NULL,DictionaryId INT NOT NULL CONSTRAINT fk_spring_DictionaryId REFERENCES Dictionary(id))")
    void createTable();
}
