package cuentas;

public class CuentaCorriente extends Cuenta {
    float sobregiro;

    public CuentaCorriente(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
        this.sobregiro = 0;
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad > 0) {
            if (cantidad <= saldo) {
                saldo -= cantidad;
            } else {
                sobregiro += (cantidad - saldo);
                saldo = 0;
            }
            numeroRetiros++;
        } else {
            System.out.println("Cantidad a retirar inválida.");
        }
    }

    @Override
    public void consignar(float cantidad) {
        if (cantidad > 0) {
            if (sobregiro > 0) {
                if (cantidad >= sobregiro) {
                    saldo += (cantidad - sobregiro);
                    sobregiro = 0;
                } else {
                    sobregiro -= cantidad;
                }
            } else {
                saldo += cantidad;
            }
            numeroConsignaciones++;
        } else {
            System.out.println("La cantidad a consignar debe ser mayor a cero.");
        }
    }

    @Override
    public void generarExtractoMensual() {
        super.generarExtractoMensual();
    }

    @Override
    public String imprimir() {
        return super.imprimir() + ", Sobregiro: " + sobregiro;
    }
}

