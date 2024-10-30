package ClienteCadastro;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private String endereco;
    private int numero;
    private String cidade;
    private String estado;

    public Cliente(String nome, String cpf, String telefone, String endereco, int numero, String cidade, String estado) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "\nTelefone: " + telefone + "\nEndereço: " + endereco + ", " + numero + 
               "\nCidade: " + cidade + "\nEstado: " + estado;
    }
}
