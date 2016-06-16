package br.ufpb.dce.anderson.silva;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Gravador {

	// APAGAR - Esse método vai ser responsável por escrever no arquivo os rótulos gerados
	public static void gravar(List<Integer> rotulos , String nomeArquivo) throws IOException {
		
		BufferedWriter gravador = null;
		try{
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for(Integer r: rotulos){
				gravador.write(r+"\n");
			}
		} finally {
			if(gravador != null){
				gravador.close();
			}
		}
	}
		
	}


