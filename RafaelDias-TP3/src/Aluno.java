
public class Aluno extends Pessoa {

	private float av1;
	private float av2;
    private float media;

	public Aluno() throws NomeIncompletoException {
		this.setNome("Aluno");
	}
	
	public Aluno(String nome) {
		super(nome);
	}
	
	public Aluno(String nome, float av1, float av2) {
		super(nome);
		this.av1 = av1;
		this.av2 = av2;
	}

	@Override
	public String toString() {
		return super.toString() + ";" + av1 + ";" + av2;
	}

    @Override
    public void imprimir() throws NomeIncompletoException{	
        System.out.println("Nome do aluno: " + this.getNome());
        System.out.println("Nota da AV1: " + this.av1);
        System.out.println("Nota da AV2: " + this.av2);
        System.out.println("Média final: " + calcularMedia(this.av1,this.av2));
        System.out.println("Situação: " + obterSituacao());
	}


    public float calcularMedia(float av1, float av2) {
        return this.media = (av1 + av2) / 2;
    }
	
	public String obterSituacao(){	
		if(this.media < 4) {
			return "Reprovado";
        } else if (this.media > 4 && this.media < 7) {
            return "Prova Final";
        }
		return "Aprovado";
	}

	public float getAV1() {
		return this.av1;
	}
	public void setAV1(float av1) {
		this.av1 = av1;
	}
	public float getAV2() {
		return this.av2;
	}
	public void setAV2(float av2) {
		this.av2 = av2;
	}
}