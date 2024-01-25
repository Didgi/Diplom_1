package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    private final String bunName = RandomStringUtils.randomAlphabetic(8);
    private final Float bunPrice = Float.valueOf(RandomStringUtils.randomNumeric(3));

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
