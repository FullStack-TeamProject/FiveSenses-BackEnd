package kr.co.edu.main.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface TestMapper {

    @Update("CREATE TABLE IF NOT EXISTS Test (id SERIAL PRIMARY KEY)")
    void createTable();
}
