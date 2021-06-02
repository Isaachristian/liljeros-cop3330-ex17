package org.example;

import java.util.Locale;
import java.util.Scanner;

/**
 * Blood Alcohol Calculator
 */
public class App {
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        // BAC = (A x 5.14 / W x r) - .015 x H

        double totalAlcohol, weight, hours, distroRatio, bloodAlcohol;
        String gender;
        final double distroRatioMale   = 0.73;
        final double distroRatioFemale = 0.66;

        System.out.print("Enter alcohol consumed (in OZ): ");
        totalAlcohol = Double.parseDouble(scanner.nextLine());
        System.out.print("    Enter body weight (in lbs): ");
        weight = Double.parseDouble(scanner.nextLine());
        System.out.print(" Enter gender (male or female): ");
        gender = scanner.nextLine().toLowerCase(Locale.ROOT);
        System.out.print("    Enter hour from last drink: ");
        hours = Double.parseDouble(scanner.nextLine());
        System.out.println();

        if (gender.equals("male")) {
            distroRatio = distroRatioMale;
        } else if (gender.equals("female")) {
            distroRatio = distroRatioFemale;
        } else {
            System.out.println("Invalid entry for gender: should be 'male' or 'female'");
            return;
        }

        bloodAlcohol = ((totalAlcohol + 5.14) / (weight * distroRatio)) - (0.015 * hours);
        bloodAlcohol = bloodAlcohol <= 0 ? 0 : bloodAlcohol;

        System.out.printf("Your BAC is %.2f%n", bloodAlcohol);

        if (bloodAlcohol >= 0.08)
            System.out.println("It is not legal for you to drive");
        else
            System.out.println("It is legal for you do drive");
    }
}
