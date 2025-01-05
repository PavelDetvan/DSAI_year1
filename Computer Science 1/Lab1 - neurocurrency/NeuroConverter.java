import java.util.Scanner;

public class NeuroConverter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your amount?:");
        double amount = scanner.nextDouble();

        scanner.nextLine();
        converter(amount);
    }

    public static void converter(double amount) {
        int coins = (int) amount; 
        System.out.println(coins); //prints number of NeuroCoins

        double cents = amount - coins; //subtracting NeoroCoins, so only cents remains
        cents = Math.round(cents * 100.0)/100.0; //rounding cents to 2 decimal places

        double halfCents = cents/0.49; //calculating number of 49-cent coins
        System.out.println((int)halfCents); //printing, but only int, because answer need to be in int
        
        double remain = cents - 0.49*(int)halfCents; //calculationg remaining sum
        remain = Math.round(remain * 100.0)/100.0; //rounding to 2 decimals
        
        double nineCents =  remain/0.09; //calculating num of 9 cent coins
        System.out.println((int)nineCents);

        double oneCents = remain - 0.09*(int)nineCents; //calculating number of 1 cent coins
        System.out.println((int)(oneCents*100));
    }
}
