import java.lang.Math;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Die Klasse Dialogklasse dient zum testen der MathFunctions
 * 
 * @author (Saad, Basel) , (Zahra, Anas) 
 * @version (15.11.2021)
 */
public class Dialogklasse {
    
    private Scanner input;
    private boolean END;
    
    /**
     * Klassenkonstanten
     */
    private static final int TEILERSUMME = 1;
    private static final int ISBN_EINGABE = 2;
    private static final int QUADRATISCHE_GLEICHUNG = 3;
    private static final int GGT = 4;
    private static final int REIHENSUMME = 5;
    private static final int ENDE = 0;
    
    public Dialogklasse (){
        
        input = new Scanner (System.in);
        END = false;
    }
    
    // Main Methode der Dialogklasse
    public static void main (String [] args){
      
        new Dialogklasse().start();
    }
    
    /**
    *Hauptschleife des Dialogs Programms
    */
    private void start (){
       int funktions = -1;
       while (!END){
           try {
               funktions = eingabeLesen();
               verarbeitungsFunktion(funktions);
           }catch (IllegalArgumentException e) {
               System.out.println (e);
           }catch (InputMismatchException e){
               System.out.print (e);
               System.out.println (" Sie muessen hier nur Zahlen eingaben");
               input.nextLine();
           }catch (Exception e ){
               System.out.println (e);
               e.printStackTrace() ;
               }
       }  
    }
   
    /**
    * Hier wird eine Meneu ausgegeben und Funktion eingelesen.
    * 
    * @return eingelesene Funktion als ganzzahliger Wert
    */
    private int eingabeLesen (){
        int funktion;
        System.out.println ("\nGeben Sie die Nummer der Funktion ein\n");
        System.out.println ("-> Teilersumme berechnen: "+ TEILERSUMME
                            +"\n-> ISBN-Pruefzahl berechnen : "+ISBN_EINGABE
                            + "\n-> p-q-Formel Anwenden: "+QUADRATISCHE_GLEICHUNG 
                            + "\n-> Groesste gemeinsamen Teiler: "+GGT 
                            + "\n-> ReihenSumme berechnen: "+REIHENSUMME
                            + "\n-> Ende: "+ENDE);
        
        funktion = input.nextInt();
        return funktion;
    }
    
     /**
     * Hier wird die benutzerdefinierte Funktion ausgeführt.
     */
    private void verarbeitungsFunktion (int funktion){
       switch (funktion){
           case TEILERSUMME : 
               teilerSumme();
               break;
           case ISBN_EINGABE :
               isbnZahl();
               break;
           case QUADRATISCHE_GLEICHUNG: 
               QuadratischGleichung();
               break;
           case GGT : 
               Ggtberechnen();
               break;
           case REIHENSUMME :
               reihenSummeBerechnen ();
               break;
           case ENDE:
               END = true;
               break;
           default : 
               System.out.println ("Falsche Eingabe");
       }
    }
    
    /**
    * Eine Zahl wird aus dem Anwender gefragt, um dieser Zahl die Teiler summe zu finden.
    */
    private void teilerSumme (){
        System.out.print ("Geben Sie bitte die Zahl ein: ");
        long zahl = input.nextLong();
        System.out.println ("\n"+String.format("Die Tielersummer von (%d): ", zahl)+MathFunctions.berechneTeilersumme(zahl));
    }
   
    /**
    * Eine neunstellige Zahl wird gefragt, um es zu prüfen, ob es eine richtige ISBN Zahl ist.
    */
    private void isbnZahl (){
        System.out.print ("Geben Sie eine neun-stellige Zahl ein: ");
        long isbn = input.nextLong();
        System.out.println (MathFunctions.berechneChecksummeIsbn(isbn));
    }
   
    /**
    * Die p und q werte werden gefragt um eine p-q Formel auszufuehren.
    */
    private void QuadratischGleichung (){
        double p = 0d;
        double q = 0d;
        System.out.print ("Geben Sie bitte die Variable P ein: ");
        p = input.nextDouble();
        System.out.print ("Geben Sie bitte die Variable Q ein: ");
        q = input.nextDouble();
       
        System.out.println ("\n"+MathFunctions.berechneNullstellen(p, q));
    }
    
    private void Ggtberechnen (){
        int zahl1 = 0;
        int zahl2 = 0;
        
        System.out.print("\nGeben Sie bitte die erste Zahl ein: ");
        zahl1 = input.nextInt();
        System.out.print("Geben Sie bitte die zweite Zahl ein: ");
        zahl2 = input.nextInt();
        
        System.out.println("ggT von ("+zahl1+" und "+zahl2+" ) = "+MathFunctions.berechneGgt(zahl1, zahl2));
    }
    
    private void reihenSummeBerechnen(){
        int i = 0;
        double x = 0.0d;
        System.out.print("\nGeben Sie bitte den Wert von i ein: ");
        i = input.nextInt();
        System.out.print("Geben Sie bitte den Wert von x ein: ");
        x = input.nextDouble();
        
        System.out.println("S"+i+"("+x+") = "+MathFunctions.berechneReihensumme(i, x));
        
    }
}
