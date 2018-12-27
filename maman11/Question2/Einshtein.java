/**
 * The program is a riddle of Albert Einstein
 * 
 * @author Dmitriy Chudnovsky
 * @version 11.2
 */
import java.util.Scanner;
public class Einshtein
{
    /**
     *  Gets 3 digit positive number whose first and last digits are different, 
     *  checks their legality, 
     *  in case of illegal number - prints appropriate notice,
     *  otherwise - calculates  difference between the number 
     *  and the opposite number   which always must be positive,
     *  take this difference numbers and add him to opposite number of this difference,
     *  checks adding numbers a value is 1089,
     *  in case of value is not 1089 - prints appropriate notice
     */
    
    public static void main(String[]args)
    {
        int num,num1,num2,num3;
        final int Ten=10;
        final int HUN=100;
        final int FIX=1089;
        //Gets a 3 digit positive number
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Einshtein magic game");
        System.out.println("Please enter a 3 digit positive number whose first and last digits are different:");
        num = scan.nextInt();
        if((num<100) || (num>999))//check legality of number if legal jump to else
        System.out.println("The number you entered is not a 3 digit positive number");
        else
        {
            System.out.println("User number is:"+num);
            num1=(num/HUN)+(num%HUN-num%Ten)+((num%Ten)*HUN);//opposite number
            num2=Math.abs(num-num1);//positive difference
            System.out.println("Difference:"+num2);
            num3=(num2/HUN)+(num2%HUN-num2%Ten)+((num2%Ten)*HUN);//opposite number of difference numbers
            System.out.println("Reversed difference:"+num3);
            if((num2+num3)==FIX)//adding of difference of numbers and his opposite number and check adding is 1089
            System.out.println("SUCCEEDED");
            else//adding is not 1089
            System.out.println("FAILED");
        }//else
    }//main
}//Class Einshtein