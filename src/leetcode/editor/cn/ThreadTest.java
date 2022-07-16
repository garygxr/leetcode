package leetcode.editor.cn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author garygan
 * @Date 2022/7/16 13:25
 * @Description
 */
public class ThreadTest {
    public static Object o = new Object();

    public static Lock lock = new ReentrantLock();
    public static Condition conditionA = lock.newCondition();
    public static Condition conditionB = lock.newCondition();
    public static Condition conditionC = lock.newCondition();

    public  static String state = "A";

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 0; i < 10; i++) {
                        if (!state.equals("A")) {
                            conditionA.await();
                        }
                        state = "B";
                        System.out.println("A");
                        conditionB.signal();
                    }
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 0; i < 10; i++) {
                        if (!state.equals("B")) {
                            conditionB.await();
                        }
                        state = "C";
                        System.out.println("B");
                        conditionC.signal();
                    }
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    for (int i = 0; i < 10; i++) {
                        if (!state.equals("C")) {
                            conditionC.await();
                        }
                        state = "A";
                        System.out.println("C");
                        conditionA.signal();
                    }
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
}
