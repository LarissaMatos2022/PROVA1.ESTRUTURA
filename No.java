package BIMESTRE1;

public class No<TIPO> {

	public TIPO elemento;//ou dado
	public No<TIPO> proximo;
	//protected No<TIPO> atual;
	
	public No(TIPO elemento) {
		this.elemento = elemento;
	}
	
	public No(TIPO elemento, No<TIPO> proximo) {
		this.elemento = elemento;
		this.proximo = proximo;
	}
	
	public TIPO getElemento() {
		return elemento;
	}
	public void setElemento(TIPO elemento) {
		this.elemento = elemento;
	}
	
	public No<TIPO> getProximo() {
		return proximo;
	}
	public void setProximo(No<TIPO> proximo) {
		this.proximo = proximo;
	}

	public int compareTo(TIPO elementosComparable) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/*
	public No<TIPO> getAtual() {
		return atual;
	}
	public void setAtual(No<TIPO> atual) {
		this.atual = atual;
	}*/

}
