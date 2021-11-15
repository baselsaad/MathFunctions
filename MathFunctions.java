import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

/**
 * Die Klasse MathFunctions enthält Methoden zum Ausführen verschiedene mathematische Operationen.
 * 
 * (Saad, Basel) , (Zahra, Anas) 
 * @version (15.11.2021)
 */
public class MathFunctions{
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
     * Die angegebene Zahl wird geprueft, ob es ein richtige ISBN Zahl ist.
     * 
     * @param isbn, der Wert der ISBN-Zahl wird durch den Parameter isbn aufgenommen. 
     */
     static String berechneChecksummeIsbn(long isbn) {
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
     * @param doppelte, dient zur ueperpruefung , ob es um eine doppelte oder einfache Nullstelle geht.
     * Die angegebenen Nullstellen werden zwei nachKommastellen gerundet.
     */
    private String pqFormelBerechnen (double p,double q,boolean doppelte){
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
    
    
}
