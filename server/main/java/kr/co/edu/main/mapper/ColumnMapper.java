package kr.co.edu.main.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ColumnMapper {

    @Update("CREATE TABLE IF NOT EXISTS ColumnTable (idx SERIAL PRIMARY KEY, ColumnOrigin VARCHAR(255) NOT NULL, ColumnName VARCHAR(255) NOT NULL, ColumnKoreaName VARCHAR(255) NOT NULL, ColumnType VARCHAR(255) NOT NULL, ColumnMinSize INT NOT NULL, ColumnMaxSize INT NOT NULL, ColumnTurn VARCHAR(255) NOT NULL, DomainId INT NOT NULL CONSTRAINT fk_spring_DomainId REFERENCES DomainTable(id), DatabaseId INT NOT NULL CONSTRAINT fk_spring_DatabaseId REFERENCES Database(id))")
    void createTable();


    @Insert("INSERT INTO ColumnTable ( columnOrigin, columnName, columnKoreaName,columnType, columnMinSize, columnMaxSize, columnTurn,domainId,databaseId) VALUES ( #{columnOrigin}, #{columnName},#{columnKoreaName},#{columnType}, #{columnMinSize}, #{columnMaxSize}, #{columnTurn},#{domainId},#{databaseId})")
    void insertTable();
}
