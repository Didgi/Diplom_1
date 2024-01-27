package praktikum;


import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {

    @Test
    public void getEnumValuesShowsOk() {
        Assert.assertEquals(IngredientType.valueOf("SAUCE"), IngredientType.SAUCE);
        Assert.assertEquals(IngredientType.valueOf("FILLING"), IngredientType.FILLING);
    }

}