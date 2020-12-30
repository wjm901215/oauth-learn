package com.spiderman.security.dao;

import com.spiderman.security.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public UserDto getUserByUsername(String username) {
        String sql = "select id,username,password,fullname from t_user where username = ?";
        List<UserDto> list = jdbcTemplate.query(sql, new Object[]{username}, new
                BeanPropertyRowMapper<>(UserDto.class));
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }
}