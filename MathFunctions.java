import java.util.Scanner;

public class MathFunctions
{
    public long summe (long a){
        long quersumme = 0;
        int i = 9;
        
        if (String.valueOf(a).length() == 9){
            
            while (a > 0){
            quersumme += (i * (a%10));
            a /= 10;
            i--;
            }
        
        }else {
            System.out.println ("Die Zahl muss aus Neun Stellen bestehen!");
        }

        return quersumme; 
       
    }
}
