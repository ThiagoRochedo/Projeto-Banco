public class Conta {
    private static int proximoNumero = 1;
    private int numero;
    private String titular;
    private String cpf;
    private double saldo;

    public Conta(String titular, String cpf) {
        this.titular = titular;
        this.cpf = cpf;
        this.numero = proximoNumero++;
        this.saldo = 0.0;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getTitular() {
        return this.titular;
    }

    public String getCPF() {
        return this.cpf;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor > this.saldo) {
            return false;
        }
        this.saldo -= valor;
        return true;
    }

    public boolean transferir(Conta destino, double valor) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }
}