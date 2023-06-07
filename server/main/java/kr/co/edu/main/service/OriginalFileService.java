package kr.co.edu.main.service;

import kr.co.edu.main.entity.OriginalFile;
import kr.co.edu.main.mapper.DatabaseMapper;
import kr.co.edu.main.mapper.OriginalFileMapper;
import kr.co.edu.main.mapper.UserMapper;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Slf4j
@Service
public class OriginalFileService {


    @Autowired
    private SqlSession sqlSession;
    @Autowired
    private final OriginalFileMapper originalFileMapper;

    public OriginalFileService(OriginalFileMapper originalFileMapper) {
        this.originalFileMapper = originalFileMapper;
    }

    @PostConstruct
    public void init() {
        originalFileMapper.createTable();
    }

    public void insert(String fileOrigin, String fileSaveName, String fileSaveDirection, String fileSize, String fileType){
        OriginalFile originalFile = new OriginalFile();
        originalFile.setFileOrigin(fileOrigin);
        originalFile.setFileSaveName(fileSaveName);
        originalFile.setFileSaveDirection(fileSaveDirection);
        originalFile.setFileSize(fileSize);
        originalFile.setFileType(fileType);

        sqlSession.insert("kr.co.edu.main.mapper.OriginalFileMapper.InsertOriginalFile",originalFile);
//        sqlSession.commit();
//        sqlSession.close();
    }

    public Integer findFirstidx() {
        OriginalFileMapper mapper = sqlSession.getMapper(OriginalFileMapper.class);

        Integer idx = mapper.findFirstIdx();

        return idx;
    }
}
