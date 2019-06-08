class Arvore {
	public Nodo raiz;                         
	public static Nodo nil = new Nodo(0, false); 											   	    
	public Integer cont;

	public Arvore() {
		this.raiz = Arvore.nil;
	}

	public Arvore(int v) {
		this.raiz = new Nodo(v, false);
	}
	              
	private void rotacao_esq(Nodo x) {
		Nodo y = x.dir;
		x.dir = y.esq;
		if (y.esq != Arvore.nil) y.esq.p = x;
		y.p = x.p;
		
		if (x.p == Arvore.nil) this.raiz = y;
		else if (x == x.p.esq) x.p.esq = y;
		else x.p.dir = y;
		y.esq = x;
		x.p = y;
	}
     
	private void rotacao_dir(Nodo x) {
		Nodo y = x.esq;
		x.esq = y.dir;
		if (y.dir != Arvore.nil) y.dir.p = x;
		y.p = x.p;
		
		if (x.p == Arvore.nil) this.raiz = y;
		else if (x == x.p.esq) x.p.esq = y;
		else x.p.dir = y;
		y.dir = x;
		x.p = y;
	}

	public void adiciona (int n) {
		if (this.raiz == Arvore.nil) {
	  			
		   this.raiz = new Nodo (n, false);
		} 
		
		else {			
			Nodo a = this.encontra(n);
			
			if (n < a.v) {				
				a.esq = new Nodo(n, true);
				a.esq.p = a;
				this.fixaAdicao(a.esq);				
			}	
			
			else if (n > a.v) {				
				a.dir = new Nodo(n, true);
				a.dir.p = a;
				this.fixaAdicao(a.dir);					   
			}
		}
	}

	public void transplant (Nodo x, Nodo y) {		
		if (x.p == Arvore.nil) this.raiz = y;
		else if (x == x.p.esq) x.p.esq = y;
		else x.p.dir = y;
		y.p = x.p;
	}

	private void fixaAdicao(Nodo z) {
			Nodo y;
			while (z.p.ver) {
					if (z.p == z.p.p.esq) {
							y = z.p.p.dir;
							if (y.ver) { 			  
								                           							
								z.p.ver = false;
								y.ver = false;
								z.p.p.ver = true;
								z = z.p.p;
							}	
							
							else {                                    
									if (z == z.p.dir) {                     
										z = z.p;
										this.rotacao_esq(z);
									}
								                                           	
									z.p.ver = false;
									z.p.p.ver = true;
									this.rotacao_dir(z.p.p);
							}							
					      }	
					
					        else {
							y = z.p.p.esq;
							if (y.ver) {                      
								y.ver = z.p.ver = false;
								z.p.p.ver = true;
								z = z.p.p;
							}	
							
							else {
								  if (z == z.p.esq) {                     
									  z = z.p;
									  this.rotacao_dir(z);
								  }									                                       
								  z.p.ver = false;
								  z.p.p.ver = true;
								  this.rotacao_esq(z.p.p);
							      }
					            }      
			                }                
	  this.raiz.ver = false;
	}
		
	 public void grafico() {
	 System.out.println("digraph Arvore {");
	 this.raiz.grafico();
	 System.out.println("\tnil [style = filled, fillcolor = black, fontcolor = white];");
	 System.out.println("}");
	}

	public void inorderWalk() {
	this.raiz.inorderWalk();
	}

	public Nodo minimo() {
	return this.raiz.minimo();
	}

	public Nodo maximo() {
	return this.raiz.maximo();
	}

	public Nodo encontra (int n) {
	return this.raiz.encontra(n);
	}
}