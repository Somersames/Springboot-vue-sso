package somersames.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import somersames.entity.UserLoginInfo;

/**
 * @author szh
 * @create 2019-01-13 12:41
 **/
@Configuration@Order(1)
@Data
public class RedisConfig {
    @Value("${spring.redis.host}")
    private String host ;

    @Value("${spring.redis.port}")
    private Integer port;

    @Value("${spring.redis.password}")
    private String password;

    @Bean
    @ConfigurationProperties(prefix="spring.redis")
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory =new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("localhost");
        jedisConnectionFactory.setPort(6379);
        jedisConnectionFactory.setPassword("123456");
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, UserLoginInfo> redisTemplate() {
        RedisTemplate<String, UserLoginInfo> template = new RedisTemplate<String, UserLoginInfo>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }
}
