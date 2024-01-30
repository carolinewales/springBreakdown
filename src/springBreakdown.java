import java.util.Scanner;

public class springBreakdown {
    public static void main(String[] args) {
        double total, nightlyRate, cleaning, fee, taxes;
        int nights, people;
        double idvTotal;

        int whole;
        int part, partNights;
        double partTotal;

        double overallTotal;

        String everyone;

        Scanner scnr = new Scanner(System.in);

        System.out.println("Welcome to Spring Break(down)!");
        System.out.println("What is the total cost of your trip?");
        total = scnr.nextDouble();

        System.out.println("Nice! How much does does it cost to stay each night?");
        nightlyRate = scnr.nextDouble();

        System.out.println("How many nights are you staying?");
        nights = scnr.nextInt();

        System.out.println("What is the cleaning fee?");
        cleaning = scnr.nextDouble();

        System.out.println("What is the Airbnb fee?");
        fee = scnr.nextDouble();

        System.out.println("What about taxes?");
        taxes = scnr.nextDouble();

        System.out.println("Finally, how many people are going on your trip?");
        people = scnr.nextInt();

        System.out.println("Is everyone going for every night? Enter [Y] or [N].");
        everyone = scnr.next();

        if (everyone.equals("Y") || everyone.equals("yes") || everyone.equals("Yes")){
            System.out.println("Great! Calculating your total now.");
            idvTotal = perPerson(nightlyRate, nights, cleaning, fee, taxes, people);

            System.out.println();
            System.out.println("Here's your breakdown: ");
            System.out.print("Each person will individually pay $");
            System.out.printf("%.2f", idvTotal);
            System.out.println();

            overallTotal = idvTotal * people;
        }
        else {
            System.out.println("Ok, how many people are staying the whole trip?");
            whole = scnr.nextInt();
            part = people - whole;

            System.out.println("Got it. " + whole + " people are staying the whole trip and " + part + " people are staying for part of the trip.");

            System.out.println("How many nights are the part-trippers staying for?");
            partNights = scnr.nextInt();
            int n = nights - partNights;

            idvTotal = ((nightlyRate * partNights)/people) + ((nightlyRate * n)/whole) + partOther(cleaning, fee, taxes, people);
            partTotal = ((nightlyRate * partNights)/people) + partOther(cleaning, fee, taxes, people);

            System.out.println();
            System.out.println("Here's your breakdown: ");
            System.out.print("Each person staying the whole trip will individually pay $");
            System.out.printf("%.2f", idvTotal);
            System.out.println();
            System.out.print("Each person staying for " + partNights + " nights will pay $");
            System.out.printf("%.2f", partTotal);
            System.out.println();

            overallTotal = (partTotal * part) + (idvTotal * whole);
        }

        System.out.println();
        System.out.println("Last thing. Let's double-check to see if the input total and calculated total match up:");
        System.out.println("Input total: " + total);
        System.out.print("Calculated total based on individual rates: ");
        System.out.printf("%.2f", overallTotal);
        System.out.println();
        System.out.println("Thank you for using Spring Break(down)");
    }

    public static double perPerson (double rate, double night, double clean, double fee, double tax, double ppl){
        double idvRate = (rate * night)/ppl;
        double idvClean = clean/ppl;
        double idvFee = fee/ppl;
        double idvTax = tax/ppl;

        return idvRate + idvClean + idvFee + idvTax;
    }

    public static double partOther(double clean, double fee, double tax, double ppl){
        double idvClean = clean/ppl;
        double idvFee = fee/ppl;
        double idvTax = tax/ppl;

        return idvClean + idvFee + idvTax;
    }

}
