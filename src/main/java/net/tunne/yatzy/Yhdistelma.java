package net.tunne.yatzy;

public enum Yhdistelma {

    YKKOSET("Ykköset"),
    KAKKOSET("Kakkoset"),
    KOLMOSET("Kolmoset"),
    NELOSET("Neloset"),
    VIITOSET("Viitoset"),
    KUUTOSET("Kuutoset");
    //PARI, KAHDET_PARIT, KOLME_SAMAA, NELJÄ_SAMAA, PIENI_SUORA, SUURI_SUORA, TÄYSKÄSI, SATTUMA, JATSI;

    Yhdistelma(String nimi) {
        this.nimi = nimi;
    }

    private String nimi;

    @Override
    public String toString() {
        return nimi;
    }

    public int annaPistemaara(Nopat nopat) {
        switch (this) {
            case YKKOSET:
                return pisteetTiettyLuku(nopat, 1);
            case KAKKOSET:
                return pisteetTiettyLuku(nopat, 2);
            case KOLMOSET:
                return pisteetTiettyLuku(nopat, 3);
            case NELOSET:
                return pisteetTiettyLuku(nopat, 4);
            case VIITOSET:
                return pisteetTiettyLuku(nopat, 5);
            case KUUTOSET:
                return pisteetTiettyLuku(nopat, 6);
        }
        return 0;
    }

    private static int pisteetTiettyLuku(Nopat nopat, int luku) {
        int summa = 0;
        for (int silmaluku : nopat.annaSilmaluvut()) {
            if (silmaluku == luku) {
                summa += luku;
            }
        }
        return summa;
    }
}


