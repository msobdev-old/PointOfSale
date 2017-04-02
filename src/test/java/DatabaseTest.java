
import db.Database;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by sob1 on 01.04.2017.
 */

public class DatabaseTest {

    Database db;

    @Before
    public void init(){
        db = new Database("DB/data.txt");
    }

    @Test
    public void containsKeyInDB(){
        String result = db.containsProduct("80636").toString();
        assertEquals("keyboard 467.25", result);
    }


}
