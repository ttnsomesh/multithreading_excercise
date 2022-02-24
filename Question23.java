package com.multithreading;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class SingleCache{
    public void printData(List<String> c){
        for(String x : c){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("SingleExecular : "+x);
        }
    }
}
class SingleDemoCache implements Runnable{
    SingleCache p;
    public SingleDemoCache(SingleCache p){
        this.p = p;
    }
    @Override
    public void run() {
        p.printData(Arrays.asList("dinesh" , "kundan" , "devesh" , "jayant"));
    }
}
public class Question23 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService excr = Executors.newCachedThreadPool();
        ThreadPoolExecutor mypool = (ThreadPoolExecutor) excr;
        SingleCache se = new SingleCache();
        SingleDemoCache sw = new SingleDemoCache(se);
        System.out.println("size of mypool: " + mypool.getPoolSize());
        excr.submit(sw);
        excr.submit(sw);
        System.out.println("Total number threads scheduled): "+ mypool.getTaskCount());
        excr.shutdown();
    }
}
