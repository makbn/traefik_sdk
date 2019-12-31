package io.github.makbn.traefiksdk.config


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer

@Configuration
@PropertySource(value = ["file:env.properties", "file:\${config.location}", "classpath:/env.properties"], ignoreResourceNotFound = true)
class AppSettingConfiguration {

    @Bean
    fun propertyConfigurer(): PropertySourcesPlaceholderConfigurer {
        return PropertySourcesPlaceholderConfigurer()
    }
}
