package com.insup.jung.thread;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("asyncTaskService")
public class AsyncTaskService {

    @Async
    public void jobRunningInBackground(int i){
        System.out.println("async i = " + i);
    }
}
