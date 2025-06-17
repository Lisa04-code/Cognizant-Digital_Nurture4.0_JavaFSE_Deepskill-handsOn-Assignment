public class LoggerTest {
    public static void main(String[] args) {
        Logger loggerA = Logger.getInstance();
        Logger loggerB = Logger.getInstance();

        loggerA.log("Application started.");
        loggerB.log("User logged in.");

        if(loggerA == loggerB){
            System.out.println("Logger is a singleton. Same instance used.");
        }else{
            System.out.println("Logger is NOT a singleton. Different instances.");
        }
    }
}
