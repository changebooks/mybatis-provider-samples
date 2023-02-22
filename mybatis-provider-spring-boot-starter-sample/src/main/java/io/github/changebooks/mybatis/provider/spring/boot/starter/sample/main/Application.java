package io.github.changebooks.mybatis.provider.spring.boot.starter.sample.main;

import io.github.changebooks.mybatis.provider.spring.boot.starter.EnableMybatisProvider;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author changebooks@qq.com
 */
@SpringBootApplication
@EnableMybatisProvider
@MapperScan(basePackages = {"io.github.changebooks.mybatis.provider.spring.boot.starter.sample.repository"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
