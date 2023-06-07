package kr.co.edu.main.service;

import kr.co.edu.main.dao.MainDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 메인 비즈니스로직 입니다.
 *
 * @author 000
 * @since 2023.04.28
 */
@Service
public class MainService {

    @Autowired
    private MainDAO mainDAO;

    /**
     * 데이터 조회 테스트
     *
     * @author 000
     * @since 2023.04.28
     */
    public List<HashMap<String, Object>> testDataSelectList (HashMap<String, Object> params) throws Exception {
        return mainDAO.testDataSelectList(params);
    }
}
