package modelos;

import java.text.DecimalFormat;

public class Credito extends Cuenta {

    private double valorPrestado;
    private double tasaInteres;
    private int plazo;
    private double valorRetirado;

    public Credito(String titular, String numero, double valorPrestado, double tasaInteres, int plazo) {
        super(titular, numero);
        this.valorPrestado = valorPrestado;
        this.tasaInteres = tasaInteres;
        this.plazo = plazo;
        this.valorRetirado = 0;
    }

    public double getValorPrestado() {
        return valorPrestado;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public int getPlazo() {
        return plazo;
    }

    public double getValorRetirado() {
        return valorRetirado;
    }

    @Override
    public boolean retirar(double cantidad) {
        if (valorPrestado - valorRetirado >= cantidad) {
            valorRetirado += cantidad;
            return true;
        }
        return false;
    }

    public double getCuota() {
        double tasaInteresReal = tasaInteres / 100;
        return valorPrestado * Math.pow(1 + tasaInteresReal, plazo) * tasaInteresReal
                / (Math.pow(1 + tasaInteresReal, plazo) - 1);
    }

    public void pagar(double cantidad) {
        if (getSaldo() < valorPrestado) {
            var intereses = (valorPrestado - getSaldo()) * tasaInteres / 100;
            var abonoCapital = cantidad - intereses;
            setSaldo(getSaldo() + abonoCapital);
        }
    }

    @Override
    public String[] getDatos() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        return new String[] {
                "Crédito",
                getNumero(),
                getTitular(),
                df.format(getSaldo()),
        };
    }

}
