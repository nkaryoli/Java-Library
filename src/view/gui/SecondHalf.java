/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.gui;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author karyo
 */
public class SecondHalf {

   static Scanner scan = new Scanner(System.in);
   public static final String ANSI_BLUE = "\u001B[34m";
   public static final String ANSI_CIAN = "\u001B[36m";
   public static final String ANSI_PURPLE = "\u001B[35m";
   public static final String ANSI_WHITE = "\u001B[37m";
   public static final String ANSI_YELLOW = "\u001B[33m";
   public static final String ANSI_RED = "\u001B[31m";
   public static final String ANSI_GREEN = "\u001B[0;32m";
   public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
   public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
   public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
   public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
   public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
   public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
   public static final String ANSI_RESET = "\u001B[0m";

   public static void main(String[] args) {
      int op = 0;
      do {
         try {
            String menu[] = {"Menu:", ANSI_YELLOW + "1 - Exercise 1", ANSI_YELLOW + "2 - Exercise 2", ANSI_YELLOW + "3 - Exercise 3", ANSI_YELLOW + "4 - Exercise 4", ANSI_YELLOW + "5 - To exit" + ANSI_RESET, "\nEnter your choice: "};
            printMenu(menu);

            op = scan.nextInt();

            switch (op) {

               case 1 -> {
                  String str = scan.next();
                  if (isNumeric(str)) {
                     System.out.println("SI es numerico");
                  } else {
                     System.out.println("NO es numerico");
                  }
                  break;
               }
               case 2 -> {
                  scan.nextLine();
                  String str = scan.nextLine();
                  if (isAlphabetic(str)) {
                     System.out.println("SI es alfabetico");
                  } else {
                     System.out.println("NO es alfabetico");
                  }
                  break;
               }

               case 3 -> {
                  scan.nextLine();
                  String str = scan.nextLine();
                  if (checkEmailRegex(str)) {
                     System.out.println("SI es valido");
                  } else {
                     System.out.println("NO es valido");
                  }
                  break;
               }
               case 4 -> {
                  //checkName();
                  break;
               }
               case 5 -> {
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

// 5.	boolean isNumeric(String str): 
//    Debe Validar que el contenido del String es numérico. 
//    Si lo es retornará true, en caso contrario false. 
   public static boolean isNumeric(String str) {
      for (int i = 0; i < str.length(); i++) {
         if (str.charAt(i) < 48 || str.charAt(i) > 57)
            return false;
      }
      return true;
   }

// 6.	boolean isAlphabetic(String str): 
//    Debe Validar que el contenido del String solo tenga letras. 
//    Si es así retornará true, en caso contrario false. 
   public static boolean isAlphabetic(String str) {
      for (int i = 0; i < str.length(); i++) {
         if (!Character.isLetter(str.charAt(i))) 
            return false;
      }
      return true;
   }

// 7.	boolean checkEmail(String email): 
//    Debe validar que el formato del correo se corresponde con un correo electronico 
//    debe contener una @ y la terminación debe ser .com, .es, …). 
//    Si es correcto retornará true, en caso contrario false. 
   
//   Parte local (lo que va antes del @):
//                Solo puede contener letras, números, y los caracteres especiales _, ., -
//                No puede empezar ni terminar con un punto
//                No puede tener dos puntos consecutivos

//   Dominio (lo que va después del @):
//       Debe contener al menos un punto
//       Solo letras, números y guiones
//                No puede empezar ni terminar con un guión o punto
//       La extensión final (.com, .es, etc.) debe tener entre 2 y 6 letras aproximadamente

//   Controles generales:
//                No puede estar vacío
//                No puede tener espacios en ninguna parte
//                El @ no puede ser el primer ni el último carácter
   
   public static boolean checkEmail(String email) {
      String local;
      String domain;
      try {
         // No puede estar vacío
         // El @ no puede ser el primer ni el último carácter
         // No puede empezar ni terminar con un punto
         char firstChar = email.charAt(0);
         char lastChar = email.charAt(email.length() - 1);

         if (email.length() == 0 || firstChar == '.' || firstChar == '@' || lastChar == '@' || lastChar == '.' || lastChar == '-' || lastChar == '_')
            return false;
         
         String[] array = email.split("@");
         if (array.length == 2) {
            local = array[0];
            domain = array[1];
         } else {
            return false;
         }
         
         // Domein Debe contener al menos un punto
         
         String[] domainArray = domain.split(".");
         if (domainArray.length < 2) return false;

         char localLastChar = local.charAt(local.length() - 1);
         char domainFirstChar = domain.charAt(0);
         
         // La parte local no puede terminar con punto
         // La parte de dominio no puede empezar con un punto
         if (localLastChar == '.' || domainFirstChar == '.' || domainFirstChar == '-' || domainFirstChar == '_')
            return false;
         
         for (int i = 0; i < local.length(); i++) {
            char currentChar = local.charAt(i);
            String currentStr = Character.toString(currentChar);
            // No puede tener espacios en ninguna parte
            if (currentChar == ' ')
               return false;
            // No puede tener dos puntos consecutivos
            if (i < local.length() - 2  && currentChar == '.' && local.charAt(i + 1) == '.')
               return false;
            // Solo puede contener letras, números, y los caracteres especiales _, ., -
            if (!isAlphabetic(currentStr) && !isNumeric(currentStr) && currentChar != '_' &&currentChar != '.' && currentChar != '-')
               return false;
         }
         
         // Debe contener al menos un punto
         
         
         for (int i = 0; i < domain.length(); i++) {
            char currentChar = domain.charAt(i);
            String currentStr = Character.toString(currentChar);
            // No puede tener espacios en ninguna parte
            if (currentChar == ' ')
               return false;
            // No puede tener dos puntos consecutivos
            if (i < local.length() - 2  && currentChar == '.' && local.charAt(i + 1) == '.')
               return false;
            // Solo puede contener letras, números, y los caracteres especiales _, ., -
            if (!isAlphabetic(currentStr) && !isNumeric(currentStr) && currentChar != '_' &&currentChar != '.' && currentChar != '-')
               return false;
            
         }
      } catch (Exception e) {
         System.out.println(ANSI_RED + "\nInvalid value. " + e.getMessage() + ANSI_RESET);
         scan.nextLine();
         return false;
      }

      return true;
   }

   public static boolean checkEmailRegex(String email) {
      String emailPattern = "^[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
      
      Pattern pattern = Pattern.compile(emailPattern);
      Matcher matcher = pattern.matcher(email);
      
      return matcher.matches();
   }
   
// 8.	boolean checkName(String name): 
//    Debe validar que el nombre tiene una longitud lógica y que no contenga números. 
//    Si es correcto retornará true, en caso contrario false. 
   public static boolean checkName(String name) {
      return (name.length() < 3 && !isAlphabetic(name));
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
