import java.util.Scanner;

public class TP3 {

	private static Pessoa[] pessoa;

	private static void imprimir() throws NomeIncompletoException {
		for (int i = 0; i < Constante.TAMANHO; i++) {
			if (pessoa[i] != null) {
				pessoa[i].imprimir();
			}
		}
	}

	public static void main(String[] args) throws NomeIncompletoException {

		pessoa = new Pessoa[Constante.TAMANHO];

		Scanner in = new Scanner(System.in);

		String opcao;
		int pos = 0;

		do {
			System.out.println("[1] Registrar as notas de um novo aluno.");
			System.out.println("[2] Registrar professor.");
			System.out.println("[3] Consultar boletim de um aluno.");
			System.out.println("[4] Consultar notas da turma.");
			System.out.println("[5] Sair");

			System.out.print("Informe a opção desejada: ");
			opcao = in.next();

			switch (opcao) {
				case "1":
					if (pos < Constante.TAMANHO) {
						try {
							Aluno aluno = new Aluno();

							System.out.print("Informe o seu nome: ");
							aluno.setNome(in.next());
	
							System.out.print("Informe a nota AV1: ");
							aluno.setAV1(in.nextFloat());
	
							System.out.print("Informe a nota AV2: ");
							aluno.setAV2(in.nextFloat());
	
							pessoa[pos] = aluno;
	
							pessoa[pos].imprimir();
	
							pos++;
						} catch (NomeIncompletoException e) {
							System.out.println("Error " + e.getMessage());
						}

					} else {
						System.out.println("Impossivel realizar um novo cadastramento!");
					}
					break;

				case "2":
					if (pos < Constante.TAMANHO) {

						System.out.print("Informe o seu nome: ");
						String nome = in.next();

						Professor professor = new Professor(nome);

						System.out.print("Informe o seu salário: ");
						professor.setSalario(in.nextFloat());

						pessoa[pos] = professor;

						pessoa[pos].imprimir();

						pos++;
					} else {
						System.out.println("Impossivel realizar um novo cadastramento!");
					}
					break;

				case "3":
					System.out.print("Informe o registro do aluno para impressão");
					int id = in.nextInt();

					if (id >= 0 && id < pos) {
						pessoa[id].imprimir();
					} else {
						System.out.println("O indice [" + id + "] é invalido!!!");
					}
					break;

				case "4":
					imprimir();
					break;

				case "5":
					System.out.println("Saida");
					break;

				default:
					System.out.println("A opção [" + opcao + "] invalida");
					break;
			}
		} while (!"5".equalsIgnoreCase(opcao));

		System.out.println("Processamento finalizado!!!");

		in.close();
	}
}