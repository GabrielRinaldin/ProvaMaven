package entidade;


public class Funcionario extends Entidade {

	public Funcionario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Funcionario(int id, String nome, int telefone, int cpf, String email, String cep) {
		super(id, nome, telefone, cpf, email, cep);
		// TODO Auto-generated constructor stub
	}

	public Funcionario(String nome, int telefone, int cpf, String email, String cep) {
		super(nome, telefone, cpf, email, cep);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Funcionario [getId()=" + getId() + ", getNome()=" + getNome() + ", getTelefone()=" + getTelefone()
				+ ", getCpf()=" + getCpf() + ", getEmail()=" + getEmail() + ", getCep()=" + getCep() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
 

	
}
