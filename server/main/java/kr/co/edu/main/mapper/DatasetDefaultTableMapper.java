package kr.co.edu.main.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface DatasetDefaultTableMapper {


    void datasetDefaultTableCreate(String TableName, ArrayList<Object> columnDatas, String ColumnName, String dbDataType);
}
