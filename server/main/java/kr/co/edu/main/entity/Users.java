package kr.co.edu.main.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class Users implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String email;
}
