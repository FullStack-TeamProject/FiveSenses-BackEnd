package kr.co.edu.main.web;

import kr.co.edu.main.entity.OriginalFile;
import kr.co.edu.main.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * 메인 Controller 입니다.
 *
 * @author 000
 * @since 2023.04.28
 */
/*@Slf4j*/
@Controller
public class MainController {

    @Autowired
    private MainService mainService;

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private OriginalFileService originalFileService;

    @Autowired
    private ColumnService columnService;
    @Autowired
    private DatasetDefaultService datasetDefaultService;

    /**
     * 메인 ROOT URL
     *
     * @author 000
     * @since 2023.04.28

    @RequestMapping(value = "/")
    public String main (HashMap<String, Object> params) throws Exception {
        List<HashMap<String, Object>> testDataList = mainService.testDataSelectList(params);
        System.out.println("testDataList size : " + testDataList.size());
        for (int i = 0; i < testDataList.size(); i++) {
            System.out.println("testDataList.get(" + i + ").get(\"test_seq\") : " + testDataList.get(i).get("test_seq"));
            System.out.println("testDataList.get(" + i + ").get(\"test_title\") : " + testDataList.get(i).get("test_title"));
            System.out.println("testDataList.get(" + i + ").get(\"test_content\") : " + testDataList.get(i).get("test_content"));
            System.out.println("testDataList.get(" + i + ").get(\"test_create_datetime\") : " + testDataList.get(i).get("test_create_datetime"));
            System.out.println("");
        }
        return "/index";
    } */

    @RequestMapping(value = "/")
    public ModelAndView main (HashMap<String, Object> params) throws Exception {
        ModelAndView mav = new ModelAndView("jsonView");
        //*************** 데이터 조회 테스트 (시작) *********************//
        List<HashMap<String, Object>> testDataList = mainService.testDataSelectList(params);
        System.out.println("testDataList size : " + testDataList.size());
        for (int i = 0; i < testDataList.size(); i++) {
            System.out.println("testDataList.get(" + i + ").get(\"test_seq\") : " + testDataList.get(i).get("test_seq"));
            System.out.println("testDataList.get(" + i + ").get(\"test_title\") : " + testDataList.get(i).get("test_title"));
            System.out.println("testDataList.get(" + i + ").get(\"test_content\") : " + testDataList.get(i).get("test_content"));
            System.out.println("testDataList.get(" + i + ").get(\"test_create_datetime\") : " + testDataList.get(i).get("test_create_datetime"));
            System.out.println("");
        }
        //*************** 데이터 조회 테스트 (종료) *********************//
        mav.addObject("testDataList", testDataList);
        return mav;
    }

    @RequestMapping(value = "/test.json")
    public ModelAndView test (HashMap<String, Object> params) throws Exception {
        ModelAndView mav = new ModelAndView("jsonView");
        //*************** 데이터 조회 테스트 (시작) *********************//
        List<HashMap<String, Object>> testDataList = mainService.testDataSelectList(params);
        System.out.println("testDataList size : " + testDataList.size());
        for (int i = 0; i < testDataList.size(); i++) {
            System.out.println("testDataList.get(" + i + ").get(\"test_seq\") : " + testDataList.get(i).get("test_seq"));
            System.out.println("testDataList.get(" + i + ").get(\"test_title\") : " + testDataList.get(i).get("test_title"));
            System.out.println("testDataList.get(" + i + ").get(\"test_content\") : " + testDataList.get(i).get("test_content"));
            System.out.println("testDataList.get(" + i + ").get(\"test_create_datetime\") : " + testDataList.get(i).get("test_create_datetime"));
            System.out.println("");
        }
        //*************** 데이터 조회 테스트 (종료) *********************//
        mav.addObject("testDataList", testDataList);
        return mav;
    }

    @RequestMapping(value = "/test2.json", method = {RequestMethod.GET, RequestMethod.POST})
    @CrossOrigin(origins = "*")
    public ModelAndView test2 (@RequestBody HashMap<String, Object> params) throws Exception {
        ModelAndView mav = new ModelAndView("jsonView");

        return mav;
    }

