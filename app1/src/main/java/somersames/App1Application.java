package somersames;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author szh
 * @create 2019-01-13 14:14
 **/
@SpringBootApplication
@EnableEurekaClient
@MapperScan("somersames.dao.mapper")
public class App1Application {
    public static void main(String[] args) {
        SpringApplication.run(App1Application.class);
    }
}
