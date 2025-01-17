package cuentas;

public class CuentaAhorros extends Cuenta {
    private boolean activa;

    public CuentaAhorros(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
        this.activa = saldoInicial >= 10000;
    }

    @Override
    public void consignar(float cantidad) {
        if (activa) {
            super.consignar(cantidad);
            verificarEstadoCuenta();
        } else {
            System.out.println("No se puede consignar. La cuenta está inactiva.");
        }
    }

    @Override
    public void retirar(float cantidad) {
        if (activa && cantidad > 0) {
            super.retirar(cantidad);
            verificarEstadoCuenta();
        } else {
            System.out.println("No se puede retirar. La cuenta está inactiva o cantidad inválida.");
        }
    }

    @Override
    public void generarExtractoMensual() {
        if (numeroRetiros > 4) {
            comisionMensual += (numeroRetiros - 4) * 1000;
        }
        super.generarExtractoMensual();
        verificarEstadoCuenta();
    }

    private void verificarEstadoCuenta() {
        activa = saldo >= 10000;
    }

    @Override
    public String imprimir() {
        return super.imprimir() + ", Estado: " + (activa ? "Activa" : "Inactiva");
    }
}
