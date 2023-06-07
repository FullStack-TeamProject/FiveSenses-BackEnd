package kr.co.edu.main.mapper;

import kr.co.edu.main.entity.Database;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DatabaseMapper {

    @Insert("INSERT INTO database ( databaseName, databaseKorean, databaseStandWehter, originalFileIdx)VALUES ( #{databaseName}, #{databaseKorean},#{databaseStandWehter},#{originalFileIdx})")
    void insertData(Database database);


    @Update("CREATE TABLE IF NOT EXISTS Database (id SERIAL PRIMARY KEY, databaseName VARCHAR(255) NOT NULL, databaseKorean VARCHAR(255) NOT NULL, databaseStandWehter VARCHAR(255) NOT NULL, OriginalFileIdx INT NOT NULL CONSTRAINT fk_spring_OriginalFileIdx REFERENCES OriginalFile(id))")
    void createTable();

    @Select("SELECT MAX(id) FROM Database")
    Integer findFirstIdx();
}
