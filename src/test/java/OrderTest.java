import model.Order;
import model.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by sob1 on 02.04.2017.
 */
public class OrderTest {

    Order order;

    @Before
    public void init(){
        order = new Order();
    }

    @Test
    public void emptyListReturnCostZero(){
        double cost = order.getTotalAmount();
        assertEquals(cost, 0, 0.01);
    }

    @Test
    public void whenListNotEmptyReturnCost(){
        order.addProduct(new Product("lamp", 35.60));
        order.addProduct(new Product("window", 500.20));
        double cost = order.getTotalAmount();
        assertEquals(cost, 535.80, 0.01);
    }
}
