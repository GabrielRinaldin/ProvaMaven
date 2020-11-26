package entidade;

public class Cliente_Juridico extends Entidade{

	public Cliente_Juridico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente_Juridico(int id, String nome, int telefone, int cpf, String email, String cep) {
		super(id, nome, telefone, cpf, email, cep);
		// TODO Auto-generated constructor stub
	}

	public Cliente_Juridico(String nome, int telefone, int cpf, String email, String cep) {
		super(nome, telefone, cpf, email, cep);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cliente_Juridico [getId()=" + getId() + ", getNome()=" + getNome() + ", getTelefone()=" + getTelefone()
				+ ", getCpf()=" + getCpf() + ", getEmail()=" + getEmail() + ", getCep()=" + getCep() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
	
	

}
