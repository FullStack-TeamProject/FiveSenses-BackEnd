package kr.co.edu.main.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * 메인 비즈니스로직에 전달할 데이터 처리 객체 입니다.
 *
 * @author 000
 * @since 2023.04.28
 */
@Mapper
public interface MainDAO {

    /**
     * 데이터 조회 테스트
     *
     * @author 000
     * @since 2023.04.28
     */
    public List<HashMap<String, Object>> testDataSelectList (HashMap<String, Object> params) throws Exception;
}
