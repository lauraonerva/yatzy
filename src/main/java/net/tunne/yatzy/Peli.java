package net.tunne.yatzy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Peli {

    private final List<Pelaaja> pelaajat = new ArrayList<>();

    public Peli(int pelaajienLukumaara) {
        for (int pelaajanNumero = 1; pelaajanNumero <= pelaajienLukumaara; ++pelaajanNumero) {
            Pelaaja pelaaja = new Pelaaja(pelaajanNumero);
            pelaajat.add(pelaaja);
        }
    }

    public int annaPelaajienLukumaara() {
        return pelaajat.size();
    }

    public List<Pelaaja> annaPelaajat() {
        return pelaajat;
    }

    public Pelaaja johtavaPelaaja() {
        Pelaaja paras = null;
        for (Pelaaja pelaaja : pelaajat) {
            if (paras == null || paras.annaPistemaara() < pelaaja.annaPistemaara()) {
                paras = pelaaja;
            }
        }
        return paras;
    }

    public List<Pelaaja> annaPelaajatJarjestykessa() {
        List<Pelaaja> lista = new ArrayList<>(pelaajat);
        lista.sort(Comparator.comparingInt(Pelaaja::annaPistemaara));
        return lista;
    }
}
