package eu.lengarski.nlpostcode.main;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@ComponentScan("eu.lengarski.nlpostcode")
@EnableJpaRepositories("eu.lengarski.nlpostcode.repositories")
@EntityScan("eu.lengarski.nlpostcode.models")
@EnableScheduling
public class NLPostCodeMain {


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(NLPostCodeMain.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("server.port", "8087");
        map.put(" spring.jpa.hibernate.ddl-auto", "update");

        app.setDefaultProperties(map);

        app.run(args);

    }

}
