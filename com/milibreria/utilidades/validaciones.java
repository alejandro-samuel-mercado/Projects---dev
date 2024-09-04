package com.milibreria.utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JOptionPane; // Importa la clase JOptionPane
import java.time.DateTimeException; // Importa la clase DateTimeException

public class validaciones {
    private static final String PATRON_SOLO_CARACTERES = "^[a-zA-Z\\s]+$";
    private static final String FORMATO_FECHA = "yyyy-MM-dd";
    private static final String PATRON_EMAIL = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
    private static final String PATRON_TELEFONO = "^\\+?[0-9]{10,15}$"; // Ejemplo para validar número de teléfono

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
        if (input == null || input.trim().isEmpty()) {
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
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(FORMATO_FECHA);
        LocalDate fecha = null;
        do {
            System.out.println("Ingrese la fecha de ingreso en formato yyyy-MM-dd: ");
            String fechaIngresada = input.nextLine();
            try {
                fecha = LocalDate.parse(fechaIngresada, formatoFecha);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha no válida. Use el formato yyyy-MM-dd.");
            }
        } while (fecha == null);
        return fecha;

    }

    public static int validarNumIntEnVentana(String mensaje) {
        int num = 0;
        boolean entradaValida = false;
        do {

            try {
                String date = JOptionPane.showInputDialog(mensaje);

                if (validarTextoVacio(date)) {
                    JOptionPane.showMessageDialog(null, "La entrada no puede estar vacía.");
                } else {
                    num = Integer.parseInt(date);
                    entradaValida = true; // Sal del bucle si la entrada es válida
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error, debe contener solo números");
            }
        } while (!entradaValida);
        return num;

    }

    public static double validarNumDoubleEnVentana(String mensaje) {
        double num = 0;
        boolean entradaValida = false;
        do {
            try {
                String input = JOptionPane.showInputDialog(mensaje);

                if (validarTextoVacio(input)) { // Verifica si el campo está vacío
                    JOptionPane.showMessageDialog(null, "La entrada no puede estar vacía.");
                } else {
                    num = Double.parseDouble(input);
                    entradaValida = true; // Sal del bucle si la entrada es válida
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error, debe contener solo números");
            }
        } while (!entradaValida);
        return num;

    }

    public static String validarTextoVentana(String mensaje) {
        String input = "";
        do {
            input = JOptionPane.showInputDialog(mensaje);

            if (validarTextoVacio(input)) {
                JOptionPane.showMessageDialog(null, "El campo está vacío. Ingrese un valor.");
            } else if (!esSoloCaracteres(input)) {
                JOptionPane.showMessageDialog(null, """
                        Error, el valor solo debe contener caracteres alfabéticos.
                        \nIngrese otro valor
                        """);
            }
        } while (validarTextoVacio(input) || !esSoloCaracteres(input));
        return input;
    }

    public static LocalDate validarFormatoFechaVentana(String mensaje) {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern(FORMATO_FECHA);
        LocalDate fecha = null;
        do {
            String fechaIngresada = JOptionPane.showInputDialog(mensaje);
            if (validarTextoVacio(fechaIngresada)) {
                JOptionPane.showMessageDialog(null, "La entrada no puede estar vacía.");
            } else {
                try {
                    fecha = LocalDate.parse(fechaIngresada, formatoFecha);
                } catch (DateTimeException e) {
                    JOptionPane.showMessageDialog(null, "Fecha no válida. Use el formato yyyy-MM-dd.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } while (fecha == null);
        return fecha;
    }

    // Validación adicional: verifica que un número esté dentro de un rango
    // específico
    public static boolean validarNumeroEnRango(int numero, int min, int max) {
        return numero >= min && numero <= max;
    }

    // Validación adicional: verifica que la fecha no esté en el pasado
    public static boolean validarFechaNoPasada(LocalDate fecha) {
        return !fecha.isBefore(LocalDate.now());
    }
}
