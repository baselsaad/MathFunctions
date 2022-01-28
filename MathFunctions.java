import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
import java.math.BigDecimal;

/**
 * Die Klasse MathFunctions enthält Methoden zum Ausführen verschiedene mathematische Operationen.
 * 
 * (Saad, Basel) , (Zahra, Anas) 
 * @version (22.11.2021)
 */
public class MathFunctions{
    private MathFunctions(){}
    
    /**
     * hier wird die Teilersumme einer Zahl berechnet
     * @param zahl, Teilersumme dieses Parameters wird berechnet.
     */
    static long berechneTeilersumme (long zahl){
        long teilersumme = 0;
        
        if (zahl > 0){
            for (int a = 1;a <= zahl;a++){
                if ((zahl % a) == 0){
                    teilersumme += a;
                }
            }
        }else {
            throw new IllegalArgumentException ("Die Methode ist für die natuerliche Zahlen gewidmet");
        }
        
        return teilersumme; //bei retrun 0 , muss eine Fehlermeldung angezeigt werden (in DialogKlasse kontrollieren) 
    }
    
    /**
     * Die angegebene Zahl wird geprueft, ob es ein richtige ISBN Zahl ist.
     * 
     * @param isbn, der Wert der ISBN-Zahl wird durch den Parameter isbn aufgenommen. 
     */
    public static String berechneChecksummeIsbn(long isbn) {
        long quer_summe = 0;
        int i = 9;
        String rechenweg = "z10= ";
        
        if (String.valueOf(isbn).length() == 9){
            while (isbn > 0){
                if (i == 1){
                    rechenweg += i +"*"+(isbn%10);
                }else{
                    rechenweg += i +"*"+(isbn%10)+" + ";
                }
                quer_summe += (i * (isbn%10));
                isbn /= 10;
                i--;
            }
        }else {
            throw new IllegalArgumentException ("Die Zahl muss aus Neun Stellen bestehen!");
        }
        
        long pruefzahl = quer_summe % 11;
            if (pruefzahl == 10){
                rechenweg += " = "+ String.valueOf(quer_summe)+ " mod 11 = X"; 
                return "\n"+rechenweg;
            }else{
                rechenweg += " = "+ String.valueOf(quer_summe)+ " mod 11 = "+String.valueOf(pruefzahl); 
                return "\n"+rechenweg;
        }
    }
    
    /**
     * Nullstellen einer Quadratische Gleichung anhand der p-q-Formel und mit Hilfe der Methode pqFormelBerechnen brechnen.
     * @param p, erste Variable
     * @param q, zweite Variable
     */
    public static String berechneNullstellen(double p, double q) {
        double D = ((Math.pow(p/2,2))) - q;
       
        if (D > 0 ){          
            return new MathFunctions().pqFormelBerechnen (p,q,false);
        }else if (D == 0 ){
            return new MathFunctions().pqFormelBerechnen (p,q,true); 
        }else {
            return "In diesem Programm werden die komplexen Nullstellen nicht berechnet";
        }
        
    }
    
    /**
     * Nullstellen einer Quadratische Gleichung anhand der p-q-Formel brechnen.
     * @param p, erste Variable
     * @param q, zweite Variable
     * @param doppelte, dient zur ueperpruefung , ob es um eine doppelte oder einfache Nullstelle geht.
     * Die angegebenen Nullstellen werden zwei nachKommastellen gerundet.
     */
    private static String pqFormelBerechnen (double p,double q,boolean doppelte){
        
        double x1 = 0d;
        double x2 = 0d;
        String form = "#.##";
        DecimalFormat decimal = new DecimalFormat (form);
        if (doppelte){
            x1 = (-p/2) + Math.sqrt(((Math.pow(p/2,2))-q));
            return "Dopplete Nullstelle: x = "+decimal.format(x1);
        }else {
            x1 = (-p/2) + Math.sqrt(((Math.pow(p/2,2))-q));
            x2 = (-p/2) - Math.sqrt(((Math.pow(p/2,2))-q));
            return "Zwei Nullstellen x1 = "+decimal.format(x1) + " | x2 = "+decimal.format(x2);
        }
    }
    
