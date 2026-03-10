package modelos;

public abstract class Cuenta {
    private String titular;
    private double saldo;
    private String numero;

    public Cuenta(String titular, String numero) {
        this.titular = titular;
        this.saldo = 0;
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumero() {
        return numero;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract boolean retirar(double cantidad);

    public void depositar(double cantidad) {
        if (cantidad >= 0)
            saldo += cantidad;
    }

    public abstract String[] getDatos();

}
