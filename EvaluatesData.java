import java.util.Scanner;


public class EvaluatesData {
	
	private String letra;
	private String data;
	private String output="";
	private String refList="";
	private String refCell="";
	private int i=0;
	
	public EvaluatesData() {}
	
	public void ReadData(String data) {
		
		this.data = data;
		Scanner sc;

		boolean wrong = false;
		int a1 = 1;		// variavel que simulam o valor retornado de uma lista
		int a2 = 2;		// variavel que simulam o valor retornado de uma lista
		int a3 = 3;		// variavel que simulam o valor retornado de uma lista	
		
		while (i < this.data.length() && wrong == false) {
			
			this.letra = this.data.substring(i,i+1);
			sc = new Scanner(this.letra);
			
			if (sc.hasNextInt()) {
				this.output = this.output + this.letra;
				
				if (ValidatesNext() == true) {
					this.letra = this.data.substring(i,i+1);
					sc = new Scanner(this.letra);
					if (sc.hasNextInt()) {
						wrong = false;
						i--;
					}
					else if (this.letra.equals("+") || this.letra.equals("-")
								|| this.letra.equals("*") || this.letra.equals("/")) {
						wrong = false;
						i--;
					}
					else {
						System.out.println("Formula Inválida para numeros");
						wrong = true;
					}
				}
				else {
					System.out.println("Não há mais dados.");
					break;
				}
			}
			else if (this.letra.equals("+") || this.letra.equals("-")
					|| this.letra.equals("*") || this.letra.equals("/")) {
				this.output = this.output + this.letra;
				
				if (ValidatesNext() == true) {
					this.letra = this.data.substring(i,i+1);
					sc = new Scanner(this.letra);
					if (sc.hasNextInt()) {
						wrong = false;
						i--;
					}
					else if (this.letra.equals("+") || this.letra.equals("-")
								|| this.letra.equals("*") || this.letra.equals("/")) {
						System.out.println("Formula Inválida para numeros");
						wrong = true;
					}
					else {
						wrong = false;
						i--;
					}
				}
				else {
					System.out.println("nao tem numeros");
					break;
				}
			}	
			else {
				this.refList = this.letra;
				
				boolean reference = false; 
				
				while (ValidatesNext() == true) {
					this.letra = this.data.substring(i,i+1);
					sc = new Scanner(this.letra);
					if (sc.hasNextInt()) {
						refCell = refCell + letra;
						wrong = false;
						reference = true;
					}
					else if (reference == true) {
						if (this.letra.equals("+") || this.letra.equals("-")
								|| this.letra.equals("*") || this.letra.equals("/")) {
							wrong = false;
							i--;
							break;
						}
						else {
							System.out.println("Formula Inválida.");
							wrong = true;
							break;
						}
					}
					else {
						System.out.println("Formula Inválida.");
						wrong = true;
						break;
					}
				}
				if (reference == false) {
					System.out.println("Formula Inválida.");
				}
			}	
			i++;
		}
		System.out.println("saida: "+this.output);
		System.out.println("refList: "+this.refList);
		System.out.println("refCell: "+this.refCell);
	}
	
	public boolean ValidatesNext() {
		i++;
		if (i == data.length()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
