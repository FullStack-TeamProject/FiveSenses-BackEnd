package kr.co.edu.main.service;

import kr.co.edu.main.entity.Column;
import kr.co.edu.main.entity.Database;
import kr.co.edu.main.mapper.ColumnMapper;
import kr.co.edu.main.mapper.DatabaseMapper;
import kr.co.edu.main.mapper.OriginalFileMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ColumnService {

    private final ColumnMapper columnMapper;

    @Autowired
    private SqlSession sqlSession;

    public ColumnService(ColumnMapper columnMapper) {
        this.columnMapper = columnMapper;
    }

    @PostConstruct
    public void init() {
        columnMapper.createTable();
    }

    public void ColumnInsert(String ColumnOrigin, String ColumnName, String ColumnType,Long Size,String ColumnTurn) {
        DatabaseMapper mapper = sqlSession.getMapper(DatabaseMapper.class);

        Integer idx = mapper.findFirstIdx();
        Long.valueOf(idx);

        Column column = new Column();
        column.setColumnOrigin(ColumnOrigin);
        column.setColumnName(ColumnName);
        column.setColumnKoreaName(ColumnName);
        column.setColumnType(ColumnType);
        column.setColumnMinSize(Size);
        column.setColumnMaxSize(Size);
        column.setColumnTurn(ColumnTurn);
        column.setDomainId(1L);
        column.setDatabaseId(Long.valueOf(idx));

        System.out.println(column);

        sqlSession.insert("kr.co.edu.main.mapper.ColumnMapper.insertTable",column);
//        sqlSession.commit();
    }
}
