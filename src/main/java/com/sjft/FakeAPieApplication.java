package com.sjft;

import com.dtflys.forest.springboot.annotation.ForestScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Mr.Baiyy
 * @version 1.0
 * @ClassName FakeAPieApplication
 * @Description TODO
 * @date 2022/1/19 15:27
 **/
@SpringBootApplication
@ForestScan(basePackages = "com.sjft.forest")
public class FakeAPieApplication {
    public static void main(String[] args) {
        SpringApplication.run(FakeAPieApplication.class, args);
    }
}
