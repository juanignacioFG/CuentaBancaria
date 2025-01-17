package org.example;

import cuentas.CuentaAhorros;
import cuentas.CuentaCorriente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CuentaAhorros cuentaAhorros = new CuentaAhorros(5000, 5);
        CuentaCorriente cuentaCorriente =  new CuentaCorriente(8000, 3);

        int opcion;
        do {
            System.out.println("\nSistema de Cuentas Bancarias");
            System.out.println("1. Consignar en Cuenta de Ahorros");
            System.out.println("2. Retirar de Cuenta de Ahorros");
            System.out.println("3. Generar Extracto Mensual de Cuenta de Ahorros");
            System.out.println("4. Consignar en Cuenta Corriente");
            System.out.println("5. Retirar de Cuenta Corriente");
            System.out.println("6. Generar Extracto Mensual de Cuenta Corriente");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa la cantidad a consignar: ");
                    float cantidadConsignar = scanner.nextFloat();
                    cuentaAhorros.consignar(cantidadConsignar);
                    System.out.println("Saldo actual: " + cuentaAhorros.imprimir());
                    break;
                case 2:
                    System.out.print("Ingresa la cantidad a retirar: ");
                    float cantidadRetirar = scanner.nextFloat();
                    cuentaAhorros.retirar(cantidadRetirar);
                    System.out.println("Saldo actual: " + cuentaAhorros.imprimir());
                    break;
                case 3:
                    cuentaAhorros.generarExtractoMensual();
                    System.out.println("Extracto mensual generado: " + cuentaAhorros.imprimir());
                    break;
                case 4:
                    System.out.print("Ingresa la cantidad a consignar: ");
                    cantidadConsignar = scanner.nextFloat();
                    cuentaCorriente.consignar(cantidadConsignar);
                    System.out.println("Saldo actual: " + cuentaCorriente.imprimir());
                    break;
                case 5:
                    System.out.print("Ingresa la cantidad a retirar: ");
                    cantidadRetirar = scanner.nextFloat();
                    cuentaCorriente.retirar(cantidadRetirar);
                    System.out.println("Saldo actual: " + cuentaCorriente.imprimir());
                    break;
                case 6:
                    cuentaCorriente.generarExtractoMensual();
                    System.out.println("Extracto mensual generado: " + cuentaCorriente.imprimir());
                    break;
                case 7:
                    System.out.println("Gracias por usar el sistema de cuentas bancarias.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}