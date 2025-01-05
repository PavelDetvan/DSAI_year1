import java.util.*;
import java.util.Scanner;

public class CoolNumbers {

    // public static void main(String[] args) {

    //     //This is just to test your method
    //     Scanner input = new Scanner(System.in);
    //     System.out.println("give in start");
    //     int s = input.nextInt();
    //     System.out.println("give in n");
    //     int n = input.nextInt();
    //     System.out.println("give in end");
    //     int e = input.nextInt();
        
    //     if(s>0){
    //         isCool(n, s);
    //         System.out.println(isCool(n, s));
    //         countCools(s, n, e);
    //     }
    //     else{
    //     }
        

    // }
    public static boolean isCool(int x, int n) {
     // your code here
        boolean bool = false;
        while(x>0){
            int check = x%10;
            if(check!=0 && n%check ==0 ){
                bool = true;
            }
            else{
                bool = false;
                break;
            }
            x = x/10;
        }
        //System.out.println(bool);
        return bool;

    }


    public static int countCools(int n, int a, int b) {
     //your code here
        int counter = 0;
        for(int i = a; i<=b; i++){
            System.out.println(i);
            if(isCool(i, n)==true){
                counter+=1;
            }
        }
        System.out.println(counter);
        return counter;
    }


    
}