package com.multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Single{
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
class SingleDemo implements Runnable{
    Single p;
    public SingleDemo(Single p){
        this.p = p;
    }
    @Override
    public void run() {
        p.printData(Arrays.asList("dinesh" , "kundan" , "devesh" , "jayant"));
    }
}

public class Question21 {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newSingleThreadExecutor();
        Single se = new Single();
        SingleDemo sw = new SingleDemo(se);
        try {
            ex.submit(sw);
            System.out.println("Shutingdown executor");
            ex.shutdown();
            ex.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println(e);
        }finally {
            if (!ex.isTerminated()) {
                System.err.println("cancel  tasks");
            }
            ex.shutdownNow();
            System.out.println(" finished");
        }
    }
}
