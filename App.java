
/*
 * 
 * in circle, for last student, we need modulo
 * 
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
        ExecutorService executorService = null;
        Student[] phils = null;
        Book[] sticks = null;

        try {
            phils = new Student[Constants.getInstance().getStudents()];
            sticks = new Book[Constants.getInstance().getBooks()];

            for (int i = 0; i < sticks.length; i++) {
                sticks[i] = new Book(i);
            }

            executorService = Executors.newFixedThreadPool(Constants.getInstance().getStudents());

            for (int i = 0; i < Constants.getInstance().getStudents(); i++) {
                phils[i] = new Student(i, sticks[i]);
                executorService.execute(phils[i]);
            }

            Thread.sleep(Constants.getInstance().getTime());

            executorService.shutdown();

            for (int i = 0; i < phils.length; i++) {
                phils[i].setFull(true);
            }

        } catch (Exception e) {
            executorService.shutdownNow();

            while (!executorService.isTerminated()){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

            for (Student phil : phils){
                System.out.println(phil + " read #" + phil.getCounter() + " times");
            }
        }
    }
}