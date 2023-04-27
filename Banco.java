import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<Conta>();
    }

    public void addConta(Conta conta) {
        this.contas.add(conta);
    }

    public Conta getConta(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    public void removeConta(Conta conta) {
        this.contas.remove(conta);
    }

    
}