    @RequestMapping(value= "/testing", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<String> test(@RequestParam("name")String name){
        /*log.info(name);*/
        return ResponseEntity.ok("Hello, " + name);
    }


    /*
    * Database 생성하기위한
    * */

    @RequestMapping(value = "/Database", method = RequestMethod.GET)
    public ResponseEntity<String> Database(@RequestParam("DatabaseKorean") String dbKorean,@RequestParam("DatabaseSW") String databaseSW, @RequestParam("DatabaseName") String dbname){

        databaseService.insert(dbKorean, databaseSW, dbname);
        return ResponseEntity.ok("성공했습니다");

    }

    @RequestMapping(value = "/OriginalFile", method = RequestMethod.GET)
    public ResponseEntity<String> OriginalFile(@RequestParam("fileOrigin") String fileOrigin,@RequestParam("fileSaveName") String fileSaveName, @RequestParam("fileSaveDirection") String fileSaveDirection,@RequestParam("fileSize") String fileSize,@RequestParam("fileType") String fileType){

        originalFileService.insert(fileOrigin, fileSaveName, fileSaveDirection,fileSize,fileType);
        return ResponseEntity.ok("성공했습니다");
    }


    //배열 받기
    @RequestMapping(value = "/ColumnArray", method = RequestMethod.POST)
    public ModelAndView ColumnArray(@RequestBody HashMap<String, Object> params) {
        ModelAndView mav = new ModelAndView("jsonView");
        //String[] receivedArray = request.getArray();

        System.out.println("@@@@@@@@@@@@@@@ params.size : " + params.size());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return mav;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/xmlArray", method = RequestMethod.POST)
    public ModelAndView xmlArray(@RequestBody HashMap<String, Object> params) {
        ModelAndView mav = new ModelAndView("jsonView");
        //String[] receivedArray = request.getArray();


        //파일의 크기는 그대로 넘겨주신 값이기때문에 이렇게 설정.
        HashMap<String, Object> size = params;
        System.out.println(params);
        //파일의 제목을 가져와서 얻는것
        HashMap<String, Object> specificSize = (HashMap<String, Object>) size.get("202304_연도별 현황");
        //rowData에 해당하는 배열을 가져와서 배열로 만듬.
        ArrayList<ArrayList<Object>> rowData = (ArrayList<ArrayList<Object>>) specificSize.get("rowData");
        //columnData에 대한 배열을 가져와서 배열로 만듬
        ArrayList<Object> columnDatas = (ArrayList<Object>) specificSize.get("columnDatas");


        //System.out.println(columnDatas);

        ArrayList<String> ColumnName = new ArrayList<>();

        //originalColumnName 가져오는 코드.
        for (Object columnData : columnDatas) {
            Map<String, Object> columnDataMap = (Map<String, Object>) columnData;
            String originColumnName = (String) columnDataMap.get("originColumnName");
            ColumnName.add(originColumnName);
            //System.out.println(originColumnName);
            // originColumnName 값을 이용하여 필요한 작업 수행
        }

        //columnValues를 가져오는 코드
        List<ArrayList<Map<String, Object>>> columnValuesList = new ArrayList<>();

        for (Object column : columnDatas) {
            Map<String, Object> columnDataMap = (Map<String, Object>) column;
            ArrayList<Map<String, Object>> columnValues = (ArrayList<Map<String, Object>>) columnDataMap.get("columnValues");
            columnValuesList.add(columnValues);
        }
        //System.out.println(columnValuesList);


// 주어진 배열의 길이를 반복하여 처리, 컬럼의 각 타입에 대해서 배열로 가져오는 것.
        List<List<Map<String, Object>>> extractedDataList = new ArrayList<>();

        for (ArrayList<Map<String, Object>> dataList : columnValuesList) {
            List<Map<String, Object>> extractedData = new ArrayList<>();

            for (Map<String, Object> dataMap : dataList) {
                extractedData.add(dataMap);

                // 배열의 길이만큼 데이터를 가져왔으면 반복문 종료
                if (extractedData.size() == dataList.size()) {
                    break;
                }
            }

            extractedDataList.add(extractedData);

            // 배열의 길이만큼 데이터를 가져왔으면 반복문 종료
            if (extractedDataList.size() == columnValuesList.size()) {
                break;
            }
        }

// 각 배열의 길이만큼 dataType 값을 가져오는 리스트 생성
        List<List<Object>> extractedDataTypeList = new ArrayList<>();

        for (List<Map<String, Object>> dataList : extractedDataList) {
            List<Object> extractedDataType = new ArrayList<>();

            for (Map<String, Object> dataMap : dataList) {
                Object dataType = dataMap.get("dataType");
                extractedDataType.add(dataType);

                // 배열의 길이만큼 데이터를 가져왔으면 반복문 종료
                if (extractedDataType.size() == dataList.size()) {
                    break;
                }
            }

            extractedDataTypeList.add(extractedDataType);

            // 배열의 길이만큼 데이터를 가져왔으면 반복문 종료
            if (extractedDataTypeList.size() == extractedDataList.size()) {
                break;
            }
        }


        //column content 가져오는 코드.

        int arrayLength = rowData.get(0).size(); // 배열의 길이

        ArrayList<Object>[] newArray = new ArrayList[arrayLength]; // 새로운 배열 생성

        // 각 배열 요소 초기화
        for (int i = 0; i < arrayLength; i++) {
            newArray[i] = new ArrayList<>();
        }
        // 새로운 배열에 값을 추가 각열에 data를 새 배열에 넣어서 배열을 만듬
        for (ArrayList<Object> innerArray : rowData) {
            for (int i = 0; i < innerArray.size(); i++) {
                Object value = innerArray.get(i);
                newArray[i].add(value);
            }
        }

        //새로 만든 배열만큼 반복하여서 출력. /*이후 db에 값 넣는거 까지 진행해야함*/
        for (int i = 0; i< newArray.length; i++) {
            System.out.println(ColumnName.get(i));
            System.out.println(newArray[i]);
            //System.out.println(extractedDataTypeList.get(i));
       }

        System.out.println("@@@@@@@@@@@@@@@ params.size : " + params.size());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return mav;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/xmlArray2", method = RequestMethod.POST)
    public ResponseEntity xmlArray2(@RequestBody HashMap<String, Object> params) {

        //System.out.println(params);

        String tableName = (String) params.get("tableName");
        String fileType  = (String)params.get("fileType");
        String fileOrigin = (String)params.get("fileOrigin");
        String fileSaveName = (String)params.get("fileSaveName");
        Integer fileSize = (Integer) params.get("fileSize");
        String fileSavedirection = (String)params.get("fileSavedirection");
        ArrayList<ArrayList<Object>> rowData = (ArrayList<ArrayList<Object>>) params.get("rowData");
        ArrayList<Object> columnDatas = (ArrayList<Object>) params.get("columnDatas");

        ArrayList<String> originColumnNames = new ArrayList<>();
        ArrayList<String> displayColumnNames = new ArrayList<>();
        ArrayList<Integer> sizes = new ArrayList<>();
        ArrayList<String> dataTypes = new ArrayList<>();
        ArrayList<String> dbDataTypes = new ArrayList<>();

        //column이름,크기,datatype,dbdatatype들고와서 저장.
        for (Object columnData : columnDatas) {
            HashMap<String, Object> columnMap = (HashMap<String, Object>) columnData;

            String originColumnName = (String) columnMap.get("originColumnName");
            String displayColumnName = (String) columnMap.get("displayColumnName");
            int size = (int) columnMap.get("size");
            String dataType = (String) columnMap.get("dataType");
            String dbDataType = (String) columnMap.get("dbDataType");

            originColumnNames.add(originColumnName);
            displayColumnNames.add(displayColumnName);
            sizes.add(size);
            dataTypes.add(dataType);
            dbDataTypes.add(dbDataType);
        }



        //originalfile db insert
//        originalFileService.insert(fileOrigin, fileSaveName, fileSavedirection,String.valueOf(fileSize),fileType);
        System.out.println(fileOrigin);
        System.out.println(fileSaveName);
        System.out.println(fileSavedirection);
        System.out.println(String.valueOf(fileSize));
        System.out.println(fileType);
        System.out.println("-------------------------");

        //database db insert
        String databaseSW = "N";
//        databaseService.insert(tableName, databaseSW, tableName);
        System.out.println(tableName);
        System.out.println(databaseSW);
        System.out.println(tableName);
        System.out.println("-------------------------");


        int arrayLength = rowData.get(0).size(); // 배열의 길이

        ArrayList<Object>[] newArray = new ArrayList[arrayLength]; // 새로운 배열 생성

        // 각 배열 요소 초기화
        for (int i = 0; i < arrayLength; i++) {
            newArray[i] = new ArrayList<>();
        }
        // 새로운 배열에 값을 추가 각열에 data를 새 배열에 넣어서 배열을 만듬
        for (ArrayList<Object> innerArray : rowData) {
            for (int i = 0; i < innerArray.size(); i++) {
                Object value = innerArray.get(i);
                newArray[i].add(value);
            }
        }


//        column db insert
        for(int i=0; i<originColumnNames.size(); i++) {
            System.out.println("Origin Column Names: " + originColumnNames.get(i));
            System.out.println("Display Column Names: " + displayColumnNames.get(i));
            System.out.println("Sizes: " + sizes.get(i));
            System.out.println("Data Types: " + dataTypes.get(i));
            System.out.println("DB Data Types: " + dbDataTypes.get(i));
        System.out.println(i);
//            컬럼 데이터 생성
//        columnService.ColumnInsert(originColumnNames.get(i),
//                originColumnNames.get(i),
//                dataTypes.get(i),
//                Long.valueOf(sizes.get(i)),
//                String.valueOf(i));
            System.out.println(newArray[i]);
//            datasetDefaultService.datasetInsert(tableName,newArray[1],originColumnNames.get(i),dbDataTypes.get(i));
        }



// 각 배열의 길이만큼 dataType 값을 가져오는 리스트 생성
//        ModelAndView mav = new ModelAndView("jsonView");
        return ResponseEntity.ok(newArray);
    }
}
