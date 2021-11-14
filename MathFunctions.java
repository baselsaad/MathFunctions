import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

/**
 * Die Klasse MathFunctions enthält Methoden zum Ausführen verschiedene mathematische Operationen.
 * 
 * @author (Basel) , (Anas) 
 * @version (13.11.2021)
 */
public class MathFunctions
{
    
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
            throw new IllegalArgumentException ("Die Methode ist nur für die natuerliche Zahlen");
        }
        return teilersumme; //bei retrun 0 , muss eine Fehlermeldung angezeigt werden (in DialogKlasse kontrollieren) 
    }
    
    /**
     * ISBN ueberpruefen mit hilfe der Methode 'querSumme' 
     * @param isbn, der Wert der ISBN-Zahl wird durch den Parameter isbn aufgenommen. 
     */
     static String berechneChecksummeIsbn(long isbn) {
        if (String.valueOf(isbn).length() == 9){  
            long pruefzahl = (new MathFunctions().querSumme (isbn) % 11);
            if (pruefzahl == 10){
                return "\nDie Pruefzahl ist: X";
            }else{
                return "\nDie Pruefzahl ist: "+pruefzahl;
        }
        }else{ 
            throw new IllegalArgumentException( "\nDie Zahl muss aus neun Ziffern bestehen");
        }
   
    }
    
    /**
     * Quersumme berechnen
     * @param isbn, der Wert der ISBN-Zahl wird durch den Parameter isbn aufgenommen.
     */
    private long querSumme (long isbn){
        long quer_summe = 0;
        int i = 9;
        
        if (String.valueOf(isbn).length() == 9){
            
            while (isbn > 0){
            quer_summe += (i * (isbn%10));
            isbn /= 10;
            i--;
            }
        
        }else {
            System.out.println ("Die Zahl muss aus Neun Stellen bestehen!");
        }

        return quer_summe; 
    }
    /**
     * Nullstellen einer Quadratische Gleichung anhand der p-q-Formel und mit Hilfe der Methode pqFormelBerechnen brechnen.
     * @param p, erste Variable
     * @param q, zweite Variable
     */
    static String berechneNullstellen(double p, double q) {
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
     * @param doppelte, dient zur ueperpruefung , ob es um eine doppelte oder einfache Nullstelle geht
     */
    private String pqFormelBerechnen (double p,double q,boolean doppelte){
        double x1 = 0d;
        double x2 = 0d;
        String form = "#.##";
        DecimalFormat decimal = new DecimalFormat (form);
        if (doppelte){
            x1 = (-p/2) + Math.sqrt(((Math.pow(p/2,2))-q));
            return "Dopplete Nullstelle: "+x1;
        }else {
            x1 = (-p/2) + Math.sqrt(((Math.pow(p/2,2))-q));
            x2 = (-p/2) - Math.sqrt(((Math.pow(p/2,2))-q));
            return "Zwei Nullstellen X1: "+decimal.format(x1) + " | X2: "+decimal.format(x2);
          
        }
    }
    
    
}
