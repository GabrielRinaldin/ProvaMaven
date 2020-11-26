package entidade;

public class Cliente_Fisico extends Entidade {

	public Cliente_Fisico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente_Fisico(int id, String nome, int telefone, int cpf, String email, String cep) {
		super(id, nome, telefone, cpf, email, cep);
		// TODO Auto-generated constructor stub
	}

	public Cliente_Fisico(String nome, int telefone, int cpf, String email, String cep) {
		super(nome, telefone, cpf, email, cep);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cliente_Fisico [getId()=" + getId() + ", getNome()=" + getNome() + ", getTelefone()=" + getTelefone()
				+ ", getCpf()=" + getCpf() + ", getEmail()=" + getEmail() + ", getCep()=" + getCep() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}

		

	
		
	
			
			
}
