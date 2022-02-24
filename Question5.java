package com.multithreading;

import java.util.concurrent.locks.ReentrantLock;

/*
Write a program to simulate a deadlock in java
and then improve the program to handle the deadlock using reentract lock.
 */
//Deadlock
/*
public class Question5 {
    public static void main(String[] args) {
        ReentrantLock r = new ReentrantLock();
        Thread t1 = new Thread(new Display("Thread-1", r));
        Thread t2 = new Thread(new Display("Thread-2", r));
        t1.start();
        t2.start();
    }
}

class Display implements Runnable {
    private String threadName;
    ReentrantLock lock;
    Display(String threadName, ReentrantLock lock){
        this.threadName = threadName;
        this.lock = lock;
    }
    @Override
    public void run() {
        System.out.println(threadName +
                " is waiting to get lock");
        lock.lock();
        try {
            System.out.println("Thread " + threadName + "has got lock");
            methodA();
        } finally{
            lock.unlock();
        }
    }

    public void methodA(){
        System.out.println("In Display methodA, thread " + threadName +
                " is waiting to get lock");
        lock.lock();
        System.out.println("Thread " + threadName + "has got lock");
        System.out.println("Count of locks held by thread " + threadName +
                " - " + lock.getHoldCount());

    }
}

 */

public class Question5 {
    public static void main(String[] args) {
        ReentrantLock rLock = new ReentrantLock();
        Thread t1 = new Thread(new Display("Thread-1", rLock));
        Thread t2 = new Thread(new Display("Thread-2", rLock));
        System.out.println("starting threads ");
        t1.start();
        t2.start();
    }
}

class Display implements Runnable {
    private String threadName;
    ReentrantLock lock;
    Display(String threadName, ReentrantLock lock){
        this.threadName = threadName;
        this.lock = lock;
    }
    @Override
    public void run() {
        System.out.println("In Display run method, thread " + threadName +
                " is waiting to get lock");
        //acquiring lock
        lock.lock();
        try {
            System.out.println("Thread " + threadName + "has got lock");
            methodA();
        } finally{
            lock.unlock();
        }
    }

    public void methodA(){
        System.out.println("In Display methodA, thread " + threadName
                + " is waiting to get lock");
        //acquiring lock
        lock.lock();
        try {
            System.out.println("Thread " + threadName + "has got lock");
            System.out.println("Count of locks held by thread " + threadName
                    + " - " + lock.getHoldCount());
        } finally{
            lock.unlock();
        }
    }
}