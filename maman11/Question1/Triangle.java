/**
 * The program gets the length of the three sides of the  
 * triangle and calculate perimeter and area of a triangle.
 * 
 * @author Dmitriy Chudnovsky
 * @version 11.1
 */
import java.util.Scanner;
public class Triangle
{
     /**
     *  Gets three sides of triagle, 
     *  checks their legality, 
     *  in case of illegal sides - prints appropriate notice
     *  otherwise - calculates perimeter and area of a triangle
     */
    public static void main(String[]args)
    {
        int a,b,c,perimeter;
        final int MAX=100;
        double s,area,beforeRounding,afterRounding;
        //Gets three sides of triagle
        Scanner scan = new Scanner(System.in);
        System.out.println("This program calculates the area "+
        "and the perimeter of a given triangle ");
        System.out.println("Please enter the three lengths of the "+
        "triangle's sides:");
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();
        // if sides legal calculates perimeter and area if not jump to else
        if((a>0) && (b>0) && (c>0) && (a+b>c) && (a+c>b) && (c+b>a)){
        perimeter=a+b+c;
        System.out.println("The perimeter is:"+perimeter);
        s=0.5*perimeter;
        area=Math.sqrt(s*(s-a)*(s-b)*(s-c));
        //rounding a value of area
        beforeRounding=area;
        afterRounding=Math.round(beforeRounding*MAX)/(MAX*1.0);
        area=afterRounding;
        System.out.println("The area is: "+area);
    }//if
    //if sides illegal
        else
        System.out.println("You can not create a triangle");
    }//main
}//class Triangle