package cuentas;

public class Cuenta {
    // Atributos protegidos
    protected float saldo;
    protected int numeroConsignaciones;
    protected int numeroRetiros;
    protected float tasaAnual;
    protected float comisionMensual;

    // Constructor
    public Cuenta(float saldoInicial, float tasaAnual) {
        this.saldo = saldoInicial;
        this.tasaAnual = tasaAnual;
        this.numeroConsignaciones = 0;
        this.numeroRetiros = 0;
        this.comisionMensual = 0;
    }

    // Método para consignar dinero
    public void consignar(float cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            numeroConsignaciones++;
        } else {
            System.out.println("La cantidad a consignar debe ser mayor a cero.");
        }
    }

    // Método para retirar dinero
    public void retirar(float cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            numeroRetiros++;
        } else {
            System.out.println("Fondos insuficientes o cantidad inválida para retirar.");
        }
    }

    // Método para calcular interés mensual
    public void calcularInteresMensual() {
        float interesMensual = (tasaAnual / 12) / 100 * saldo;
        saldo += interesMensual;
    }

    // Método para generar extracto mensual
    public void generarExtractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
        numeroRetiros = 0;
        numeroConsignaciones = 0;
        comisionMensual = 0;
    }

    // Método para imprimir los atributos
    public String imprimir() {
        return String.format("Saldo: %.2f, Consignaciones: %d, Retiros: %d, Tasa Anual: %.2f%%, Comisión Mensual: %.2f",
                saldo, numeroConsignaciones, numeroRetiros, tasaAnual, comisionMensual);
    }
}

