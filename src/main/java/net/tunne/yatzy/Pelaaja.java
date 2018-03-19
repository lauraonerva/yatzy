package net.tunne.yatzy;

import java.util.ArrayList;
import java.util.List;

public class Pelaaja {

    private final int pelaajanNumero;
    private final List<Rivi> rivit = new ArrayList<>();

    public Pelaaja(int pelaajanNumero) {
        this.pelaajanNumero = pelaajanNumero;
        for (Yhdistelma yhdistelma : Yhdistelma.values()) {
            Rivi rivi = new Rivi(yhdistelma);
            rivit.add(rivi);
        }
    }

    public int annaPelaajanNumero() {
        return pelaajanNumero;
    }

    public Rivi annaRivi(int rivinNumero) {
        return rivit.get(rivinNumero);
    }

    public List<Rivi> annaRivit() {
        return rivit;
    }

    public Rivi annaParasPelaamatonRivi(Nopat nopat) {
        Rivi paras = null;
        for (Rivi rivi : rivit) {
            if (rivi.onPelattu()) {
                continue;
            }
            if (paras == null || paras.annaMahdollinenPistemaara(nopat) < rivi.annaMahdollinenPistemaara(nopat)) {
                paras = rivi;
            }
        }
        return paras;
    }

    public int annaPistemaara() {
        int pistemaara = 0;
        for (Rivi rivi : rivit) {
            // Pistemäärä on nolla jos riviä ei ole pelattu,
            // joten onPelattu() ei tarvitse tarkistaa.
            pistemaara += rivi.annaPistemaara();
        }
        return pistemaara;
    }
}
