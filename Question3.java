package com.multithreading;
/*
Use Synchronize method and synchronize block to enable synchronization
between multiple threads trying to access method at same time.
 */

import java.util.Scanner;

class PrintData{
    synchronized void printDetail(String name){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("your name is "+name);
    }
}

class SyncData{
    void printNumber(int n){
        synchronized (this){
            for(int i = 1 ; i <= n ; i++){
                System.out.println("Number "+i);
            }
        }
    }
}
class SyncMethod implements Runnable{
    PrintData p;
    SyncMethod(PrintData p){
        this.p = p;
    }
    Scanner sc = new Scanner(System.in);
    String name = sc.next();
    @Override
    public void run() {
        p.printDetail(name);
    }
}

class SyncBlock implements Runnable{
    SyncData sd;
    public SyncBlock(SyncData sd){
        this.sd = sd;
    }
    @Override
    public void run() {
        sd.printNumber(5);
    }
}
public class Question3 {
    public static void main(String[] args) {
        PrintData pdata = new PrintData();
        SyncMethod s1 = new SyncMethod(pdata);
        Thread t1 = new Thread(s1);
        t1.start();
        SyncMethod s2 = new SyncMethod(pdata);
        Thread t2 = new Thread(s2);
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SyncData ss = new SyncData();
        SyncBlock s3 = new SyncBlock(ss);
        Thread t3 = new Thread(s3);
        t3.start();
        SyncBlock s4 = new SyncBlock(ss);
        Thread t4 = new Thread(s4);
        t4.start();
    }
}
