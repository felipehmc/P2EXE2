package exe2.P2E2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class VulnerableClass {
	
	public void vulnerableMethod(String FILENAME) throws IOException{
		boolean usuarioQuerOperacao = true;
		//while (usuarioQuerOperacao) {
			Scanner console = new Scanner(System.in);
			int cont = 2;
			boolean comandoValido = false;
		    String opr = "";
		    
		    //so deve aceitar R ou W e nao deve pedir operacoes por um numero infinito de vezes
		    while(!comandoValido) {
		    	if(cont == 0) {
		    		System.out.println("Acabaram-se as chances de digitar um comando");
		    		break;
		    	}
		    	System.out.print("Digite a operacao desejada para realizar no arquivo <R para ler um arquivo, "
				    		+ "W para escrever em um arquivo>?\n" + "(Voce tem " + cont + " chances de digitar um comando valido)\n");
		    	opr= console.nextLine();
		    	if(opr.equals("R")) {
		    		//Scanner scan = new Scanner(System.in); /* Para teste */
		    		int numberOfCaracteresRead = 5;
		    		BufferedReader br = null;
		    		FileReader fr = null;

		    		try {
		    			fr = new FileReader(FILENAME);
		    			br = new BufferedReader(fr, numberOfCaracteresRead);

		    			char [] auxBuffer = new char [numberOfCaracteresRead];

		    			while (br.read(auxBuffer, 0, numberOfCaracteresRead)!=-1) {
		    				String sCurrentLine = String.valueOf(auxBuffer);
		    				System.out.print(sCurrentLine);	
		    				//String s = scan.nextLine(); /* Para teste */
		    			}

		    		} catch (IOException e) {
		    			throw e;
		    		} 
		    		comandoValido = true;
		    	}
		    	else if(opr.equals("W")) {
		    		BufferedWriter buffWrite = null;
		  		  
			  		try {
			  			//para nao sobrescrever
			  			buffWrite = new BufferedWriter(new FileWriter(FILENAME, true));
			  			String linha = "";
			  			System.out.println("Escreva algo: ");
			  		    linha = console.nextLine();
			  		    buffWrite.append(linha);
			  		    //buffWrite.write("\n" + linha + "\n");
			  		    System.out.println("LINHA: " +linha);
			  		     
			  		} catch (IOException e) {
			  			throw e;
			  			//e.printStackTrace();
			  		} 
			  		
			  		finally {
			  			try {
			  				buffWrite.close();
			  	            } catch (Exception e) {
			  	        }
			  		}
		    		comandoValido = true;
		    	}
		    	cont--;
		    }
		    
		    //String resp = "";
		    //boolean loop = false;
		    //cont = 3;
		    /*while (!loop) {
		    	if(cont == 0) {
		    		usuarioQuerOperacao = false;
		    		System.out.println("Acabaram-se o numero de chances de se digitar S ou N");
		    		loop = true;
		    	}
		    	System.out.println("O usuario deseja fazer mais alguma operacao? Digite S para sim ou N para nao.");
		    	System.out.println("(Voce tem " + cont + " chances de digitar S ou N)");
		    	resp = console.nextLine();
		    	System.out.println("RESP " +resp);
		    	if(resp.equals("S") || resp.equals("N"))
		    		loop = true;
		    	cont--;
		    }
		    if(resp.equals("N"))
		    	usuarioQuerOperacao = false;*/
		    try {
				//console.close();
			} catch (Exception e) {
			}
		//}
	}
	
}