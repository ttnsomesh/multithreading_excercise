package com.multithreading;
/*
Use a singleThreadExecutor, newCachedThreadPool() and
newFixedThreadPool() to submit a list of tasks and wait for completion of all tasks.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;


class Task implements Callable<String> {

    public Task(List<String> l)
    {
        for(String x : l){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(x);
        }
    }


    public String call() throws Exception
    {
        return "";
    }
}


public class Question2 {


    public static void main(String[] args)
    {

        List<String> list = new ArrayList<>();
        list.add("somesh");
        list.add("tushar");
        list.add("kishan");
        list.add("kisan");
        list.add("riya");
        Task task = new Task(list);


        ExecutorService executorService
                = Executors.newFixedThreadPool(4);
        Future<String> result
                = executorService.submit(task);


        try {
            System.out.println(result.get());
        }


        catch (InterruptedException
                | ExecutionException e) {


            System.out.println(
                    "Error occured while executing the submitted task");


            e.printStackTrace();
        }


        executorService.shutdown();
    }
}
