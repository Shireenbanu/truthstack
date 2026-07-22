import jdk.jfr.Event;
import jdk.jfr.StackTrace;

public class Main {

    @StackTrace(true)
    public static class SleepEvent extends Event {
        String operation;
    }


    public static void main(String[] args) {
        System.out.println("Hello, World!");
        System.out.println(arithmaticOps(10, 5, '+'));
        System.out.println(arithmaticOps(10, 5, '-'));
        System.out.println(arithmaticOps(10, 5, '*'));
        System.out.println(arithmaticOps(10, 5, '/'));
    }

    public static int arithmaticOps(int a , int b, char operator){

        if(operator == '+'){
            return add(a,b);
        }
        else if(operator == '-'){
            return subtract(a,b);
        }
        else if(operator == '*'){
            return multiply(a,b);
        }
        else if(operator == '/'){
            return divide(a,b);
        }
        else{
            System.out.println("Invalid operator");
            return 0;
        }
    }

    public static int add(int a, int b){
        SleepEvent event = new SleepEvent();
        event.operation = "sleep(10ms)";
        try {
            event.begin();
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            event.commit();
        }
        return a + b;
    }
    public static int subtract(int a, int b){
        return a - b;
    }
    public static int multiply(int a, int b){
        return a * b;       
    }
    public static int divide(int a, int b){
        if(b == 0){
            System.out.println("Cannot divide by zero");
            return 0;
        }
        return a / b;
    }

}

