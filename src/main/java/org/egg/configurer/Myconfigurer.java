package org.egg.configurer;

import org.egg.utils.SnowFlake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cdt
 * @Description
 * @date: 2017/11/14 11:39
 */
@Configuration
public class Myconfigurer {

    @Bean
    public SnowFlake getSnowFlakeBean() {
        SnowFlake snowFlake = new SnowFlake(1, 2);
        return snowFlake;
    }
}
