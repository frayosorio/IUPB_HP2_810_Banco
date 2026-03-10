package servicios;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelos.Ahorros;
import modelos.Corriente;
import modelos.Credito;
import modelos.Cuenta;
import modelos.TipoCuenta;

public class CuentaServicio {

    private static String[] encabezados = new String[] { "Tipo", "Número", "Titular", "Saldo",
            "Sobregiro o Límite" };
    private static List<Cuenta> cuentas = new ArrayList<>();

    public static String[] getEncabezados() {
        return encabezados;
    }

    public static void mostrar(JTable tblCuentas) {
        String[][] datos = new String[cuentas.size()][encabezados.length];
        int fila = 0;
        for (Cuenta cuenta : cuentas) {
            var datosCuenta = cuenta.getDatos();
            int columna = 0;
            for (String dato : datosCuenta) {
                datos[fila][columna] = dato;
                columna++;
            }
            fila++;
        }

        DefaultTableModel dtm = new DefaultTableModel(datos, CuentaServicio.getEncabezados());
        tblCuentas.setModel(dtm);
    }

    public static Cuenta agregar(TipoCuenta tipo,
            String titular,
            String numero,
            double sobregiro,
            double tasaInteres,
            double valorPrestado,
            int plazo) {
        Cuenta cuenta = null;

        switch (tipo) {
            case AHORROS:
                cuenta = new Ahorros(titular, numero, tasaInteres);
                break;
            case CORRIENTE:
                cuenta = new Corriente(titular, numero, sobregiro);
                break;
            case CREDITO:
                cuenta = new Credito(titular, numero, valorPrestado, tasaInteres, plazo);
        }

        return cuenta;
    }

}
