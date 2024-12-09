package com.ffreitas.gamestoreserver.configuration;

import com.ffreitas.gamestoreserver.auditing.ApplicationAuditAware;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.domain.AuditorAware;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAspectJAutoProxy
@RequiredArgsConstructor
public class ApplicationConfiguration {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new ApplicationAuditAware();
    }

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("Thread Name - ");
        executor.initialize();
        return executor;
    }
}
