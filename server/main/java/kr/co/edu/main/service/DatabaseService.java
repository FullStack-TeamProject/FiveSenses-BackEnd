package kr.co.edu.main.service;

import kr.co.edu.main.entity.Database;
import kr.co.edu.main.mapper.DatabaseMapper;
import kr.co.edu.main.mapper.OriginalFileMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class DatabaseService {
    @Autowired
    private final DatabaseMapper databaseMapper;
    private SqlSessionTemplate sqlSessionTemplate;
    private InputStream inputStream;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Autowired
    private SqlSession sqlSession;


    public DatabaseService(DatabaseMapper databaseMapper) {
        this.databaseMapper = databaseMapper;
    }

    @PostConstruct
    public void init() {
        databaseMapper.createTable();
    }

//    @PostConstruct
//    public static void DatabaseInput(String[] args) {
//        try (SqlSession session = SqlSessionFactoryHolder.getSqlSessionFactory().openSession()) {
//            DatabaseMapper mapper = session.getMapper(DatabaseMapper.class);
//
//            Database database = new Database();
//            database.setIdx(2);
//            database.setDatabaseName("dbName2");
//            database.setDatabaseKorean("dbKorean2");
//            database.setDatabaseStandWehter("dbsw2");
//
//            mapper.insertData(database);
//
//            session.commit();
//
//        }
//    }

    public void insert(String DatabaseKorean, String DatabaseSW, String DatabaseName) {
        OriginalFileMapper mapper = sqlSession.getMapper(OriginalFileMapper.class);

        Integer idx = mapper.findFirstIdx();
        Long.valueOf(idx);

        Database database = new Database();
        database.setDatabaseKorean(DatabaseKorean); //db한글명
        database.setDatabaseStandWehter(DatabaseSW); //표준화 완료 여부
        database.setDatabaseName(DatabaseName); //db이름
        database.setOriginalFileIdx(Long.valueOf(idx)); //originalfile idx;

        sqlSession.insert("kr.co.edu.main.mapper.DatabaseMapper.insertData",database);
        //sqlSession.commit();
    }



    public void select(){
        databaseMapper.findFirstIdx();
    }


    }

