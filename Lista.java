package BIMESTRE1;

public abstract class Lista<TIPO extends Comparable<TIPO>> {

	public No<TIPO> primeiro;//ou inicio
	public No<TIPO> ultimo;//ou fim
	public int totalElementos;//ou total de elementos
	
	public Lista() {
		this.totalElementos = 1;
	}
	
	public No<TIPO> getPrimeiro() {
		return primeiro;
	}
	public void setPrimeiro(No<TIPO> primeiro) {
		this.primeiro = primeiro;
	}
	
	public No<TIPO> getUltimo() {
		return ultimo;
	}
	public void setUltimo(No<TIPO> ultimo) {
		this.ultimo = ultimo;
	}

	public int getTotalElementos() {
		return totalElementos;
	}
	public void setTotalElementos(int totalElementos) {
		this.totalElementos = totalElementos;
	}
	
	public abstract void adicionarFim(TIPO elemento) throws Exception;

	public abstract void adicionarInicio(TIPO elemento) throws Exception;
	
	public abstract void adicionar(TIPO elemento, int posicao) throws Exception;
	
	public abstract TIPO get(int posicao) throws Exception;
	 
	public abstract int getPos(TIPO elemento) throws Exception;
	
	public abstract void remover(int posicao) throws Exception;
	 
	public abstract void limpar();
	 
	public abstract int getTamanho();
	 
	public abstract boolean contem(TIPO elemento) throws Exception;
	
}
