package io.github.changebooks.mybatis.provider.sample;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author changebooks@qq.com
 */
public class Application {

    static SqlSession sqlSession = DataSourceConstants.SESSION_FACTORY.openSession(true);
    static CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);

    /**
     * SELECT id, city_name FROM city WHERE (city_name LIKE '%a%' AND city_name LIKE '%i%') ORDER BY city_name ASC, id DESC LIMIT 2 OFFSET 0
     */
    public static final class SelectListTest {

        public static void main(String[] args) {
            String[] conditions = {"city_name LIKE '%a%'", "city_name LIKE '%i%'"};
            String[] orders = {"city_name ASC", "id DESC"};
            Long startRow = 0L;
            Integer pageSize = 2;

            List<City> list = cityMapper.selectList(conditions, orders, startRow, pageSize);
            System.out.println(list);
        }

    }

    /**
     * SELECT COUNT(*) AS aggregate FROM city WHERE (city_name LIKE '%a%' AND city_name LIKE '%i%')
     */
    public static final class SelectCountTest {

        public static void main(String[] args) {
            String[] conditions = {"city_name LIKE '%a%'", "city_name LIKE '%i%'"};

            long size = cityMapper.selectCount(conditions);
            System.out.println(size);
        }

    }

    /**
     * SELECT id, city_name FROM city WHERE (id = ?)
     */
    public static final class SelectOneTest {

        public static void main(String[] args) {
            City record = cityMapper.selectOne(1);
            System.out.println(record);
        }

    }

    /**
     * INSERT INTO city (city_name) VALUES (?)
     */
    public static final class InsertOneTest {

        public static void main(String[] args) {
            City record = new City();
            record.setCityName("Chongqing");

            int affectedRows = cityMapper.insertOne(record);
            System.out.println(affectedRows);
        }

    }

    /**
     * UPDATE city SET city_name = ? WHERE (id = ?)
     */
    public static final class UpdateOneTest {

        public static void main(String[] args) {
            City record = new City();
            record.setId(1);
            record.setCityName("Tianjin");

            int affectedRows = cityMapper.updateOne(record);
            System.out.println(affectedRows);
        }

    }

    /**
     * DELETE FROM city WHERE (id = ?)
     */
    public static final class DeleteOneTest {

        public static void main(String[] args) {
            int affectedRows = cityMapper.deleteOne(1);
            System.out.println(affectedRows);
        }

    }

}
