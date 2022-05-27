package com.hanxiao.spring_mall.typehandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:
 * @author: Han Xiao
 * @date: 2022/5/27
 **/
@MappedTypes(Integer[].class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class IntegerArrayTypeHandler implements TypeHandler<Integer[]> {
    //is AutoWired ok?
    @Autowired
    ObjectMapper objectMapper;

    @SneakyThrows
    @Override
    public void setParameter(PreparedStatement ps, int i, Integer[] parameter, JdbcType jdbcType) throws SQLException {
        String input = objectMapper.writeValueAsString(parameter);
        ps.setString(i, input);
    }

    @SneakyThrows
    @Override
    public Integer[] getResult(ResultSet rs, String columnName) throws SQLException {
        String string = rs.getString(columnName);
        return getIntegers(string);
    }

    @SneakyThrows
    @Override
    public Integer[] getResult(ResultSet rs, int columnIndex) throws SQLException {
        String string = rs.getString(columnIndex);
        return getIntegers(string);
    }

    @SneakyThrows
    @Override
    public Integer[] getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String string = cs.getString(columnIndex);
        return getIntegers(string);
    }

    private Integer[] getIntegers(String string) throws JsonProcessingException {
        if (StringUtils.isEmpty(string)) {
            return new Integer[0];
        }
        return objectMapper.readValue(string, Integer[].class);
    }
}
