package playground.testsample;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class JunitAnnotationTests {

    @TestFactory
    List<DynamicNode> testFactoryExampleTest() {
        int size = 10;
        List<DynamicNode> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int finalI = i;
            result.add(dynamicTest("Test CaseName" + i , () -> System.out.println("Dynamic Test #" + finalI)));
        }

        return result;
    }

    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    void repeatedTestExample(RepetitionInfo info) {
        System.out.println("repetitionInfo = " + info.getCurrentRepetition() + "/" + info.getTotalRepetitions());
     //   assertEquals();
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 2", "2, 4", "3, 6"})
    void csvSourceExampleTest(int input, int expected) {
        assertEquals(expected, input*2);
    }

    @ParameterizedTest
    @CsvSource(value = {"1|2", "2|4", "3|6"}, delimiterString = "|")
    void csvSourceExampleWithDelimiterStringTest(int input, int expected) {
        assertEquals(expected, input*2);
    }
}
