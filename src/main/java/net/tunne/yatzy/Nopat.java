package net.tunne.yatzy;

import com.sun.org.apache.bcel.internal.generic.NOP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Nopat {

    private static final int NOPPIEN_LUKUMAARA = 5;

    private Random random = new Random();
    private List<Integer> silmaluvut = new ArrayList<>();

    public Nopat() {
        for (int i = 0; i < NOPPIEN_LUKUMAARA; ++i) {
            silmaluvut.add(1);
        }
    }

    public Nopat(int... silmaluvut) {
        for (int silmaluku : silmaluvut) {
            this.silmaluvut.add(silmaluku);
        }
    }

    public static Nopat arvoKaikki() {
        Nopat nopat = new Nopat();
        for (int i = 1; i <= NOPPIEN_LUKUMAARA; ++i) {
            nopat.arvoUusiSilmaluku(i);
        }
        return nopat;
    }

    public List<Integer> annaSilmaluvut() {
        return silmaluvut;
    }

    public int annaSilmaluku(int noppa) {
        return silmaluvut.get(noppa - 1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int silmaluku : silmaluvut) {
            sb.append(silmaluku);
            sb.append(" ");
        }
        return sb.toString();
    }

    public void arvoUusiSilmaluku(int noppa) {
        int silmaluku = arvoSilmaluku();
        silmaluvut.set(noppa - 1, silmaluku);
    }

    private int arvoSilmaluku() {
        return random.nextInt(6) + 1;
    }
}
