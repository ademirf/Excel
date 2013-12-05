import java.util.Scanner;

public class Matrix {

	public static void main(String[] args) {

		String nameCell = null;
		String data = "";
		int position = 0;
		
		Scanner sc;
		
		ListList ll = new ListList();
		List l = new List(data);
		EvaluatesData c = new EvaluatesData();		
		
		/* exibir a planilha
		// dados:
		A1: 10.0000
		A2: 5.5000
		B2: 1.5000
		B2: 3.0000
		C3: 9.0000
		*/
		
		while (true) {
			
			System.out.println(l);
			
			System.out.println("Digite a célula que de seja acessar: ");
			sc = new Scanner(System.in);
			nameCell = sc.next();
			
			if (nameCell.equalsIgnoreCase("fim")) {
				System.exit(0);
			}
			System.out.println("Digite a fórmula desejada:");
			System.out.println(nameCell+": ");
			sc = new Scanner(System.in);
			data = sc.next();
			c.ReadData(data);
		}

		//-------------------------------------------------------------------------------------------------------
		// Apos o usuario digitar a celula, caso a mesma ja exista, exibir a formula associada a celula.
		
		// solicitar nova fórmula
		
		// Apos a entrada da nova formula, exibir novamente a planilha e esperar pela entrada de dados do usuario.
		//-------------------------------------------------------------------------------------------------------
/*		
		// COMANDOS DA LISTA:
		position = 1;
		data = "teste";
		
		l.AddsBeginning(data);	// adiciona no inicio
		l.Adds(data);	// adiciona no fim
		l.Adds(position, data);  // adiciona em qualquer posição
		
		l.RemoveBeginning();	// remove do começo
		l.RemoveEnd();		// remove do fim
		l.Remove(position); 	// remove de qualquer posição
		
		l.Magpie(position); 	// pega dado de qualquer posição
		l.Size(); 		// verifica o tamanho
		l.toString();		// verifica se alista está vazia
		
		System.out.println(l);		// mostra a lista
		
		//TESTE ADICIONA NO FIM
		l.Adds("Rafael");
		l.Adds("Paulo");
	    
	    System.out.println(l);
	    
	    //TESTE ADICIONA POR POSIÇÃO
	    l.Adds(0, "primeira posição");
	    l.Adds(1, "segunda posição");
*/
		
	}
}

