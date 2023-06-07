package kr.co.edu.main.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DictionaryMapper {

    @Update("CREATE TABLE IF NOT EXISTS Dictionary(id SERIAL PRIMARY KEY, DictionaryCreateDate VARCHAR(255) NOT NULL, DictionaryCreateName VARCHAR(255) NOT NULL, DictionaryModifyDate VARCHAR(255) NOT NULL, DictionaryModifyName VARCHAR(255) NOT NULL, DictionaryKorean VARCHAR(255) NOT NULL, DictionaryEnglish VARCHAR(255) NOT NULL,DictionaryEnglishAb VARCHAR(255) NOT NULL)")
    void createTable();
}
