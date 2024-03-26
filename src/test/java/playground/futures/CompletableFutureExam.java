package playground.futures;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompletableFutureExam {

    final String iphone15 = "Iphone15";

    @Test
    void calculateAsyncTest() throws Exception {
        Future<String> completeFuture = calculateAsync();

        String result = completeFuture.get();
        assertEquals("Hello", result);
    }

    Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });

        return completableFuture;
    }

    /*처리의 결과로 어떤 값을 돌려주고, 그것을 사용해 다른 처리를 한다.*/
    @Test
    void supplierAndConsumer() throws InterruptedException, ExecutionException {
        Supplier<Integer> initValueSupplier = () -> 100;
        Consumer<Integer> valueConsumer = value -> System.out.println(value);
        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(initValueSupplier)
                .thenAcceptAsync(valueConsumer);

        future.get();
    }

    /*처리의 결과로 어떤 값을 돌려주고, 그것을 변환하여 반환하고, 그 반환 값을 처리를 한다.*/
    @Test
    void supplierAndFunctionAndConsumer() throws InterruptedException, ExecutionException {
        Supplier<Integer> initValueSupplier = () -> 100;
        Function<Integer, Integer> multiply = value -> value * 2;
        Consumer<Integer> valueConsumer = value -> System.out.println(value);

        CompletableFuture<Void> future = CompletableFuture
                .supplyAsync(initValueSupplier)
                .thenApplyAsync(multiply)
                .thenAcceptAsync(valueConsumer);

        future.get();
    }

    /*하나의 처리를 여러 스레드에서 수행하고, 첫 번째 결과를 사용하여 다른 처리를 수행한다.*/
    @Test
    void multiSupplierAndConsumer() throws InterruptedException, ExecutionException {
        Supplier<Integer> initValueSupplier = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 100;
        };
        Supplier<Integer> anotherValueSupplier = () -> 200;
        Consumer<Integer> valueConsumer = value -> System.out.println(value);

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(initValueSupplier);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(anotherValueSupplier);

        future1.acceptEitherAsync(future2, valueConsumer).get();
    }

    /*하나의 처리를 여러 스레드에서 수행하고, 첫 번째 결과를 사용하여 다른 처리를 수행하고, 그 결과를 사용하여 다른 처리를 수행한다.*/
    @Test
    void multiSupplierAndFunctionAndConsumer() throws InterruptedException, ExecutionException {
        Supplier<Integer> initValueSupplier = () -> 100;
        Supplier<Integer> anotherValueSupplier = () -> 200;
        Function<Integer, Integer> multiply = value -> value * 2;
        Consumer<Integer> valueConsumer = value -> System.out.println(value);

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(initValueSupplier);
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(anotherValueSupplier);

        future1.applyToEitherAsync(future2, multiply)
                .thenAcceptAsync(valueConsumer)
                .get();
    }

    @Test
    @DisplayName("주문 정보를 조회하는 예시입니다.")
    void supplyAsync() throws Exception {
        String orderNo = "1234567890";
        CompletableFuture<String> orderFuture = CompletableFuture.supplyAsync(() -> getOrder(orderNo));

        assertEquals(iphone15, orderFuture.get());
    }

    @Test
    @DisplayName("주문 정보 조회가 완료되면 결제 정보를 조회하는 예시입니다.")
    void thenApply() throws Exception {
        String orderNo = "1234567890";
        CompletableFuture<String> orderFuture = CompletableFuture.supplyAsync(() -> getOrder(orderNo));
        CompletableFuture<String> paymentFuture = orderFuture.thenApply(it -> getPaymentTransaction(it));

        assertEquals(iphone15.concat(", [결제정보] 신용카드: 120,000"), paymentFuture.get());

        CompletableFuture.allOf(
                CompletableFuture.runAsync(() -> System.out.println("hello")),
                CompletableFuture.runAsync(() -> System.out.println("hello")),
                CompletableFuture.runAsync(() -> System.out.println("hello"))
        );
    }


    private String getOrder(String orderNo) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        return iphone15;
    }

    private String getPaymentTransaction(String item) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        return item.concat(", [결제정보] 신용카드: 120,000");
    }
}
