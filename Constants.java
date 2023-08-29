
public class Constants {

    private static Constants instance = null;
    private int NUMBER_OF_BOOKS, NUMBER_OF_STUDENTS, SIMULATION_TIME;
    
    private Constants(){
        this.NUMBER_OF_BOOKS = 5; // if nymber of books not same as students, error
        this.NUMBER_OF_STUDENTS = 5;
        this.SIMULATION_TIME = 1000*5;
    }

    public static Constants getInstance(){
        synchronized(Constants.class){
            if (instance == null){
                instance = new Constants();
            }

            return instance;
        }
    }

    public int getBooks(){
        return NUMBER_OF_BOOKS;
    }
    
    public int getStudents(){
        return NUMBER_OF_STUDENTS;
    }

    public int getTime(){
        return SIMULATION_TIME;
    }

    
}