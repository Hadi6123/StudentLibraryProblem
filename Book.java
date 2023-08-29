
/*
 * lock needed becasue students may use same books
 * 
 */

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book{

    private int id;
    private Lock lock;

    public Book(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    public boolean pickUp(Student student) throws InterruptedException{

        // trying to acquire the chopstick (getting the lock)
        if (lock.tryLock(10, TimeUnit.MILLISECONDS)){
            System.out.println(student+ "picked up book #" + this.id);
            return true;
        }
        
        return false;
    }

    public void putDown(Student student){
        lock.unlock();
        System.out.println(student +" put down book #" + this.id);

    }


    @Override
    public String toString(){
        return "Book #" + id;
    }


}