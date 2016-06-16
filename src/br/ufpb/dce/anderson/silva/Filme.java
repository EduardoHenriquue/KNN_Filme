package br.ufpb.dce.anderson.silva;

import java.util.List;

public class Filme {
	private float nota;
	private String [] dadosDoFilme;
	
	public Filme(){
		
	}
	
	public Filme(float nota, String[] dadosDoFilme) {
		super();
		this.nota = nota;
		this.dadosDoFilme = dadosDoFilme;
	}
	
	public Filme(String[] dadosDoFilme){
		this.dadosDoFilme = dadosDoFilme;
	}

	public float getNota() {
		return nota;
	}

	public void setNota(float nota) {
		this.nota = nota;
	}

	public String[] getDadosDoFilme() {
		return dadosDoFilme;
	}

	public void setDadosDoFilme(String[] dadosDoFilme) {
		this.dadosDoFilme = dadosDoFilme;
	}
	
	
}