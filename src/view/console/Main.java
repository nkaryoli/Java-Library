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
                  System.out.println("typeDoc: ");
                  int doc1 = scan.nextInt();
                  System.out.println("id: ");
                  String id1 = scan.next();
                  if (UserDataValidations.checkld(doc1, id1)) {
                     System.out.println(ANSI_GREEN + "true");
                  } else {
                     System.out.println(ANSI_RED + "false");
                  }
                  break;
               }
               case 2 -> {
                  System.out.println("date: ");
                  String date = scan.next();
                  if (UserDataValidations.checkFormatDate(date)) {
                     System.out.println(ANSI_GREEN + "true");
                  } else {
                     System.out.println(ANSI_RED + "false");
                  }
                  break;
               }
               case 3 -> {
                  System.out.println("agedate dd/MM/yyyy: ");
                  String agedate = scan.next();
                  int fi = UserDataValidations.calculateAge(agedate);
                  System.out.println(fi);
                  break;
               }
               case 4 -> {
                  System.out.println("codigo postal: ");
                  String cp = scan.next();
                  if (UserDataValidations.checkPostalCode(cp)) {
                     System.out.println(ANSI_GREEN + "true");
                  } else {
                     System.out.println(ANSI_RED + "false");
                  }
                  break;
               }
               case 5 -> {
                  System.out.println("Number to validate: ");
                  String str = scan.next();

                  if (UserDataValidations.isNumeric(str)) {
                     System.out.println(ANSI_GREEN  + "SI es numerico");
                  } else {
                     System.out.println(ANSI_RED + "NO es numerico");
                  }
                  break;
               }
               case 6 -> {
                  System.out.println("String to validate: ");
                  scan.nextLine();
                  String str = scan.nextLine();
                  if (UserDataValidations.isAlphabetic(str)) {
                     System.out.println(ANSI_GREEN + "SI es alfabetico");
                  } else {
                     System.out.println(ANSI_RED + "NO es alfabetico");
                  }
                  break;
               }

               case 7 -> {
                  System.out.println("Email to validate: ");
                  scan.nextLine();
                  String str = scan.nextLine();
                  if (UserDataValidations.checkEmail(str)) {
                     System.out.println(ANSI_GREEN + "SI es valido");
                  } else {
                     System.out.println(ANSI_RED + "NO es valido");
                  }
                  break;
               }
               case 8 -> {
                  System.out.println("Name to validate: ");
                  scan.nextLine();
                  String str = scan.nextLine();
                  if (UserDataValidations.checkName(str)) {
                     System.out.println(ANSI_GREEN + "SI es valido");
                  } else {
                     System.out.println(ANSI_RED + "NO es valido");
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
