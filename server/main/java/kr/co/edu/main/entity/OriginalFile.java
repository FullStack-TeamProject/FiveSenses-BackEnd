package kr.co.edu.main.entity;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class OriginalFile implements Serializable  {
    //원본 파일 저장 테이블
    private long idx;
    private String fileOrigin;
    private String fileSaveName;
    private String fileSaveDirection;
    private String fileSize;
    private String fileType;

}
