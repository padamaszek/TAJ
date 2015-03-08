/**
 * Created by Hunter on 2015-03-08.
 */
import org.junit.*;
import org.junit.rules.ExpectedException;

public class CalculatorDoubleTest {
    private CalculatorDouble calculatorDouble;
    //DIFF is diffrence between expected result and actual result

    private static final double DIFF = 0.1;
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Before
    public void setUp(){
        calculatorDouble = new CalculatorDouble();
    }
    @Test
    public void AddTest(){
        Assert.assertEquals(9.33, calculatorDouble.add(9.11, 0.22), DIFF);
    }
    @Test
    public void SubTest(){
        Assert.assertEquals(2.01, calculatorDouble.sub(14.23, 12.22), DIFF);
    }
    @Test
    public void multiTest(){
        Assert.assertEquals(16.4, calculatorDouble.multi(3.2, 5.125), DIFF);
    }
    @Test
    public void divTest(){
        Assert.assertEquals(5.125, calculatorDouble.div(16.4, 3.2), DIFF);
    }
    @Test
    public void greaterTest(){
        Assert.assertTrue(calculatorDouble.greater(18.11, 7.42));
    }
    @Test
    public void DivideArithmeticException_Excepted(){
        thrown.expect(ArithmeticException.class);
        calculatorDouble.div(14,0);
    }
    //to samo co wyzej
    @Test(expected = ArithmeticException.class)
    public void DivExp() throws ArithmeticException{
        calculatorDouble.div(10,0);
    }
}