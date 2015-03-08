/**
 * Created by Hunter on 2015-03-08.
 */

import org.junit.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
/**
 * Created by student on 25.02.15.
 */

public class CalculatorTest {
    private Calculator calculatorImp;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() {
        calculatorImp = new Calculator();
    }

    @Test
    public void AddTest() {
        Assert.assertEquals(20, calculatorImp.add(14, 6));
    }

    @Test
    public void SubTest() {
        Assert.assertEquals(19, calculatorImp.sub(20, 1));
    }

    @Test
    public void multiTest() {
        Assert.assertEquals(40, calculatorImp.multi(8, 5));
    }

    @Test
    public void divTest() {
        Assert.assertEquals(12, calculatorImp.div(36, 3));
    }

    @Test
    public void greaterTest() {
        Assert.assertTrue(calculatorImp.greater(20, 12));
    }

    @Test
    public void DivideArithmeticException_Excepted() {
        thrown.expect(ArithmeticException.class);
        calculatorImp.div(14, 0);
    }

    //to samo co wyzej
    @Test(expected = ArithmeticException.class)
    public void DivExp() throws ArithmeticException {
        calculatorImp.div(14, 0);
    }
}
