/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UserDataValidations {

   /*
    Esta funcion comprueba que lo que primero el tipo de 
    documento sea 1 y que el DNI exista.
    @param id un String y typeDoc un numeró entero.
    @return boleano segun coincide el tipo y el formato del id.
    */
   public static boolean checkld(int typeDoc, String id) {
      if (typeDoc != 1 || id.length() != 9) {
         return false;
      }
      String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
      int numero = Integer.parseInt(id.substring(0, 8));
      char letra = Character.toUpperCase(id.charAt(8));
      return letrasDNI.charAt(numero % 23) == letra;
   }

   /*
    Esta funcion comprueba que lo que se ingresa sea una fecha con fomrato dd/mm/yyyy
    y que la fecha sea possible.
    @param date un String.
    @return boleano segun si coincide el formato.
    */
   public static boolean checkFormatDate(String date) {
      String[] partes = date.split("/");
      if (partes.length != 3) {
         return false;
      }
      int dia = Integer.parseInt(partes[0]);
      int mes = Integer.parseInt(partes[1]);
      int year = Integer.parseInt(partes[2]);

      if (dia > 31 || dia < 1) {
         return false;
      }
      if (mes > 12 || mes < 1) {
         return false;
      }
      if (year < 1000 || year > 9999) {
         return false;
      }
      if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
         return false;
      }
      return !(mes == 2 && dia > 28);

   }

   /*
    Esta funcion calcula la edad segun la fecha de nacimiento ingresada en formato dd/mm/yyyy.
    @param birthDate un String.
    @return numero de años.
    */
   public static int calculateAge(String birthDate) {
      if (!checkFormatDate(birthDate)) {
         return -1;
      }
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      LocalDate fechaNacimiento = LocalDate.parse(birthDate, formatter);
      LocalDate fechaActual = LocalDate.now();
      if (fechaNacimiento.isAfter(fechaActual)) {
         return -1;
      }
      return Period.between(fechaNacimiento, fechaActual).getYears();
   }

   /*
    Esta funcion comprueba que la String ingresada tenga formato codigo postal.
    @param zip una String.
    @return boleano segun coincida el formato..
    */
   public static boolean checkPostalCode(String zip) {
      if (zip.length() != 5) {
         return false;
      }
      for (int i = 0; i < 5; i++) {
         char num = zip.charAt(i);
         if (num < '0' || num > '9') {
            return false;
         }
      }
      return true;

   }

   /*
    Esta funcion comprueba si una String contiene solamente caracteres numericos.
    @param str una String a validar.
    @return true si la String contiene solo digitos, false en caso contrario.
    */
   public static boolean isNumeric(String str) {
      for (int i = 0; i < str.length(); i++) {
         if (str.charAt(i) < 48 || str.charAt(i) > 57) {
            return false;
         }
      }
      return true;
   }

   /*
    Esta funcion comprueba si una String contiene solamente caracteres alfabeticos.
    @param str una String a validar.
    @return true si la String contiene solo letras, false en caso contrario.
    */
   public static boolean isAlphabetic(String str) {
      for (int i = 0; i < str.length(); i++) {
         if (!Character.isLetter(str.charAt(i))) 
            return false;
      }
      return true;
   }
   
   /*
    Esta funcion comprueba que la String ingresada tenga formato de correo electronico válido.
    @param email una String que contiene la dirección de correo a validar.
    @return true si el email tiene formato válido, false en caso contrario.
    */
   public static boolean checkEmail(String email) {
      String emailPattern = "^[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
      
      Pattern pattern = Pattern.compile(emailPattern);
      Matcher matcher = pattern.matcher(email);
      
      return matcher.matches();
   }
   
   /*
    Esta funcion comprueba que el nombre tenga al menos 3 caracteres y contenga solo letras.
    @param name una String que contiene el nombre a validar.
    @return true si el nombre es valido (mayor o igual a 3 caracteres alfabeticos), false en caso contrario.
    */
   public static boolean checkName(String name) {
      return (name.length() < 3 && !isAlphabetic(name));
   }
}
