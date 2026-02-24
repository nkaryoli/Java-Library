/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica11_FuncionesYBibliotecas;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author marinabenvil
 */
public class FirstHalf {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.println("typeDoc: ");
//        int doc1 = scan.nextInt();
//        System.out.println("id: ");
//        String id1 = scan.next();
//        if (checkld(doc1, id1)) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }

//        System.out.println("date: ");
//        String date =scan.next();
//        if (checkFormatDate(date)) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }

//        System.out.println("agedate dd/MM/yyyy: ");
//        String agedate =scan.next();
//        int fi=calculateAge(agedate);
//        System.out.println(fi);

//        System.out.println("codigo postal: ");
//        String cp =scan.next();
//        if (checkPostalCode(cp)) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
    }

    /*
    Esta funcion comprueba que lo que primero el tipo de 
    documento sea 1 y que el DNI exista.
    @param id un String y typeDoc un numeró entero.
    @retunr boleano segun coincide el tipo y el formato del id.
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
    @retunr boleano segun si coincide el formato.
    
*/
    public static boolean checkFormatDate(String date) {
        String[] partes = date.split("/");
        if (partes.length != 3) {
            return false;
        }
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int year = Integer.parseInt(partes[2]);
        
        if (dia>31||dia<1) return false;
        if (mes>12||mes<1)return false;
        if (year<1000 || year>9999) return false;
        if ((mes == 4 || mes==6 || mes==9 || mes==11 ) && dia>30) return false;
        return !(mes==2 && dia>28);
        
    }
/*
    Esta funcion calcula la edad segun la fecha de nacimiento ingresada en formato dd/mm/yyyy.
    @param birthDate un String.
    @retunr numero de años.
    
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
    Esta funcion comprueba que la String ingresada tenga fomrato codigo postal.
    @param zip una String.
    @retunr boleano segun coincida el formato..
    
    */
    public static boolean checkPostalCode(String zip) {
        if (zip.length() !=5 ) {
            return false;
        }
        for (int i = 0; i < 5; i++) {
            char num = zip.charAt(i);
            if (num<'0' || num> '9') {
                return false;
            }
        }
        return true;
        
    }
}
