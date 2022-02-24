package com.multithreading;
/*
Create and Run a Thread using Runnable Interface and Thread class
and show usage of sleep and join methods in the created threads.
 */

//using thread class
class Demo extends Thread{
    @Override
    public void run() {
        super.run();
        for(int i = 1 ; i < 3 ; i++){
            try{
                sleep(3000);
                System.out.println("current thread is "+Thread.currentThread().getName());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Hello world "+i);
        }
    }
}

//using runnable interface

class DemoRunnable implements Runnable{

    @Override
    public void run() {
        try
        {
            Thread.sleep(3000);
            System.out.println("....thread running....."+Thread.currentThread().getName());
        }
        catch (InterruptedException ie)
        {
            ie.printStackTrace();
        }

    }
}
public class Question1 {
    public static void main(String[] args) {
        //thread class
        Demo d1 = new Demo();
        Demo d2 = new Demo();
        Demo d3 = new Demo();
        d1.start();
        try {
            d1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        d2.start();
        try {
            d2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        d3.start();
        try {
            d3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //runnable interface
        DemoRunnable t1 = new DemoRunnable();
        DemoRunnable t2 = new DemoRunnable();
        DemoRunnable t3 = new DemoRunnable();
        Thread m1 = new Thread(t1);
        m1.start();
        try {
            m1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread m2 = new Thread(t2);
        m2.start();
        try {
            m2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread m3 = new Thread(t3);
        m3.start();
        try {
            m3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
