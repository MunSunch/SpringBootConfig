package com.munsun.configuration_spring_boot.profile.config;

import com.munsun.configuration_spring_boot.profile.SystemProfile;
import com.munsun.configuration_spring_boot.profile.impl.DevProfile;
import com.munsun.configuration_spring_boot.profile.impl.ProductionProfile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfileConfiguration {
    @Bean
    @ConditionalOnProperty(value = "netology.profile.dev", havingValue = "true")
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnMissingBean
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
