package kr.co.edu.main.mapper;


import kr.co.edu.main.entity.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
//    @Select("SELECT * FROM users")
//    List<Users> findAll();
//    @Select("SELECT * FROM users WHERE id = #{id}")
//    Users findById(Long id);
//
//    @Insert("INSERT INTO users (username, password, email) VALUES (#{username}, #{password}, #{email})")
//    @Options(useGeneratedKeys = true, keyProperty = "id")
//    void insert(Users users);
//
//    @Update("UPDATE users SET username = #{username}, password = #{password}, email = #{email} WHERE id = #{id}")
//    void update(Users users);
//
//    @Delete("DELETE FROM users WHERE id = #{id}")
//    void delete(Long id);

    @Update("CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, username VARCHAR(255) NOT NULL, password VARCHAR(255) NOT NULL, email VARCHAR(255) NOT NULL)")
    void createTable();
}
