import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Banco {
    private String nome;
    private int saldo;
    private int divida;
    private String historico;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");



    public Banco(String nome, int saldo) {
        this.nome = nome;
        this.saldo = saldo;
        this.divida = 0;
        this.historico = "";
    }


    public String getNome() {
        return this.nome;
    }
    public int getSaldo() {
        return this.saldo;
    }

    public int getDivida() {
        return this.divida;
    }

    public String getHistorico() {
        return this.historico;
    }

    public void depositar(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException();
        }
        this.saldo = this.saldo + quantidade;
        this.historico = this.historico + "Deposito realizado em: " + dtf.format(LocalDateTime.now()) + "\n";

    }

    public void checarSaldo() {
        System.out.println("Seu saldo é de: " + this.saldo);
    }

    public void pedirEmprestimo(int quantidade) {
        if (divida > 0) {
            System.out.println("Infelizmente não é possivel pegar empréstimo para sua conta, voce já possui uma divida ativa.");
            System.exit(0);
        }
        this.saldo = this.saldo + quantidade;
        this.divida = this.divida + quantidade;
        this.historico = this.historico + "Pedido de emprestimo feito em: " + dtf.format(LocalDateTime.now()) + "\n";

    }

    @Override
    public String toString() {
        if(this.historico.equals("")) {
            this.historico = "Histórico  vazio.";
        }
        return "Sua conta: Nome: " + this.getNome() + " Saldo dísponivel: " + this.getSaldo() + " Está devendo: " + this.getDivida() + " Seu historico: " + getHistorico();
    }
}
