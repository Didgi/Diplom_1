package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunParameterizedTest {
    private static final String randomName = RandomStringUtils.randomAlphabetic(8);
    private static Float randomPrice = Float.valueOf(RandomStringUtils.randomNumeric(3));
    private final String bunName;
    private final float bunPrice;

    public BunParameterizedTest(String bunName, float bunPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
    }

    @Parameterized.Parameters
    public static Object[][] bunData() {
        return new Object[][]{
                {randomName, randomPrice},
                {"", 0},
                {null, Float.MAX_VALUE},
                {"Name~!@#$%^&*<>", Float.MIN_VALUE}
        };
    }

    @Test
    public void getNameBunShowsOk() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunName, bun.getName());
    }

    @Test
    public void getPriceBunShowsOk() {
        Bun bun = new Bun(bunName, bunPrice);
        Assert.assertEquals(bunPrice, bun.getPrice(), 0);

    }
}
