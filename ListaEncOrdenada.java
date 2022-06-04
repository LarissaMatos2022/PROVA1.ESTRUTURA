package BIMESTRE1;

public class ListaEncOrdenada<TIPO extends Comparable<TIPO>> extends ListaEnc<TIPO> {//<TIPO extends Comparable<TIPO>>

	public void setTipoOrdenacao (boolean crescente) throws Exception {
		if (crescente==true) {
			System.out.println("A ordenação será feita em ordem crescente.");
			TIPO atual;
			No<TIPO> i;
			No<TIPO> j;
	        for(i = primeiro; i.proximo != null; i = i.proximo){ 
	            for(j = i.proximo; j != null; j = j.proximo){ 
	                if (i.elemento.compareTo(j.elemento)>0) {
	                	atual = j.elemento;
	                	j.elemento = i.elemento;
	                	i.elemento = atual;
	                }
	            }
	        }
		}else {
			if (crescente==false) {
				System.out.println("A ordenação será feita em ordem decrescente.");
				TIPO atual;
				No<TIPO> i;
				No<TIPO> j;
		        for(i = primeiro; i.proximo != null; i = i.proximo){ 
		            for(j = i.proximo; j != null; j = j.proximo){ 
		                if (i.elemento.compareTo(j.elemento)<0) {
		                	atual = j.elemento;
		                	j.elemento = i.elemento;
		                	i.elemento = atual;
		                }
		            }
		        }
			}
		}
	}
	
	public void adicionarFim(TIPO elemento) throws Exception {
		//Adiciona um elemento no final da lista
		if (primeiro==null) {
			 this.adicionarInicio(elemento);
		 }else {
			 No<TIPO> novoElemento = new No<TIPO>(elemento);
			 ultimo.proximo = novoElemento;  
			 ultimo = novoElemento;
			 novoElemento.proximo = null;      
			 this.totalElementos++;
		 }
	}

	public void adicionarInicio(TIPO elemento) throws Exception {
		//Adiciona um elemento no início da lista
		if (primeiro==null) {
				 No<TIPO> novoElemento = new No<TIPO>(elemento);
				 primeiro = novoElemento;
				 ultimo = novoElemento;
		}else {
				 No<TIPO> novoElemento = new No<TIPO>(elemento, primeiro);
				 novoElemento.proximo = primeiro;   
				 primeiro = novoElemento; 
				 this.totalElementos++;
		}
	}
	
	public void adicionar(TIPO elemento, int posicao) throws Exception {
		if(primeiro==null || posicao==1){
			this.adicionarInicio(elemento);
		}else {
			if(ultimo.proximo==null && posicao>this.totalElementos){
				this.adicionarFim(elemento);
			}else {
				No<TIPO> atual = this.pegaNo(posicao-1);
				No<TIPO> novoElemento = new No<TIPO>(elemento);
				novoElemento.proximo = atual.proximo;
				atual.proximo = novoElemento; 
				this.totalElementos++;
			}
		}
	}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 1 && posicao <= this.totalElementos;
	}
	
	private No<TIPO> pegaNo(int posicao) {
		No<TIPO> atual = primeiro;
		for (int i = 1; i < posicao; i++) {
			atual = atual.proximo;
		}
		return atual;
	}
	
	public TIPO get(int posicao) throws Exception {
		//Retorna o elemento que está na posição
		if(!this.posicaoOcupada(posicao)){
			throw new Exception("Posição solicitada não existe na lista!");
		}else {
			return this.pegaNo(posicao).getElemento();
		}
	}
	 
	public int getPos(TIPO elemento) throws Exception {
		// Retorna a posição do elemento
		for (int i = 1; i <= this.getTamanho(); i++) {
			if (this.pegaNo(i).getElemento().compareTo(elemento) == 0) {
				return i;
			}
		}
		throw new Exception("Elemento não localizado!");
	}
	
	public void remover(int posicao) throws Exception {
		//System.out.println("Remove o elemento do inicio");
		if (posicao == 1 || this.totalElementos==1) {
			if (!this.posicaoOcupada(1)) {
				throw new Exception("Posicao não existe!");
			}
			primeiro = primeiro.proximo;
			this.totalElementos--;
			if (this.totalElementos == 1) {
				No<TIPO> atual = ultimo;
				ultimo = atual;
			}
		}else {
			//System.out.println("Remove o elemento do fim");
			if (posicao == this.totalElementos) {
				if (!this.posicaoOcupada(this.totalElementos)) {
					throw new Exception("Posicao não existe!");
				}
		        No<TIPO> atual = this.pegaNo(posicao-1);
		        atual.proximo = null;
		        ultimo = atual;
		        this.totalElementos--;
		    }else {
		    	//System.out.println("Remove o elemento da posição específica");
		    	if (!this.posicaoOcupada(posicao)) {
		    		throw new Exception("Posicao não existe!");
				}
		    	No<TIPO> atual = this.pegaNo(posicao-1);
		    	atual.proximo = atual.proximo.proximo;
		    	this.totalElementos--;
		    }
		}
	}
	 
	public void limpar() {
		// Remove todos os elementos da lista
		if (primeiro==null) {
			System.out.println("A lista está vazia!");
		}else {
			primeiro=null;
			System.out.println("A lista foi esvaziada");
			totalElementos = getTamanho()-totalElementos;
		}
	}
	 
	public int getTamanho() {
		 // Retorna a quantidade de elementos na lista
		return this.totalElementos;
	}
	 
	public boolean contem(TIPO elemento) throws Exception {
		//Indica se contém ou não o elemento na lista
		No<TIPO> atual = this.primeiro;
		while (atual != null) {
		if (atual.getElemento().compareTo(elemento)==0) {
			throw new Exception("O elemento está na lista.");
		}
		atual = atual.getProximo();
		}
		throw new Exception("O elemento não está na lista!");
	}
	
	public String toString() {
		No<TIPO> atual = primeiro;
		String listaCompleta = "[";
		if (atual == null) {
			return "[]";
		}else {
			while (atual!=null) {
				if (atual==getUltimo()) { 
					listaCompleta += atual.getElemento() + "]";
					break;
				}else {
					listaCompleta += atual.getElemento() + ", ";
				    atual = atual.proximo;
				}
			}
		return listaCompleta;
		}
	}
	
	public int compareTo(TIPO elemento1, TIPO elemento2) {
		if (elemento1.compareTo(elemento2) < 0) { 
			  return 1; 
		}
		if (elemento1.compareTo(elemento2) > 0) { 
			  return -1; 
		} 
	    return 0; 
	}
}
