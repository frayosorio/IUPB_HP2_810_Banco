package modelos;

import java.text.DecimalFormat;

public class Ahorros extends Cuenta {

    private double tasaInteres;

    public Ahorros(String titular, String numero, double tasaInteres) {
        super(titular, numero);
        this.tasaInteres = tasaInteres;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    @Override
    public boolean retirar(double cantidad) {
        if (getSaldo() >= cantidad) {
            setSaldo(getSaldo() - cantidad);
            return true;
        }
        return false;
    }

    public void aplicarIntereses() {
        setSaldo(getSaldo() * (1 + tasaInteres));
    }

    @Override
    public String[] getDatos() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return new String[] {
                "Ahorros",
                getNumero(),
                getTitular(),
                df.format(getSaldo()),
        };
    }

}
