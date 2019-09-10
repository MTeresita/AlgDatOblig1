package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 - 2019 ////////////////////////
/**
 * Camilla Hoelgaard - s333783
 * Maria Teresita Halvorsen - s326325
 * Signe Aanderaa Eide - s333781
 * Ana-Maria Poljac - s333745
 * Christian Dyrli - s333738
 */

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;


public class Oblig1 {


    private Oblig1() {
    }

    // metode som bytter plass på verdiene når den kalles
    public static void bytt(int[] a, int i, int j){
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    /** Oppg.1 :
     * Gitt en tabell med tallene fra 1 til n vil det være :
     * Flest ombyttinger: når største verdi er på indeks 0
     * Færrest ombyttinger: omvendt av over - når største verdi er på siste indeks
     * I gjennomsnitt:
     */

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {

        //MARIA WAS HERE
        //AMPELINII was here

        //throw new NotImplementedException(); // TODO: se på denne (original)

        if(a.length < 1){
            throw new NoSuchElementException("Tabellen er tom");
        }

        for(int i= 0; i < a.length-1; i++){
            if(a[i] > a[i+1]){
                bytt(a,i,i+1);
            }
        }
        return a[a.length-1];
    }

    // Henter inn hjelpemetoder
    public static void randPerm(int[] a) {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a, k, i);
        }
    }

    public static int[] randPerm(int n) { // stokker om a
        Random r = new Random();         // en randomgenerator (hentes fra java.util)
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--){ // løkke som går n - 1 ganger

            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k [0,k]
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }

    public static int ombyttinger(int[] a) {

        //throw new NotImplementedException(); // TODO: se på denne (original)

        int teller = 0;
        randPerm(a);

        for(int i=0; i < a.length -1; i++){
            if(a[i] > a[i+1]){
                bytt(a,i,i+1);
                teller++;
            }
        }
        return teller; // Returnerer antall ombyttinger
    }

    // Egendef metode
    public static int gjennomsnitt(int[] a){
        int sum = 0;

        for(int i = 0; i < a.length; i++){
            sum += ombyttinger(a);
        }
        int snitt = sum / a.length;
        return snitt;
    }

    // For testing per nå - endres / fjernes
    public static void main(String[] args) {
        int[] a = {1,2,11,4,2,6,7,13,9,10};
        int[] b = randPerm(20); // TODO: Bør defineres som egen metode alt. i test klassen

        System.out.println("Maks verdi er: "+ maks(a));
        System.out.println("Array det jobbes på: "+Arrays.toString(a));
        System.out.println("-------------------------------------------------");
        System.out.println("Antall ombyttinger :"+ombyttinger(b));
        System.out.println("Arrayet det jobbes på:"+Arrays.toString(b));
        System.out.println("Gjennomsnittlig ombyttinger er "+gjennomsnitt(b));
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        throw new NotImplementedException();
    }


    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new NotImplementedException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new NotImplementedException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new NotImplementedException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new NotImplementedException();
    }


    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new NotImplementedException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new NotImplementedException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new NotImplementedException();
    }

}  // Oblig1
