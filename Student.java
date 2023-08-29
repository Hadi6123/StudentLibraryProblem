
import java.util.Random;

public class Student implements Runnable{

    private int id;
    private volatile boolean isFull;
    private Book book;
    private Random random;
    private int counter;

    public Student(int id, Book book){
        this.id = id;
        this.book = book;
        this.counter = 0;

        this.random = new Random();

    }

    @Override
    public void run() {
        
        try {
            
            while (!isFull){
                think();
                
                if (book.pickUp(this)){
                    
                    read();

                    book.putDown(this);

                }


            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void think() throws InterruptedException{
        System.out.println(this + " is thinking....");
        Thread.sleep(random.nextInt(1000));
    }

    private void read() throws InterruptedException{
        System.out.println(this + " is reading....");
        counter += 1;
        Thread.sleep(random.nextInt(1000));
    }

    public boolean getFull(){
        return this.isFull;
    }


    public void setFull(boolean isFull){
        this.isFull = isFull;
    }


    @Override
    public String toString(){
        return "Student " + id;
    }

    public int getCounter(){
        return counter;
    }


}