package io.github.changebooks.mybatis.provider.spring.boot.starter.sample.repository;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author changebooks@qq.com
 */
public interface CityMapper {
    /**
     * 查询列表
     *
     * @param conditions 查询条件
     * @param orders     排序
     * @param startRow   开始行数
     * @param pageSize   每页行数
     * @return list
     */
    @SelectProvider(type = CityProvider.class, method = "selectList")
    @ResultMap("BaseResultMap")
    List<City> selectList(String[] conditions, String[] orders, Long startRow, Integer pageSize);

    /**
     * 查询总数
     *
     * @param conditions 查询条件
     * @return long
     */
    @SelectProvider(type = CityProvider.class, method = "selectCount")
    long selectCount(String[] conditions);

    /**
     * 通过主键，获取一条记录
     *
     * @param id 主键
     * @return City
     */
    @SelectProvider(type = CityProvider.class, method = "selectOne")
    @ResultMap("BaseResultMap")
    City selectOne(@Param("id") int id);

    /**
     * 新增一条记录
     *
     * @param record City
     * @return 影响行数
     */
    @InsertProvider(type = CityProvider.class, method = "insertOne")
    int insertOne(City record);

    /**
     * 通过主键，修改一条记录
     *
     * @param record City
     * @return 影响行数
     */
    @UpdateProvider(type = CityProvider.class, method = "updateOne")
    int updateOne(City record);

    /**
     * 通过主键，删除一条记录
     *
     * @param id 主键
     * @return 影响行数
     */
    @DeleteProvider(type = CityProvider.class, method = "deleteOne")
    int deleteOne(@Param("id") int id);

}
