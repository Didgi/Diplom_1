package praktikum;

import junit.framework.TestCase;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;


public class IngredientTest {
    @Mock
    IngredientType ingredientType;
    private final String ingredientName = RandomStringUtils.randomAlphabetic(8);
    private final Float ingredientPrice = Float.valueOf(RandomStringUtils.randomNumeric(3));
    @Test
    public void getPriceIngredientShowsOk() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, ingredientName, ingredientPrice);
        Assert.assertEquals(ingredientPrice, ingredient.getPrice(),0);
    }
    @Test
    public void getNameIngredientShowsOk() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, ingredientName, ingredientPrice);
        Assert.assertEquals(ingredientName, ingredient.getName());
    }
    @Test
    public void getTypeIngredientSauceShowsOk() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, ingredientName, ingredientPrice);
        Assert.assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
    @Test
    public void getTypeIngredientFillingShowsOk() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, ingredientName, ingredientPrice);
        Assert.assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}