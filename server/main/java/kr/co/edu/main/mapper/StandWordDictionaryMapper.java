package kr.co.edu.main.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StandWordDictionaryMapper {

    @Update("CREATE TABLE IF NOT EXISTS StandWordDictionary (idx SERIAL PRIMARY KEY, StandWordDictionaryNo INT NOT NULL, StandWordDictionaryWordName VARCHAR(255) NOT NULL, StandWordDictionaryWordEnglish VARCHAR(255) NOT NULL)")
    void createTable();
}
