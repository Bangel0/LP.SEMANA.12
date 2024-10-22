package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] nombres = { "Brahian Angel", "Juan Fernando", "Cristian Camilo" };
        double[] saldos = { 2500.00, 1200.00, 1600.00 };
        boolean metood = true;
        Scanner mouse3 = new Scanner(System.in);
        int indice = seleccionarCuenta(nombres);
        if (indice == -1) {
            metood = false;
        }
        while (metood) {

            mostrarMenu();
            System.out.println("Ingrese una opcion valida dentro del menu");
            int opcion = mouse3.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("SELECCIONO --> DEPOSITAR");
                    depositar(indice, saldos, nombres);
                    break;

                case 2:
                    Scanner mouse4 = new Scanner(System.in);
                    System.out.println("SELECCIONO ---> RETIRAR");
                    System.out.println("INGTRESE LA CANTIDAD QUE DESEA RETIRAR");
                    double retiro = mouse3.nextDouble();
                    retirar(indice, saldos, nombres, retiro);
                    break;

                case 3:
                    consultarSaldo(indice, saldos, nombres);
                    break;

                case 4:
                    metood = false;
                    break;

                default:
                    System.out.println("OPCION IVALIDA");
                    break;
            }
        }

    }

    public static void mostrarMenu() {
        System.out.println("<-------------MENU-------------------------->");
        System.out.println("1--- Depositar --->");
        System.out.println("2--- Retirar --->");
        System.out.println("3--- Consultar Saldo --->");
        System.out.println("4--- Salir --->");
        System.out.println("-------------------------------");
    }

    public static int seleccionarCuenta(String[] nombresCuentas) {
        Scanner monitor = new Scanner(System.in);
        System.out.println("Seleccione el indice de la cuenta a utilizar");
        int seleccion = 0;
        for (int i = 0; i < nombresCuentas.length; i++) {
            System.out.println("INDICE -->" + i + " " + nombresCuentas[i] + " ");
        }
        seleccion = monitor.nextInt();
        if (seleccion >= nombresCuentas.length || seleccion < 0) {
            System.out.println("INDICE INVALIDO");
            seleccion = -1;
        }
        return seleccion;
    }

    public static void depositar(int indiceCuenta, double[] saldosCuentas, String[] nombresCuentas) {
        Scanner monitor2 = new Scanner(System.in);
        System.out.println("Ingrese el monto a depositar:");
        double deposito = monitor2.nextDouble();
        if (deposito < 0) {
            System.out.println("DEPOSITO INVALIDO");

        } else {
            saldosCuentas[indiceCuenta] += deposito;
            System.out.println("Deposito realizado con éxito. " + nombresCuentas[indiceCuenta] + " Su nuevo saldo es : " 
                    + saldosCuentas[indiceCuenta]);
        }
    }

    public static void retirar(int indiceCuenta, double[] saldosCuentas, String[] nombresCuentas,
            double cantidadRetiro) {

        if (saldosCuentas[indiceCuenta] < cantidadRetiro || cantidadRetiro < 0) {
            System.out.println("FONDOS INSUFICIENTES");
        } else {
            saldosCuentas[indiceCuenta] -= cantidadRetiro;
            System.out.println("Retiro realizado con éxito. " + nombresCuentas[indiceCuenta] + " Su nuevo saldo es : "
                    + saldosCuentas[indiceCuenta]);
        }
    }

    public static void consultarSaldo(int indiceCuenta, double[] saldosCuentas, String[] nombresCuentas) {
        System.out.println(nombresCuentas[indiceCuenta] + " Su saldo actual es : " + saldosCuentas[indiceCuenta]);

    }

}
