package kr.co.edu.main.mapper;


import kr.co.edu.main.entity.OriginalFile;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OriginalFileMapper {

    @Insert("INSERT INTO OriginalFile ( fileOrigin, fileType, fileSaveName, fileSaveDirection, fileSize) VALUES ( #{fileOrigin},#{fileType},#{fileSaveName},#{fileSaveDirection},#{fileSize} )")
    void InsertOriginalFile(OriginalFile originalFile);


    @Update("CREATE TABLE IF NOT EXISTS OriginalFile ( id SERIAL PRIMARY KEY, fileOrigin VARCHAR(255) NOT NULL, fileType VARCHAR(255) NOT NULL, fileSaveName VARCHAR(255) NOT NULL, fileSaveDirection VARCHAR(255) NOT NULL, fileSize VARCHAR(255) NOT NULL)")
    void createTable();


    @Select("SELECT MAX(id) FROM OriginalFile")
    Integer findFirstIdx();
}
