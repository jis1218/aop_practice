package com.insup.jung.thread;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    private static int TASK_CORE_POOL_SIZE = 8;

    private static int TASK_MAX_POOL_SIZE = 8;

    private static int TASK_QUEUE_CAPACITY = 30;

    private final String EXECUTOR_BEAN_NAME = "executor1";

    @Resource(name="executor1")
    private ThreadPoolTaskExecutor executor1;

    @Bean(name="executor1")
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(TASK_CORE_POOL_SIZE);
        executor.setMaxPoolSize(TASK_MAX_POOL_SIZE);
        executor.setQueueCapacity(TASK_QUEUE_CAPACITY);
        executor.setBeanName(EXECUTOR_BEAN_NAME);
        //executor.setWaitForTasksToCompleteOnShutdown(false);
        //executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncExceptionHandler();
    }

    public boolean checkSampleTaskExecute(){
        boolean result = true;

        if(executor1.getActiveCount() >= (TASK_MAX_POOL_SIZE + TASK_QUEUE_CAPACITY)){
            return false;
        }
        return result;
    }



}
