package no.oslomet.cs.algdat.Oblig1;

////// Loesningsforslag Oblig 1 - 2019 ////////////////////////
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

    // hjelpemetoder som bytter plass paa verdiene naar den kalles
    public static void bytt(int[] a, int i, int j){
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static void byttChar(char []a, int b, int c){
        char temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }

    // randPerm metode som generer tilfeldige tall - brukt ifm testing i main
    public static int[] randPerm(int n){
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for(int k = n - 1; k > 0; k--){
            int i = r.nextInt(k+1);
            bytt(a,k,i);
        }

        return a;  // permutasjonen returneres
    }

    /** Oppgave 1
     *
     * @author Ana-Maria og Camilla
     *
     * Gitt en tabell med tallene fra 1 til n vil det vaere :
     * 1) Flest ombyttinger: naar stoerste verdi er paa indeks 0
     * 2) Faerrest ombyttinger: tabellen er sortert stigende
     * 3) Finner gjennomsnitt antall ganger ved aa beregne antall operasjoner som gjoeres i ombyttinger():
     *    2 + n - 1 + 1 + n + 3n + 2x + 1 = 3 + 5n + 2x. Det harmoniske tallet er 5n.
     *    Vi faar en en 0(n) - algoritme.
     * 4) Er denne maks metoden bedre (eller daarligere) enn de maks metodene vi har sett paa tidligere?
     * - Hvis vi fokuser paa sammenligningen i for-loekken -> if(a[i] > a[i+1] har vi her, sammenlignet med
     *   de andre maksmetodene én tabelloperasjon ekstra (a[i+1]).
     *   De andre maksmetodene setter tilordningen maksverdi utenfor for-loekken, dermed vil ikke denne operasjonen
     *   skje for hver gang det itereres gjennom loekken. Med andre ord kan man si at den er noe mindre effektiv.
     */

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a){

        if(a.length < 1){
            throw new NoSuchElementException("Tabellen er tom");
        }

        for(int i = 0; i < a.length-1; i++){
            if(a[i] > a[i+1]){
                bytt(a,i,i+1);
            }
        }
        return a[a.length-1];
    }


    public static int ombyttinger(int[] a){
        int teller = 0;

        for(int i=0; i < a.length -1; i++){
            if(a[i] > a[i+1]){
                bytt(a,i,i+1);
                teller++;
            }
        }
        return teller; // Returnerer antall ombyttinger
    }

    // Egendefinert metode for aa beregne gjennomsnittet - brukt ifm testing for å svare på teorispm.
    public static int gjennomsnitt(int[] a){
        int sum = 0;

        for(int i = 0; i < a.length; i++){
            sum += ombyttinger(a);
        }
        int snitt = sum / a.length;
        return snitt;
    }

    /** Oppgave 2
     *
     * @author Ana-Maria og Maria
     */
    ///// Oppgave 2 //////////////////////////////////////
    // hjelpemetode for aa sjekke sortert rekkefoelge (stigende)
    public static boolean sortertArray(int[] a){
        for(int i=0; i < a.length -1; i++){
            if(a[i] > a[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static int antallUlikeSortert(int[] a){

        if (!sortertArray(a)) {
            throw new IllegalStateException("Arrayet er ikke sortert i stigende rekkefoelge!");
        }

        if(a.length == 0){
            return 0;
        }

        int teller = 1;
        for (int i = 0; i < a.length -1; i++){
            if (a[i] != a[i + 1]) {
                teller++;
            }
        }
        return teller;
    }


    /** Oppgave 3
     *
     * @author Ana-Maria
     */
    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a){

        if(a.length == 0){ // Returnerer 0 dersom tabellen er tom
            return 0;
        }

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

    /** Oppgave 4
     *
     * @author Christian og Camilla
     *
     * Metoden tar inn en liste, sorterer oddetall til hoeyre i listen, og partall til venstre.
     * Deretter sorteres sublistene i stigende rekkefoelge
     */
    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a){
        int oddetall = 0;

        for(int i=0;i<a.length;i++){ //ser etter oddetall, teller de og setter de fremst i listen
            if(a[i] % 2 == 1 || a[i] % 2 == -1){
                bytt(a, i, oddetall);
                oddetall++;
            }
        }
        quickSort(a, 0, oddetall-1);
        quickSort(a, oddetall, a.length-1);
    }

    //HJELPEMETODER
    private static int partition(int[] a, int begin, int end){
        int pivot = a[end];
        int j = (begin-1);

        for(int i = begin; i < end; i++){
            if(a[i] <= pivot){
                j++;
                bytt(a, i, j);
            }
        }
        bytt(a, j+1, end);
        return j+1;
    }

    public static void quickSort(int[] values, int left, int right){
        if(left < right){
            int pivot_index = partition(values, left, right);
            quickSort(values, left, pivot_index-1);
            quickSort(values, pivot_index+1, right);
        }
    }

    /** Oppgave 5
     *
     * @author Signe og Maria
     */
    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a){

        for(int i = a.length -1; i > 0; i--){
            byttChar(a,i-1,i);
        }

    }

    /** Oppgave 6
     *
     * @author Signe og Maria
     */
    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k){
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
        System.arraycopy(b,0,a,0,k);
    }

    /** Oppgave 7a)
     *
     * @author Signe
     */
    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t){

        String[] S = s.split("");
        String[] T = t.split("");

        //Haandtering av tomme strenger:
        if(S.length == 0 && T.length == 0) return "";
        if(S.length == 0) return t;
        if(T.length == 0) return s;

        int i = 0, j = 0;
        String ut = "";

        while(i < S.length && j < T.length){
            ut += S[i++];
            ut += T[j++];
        }
        // vi maa ta med resten
        while(i < S.length){
            ut += S[i++];
        }
        while(j < T.length){
            ut += T[j++];
        }

        return ut;

    }

    /** Oppgave 7b)
     *
     * @author Signe
     */
    /// 7b)
    public static String flett(String... s){

        //Her skal en liste med Strings flettes sammen.
        //En for-loekke som gaar igjennom alle stringsene. For hver runde gjoeres stringen om til et array og
        //man henter ut den bokstaven som ligger paa i. Sjekker foerst at det finnes noe paa det stedet i Stringen.

        if(s.length == 0){
            return "";
        }

        //Finner lengste String:
        int storst = s[0].length();
        for(int a = 1; a < s.length; a++){
            if(s[a].length() > storst){
                storst = s[a].length();
            }
        }

        String ut = "";

        //Loekker som gaar igjennom alle Strengene i listen og setter dem inn i "ut".
        for(int j = 0; j < storst; j++){
            for(int i = 0; i < s.length; i++){

                String[] a = s[i].split("");
                if(!(a[0].equals("0"))){
                    try{
                        ut += a[j];
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        a[0] = "0";
                    }
                }
            }
        }
        return ut;
    }

    /** Oppgave 8
     *
     * @author Camilla, Ana-Maria, Christian, Signe
     */

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a){
        if(a.length == 0){
            int[] indeks = new int[a.length];
            return indeks;
        }
        else if(a == null || a.length == 1){
            int[] indeks = new int[1];
            return indeks;
        }
        else{
            int[] sortert = new int[a.length];
            int[] indeks = new int[a.length];

            for(int i = 0; i < a.length; i++){
                sortert[i] = a[i];
            }
            sortering(sortert);

            for(int i = 0; i < sortert.length; i++){
                for(int j = 0; j < a.length; j++){
                    if(sortert[i] == a[j]){
                        indeks[i] = j;
                    }
                }
            }

            int peker = 0;
            int gjeldeneNummer;
            while(peker < indeks.length){
                gjeldeneNummer = indeks[peker];
                for(int i = 0; i < indeks.length-1; i++){
                    if(gjeldeneNummer == indeks[i] && i>peker){
                        indeks[i] = i;
                        break;
                    }
                }
                peker++;
            }
            return indeks;
        }
    }

    //HJELPEMETODER
    public static void sortering(int[] a){
        int n = a.length;   // tabellens lengde

        if(n < 2){    // maa ha minst to verdier!
            throw new NoSuchElementException("a.length(" + n + ") < 2!");
        }

        int m; //stoerste, av gjenvaerende verdier i array

        for(int i = n; i > 1; i--){
            m = maks(a, 0, i);
            bytt(a, i-1, m);
        }
    }

    public static int maks(int[] a, int fra, int til){
        if(a == null){
            throw new NullPointerException("tabellen a er null"); //sjekker om tabellen er null
        }

        int m = fra;              // indeks til stoerste verdi i a[fra:til>
        int maksverdi = a[fra];   // stoerste verdi i a[fra:til>

        for (int i = fra+1; i < til; i++){
            if (a[i] > maksverdi){
                m = i;                // indeks til stoerste verdi oppdateres
                maksverdi = a[m];     // stoerste verdi oppdateres
            }
        }
        return m;  // posisjonen til stoerste verdi i a[fra:til>
    }

    /** Oppgave 9
     *
     * @author Christian
     */

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a){
        int n = a.length;
        if(n < 3){
            throw new NoSuchElementException("a.length(" + n + ") < 3!");
        }

        int[] b = new int[3];
        for(int i = 0; i < b.length; i++){
            b[i] = a[i];
        }

        int[] bSortert = indekssortering(b);
        int m = bSortert[0];
        int nm = bSortert[1];
        int tm = bSortert[2];

        int minverdi = a[m];
        int nestminverdi = a[nm];
        int tredminverdi = a[tm];

        for(int i = 3; i < n; i++){
            if(a[i] < tredminverdi){
                if(a[i] < nestminverdi){
                    if(a[i] < minverdi){
                        tm = nm;
                        tredminverdi = nestminverdi;

                        nm = m;
                        nestminverdi = minverdi;

                        m = i;
                        minverdi = a[m];
                    }
                    else{
                        tm = nm;
                        tredminverdi = nestminverdi;

                        nm = i;
                        nestminverdi = a[nm];
                    }
                }
                else{
                    tm = i;
                    tredminverdi = a[tm];
                }
            }
        }
        return new int[] {m,nm,tm};    // m i posisjon 0, nm i posisjon 1, tm i posisjon 3
    } // tredMin

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav){
        throw new NotImplementedException();
    }

    /** Oppgave 10
     * 
     * @author Signe, Maria og Christian
     */
    public static boolean inneholdt(String a, String b){

        int[] forekomstAvBokstaverIA = new int[256];    // array med lengden til alle tegn i ASCII - totalt 256
        int[] forekomstAvBokstaverIB = new int[256];

        char[] A = a.toCharArray();  // gjoer om String til char array
        char[] B = b.toCharArray();


        for(char c : A){ // oeker verdien til posisjonen som matcher ASCII-nr til bokstaven
            forekomstAvBokstaverIA[c]++;
        }

        for(char c : B){ // oeker verdien til posisjonen som matcher ASCII-nr til bokstaven
            forekomstAvBokstaverIB[c]++;
        }

        //sjekker om antall forekomst i A er lik forekomst i B.
        for(int i = 0; i < 256; i++){
            if(forekomstAvBokstaverIB[i] < forekomstAvBokstaverIA[i]){
                return false;
            }
        }
        return true;
    }

}  // Oblig 1