    /**
     *prueft zu einer natuerlichen Zahl, ob es natuerliche Zahlen a, b, c gibt, so dass gilt zahl = a^4 + b^3 + c^2 .
     *@param i, grenze weil es wird lange dauern wenn die zahl gruesser als 3 ist.
     */
    public static boolean istSummeVonPotenzen(long zahl)
    {
        long i = 3 ; //i = 3 weil es wird lange dauern wenn die zahl gruesser als 3 ist.
        
        if (zahl > 0 ){
        for (int a = 1 ; a <= i; a++){
             for (int b =1 ; b <= i ; b++){ 
                 for (int c = 1 ; c <= i ; c++){   
                    if (zahl == Math.pow(a,4) + Math.pow(b,3) + Math.pow(c,2)){
                        //System.out.printf("a^4 = %d -- > b^3 = %d --> c^2 = %d \n" , a,b,c );
                        return true;
                    }
                }
            }
        }
        }else{
            throw new IllegalArgumentException ("Die zahl muss groesser als 0 sein!");
        }
        return false ; 
    }
    
    /**
     *  Den groessten gemeinsamen Teiler zweier natuerlicher Zahlen
     * @param zahl1, erste Eingabe als int
     * @param zahl2, zweite Eingabe als int
     */
    public static int berechneGgt (int zahl1,int zahl2){
        if (zahl1 <= 0 || zahl2 <= 0){
            throw new IllegalArgumentException ("Bitte geben Zahlen, die groesser als 0 sind");
        }
        int kleinezahl = getKleineZahl(zahl1,zahl2);
        int gemeinsameteiler = 0;
        for(int a = 1;a <= kleinezahl;a++){
            if ((zahl1 % a) == 0 && (zahl2 % a) == 0 ){
                gemeinsameteiler = a;
            }
        }
        return gemeinsameteiler;
    }
    
    /**
     * Kleine Zahl aus 'zahl1' und 'zahl2' herausfinden
     * @param zahl1, erste Eingabe als int
     * @param zahl2, zweite Eingabe als int
     */
    private static int getKleineZahl (int zahl1,int zahl2){
        if (zahl1 > zahl2){
            return zahl1;
        }else if (zahl2 > zahl1){
            return zahl1;
        }else{
            return zahl1;
        }
    }
    
    public static long berechneFakultaet(int zahl) {
        long fakultaet = 1; 
        long zahl_0 = 0 ;
        
        if ( zahl >= 0 ){
        for (int i = 1; i <= zahl; ++i) {
            fakultaet *= i;
        }
        }else{
        throw new IllegalArgumentException ("Die Methode ist für die natuerliche Zahlen gewidmet");
        }
        
        if (fakultaet <= Math.pow(2,63)-1 && fakultaet >= 0 && fakultaet > 20 ){
            zahl_0 = fakultaet ;
        }else {
            System.out.println("\nDieser Zahl kann nicht berchnet werden weil es zu groess ist");
        }
        
        return zahl_0 ;
    }
    
    /**
     * Die Methode berechnet zu einer uebergebenen ganzen
     * Zahl 'anzahl' und einem Wert 'x' die folgende mathematische Funktion
     * und gibt das Ergebnis zurueck.
     */
    public static double berechneReihensumme (int anzahl , double x){
        int anzahldersumme = 1;
        double reihensumme = 0.0d;
        if (anzahl <= 0 || x <= 0 ){
            throw new IllegalArgumentException ("Sie koennen nur natuerliche Zahlen eingeben!");
        }
            while (anzahldersumme <= anzahl){     
            reihensumme += Math.round((Math.pow (x-1,anzahldersumme)) / (anzahldersumme * Math.pow(x,anzahldersumme))*100000.0)/100000.0; 
            anzahldersumme++;
        }
       
        return reihensumme;
    }
    
}
