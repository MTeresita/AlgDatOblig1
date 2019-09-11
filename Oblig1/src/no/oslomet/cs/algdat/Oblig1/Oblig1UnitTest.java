package no.oslomet.cs.algdat.Oblig1;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Denne klassen kan du bruke til hjelp under utvikling av din oblig.
 * Lag små og enkle test-eksempler for å teste at metoden din fungerer som ønsket.
 */
class Oblig1UnitTest {

    @org.junit.jupiter.api.Test
    void maks() {
        int[] a = {1,5,23,4,6,8};

        int test = Oblig1.maks(a);
        assertEquals(23, test);

        //int pos = Oblig1.
        //assertEquals(true, false, "Implementer maks og denne testen");
    }

    @org.junit.jupiter.api.Test
    void ombyttinger() {
        int[] a = {1,5,23,4,6,8};
        int[] b = {22,3,56,43,12,2};
        int[] c = {10,15,4,6,2,3,7};


        int atest = Oblig1.ombyttinger(a);
        assertEquals(3, atest);
        int btest = Oblig1.ombyttinger(b);
        assertEquals(4, btest);
        int ctest = Oblig1.ombyttinger(c);
        assertEquals(5, ctest);
        //assertEquals(true, false, "Implementer ombyttinger og denne testen");
    }

    @org.junit.jupiter.api.Test
    void gjennomsnitt() {
        int[] a = {1,2,3,4};

        int test = Oblig1.gjennomsnitt(a);
        assertEquals(16, test);

        //int pos = Oblig1.
        //assertEquals(true, false, "Implementer maks og denne testen");
    }
/*
    @org.junit.jupiter.api.Test
    void antallUlikeSortert() {
        assertEquals(true, false, "Implementer antallUlikeSortert og denne testen");
    }

    @org.junit.jupiter.api.Test
    void antallUlikeUsortert() {
        assertEquals(true, false, "Implementer antallUlikeUsortert og denne testen");
    }

    @org.junit.jupiter.api.Test
    void delsortering() {
        assertEquals(true, false, "Implementer delsortering og denne testen");
    }

    @org.junit.jupiter.api.Test
    void rotasjon() {
        assertEquals(true, false, "Implementer rotasjon og denne testen");
    }

    @org.junit.jupiter.api.Test
    void flett() {
        assertEquals(true, false, "Implementer flett og denne testen");
    }

    @org.junit.jupiter.api.Test
    void indekssortering() {
        assertEquals(true, false, "Implementer indekssortering og denne testen");
    }

    @org.junit.jupiter.api.Test
    void tredjeMin() {
        assertEquals(true, false, "Implementer tredjeMin og denne testen");
    }

    @org.junit.jupiter.api.Test
    void bokstavNr() {
        assertEquals(true, false, "Implementer bokstavNr og denne testen");
    }

    @org.junit.jupiter.api.Test
    void inneholdt() {
        assertEquals(true, false, "Implementer inneholdt og denne testen");
    }*/
}