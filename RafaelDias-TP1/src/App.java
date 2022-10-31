import java.util.Scanner;

public class App {
    private static String[] nomes;
	private static float[] AV1;
	private static float[] AV2;
    private static float[] media;

	private static final int TAMANHO = 100; 		

	private static void imprimir() {		
		for (int i = 0; i < TAMANHO; i++) {
			if(nomes[i] != null) {
				imprimir(i);
			}
		}
	}

	private static void imprimir(int indice) {
        System.out.println("Nome do aluno: " + nomes[indice]);
        System.out.println("Nota da AV1: " + AV1[indice]);
        System.out.println("Nota da AV2: " + AV2[indice]);
        System.out.println("Média final: " + calcularMedia(AV1[indice], AV2[indice], indice));
        System.out.println("Situação: " + obterSituacao(indice));
	}

    private static float calcularMedia(float av1, float av2, int indice) {
        return media[indice] = (av1 + av2) / 2;
    }
	
	private static String obterSituacao(int indice){	
		if(media[indice] < 4) {
			return "Reprovado";
        } else if (media[indice] > 4 && media[indice] < 7) {
            return "Prova Final";
        }
		return "Aprovado";
	}

	public static void main(String[] args) {
		nomes = new String[TAMANHO];
		AV1 = new float[TAMANHO];
		AV2 = new float[TAMANHO];
        media = new float[TAMANHO];
		
		Scanner in = new Scanner(System.in);
		
		String opcao;
		int pos = 0;

		do {
			System.out.println("[1] Registrar as notas de um novo aluno.");
			System.out.println("[2] Consultar boletim de um aluno.");
			System.out.println("[3] Consultar notas da turma.");
			System.out.println("[4] Sair");
			
			System.out.print("Informe a opção desejada: ");						
			opcao = in.next();
			
			switch (opcao) {
			case "1":
				if(pos < TAMANHO) {
					System.out.print("Informe o seu nome: ");	
					nomes[pos] = in.next();
	
					System.out.print("Informe a nota AV1: ");	
					AV1[pos] = in.nextFloat();
	
					System.out.print("Informe a nota AV2: ");	
					AV2[pos] = in.nextFloat();
					
					imprimir(pos);

					pos++;
				} else {
					System.out.println("Impossível realizar um novo registro!");
				}
				break;

			case "2":
				System.out.print("Informe o registro do aluno para impressão: ");						
				int id = in.nextInt();

				if(id >= 0 && id < pos) {
					imprimir(id);
				} else {
					System.out.println("O índice ["+id+"] é inválido!!!");
				}
				break;

			case "3":
				imprimir();
				break;

			case "4":
				System.out.println("Saída");
				break;

			default:
				System.out.println("A opção ["+opcao+"] inválida");
				break;
			}
		} while (!"4".equalsIgnoreCase(opcao));
				
		System.out.println("Processamento finalizado!!!");
		
		in.close();
	}
}
