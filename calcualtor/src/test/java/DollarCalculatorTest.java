import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DollarCalculatorTest {

    @Mock
    public MarketApi marketApi;

    @BeforeEach
    public void init(){
        // marketapi가 connect가 들어갈때 실제값이 아닌 내가 원한 3000을 넣어 동작
        Mockito.lenient().when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void testHello(){
        System.out.println("hello");
    }

    @Test
    public void dollarTest() {
        MarketApi marketApi = new MarketApi();
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Calculator calculator = new Calculator(dollarCalculator);

        // 내가 원하는 결과값은 20이고 , calculator.sum(10,10)을 호출한다.
        Assertions.assertEquals(22000,calculator.sum(10,10));
        Assertions.assertEquals(0,calculator.minus(10,10));
    }

    @Test
    public void MockTest() {
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Calculator calculator = new Calculator(dollarCalculator);
        Assertions.assertEquals(60000,calculator.sum(10,10));
        Assertions.assertEquals(0,calculator.minus(10,10));
    }

}
