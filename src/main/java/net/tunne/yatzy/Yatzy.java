package net.tunne.yatzy;

import java.util.List;
import java.util.Scanner;

public class Yatzy {

    public static void main(String[] args) {
        new Yatzy();
    }

    private Scanner scanner;
    private Peli peli;

    private Yatzy() {
        System.out.println("Tervetuloa peliin! Syötä pelaajien lukumäärä?");
        scanner = new Scanner(System.in);
        int pelaajienLukumaara = scanner.nextInt();
        scanner.nextLine();
        System.out.format("Valitsit %d pelaajaa, aloitetaan!\n", pelaajienLukumaara);
        peli = new Peli(pelaajienLukumaara);
        for (int kierros = 1; kierros <= Yhdistelma.values().length; ++kierros) {
            for (Pelaaja pelaaja : peli.annaPelaajat()) {
                pelaaKierros(pelaaja);
            }
        }
        Pelaaja voittaja = peli.johtavaPelaaja();
        System.out.format("Peli päättyi. Pelaaja %d voitti pisteillä %d, onnea!\n",
                voittaja.annaPelaajanNumero(), voittaja.annaPistemaara());
        // kaikkien pelaajien pisteet järjestyksessä
        for (Pelaaja pelaaja : peli.annaPelaajatJarjestykessa()) {
            System.out.format("%d: %d\n", pelaaja.annaPelaajanNumero(), pelaaja.annaPistemaara());
        }
    }

    private void pelaaKierros(Pelaaja pelaaja) {
        System.out.format("Pelaaja %d:\n", pelaaja.annaPelaajanNumero());
        Nopat nopat = Nopat.arvoKaikki();
        for (int heitto = 1; heitto <= 3; ++heitto) {
            System.out.format("Heitto %d, Noppien silmäluvut: %s\n", heitto, nopat);
            System.out.format("Mitkä nopat heitetään uudestaan? Paina enter, mikäli haluat lopettaa kierroksen.\n");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                System.out.format("Ei heitetty yhtään noppaa\n");
                break;
            }
            String[] sanat = line.split(" +");
            for (String sana : sanat) {
                int noppa = Integer.parseInt(sana);
                nopat.arvoUusiSilmaluku(noppa);
            }
        }
        System.out.format("Yhdistelmät:\n");
        List<Rivi> rivit = pelaaja.annaRivit();
        for (int i = 0; i < rivit.size(); ++i) {
            Rivi rivi = rivit.get(i);
            int valinta = i + 1;
            Yhdistelma yhdistelma = rivi.annaYhdistelma();
            int pistemaara = yhdistelma.annaPistemaara(nopat);
            String pelattu = rivi.onPelattu() ? " (pelattu)" : "";
            System.out.format("%d %s: %d%s\n", valinta, yhdistelma, pistemaara, pelattu);
        }
        Rivi parasRivi = pelaaja.annaParasPelaamatonRivi(nopat);
        System.out.format("Valitse yhdistelmä, enter valitsee parhaan yhdistelmän:\n");
        String rivi = scanner.nextLine().trim();
        Rivi pelattuRivi = parasRivi;
        if (!rivi.isEmpty()) {
            int valinta = Integer.parseInt(rivi);
            pelattuRivi = rivit.get(valinta - 1);
        }
        pelattuRivi.pelaa(nopat);
        System.out.format("%s -yhdistelmä on lukittu. Pelaaja %d sai %d pistettä, yhteensä %d pistettä.\n",
                pelattuRivi.annaYhdistelma(), pelaaja.annaPelaajanNumero(),
                pelattuRivi.annaPistemaara(), pelaaja.annaPistemaara());
    }
}
