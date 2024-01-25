package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {
    private static IngredientType ingredientType;
    private final String bunName;
    private final String ingredientName;
    private final Float bunPrice;
    private final Float ingredientPrice;
    private final String expectedResult;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Burger burger;


    public BurgerParameterizedTest(String bunName, IngredientType ingredientType, String ingredientName,  Float bunPrice, Float ingredientPrice,  String expectedResult) {
        this.bunName = bunName;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
        this.bunPrice = bunPrice;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        burger = new Burger();
    }

    @Parameterized.Parameters
    public static Object[][] orderData() {
        return new Object[][]{
                 {"Булочка с кунжутом", IngredientType.SAUCE, "терияки", 3.0F, 1.0F, String.format("(==== %s ====)\n= %s %s =\n(==== %s ====)\n\nPrice: %.6f\n", "Булочка с кунжутом", IngredientType.SAUCE.toString().toLowerCase(), "терияки", "Булочка с кунжутом", 7.0F)},
                 {"Булочка постная", IngredientType.FILLING, "котлетка", 3.0F, 5.0F, String.format("(==== %s ====)\n= %s %s =\n(==== %s ====)\n\nPrice: %.6f\n", "Булочка постная", IngredientType.FILLING.toString().toLowerCase(), "котлетка", "Булочка постная", 11.0F)},
        };
    }

    @Test
    public void getReceiptBurgerOneDifferentIngredientShowsOk() {
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String actualResult = burger.getReceipt();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
