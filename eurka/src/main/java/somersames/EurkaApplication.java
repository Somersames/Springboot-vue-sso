package somersames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author szh
 * @create 2019-01-13 12:18
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurkaApplication.class);
    }
}
