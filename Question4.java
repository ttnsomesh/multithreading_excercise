package com.multithreading;
/*
 WAP to show usage of Callable and demonstrate how it is different from Runnable
 */

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class CallableExample implements Callable{

    @Override
    public Object call() throws Exception {
        Random ran = new Random();
        Integer i = ran.nextInt(5);
        Thread.sleep(3000);

        return i;
    }
}
class RunDemo{
    public void printRandom(){
        Random rr = new Random();
        Integer i = rr.nextInt(5);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Runnable random number : "+i);
    }
}
class RunnableExample implements Runnable{
    RunDemo runDemo;
    public RunnableExample(RunDemo runDemo){
        this.runDemo = runDemo;
    }
    @Override
    public void run() {
        runDemo.printRandom();
    }
}
public class Question4{
    public static void main(String[] args) throws Exception{
        //using callable
        FutureTask[] randomNoTasks = new FutureTask[5];
        for (int j = 0; j < 5; j++)
        {

            Callable clble = new CallableExample();


            randomNoTasks[j] = new FutureTask(clble);


            Thread th = new Thread(randomNoTasks[j]);
            th.start();
        }
        for (int j = 0; j < 5; j++)
        {

            Object o = randomNoTasks[j].get();
            Thread.sleep(2000);
            System.out.println("callable random number is: " + o);

        }
        //runnable
        RunDemo rd = new RunDemo();
        RunnableExample re1 = new RunnableExample(rd);
        Thread y1 = new Thread(re1);
        y1.start();
        RunnableExample re2 = new RunnableExample(rd);
        Thread y2 = new Thread(re2);
        y2.start();
    }
}