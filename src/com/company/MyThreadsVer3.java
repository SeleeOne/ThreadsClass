package com.company;

public class MyThreadsVer3 implements Runnable {
    Thread thread;
    MyThreadsVer3(String name) {
        thread = new Thread(this, name);
    }

    public static MyThreadsVer3 createAndStart(String name) {
        MyThreadsVer3 myThreadsVer3 = new MyThreadsVer3(name);
        myThreadsVer3.thread.start();
        return myThreadsVer3;
    }

    public void run() {
        System.out.println(thread.getName()+" start of the action");
        try {
            for (int count=0;count<10;count++) {
                Thread.sleep(400);
                System.out.println(thread.getName()+" is processing, the count value is: "+count);
            }
        } catch (InterruptedException e) {
            System.out.println(thread.getName()+" got interrupted");
        }
        System.out.println(thread.getName()+" finished an action");
    }
}

class MoreTreads2 {
    public static void main(String[] args) {
        System.out.println("The main thread starts working");
        MyThreadsVer3 myThread1 = MyThreadsVer3.createAndStart("Thread power nr 1");
        MyThreadsVer3 myThread2 = MyThreadsVer3.createAndStart("Thread power nr 2");
        MyThreadsVer3 myThread3 = MyThreadsVer3.createAndStart("Thread power nr 3");
            System.out.print(".");
            try {
                myThread1.thread.join();
                myThread2.thread.join();
                myThread3.thread.join();
            } catch (InterruptedException e) {
                System.out.println("Main tread got interrupted");
            }
            System.out.println("Main thread has ended");
    }
}
