package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final String randomName = RandomStringUtils.randomAlphabetic(8);
    private final Float randomPrice = Float.valueOf(RandomStringUtils.randomNumeric(2));
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient newIngredient;
    Burger burger;

    @Test
    public void setBunsBurgerCorrectAllFieldsBunShowsOk() {
        Mockito.when(bun.getName()).thenReturn(randomName);
        Mockito.when(bun.getPrice()).thenReturn(randomPrice);
        burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals(randomName, burger.bun.getName());
        Assert.assertEquals(randomPrice, burger.bun.getPrice(), 0);

    }

    @Test
    public void addIngredientBurgerCorrectAllFieldsIngredientShowsOk() {
        burger = new Burger();
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(randomName);
        Mockito.when(ingredient.getPrice()).thenReturn(randomPrice);
        burger.addIngredient(ingredient);
        Assert.assertEquals(IngredientType.SAUCE, burger.ingredients.get(0).getType());
        Assert.assertEquals(randomName, burger.ingredients.get(0).getName());
        Assert.assertEquals(randomPrice, burger.ingredients.get(0).getPrice(), 0);
    }

    @Test
    public void removeIngredientBurgerFirstIngredientShowsOk() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientBurgerReplaceFirstToSecondIngredientShowsOk() {
        burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(newIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(1, burger.ingredients.indexOf(ingredient));
        Assert.assertEquals(0, burger.ingredients.indexOf(newIngredient));
    }

    @Test
    public void getPriceBurgerTwoIngredientsShowsOk() {
        Mockito.when(ingredient.getPrice()).thenReturn(randomPrice);
        Mockito.when(newIngredient.getPrice()).thenReturn(randomPrice);
        Mockito.when(bun.getPrice()).thenReturn(randomPrice);
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(newIngredient);
        float expectedPrice = burger.getPrice();
        Assert.assertEquals(randomPrice * 4, expectedPrice, 0);
    }

    @Test
    public void getPriceBurgerCallBunPriceOnceShowsOk() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.getPrice();
        Mockito.verify(bun, Mockito.times(1)).getPrice();
    }

    @Test
    public void getReceiptCallBunGetNameTwiceShowsOk() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.getReceipt();
        Mockito.verify(bun, Mockito.times(2)).getName();
    }

    @Test
    public void getReceiptCallIngredientGetTypeOnceShowsOk() {
        prepareAllDataForGetReceipt();
        burger.getReceipt();
        Mockito.verify(ingredient, Mockito.times(1)).getType();
    }

    @Test
    public void getReceiptCallIngredientGetNameOnceShowsOk() {
        prepareAllDataForGetReceipt();
        burger.getReceipt();
        Mockito.verify(ingredient, Mockito.times(1)).getName();
    }

    public void prepareAllDataForGetReceipt() {
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn(randomName);
        Mockito.when(ingredient.getPrice()).thenReturn(randomPrice);
        Mockito.when(newIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(newIngredient.getName()).thenReturn(randomName);
        Mockito.when(newIngredient.getPrice()).thenReturn(randomPrice);
        Mockito.when(bun.getPrice()).thenReturn(randomPrice);
        Mockito.when(bun.getName()).thenReturn(randomName);
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(newIngredient);
    }

}