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

    @Override
    public boolean retirar(double cantidad) {
        if (valorPrestado - valorRetirado >= cantidad) {
            valorRetirado += cantidad;
            return true;
        }
        return false;
    }

}
