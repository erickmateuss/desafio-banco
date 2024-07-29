public abstract class Conta implements IConta {

    protected static final int AGENCIA_PADRAO = 0001;

    private static int SEQUENCIAL= 1;



    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected  String Emprestimo;


    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero =  SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
        
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
        
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }
    
    public double getSaldo() {
        return saldo;
    }


    public String getEmprestimo() {
        if (saldo < 2000) {
            return "Emprestimo não disponível";
        }else if (saldo >200 && saldo < 5000){
            return "Emprestimo de 10mil disponível";
        } else {
            return "Emprestimo de 20mil disponível";
        }
    }

    protected void imprimirInfosComum(){
        System.out.println(String.format("Titular: %s" , this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d" , this.agencia));
        System.out.println(String.format("Número: %d" , this.numero));
        System.out.println(String.format("Saldo: %.2f" , this.saldo));
        }

        protected void verificarEmprestimo(){
            System.out.println(getEmprestimo());
        }
}
