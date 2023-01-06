public class Main {
    public static void main(String[] args) {
        Banco b1 = new Banco("João", 300);

        System.out.println(b1.getSaldo());

        b1.depositar(300);

        b1.pedirEmprestimo(5000);

        System.out.println(b1.toString());




    }
}