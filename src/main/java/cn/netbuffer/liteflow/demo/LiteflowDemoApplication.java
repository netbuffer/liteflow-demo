package cn.netbuffer.liteflow.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"cn.netbuffer"})
public class LiteflowDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LiteflowDemoApplication.class, args);
    }

}
