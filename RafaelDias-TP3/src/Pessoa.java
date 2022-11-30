public class Pessoa {

	private String nome;
	private float salario;
	
	public Pessoa() {
		this.nome = Constante.NOME_PADRAO;
		this.salario = Constante.SALARIO_MINIMO;
	}
	
	public Pessoa(String nome) {
		this();
		this.nome = nome;
	}
	
	public Pessoa(String nome, float salario) {
		this(nome);
		this.salario = salario;
	}

	@Override
	public String toString() {
		return nome + ";" + ";" + salario;
	}
	
	public void imprimir() throws NomeIncompletoException{		
		float salarioLiquido = calcularSalarioLiquido();
		
		System.out.println("Professor(a): " + this.getNome());
		System.out.println("Salário Líquido = R$" + salarioLiquido);
		System.out.println("Situação = " + obterSituacao(salarioLiquido));
	}

	public float calcularSalarioLiquido(){
		return salario;
	}
	
	public String obterSituacao(float salarioLiquido){		
		if(salarioLiquido >= Constante.SALARIO_LIQUIDO_MAXIMO) {
			return Constante.RICO;
		}		
		return Constante.POBRE;
	}

    public String getNome() throws NomeIncompletoException {
		
		if(nome == null) {
			throw new NomeIncompletoException("O preenchimento do campo 'nome' esta incorreto");
		}

		StringBuilder sb = new StringBuilder();
		sb.append(nome.toUpperCase().charAt(0) + nome.substring(1));

		return sb.toString();
	}

	public void setNome(String nome) throws NomeIncompletoException {
		
		if(nome == null) {
			throw new NomeIncompletoException("O preenchimento do campo 'nome' esta incorreto");
		}

        this.nome = nome;
	}	

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
}