package net.tunne.yatzy;

public class Rivi {

    private Yhdistelma yhdistelma;
    private boolean pelattu = false;
    private int pistemaara = 0;

    public Rivi(Yhdistelma yhdistelma) {
        this.yhdistelma = yhdistelma;
    }

    public Yhdistelma annaYhdistelma() {
        return yhdistelma;
    }

    public boolean onPelattu() {
        return pelattu;
    }

    public int annaMahdollinenPistemaara(Nopat nopat) {
        return yhdistelma.annaPistemaara(nopat);
    }

    public int annaPistemaara() {
        return pistemaara;
    }

    public void pelaa(Nopat nopat) {
        pelattu = true;
        pistemaara = annaMahdollinenPistemaara(nopat);
    }
}
