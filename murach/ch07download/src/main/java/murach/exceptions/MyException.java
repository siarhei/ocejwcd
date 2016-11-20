package murach.exceptions;

/**
 * @author siarhei
 */
public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        method1();
    }

    private static void method3() throws MyException {
        throw new MyException("XYZ");
        //int a = 1;
        //a = a / 0;
    }

    private static void method2() throws MyException {
        method3();
    }

    private static void method1() {
        try {
            method2();
        } catch (MyException e) {
            System.out.println("myException is occurred " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("an exception is occurred " + e.getMessage());
        }
    }
}
