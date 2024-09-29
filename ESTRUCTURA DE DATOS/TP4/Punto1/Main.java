package TP4.Punto1;

import java.util.Scanner;

import TP4.validaciones;
import TP4.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Cliente> colaClientes = new Queue<>();
        Queue<Cliente> colaTemporal = new Queue<>();
        Scanner scanner = new Scanner(System.in);
        int cantidadClientesAtendidos = 0;

        agregarCliente(cantidadClientesAtendidos, colaClientes, scanner);
        atenderClientes(colaClientes, colaTemporal, cantidadClientesAtendidos);
        contarClientesPorApellido(colaClientes, colaTemporal, scanner);
    }

    public static void agregarCliente(int numClientes, Queue<Cliente> colaClientes, Scanner scanner) {

        System.out.println("Ingrese el número de clientes a atender:");
        numClientes = validaciones.validarNumero(scanner);

        for (int i = 0; i < numClientes; i++) {
            System.out.println("Ingrese el código del cliente " + (i + 1) + ": ");
            int codCliente = validaciones.validarNumero(scanner);

            System.out.println("Ingrese nombre/s del cliente:");
            String nCliente = validaciones.validarTextoIngresado(scanner);
            System.out.println("Ingrese el apellido del cliente:");
            String aCliente = validaciones.validarTextoIngresado(scanner);
            String[] aynCliente = { nCliente, aCliente };

            System.out.println("Ingrese el email del cliente:");
            String mailCliente = validaciones.validarMail(scanner);

            Cliente cliente = new Cliente(codCliente, aynCliente, mailCliente);
            colaClientes.add(cliente);
        }
    }

    public static void atenderClientes(Queue<Cliente> colaClientes, Queue<Cliente> colaTemporal, int cantidadClientes) {
        // Simulación de atención a los clientes
        while (!colaClientes.isEmpty()) {
            Cliente clienteAtendido = colaClientes.poll();
            System.out.println("Atendiendo: " + clienteAtendido);
            colaTemporal.add(clienteAtendido);
            cantidadClientes++;
        }
        System.out.println("Total de clientes atendidos: " + cantidadClientes);

    }

    public static void contarClientesPorApellido(Queue<Cliente> colaClientes, Queue<Cliente> colaTemporal,
            Scanner scanner) {
        // Contar clientes cuyo apellido coincide con uno ingresado
        System.out.println("Ingrese un apellido para contar coincidencias:");
        String apellidoBuscado = scanner.nextLine();
        int contadorCoincidencias = 0;

        while (!colaTemporal.isEmpty()) {
            Cliente cliente = colaTemporal.poll();
            if (cliente.getAynCliente()[1].equalsIgnoreCase(apellidoBuscado)) {
                contadorCoincidencias++;
            }
        }

        System.out.println("Total de clientes con apellido '" + apellidoBuscado + "': " + contadorCoincidencias);

        scanner.close();
    }
}
