package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        int principleAmount = 0;
        float interestRate = 0;
        byte periodInYears = 0;
        float monthlyInterestRate = 0;
        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.println("Principle amount ($1K - $1M): ");
            principleAmount = userInput.nextInt();
            if (principleAmount >= 1000 && principleAmount <= 1000000)
                break;
            System.out.println("Please enter valid principle amount");
        }

        while (true) {
            System.out.println("Annual Interest Rate: ");
            interestRate = userInput.nextFloat();
            if (interestRate >= 1 && interestRate <= 30) {
                monthlyInterestRate = (interestRate / PERCENT) / MONTHS_IN_YEAR;
            }
            break;
            System.out.println("Please enter interest rate greater than 1 and less than 30");
        }

        while (true) {
            System.out.println("Period (Years): ");
            periodInYears = userInput.nextByte();
            if (periodInYears >= 1 && periodInYears <= 50)
                break;
            System.out.println("Please enter period in years greater than 1 and less than 50");
        }

        int numberOfPayments = periodInYears*MONTHS_IN_YEAR;

        double powerRaise = Math.pow(1+monthlyInterestRate, numberOfPayments);
        double monthlyPayments = principleAmount*(monthlyInterestRate*powerRaise/(powerRaise-1));

        String formattedMonthlyPayments = NumberFormat.getCurrencyInstance().format(monthlyPayments);

        System.out.println("Mortgage amount: " +formattedMonthlyPayments);
    }
    }
}
