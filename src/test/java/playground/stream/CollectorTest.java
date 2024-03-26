package playground.stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class CollectorTest {

    @Test
    void testToMap() {
        List<Model> models = List.of(new Model(1L, 1), new Model(1L, 2), new Model(2L, 2));
        Map<Long, Integer> resultMap = models.stream().collect(toMap(Model::getId, Model::getQuantity, (q1, q2) -> q1 + q2));

        Assertions.assertAll(
                () -> Assertions.assertEquals(resultMap.get(1L), 3),
                () -> Assertions.assertEquals(resultMap.get(2L), 2)
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
}
