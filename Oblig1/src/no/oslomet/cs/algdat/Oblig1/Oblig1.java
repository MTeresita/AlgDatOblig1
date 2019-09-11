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

    // hjelpe metode som bytter plass på verdiene når den kalles
    public static void bytt(int[] a, int i, int j){
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static void byttChar(char []a, int b, int c){
        char temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }

    /** Oppg.1 :
     * Gitt en tabell med tallene fra 1 til n vil det være :
     * Flest ombyttinger: når største verdi er på indeks 0
     * Færrest ombyttinger: omvendt av over - når største verdi er på siste indeks
     * I gjennomsnitt:
     */

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {

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


    ///// Oppgave 2 //////////////////////////////////////

    // hjelpemetode for å sjekke sortert rekkefølge (stigende)
    public static boolean sortertArray(int[] a){
        for(int i=0; i < a.length -1; i++){
            if(a[i] > a[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static int antallUlikeSortert(int[] a) {

        if (!sortertArray(a)) {
            throw new IllegalStateException("Arrayet er ikke sortert i stigende rekkefølge!");
        }

        int teller = 1;
        for (int i = 0; i < a.length -1; i++) {
            if (a[i] != a[i + 1]) {
                teller++;
            }
            if(a.length == 0){
                teller = 0; // returnerer 0 hvis det er 0 forskjellige verdier i en tom tabell
            }
        }
        return teller;
    }


    /**
     * @author Ana-Maria og Maria
     */
    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        //throw new NotImplementedException();
        int teller = 0;
        for(int i = 0; i < a.length; i++){
            boolean duplikat = false;
            for(int j = 0; j < i; j++){
                if(a[i] == a[j]){
                    duplikat = true;
                    break;
                }
            }
            if(!duplikat){
                teller++;
            }
        }
        return teller;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {

        //Gjøres av Signe, Camilla og Christian
        throw new NotImplementedException();
    }

    /**
     * @author Signe og Maria
     */
    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        //TODO må legge til en feilmelding
        //TODO må testes i testklassen

        for (int i = a.length -1; i > 0; i--){
            byttChar(a,i-1,i);
        }

    }
    /**
     * @author Signe og Maria
     */
    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        //TODO må testes i testklassen
        int n = a.length;
        if (n < 2){
            return;
        }
        if((k %= n) < 0){
            k += n;
        }

        char [] b = Arrays.copyOfRange(a,n-k,n);
        for(int i = n-1; i >= k; i--){
            a[i] = a[i-k];
        }
        System.arraycopy(b,0,a,0,k); // DAFUQ IS DIS
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

    /**
     * @author Signe og Maria
     */
    public static boolean inneholdt(String a, String b) {

        //TODO: Vi har funnet en løsning uten å bruke hjelpemetode, funker det mon tro?? :/

        // Metoden skal ta inn to ord, begge inneholder kun store bokstaver. Ord A og B
        // Det skal sjekkes om alle bokstavene i A inngår i B.

        // 1. Splitte opp ordene i to lister
        // 2. Sjekke liste B opp imot liste A, fjerner elementet om det finne det
        // 3. Teller hvor mange elementer som blir fjernet fra liste B
        // 4. Om A.length er like lang som elementer slettet

        String[] A = a.split("");
        String[] B = b.split("");

        int teller = 0;

        for(int i = 0; i < B.length; i++){
            for(int j = 0; j < A.length; j++){
                if(A[j].equals(B[i])){
                    B[i] = "0";
                    teller++;
                }
            }
        }

        if(teller == A.length){
            return true;
        }
        return false;
    }

    // For testing per nå - endres / fjernes
    public static void main(String[] args) {
        int[] a = {1, 2, 11, 4, 2, 6, 7, 13, 9, 10};
        int[] b = randPerm(20); // TODO: Bør defineres som egen metode alt. i test klassen
        int[] sortert = {3, 3, 4, 5, 5, 6, 6, 7, 7, 7, 8};
        int[] usortert = {5, 3, 7, 4, 3, 5, 7, 8, 6, 7};
        char[] testListe = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};



        System.out.println("OPPGAVE 1:");
        System.out.println("Maks verdi er: " + maks(a));
        System.out.println("Array det jobbes på: " + Arrays.toString(a));
        System.out.println("-------------------------------------------------");

        System.out.println("OPPGAVE 2:");
        System.out.println("Antall ombyttinger :" + ombyttinger(b));
        System.out.println("Arrayet det jobbes på:" + Arrays.toString(b));
        System.out.println("Gjennomsnittlig ombyttinger er " + gjennomsnitt(b)); // TODO: kommentere i javadoc utfallet vi får med de forkjsellige str
        System.out.println("-------------------------------------------------");

        System.out.println("OPPGAVE 3:");
        System.out.println("Antall ulike sortert er: " + antallUlikeSortert(sortert));
        System.out.println(Arrays.toString(sortert));
        System.out.println("-------------------------------------------------");
        System.out.println("Antall ulike verdier : " + antallUlikeUsortert(usortert));
        System.out.println("-------------------------------------------------");

        System.out.println("OPPGAVE 5:");
        //rotasjon(testListe); //TODO tilhører oppgave 5 - kræsjer litt med hensikten til oppgave 6
        System.out.println(testListe);
        System.out.println("-------------------------------------------------");

        System.out.println("OPPGAVE 6:");
        System.out.println(Arrays.toString(testListe));
        rotasjon(testListe,3);
        System.out.println(testListe);
        rotasjon(testListe,-2);
        System.out.println(testListe);
        System.out.println("-------------------------------------------------");

        System.out.println("OPPGAVE 10:");
        String tekst = "ABBA";
        String tekst2 = "ABOPBE";
        System.out.println(inneholdt(tekst, tekst2));

    }


}  // Oblig1
