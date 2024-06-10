package playground.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CollectorTest {

    @Test
    void toMapTest() {
        List<Model> models = List.of(new Model(1L, 1), new Model(1L, 2), new Model(2L, 2));
        Map<Long, Integer> resultMap = models.stream().collect(toMap(Model::getId, Model::getQuantity, (q1, q2) -> q1 + q2));

        assertAll(
                () -> assertEquals(resultMap.get(1L), 3),
                () -> assertEquals(resultMap.get(2L), 2)
        );
    }

    @Test
    void flatMapTest() {

        List<OrderItem> orderItems = List.of(new OrderItem(1L), new OrderItem(2L), new OrderItem(3L));
        OrderSheet orderSheet = new OrderSheet(10L);

        orderItems.forEach(it -> orderSheet.addItem(it));

        List<OrderSheet> orderSheets = List.of(orderSheet);

        List<OrderItem> result = orderSheets.stream().flatMap(o -> o.orderItems.stream()).collect(Collectors.toList());

        assertAll(
                () -> assertEquals(3, result.size()),
                () -> assertEquals(10L, result.get(0).orderSheet.orderSheetNumber),
                () -> assertEquals(10L, result.get(1).orderSheet.orderSheetNumber),
                () -> assertEquals(10L, result.get(2).orderSheet.orderSheetNumber),
                () -> assertEquals(1L, result.get(0).orderSheetId),
                () -> assertEquals(2L, result.get(1).orderSheetId),
                () -> assertEquals(3L, result.get(2).orderSheetId)
        );
    }

    public static class Model {
        private Long id;
        private Integer quantity;

        public Model(Long id, Integer quantity) {
            this.id = id;
            this.quantity = quantity;
        }

        public Long getId() {
            return id;
        }

        public Integer getQuantity() {
            return quantity;
        }
    }

    public static class OrderSheet {
        private Long orderSheetNumber;
        private List<OrderItem> orderItems;

        public OrderSheet(Long orderSheetNumber) {
            this.orderSheetNumber = orderSheetNumber;
        }

        public void addItem(OrderItem orderItem) {
            if (orderItems == null) orderItems = new ArrayList<>();

            this.orderItems.add(orderItem);
            orderItem.setOrderSheet(this);
        }
    }

    public static class OrderItem {
        private Long orderSheetId;
        private OrderSheet orderSheet;

        public OrderItem(Long orderSheetId) {
            this.orderSheetId = orderSheetId;
        }

        public void setOrderSheet(OrderSheet orderSheet) {
            this.orderSheet = orderSheet;
        }
    }
}
