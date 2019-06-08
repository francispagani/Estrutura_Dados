import java.util.*;
import java.util.Scanner;

class Main {
  public static void main(String args[]) {

    Random gerador = new Random(); 
    Random gerador2 = new Random();
    
    long inicioRubroNegra, auxRubroNegra, mediaRubroNegra = 0;
    long inicioAvl, auxAvl, mediaAvl = 0;
    long totalNodos = 0;
    long MAX = 0;
    int opc;
    int numbuscar;
    int numremover;
    
    Arvore a = new Arvore();
    ArvoreAvl b = new ArvoreAvl();
    Scanner scanner = new Scanner(System.in); 
    
    System.out.println("Bem-vindos ao sistema de Árvores Binárias");
    System.out.println("Para começar informe quantos Nós a árvore Rubro Negra e AVL terão: ");
    totalNodos = scanner.nextLong();
    
    System.out.println("Informe a quantidade máxima de número a serem geradas randomicamente: ");
    
    MAX = scanner.nextLong();
    long vetor[] = new long [(int) MAX];
    
    inicioRubroNegra = System.nanoTime();  
    inicioAvl = System.nanoTime();
                                           
    for (int i = 0; i < totalNodos; i++) {
    	{
       	 auxRubroNegra = System.nanoTime();              
		 a.adiciona(gerador.nextInt((int) MAX));
		     
		 vetor[i] = gerador.nextLong();
		 mediaRubroNegra +=  System.nanoTime() - auxRubroNegra;
    	{
    	    auxAvl = System.nanoTime();
    	    b.inserir(gerador.nextInt((int) MAX));
    	   	mediaAvl += System.nanoTime() - auxAvl;    			
    		}   
    	}     
    }
    mediaRubroNegra /= totalNodos;
    mediaAvl /= totalNodos;
    
  System.out.println("tempo de Inserção Rubro Negra: ");
  System.out.println(mediaRubroNegra / 10e9);
  
  System.out.println("tempo de Inserção da AVL: ");
  System.out.println(mediaAvl / 10e9);
  
    
   System.out.println("Deseja ver os números randômicos gerados? 1 para Sim - 2 para Não ");
   opc = scanner.nextInt();
   
   if (opc == 1) {
	   for(int i = 0; i< MAX; i++ ) {
		   System.out.println(vetor[i]);
	   }
   }  
   
   System.out.println("Informe o número que deseja buscar: ");
   numbuscar = scanner.nextInt();
   
     for (int i = 0; i <= totalNodos; i++) {
	  auxRubroNegra = System.nanoTime();            
      a.encontra(numbuscar);
      mediaRubroNegra += System.nanoTime() - auxRubroNegra;
   }

   System.out.printf("Média de tempo de Busca de Árvore Rubro Negra: %.10f\n\n", (mediaRubroNegra / 10e9));  
 
   System.out.println("Informe o número que deseja remover: ");
   numremover  = scanner.nextInt();
   
   for (int i = 0; i <= totalNodos; i++) {
		  auxAvl = System.nanoTime();            
	      b.remover(numremover);;
	      mediaAvl += System.nanoTime() - auxAvl;
	   }
   
   System.out.println("Média de tempo de Remoção da AVL: ");
   System.out.println(mediaAvl / 10e9);
    }
}