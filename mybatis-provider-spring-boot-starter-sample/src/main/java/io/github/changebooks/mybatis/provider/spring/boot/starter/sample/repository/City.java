package io.github.changebooks.mybatis.provider.spring.boot.starter.sample.repository;

import io.github.changebooks.mybatis.provider.annotation.MybatisResult;
import io.github.changebooks.mybatis.provider.annotation.MybatisResultMap;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;

/**
 * City
 *
 * @author changebooks@qq.com
 */
@MybatisResultMap(table = "city")
public final class City implements Serializable {
    /**
     * ID
     */
    @MybatisResult(column = "id", jdbcType = JdbcType.INTEGER, id = true, autoIncrement = true)
    private Integer id;

    /**
     * City Name
     */
    @MybatisResult(column = "city_name", jdbcType = JdbcType.VARCHAR, id = false, autoIncrement = false)
    private String cityName;

    @Override
    public String toString() {
        return "{" +
                "\"id:\": " + getId() + ", " +
                "\"cityName\": \"" + getCityName() + "\"" +
                "}";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
