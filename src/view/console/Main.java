/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;

import java.util.Scanner;
import model.validations.UserDataValidations;

public class Main {

   static Scanner scan = new Scanner(System.in);
   public static final String ANSI_BLUE = "\u001B[34m";
   public static final String ANSI_CIAN = "\u001B[36m";
   public static final String ANSI_PURPLE = "\u001B[35m";
   public static final String ANSI_WHITE = "\u001B[37m";
   public static final String ANSI_YELLOW = "\u001B[33m";
   public static final String ANSI_RED = "\u001B[31m";
   public static final String ANSI_GREEN = "\u001B[0;32m";
   public static final String ANSI_RESET = "\u001B[0m";

   public static void main(String[] args) {
      int op = 0;
      do {
         try {
            String menu[] = {"Choose you validation method:", ANSI_YELLOW + "1 - checkld", ANSI_YELLOW + "2 - checkFormatDate", ANSI_YELLOW + "3 - calculateAge", ANSI_YELLOW + "4 - checkPostalCode", ANSI_YELLOW + "5 - isNumeric",  ANSI_YELLOW + "6 - isAlphabetic", ANSI_YELLOW + "7 - checkEmail", ANSI_YELLOW + "8 - checkName", ANSI_YELLOW + "9 - To Exit" + ANSI_RESET, "\nEnter your choice: "};
            printMenu(menu);

            op = scan.nextInt();

            switch (op) {
               case 1 -> {
                  System.out.println("Document to validate");
                  System.out.print("TypeDoc: ");
                  int doc1 = scan.nextInt();
                  System.out.print("id: ");
                  String id1 = scan.next();
                  if (UserDataValidations.checkld(doc1, id1)) {
                     System.out.println(ANSI_GREEN + "Valid id");
                  } else {
                     System.out.println(ANSI_RED + "Invalid id");
                  }
                  break;
               }
               case 2 -> {
                  System.out.print("Date to validate: ");
                  String date = scan.next();
                  if (UserDataValidations.checkFormatDate(date)) {
                     System.out.println(ANSI_GREEN + "Date is valid");
                  } else {
                     System.out.println(ANSI_RED + "Invalid Date");
                  }
                  break;
               }
               case 3 -> {
                  System.out.print("Agedate dd/MM/yyyy: ");
                  String agedate = scan.next();
                  int fi = UserDataValidations.calculateAge(agedate);
                  if (fi == -1) 
                     System.out.println("Date is invalid");
                  else
                     System.out.println("Your age is " + fi);
                  break;
               }
               case 4 -> {
                  System.out.print("Postal Code to validate: ");
                  String cp = scan.next();
                  if (UserDataValidations.checkPostalCode(cp)) {
                     System.out.println(ANSI_GREEN + "Valid Postal Code");
                  } else {
                     System.out.println(ANSI_RED + "Invalid Postal Code");
                  }
                  break;
               }
               case 5 -> {
                  System.out.print("Number to validate: ");
                  String str = scan.next();

                  if (UserDataValidations.isNumeric(str)) {
                     System.out.println(ANSI_GREEN  + "IS number");
                  } else {
                     System.out.println(ANSI_RED + "Is NOT a number");
                  }
                  break;
               }
               case 6 -> {
                  System.out.print("String to validate: ");
                  scan.nextLine();
                  String str = scan.nextLine();
                  if (UserDataValidations.isAlphabetic(str)) {
                     System.out.println(ANSI_GREEN + "IS alphabetic");
                  } else {
                     System.out.println(ANSI_RED + "Is NOT alphabetic");
                  }
                  break;
               }

               case 7 -> {
                  System.out.print("Email to validate: ");
                  scan.nextLine();
                  String str = scan.nextLine();
                  if (UserDataValidations.checkEmail(str)) {
                     System.out.println(ANSI_GREEN + "Valid Email");
                  } else {
                     System.out.println(ANSI_RED + "Invalid Email");
                  }
                  break;
               }
               case 8 -> {
                  System.out.print("Name to validate: ");
                  scan.nextLine();
                  String str = scan.nextLine();
                  if (UserDataValidations.checkName(str)) {
                     System.out.println(ANSI_GREEN + "Valid Name");
                  } else {
                     System.out.println(ANSI_RED + "Invalid Name");
                  }
                  break;
               }
               case 9 -> {
                  System.out.println("\nExiting program... ");
               }
               default -> {
                  System.out.println("\nInvalid value.");
               }
            }
         } catch (Exception e) {
            System.out.println(ANSI_RED + "\nInvalid value. " + e.getMessage() + ANSI_RESET);
            scan.nextLine();
         }
      } while (op != 9);

      System.out.println("Good bye!");
   }

   //*************************************************//
   //******************** HELPERS ********************//
   //*************************************************//
   public static void printMenu(String[] menu) {
      System.out.println("");
      for (String option : menu) {
         System.out.println(option);
      }
   }
}
