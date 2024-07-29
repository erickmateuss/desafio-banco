public class App {
    public static void main(String[] args) {
        Cliente erick = new Cliente();
        erick.setNome("ERICK");

        Conta cc = new ContaCorrente(erick);
        cc.depositar(3000);
        Conta cp = new ContaPoupanca(erick);
        cc.transferir(10, cp);


        cc.imprimirExtrato();
        cp.imprimirExtrato();
        cc.verificarEmprestimo();
    }
}
