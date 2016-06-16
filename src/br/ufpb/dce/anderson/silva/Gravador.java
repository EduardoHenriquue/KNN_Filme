package br.ufpb.dce.anderson.silva;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Gravador {

	// APAGAR - Esse m�todo vai ser respons�vel por escrever no arquivo os r�tulos gerados
	public static void gravar(List<Double> rotulos , String nomeArquivo) throws IOException {
		
		BufferedWriter gravador = null;
		try{
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for(Double r: rotulos){
				gravador.write(r+" Estrela(s)\n");
			}
		} finally {
			if(gravador != null){
				gravador.close();
			}
		}
	}
		
	}


