package com.croplanet.memb.configuration.httpConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.DefaultCookieSerializer;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600)
public class SessionConfiguration {

    @Bean
    public CookieHttpSessionStrategy cookieHttpSessionStrategy(){
        CookieHttpSessionStrategy strategy = new CookieHttpSessionStrategy();
        DefaultCookieSerializer cookieSerializer = new DefaultCookieSerializer();
        cookieSerializer.setCookieName("MEMBCOOKIE");
        cookieSerializer.setCookiePath("/");
        cookieSerializer.setCookieMaxAge(3600);
        strategy.setCookieSerializer(cookieSerializer);
        return strategy;
    }


}
