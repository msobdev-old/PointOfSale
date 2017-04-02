import db.Database;
import model.Order;
import org.junit.Before;
import org.junit.Test;
import service.PointOfSale;

/**
 * Created by sob1 on 03.04.2017.
 */
public class PointOfSaleTest {

    Database db;
    PointOfSale pointOfSale;

    @Before
    public void init(){
        db = new Database("DB/data.txt");
        pointOfSale = new PointOfSale(db, new Order());
    }

    @Test
    public void scannedProductExistsInDB(){
        pointOfSale.scanTheProduct("88670");
    }

    @Test
    public void scannedProductDoesNotExistInDBreturnsError(){
        pointOfSale.scanTheProduct("1111111111");
    }

    @Test
    public void scannedIsEmptyReturnsReturnsError(){
        pointOfSale.scanTheProduct("");
    }

    @Test
    public void inputExitReturnsBothOutputs(){
        pointOfSale.scanTheProduct("88670");
        pointOfSale.scanTheProduct("78820");
        pointOfSale.scanTheProduct("88670");
        pointOfSale.scanTheProduct("76216");
        pointOfSale.scanTheProduct("59920");
        pointOfSale.scanTheProduct("exit");
    }

}
