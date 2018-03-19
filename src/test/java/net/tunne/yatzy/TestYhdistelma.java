package net.tunne.yatzy;

import org.junit.Assert;
import org.junit.Test;

public class TestYhdistelma {

    private void testaa(int odotettu, Yhdistelma yhdistelma, int... silmaluvut) {
        Nopat nopat = new Nopat(silmaluvut);
        Assert.assertEquals(odotettu, yhdistelma.annaPistemaara(nopat));
    }

    @Test
    public void testYkkoset() {
        testaa(1, Yhdistelma.YKKOSET, 1, 2, 3, 4, 5);
        testaa(0, Yhdistelma.YKKOSET, 3, 2, 3, 4, 5);
        testaa(2, Yhdistelma.YKKOSET, 3, 1, 3, 1, 5);
        testaa(5, Yhdistelma.YKKOSET, 1, 1, 1, 1, 1);
    }
}
