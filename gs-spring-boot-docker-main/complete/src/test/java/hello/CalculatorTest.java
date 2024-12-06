package hello;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void testValidExpression() {
        // Перевіряємо вираз, який має правильний результат
        Expression expression = new ExpressionBuilder("1+1").build();
        double result = expression.evaluate();
        assertEquals(2, result, "Expression '1+1' should return 2");
    }

    /*@Test
    public void testFailingExpression() {
        // Перевіряємо вираз, який завжди повертатиме неправильний результат
        Expression expression = new ExpressionBuilder("5-1").build();
        double result = expression.evaluate();
        assertEquals(2, result, "Expression '5-1' is expected to return 2 (but it won't)");
    }*/
}
