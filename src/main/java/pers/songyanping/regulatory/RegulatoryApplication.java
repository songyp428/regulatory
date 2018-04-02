package pers.songyanping.regulatory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("pers.songyanping.regulatory.dao")
public class RegulatoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegulatoryApplication.class, args);
    }
}
