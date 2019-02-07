package com.example.redis.config;

import com.example.redis.serialize.ObjectSerializer;
import com.example.redis.vo.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource(value = "redis.properties")
public class RedisConfig {

    @Bean
    @ConfigurationProperties(prefix = "redis.pool")
    public JedisPoolConfig jedisPoolConfig(){
        return new JedisPoolConfig();
    }

    @Bean
    @ConfigurationProperties(prefix = "redis.server")
    public RedisConn redisConn(){
        return new RedisConn();
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(@Qualifier("jedisPoolConfig") JedisPoolConfig jedisPoolConfig,
                                                         @Qualifier("redisConn") RedisConn redisConn){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        jedisConnectionFactory.setHostName(redisConn.getHost());
        jedisConnectionFactory.setPort(redisConn.getPort());
        jedisConnectionFactory.setTimeout(redisConn.getTimeout());

        return jedisConnectionFactory;

    }


    @Bean(name = "redisTemplate")
    public RedisTemplate<String,Object> redisTemplate(@Qualifier("jedisConnectionFactory") JedisConnectionFactory jedisConnectionFactory){
        RedisTemplate<String,Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());

        return template;
    }

    @Bean(name = "userRedisTemplate")
    public RedisTemplate<String, User> userRedisTemplate(@Qualifier("jedisConnectionFactory") JedisConnectionFactory jedisConnectionFactory){
        RedisTemplate<String,User> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new ObjectSerializer());

        return template;
    }
}
