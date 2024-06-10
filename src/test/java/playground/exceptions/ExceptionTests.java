package playground.exceptions;

import org.junit.jupiter.api.Test;

public class ExceptionTests {


    @Test
    void exceptionCatchForReturnable() {
        boolean b = true;

        try {
            this.throwException();
        } catch (Exception e) {

            if (b) return;
            throw e;
        }
    }

    @Test
    void exceptionCatchOrders() {
        try {
            String nullStr = null;
            nullStr.trim();
        } catch (NullPointerException e) {
            System.out.println("NPE 발생");
        } catch (RuntimeException e) {
            System.out.println("Runtime 예외 발생");
        } catch (Exception e) {
            System.out.println("예외 발생");
        }
    }

    private void throwException() {
        throw new RuntimeException();
    }
}
