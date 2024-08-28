package com.milibreria.utilidades;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.time.LocalDate;
import java.time.format.*;

public class validaciones {

    public static int validarNumero(Scanner scanner) {
        int numero = 0;
        boolean esValido;
        do {
            String input = scanner.nextLine();
            esValido = esNumeroEntero(input);
            if (esValido) {
                numero = Integer.parseInt(input);
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
            }
        } while (!esValido);
        return numero;
    }

    public static boolean esNumeroEntero(String texto) {
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String validarTextoIngresado(Scanner scanner) {
        String input;
        do {
            input = scanner.nextLine();
            boolean esVacio = validarTextoVacio(input);
            boolean esValido = esSoloCaracteres(input);
            if (!esVacio) {
                if (!esValido) {
                    System.out.println("El texto ingresado no contiene solo caracteres");
                    System.out.println("Ingresa nuevamente");
                }
            } else {
                System.out.println("El campo está vacío, ingrese un texto válido");
            }
        } while (!esSoloCaracteres(input) && validarTextoVacio(input));
        return input;
    }

    public static boolean esSoloCaracteres(String texto) {
        String alfb = "^[a-zA-Z(\\s]+$";
        Pattern pattern = Pattern.compile(alfb);
        Matcher matcher = pattern.matcher(texto);
        return matcher.matches();
    }

    public static boolean validarTextoVacio(String input) {
        if (input.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean validarLongitud(String texto, int min, int max) {
        int longitud = texto.length();
        return longitud >= min && longitud <= max;
    }

    public static boolean verificarRepetidoEnArray(String[] listaElementos, String input) {
        for (String elemento : listaElementos) {
            if (input.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    public static LocalDate validarFormatoFecha(Scanner input) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Ingrese la fecha de ingreso en formato yy/mm/dd: ");
        String fechaIngresada = input.nextLine();
        LocalDate fecha = LocalDate.parse(fechaIngresada, formatoFecha);
        return fecha;

    }
}
