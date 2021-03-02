package com.insup.jung;

import com.insup.jung.thread.AsyncConfig;
import com.insup.jung.thread.AsyncTaskService;
import com.insup.jung.thread.DemonstrationRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.*;

@Component
public class ExecutorsDemo implements ApplicationRunner {

    @Autowired
    AsyncTaskService service;

    @Autowired
    AsyncConfig asyncConfig;

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        System.out.println("====================================");
//        if(asyncConfig.checkSampleTaskExecute()){
//            for(int i=0; i<20; i++) service.jobRunningInBackground(i);
//        }else{
//            System.out.println("Thread 개수 초과");
//        }
//
//        System.out.println("====================================");
//
//
//        Runnable task = () -> {
//            try{
//                Thread.sleep(1000);
//            }catch(InterruptedException e){
//                e.printStackTrace();
//            }
//            System.out.println("Thread name = " + Thread.currentThread().getName());
//            System.out.printf("Hello at %s \n", new Date());
//        };
//
//        ExecutorService cachedThreadPoolExecutorService = Executors.newCachedThreadPool();
//        if(cachedThreadPoolExecutorService.submit(task).get() == null){
//            System.out.printf("The cachedThreadPoolExecutorService " + "has succeeded at %s \n", new Date());
//        }
//
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100); //thread 100개
//        if(fixedThreadPool.submit(task).get()==null){
//            System.out.printf("The fixedThreadPoolExecutorService " + "has succeeded at %s \n", new Date());
//        }
//
//        ExecutorService singleThreadExecutorService = Executors.newSingleThreadExecutor(); //single trhead
//        if(singleThreadExecutorService.submit(task).get()==null){
//            System.out.printf("The singleThreadExecutorService " + "has succeeded at %s \n", new Date());
//        }
//
//        ExecutorService es = Executors.newCachedThreadPool();
//        if(es.submit(task, Boolean.TRUE).get().equals(Boolean.TRUE)){
//            System.out.println("Job has finished");
//        }
//
//        ScheduledExecutorService scheduledThreadExecutorService = Executors.newScheduledThreadPool(10);
//        if(scheduledThreadExecutorService.schedule(task, 30, TimeUnit.SECONDS).get() == null){
//            System.out.printf("scheduledThreadExecutorServis has " + "has succeeded at %s \n", new Date());
//        }
//
//        scheduledThreadExecutorService.scheduleAtFixedRate(task, 0, 5, TimeUnit.SECONDS);
    }
}
