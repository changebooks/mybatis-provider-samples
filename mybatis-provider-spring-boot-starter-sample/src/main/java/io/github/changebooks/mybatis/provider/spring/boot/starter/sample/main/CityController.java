package io.github.changebooks.mybatis.provider.spring.boot.starter.sample.main;

import io.github.changebooks.mybatis.provider.spring.boot.starter.sample.repository.City;
import io.github.changebooks.mybatis.provider.spring.boot.starter.sample.repository.CityMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author changebooks@qq.com
 */
@RequestMapping("city")
@RestController
public class CityController {

    @Resource
    private CityMapper cityMapper;

    @GetMapping(value = "/select-list")
    public List<City> selectList(@RequestParam("city_name") String cityName) {
        String[] conditions = {"city_name LIKE '%" + cityName + "%'"};
        String[] orders = {"city_name ASC", "id DESC"};
        Long startRow = 0L;
        Integer pageSize = 2;

        return cityMapper.selectList(conditions, orders, startRow, pageSize);
    }

    @GetMapping(value = "/select-count")
    public long selectCount(@RequestParam("city_name") String cityName) {
        String[] conditions = {"city_name LIKE '%" + cityName + "%'"};

        return cityMapper.selectCount(conditions);
    }

    @GetMapping(value = "/select-one")
    public City selectOne(@RequestParam("id") Integer id) {
        return cityMapper.selectOne(id);
    }

    @PostMapping(value = "/insert-one")
    public int insertOne(@RequestParam("city_name") String cityName) {
        City record = new City();
        record.setCityName(cityName);

        return cityMapper.insertOne(record);
    }

    @PostMapping(value = "/update-one")
    public int updateOne(@RequestParam("city_name") String cityName) {
        City record = new City();
        record.setId(1);
        record.setCityName(cityName);

        return cityMapper.updateOne(record);
    }

    @DeleteMapping(value = "/delete-one")
    public int deleteOne(@RequestParam("id") Integer id) {
        return cityMapper.deleteOne(id);
    }

}
