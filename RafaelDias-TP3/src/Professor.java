public class Professor extends Pessoa {

	public Professor() throws NomeIncompletoException {
		this.setNome("Professor");
	}
	
	public Professor(String nome) {
		super(nome);
	}
	
	public Professor(String nome, float salario) {
		super(nome, salario);
	}
}