package io.github.alice52.craftsman;

import common.swagger.annotation.EnableSwagger;

import io.github.alice52.craftsman.config.CraftsmanConfig;

import lombok.extern.slf4j.Slf4j;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Starter
 *
 * <p>COLA framework initialization is configured in {@link CraftsmanConfig}
 *
 * @author Frank Zhang
 */
@EnableSwagger
@SpringBootApplication(scanBasePackages = {"io.github.alice52.craftsman", "com.alibaba.cola"})
@MapperScan("io.github.alice52.craftsman.*.mapper")
@Slf4j
public class Application {

    public static void main(String[] args) {
        log.info("Begin to start Spring Boot Application");
        long startTime = System.currentTimeMillis();

        SpringApplication.run(Application.class, args);

        long endTime = System.currentTimeMillis();
        log.info("End starting Spring Boot Application, Time used: " + (endTime - startTime));
    }
}
