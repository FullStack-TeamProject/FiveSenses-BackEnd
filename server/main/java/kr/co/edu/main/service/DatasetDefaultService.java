package kr.co.edu.main.service;


import kr.co.edu.main.mapper.DatabaseDefineMapper;
import kr.co.edu.main.mapper.DatasetDefaultTableMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DatasetDefaultService {


    private final DatasetDefaultTableMapper datasetDefaultTableMapper;

    public DatasetDefaultService(DatasetDefaultTableMapper datasetDefaultTableMapper) {this.datasetDefaultTableMapper = datasetDefaultTableMapper;}

    public void datasetInsert(String TableName, ArrayList<Object> columnDatas, String ColumnName, String dbDataType) {

        System.out.println(TableName);
        System.out.println(columnDatas);
        System.out.println(ColumnName);
        System.out.println(dbDataType);

        datasetDefaultTableMapper.datasetDefaultTableCreate(TableName, columnDatas,ColumnName, dbDataType);
    }
}
