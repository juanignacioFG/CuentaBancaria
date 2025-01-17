package cuentas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaTest {
    private Cuenta cuenta;
    private CuentaAhorros cuentaAhorros;
    private CuentaCorriente cuentaCorriente;

    @BeforeEach
    public void setUp() {
        cuenta = new Cuenta(5000, 12);
        cuentaAhorros = new CuentaAhorros(15000, 10);
        cuentaCorriente = new CuentaCorriente(8000, 8);
    }

    @Test
    public void testConsignarEnCuenta() {
        cuenta.consignar(2000);
        assertEquals(7000, cuenta.saldo, 0.01, "El saldo no es correcto tras consignar.");
    }

    @Test
    public void testRetirarDeCuenta() {
        cuenta.retirar(3000);
        assertEquals(2000, cuenta.saldo, 0.01, "El saldo no es correcto tras retirar.");
    }

    @Test
    public void testInteresMensualCuenta() {
        cuenta.calcularInteresMensual();
        assertEquals(5050, cuenta.saldo, 0.01, "El saldo no es correcto tras calcular el interés.");
    }

    @Test
    public void testCuentaAhorrosEstadoActivo() {
        assertTrue(cuentaAhorros.imprimir().contains("Activa"), "La cuenta de ahorros debería estar activa.");
    }

    @Test
    public void testCuentaAhorrosConsignar() {
        cuentaAhorros.consignar(5000);
        assertEquals(20000, cuentaAhorros.saldo, 0.01, "El saldo de la cuenta de ahorros no es correcto tras consignar.");
    }

    @Test
    public void testCuentaCorrienteSobregiro() {
        cuentaCorriente.retirar(10000);
        assertEquals(2000, cuentaCorriente.sobregiro, 0.01, "El sobregiro no es correcto tras retirar.");
    }

    @Test
    public void testCuentaCorrienteConsignarReduccionSobregiro() {
        cuentaCorriente.retirar(10000);
        cuentaCorriente.consignar(1500);
        assertEquals(500, cuentaCorriente.sobregiro, 0.01, "El sobregiro no se ha reducido correctamente.");
    }
}
