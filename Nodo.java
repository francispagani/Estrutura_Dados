class Nodo {	                         
	public Integer v;                    
	public boolean ver;               
    public Nodo p, esq, dir;              

	public Nodo(int n, boolean ver) {
		this.v = n;
		this.ver = ver;
		this.p = this.esq = this.dir = Arvore.nil;
	}

	public Nodo encontra(int n) {	            
		if (n < this.v && this.esq != Arvore.nil) return this.esq.encontra(n);
		else if (n > this.v && this.dir != Arvore.nil) return this.dir.encontra(n);
		else return this;
	}

	public Nodo minimo() {		
		if (this.esq != Arvore.nil) return esq.minimo();
		else return this;
	}

    public Nodo maximo() {	 
		if (this.dir != Arvore.nil) return dir.maximo();
		else return this;
	}

	public void inorderWalk() {	      
		if (this.esq != Arvore.nil) this.esq.inorderWalk();
		System.out.println(this.v);
		if (this.dir != Arvore.nil) this.dir.inorderWalk();
	}

    public Nodo predecessor() {		 
		if (this.esq != Arvore.nil) return this.esq.maximo();
		else return this;
	}

	public Nodo sucessor(){		
		if (this.dir != Arvore.nil) return this.dir.minimo();
		else return this;
	}
	
    public void encontra50(Integer q, int aux, Arvore res) {       
		if(q >= 50) return;
		if (this.esq != Arvore.nil) {
			this.esq.encontra50(q, aux, res);
		}
		
		if (this.v > aux && q < 50) {
			res.adiciona(this.v);
			q++;
		}
		
		if (this.dir != Arvore.nil) {
			this.dir.encontra50(q, aux, res);
		}
	}
  
	public void grafico() {
		if (this.ver) {
				System.out.println("\t" + this.v + " [style = filled, fillcolor = red];");
		} 
		
		else {
				System.out.println("\t" + this.v + " [style = filled, fillcolor = black, fontcolor = white];");
		}

		if (this.esq != Arvore.nil) {
				System.out.println("\t" + this.v + " -> " + this.esq.v + " [label = \" esq\"];");
				this.esq.grafico();
		}
		
		else {
				System.out.println("\t" + this.v + " -> nil [label = \" esq\"];");
		}

		if (this.dir != Arvore.nil) {
				System.out.println("\t" + this.v + " -> " + this.dir.v + " [label = \" dir\"];");
				this.dir.grafico();
		}
		
		else {
				System.out.println("\t" + this.v + " -> nil [label = \" dir\"];");
		}
	}
}