public class Transacoes {

    private double valor;
    private Conta contaRemetente;
    private Conta contaDestinatario;

    public Transacoes(double valor, Conta contaRemetente, Conta contaDestinatario) {
        this.valor = valor;
        this.contaRemetente = contaRemetente;
        this.contaDestinatario = contaDestinatario;
    }

    public double getValor() {
        return valor;
    }

    public Conta getContaRemetente() {
        return contaRemetente;
    }

    public Conta getContaDestinatario() {
        return contaDestinatario;
    }

}