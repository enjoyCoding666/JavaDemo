/**
 * 
 */
package com.thread;

/**
 * @author Administrator
 *
 */
class Ticket implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; ++i) {
            sale();
        }
    }
 
    public synchronized void sale() {
        if (count > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(count--);
        }
    }
 
    public static void main(String[] args) {
        Ticket he = new Ticket();
        Thread h1 = new Thread(he);
        Thread h2 = new Thread(he);
        Thread h3 = new Thread(he);
        h1.start();
        h2.start();
        h3.start();
    }
 
    private int count = 5;
}
