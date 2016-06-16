package br.ufpb.dce.anderson.silva;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class KNN{
	private int valorK;
	private List<String> filmeTreinamento;
	private List<String> filmesDeTeste;
	private String nomeDoArquivo = "resultado.txt"; 

	
	public KNN(int valorK, List<String> filmeTreinamento, List<String> filmesDeTeste){
		this.valorK = valorK;
		this.filmeTreinamento = filmeTreinamento;
		this.filmesDeTeste = filmesDeTeste;
	}
	
	
	public int getValorK() {
		return valorK;
	}

	public List<String> getFilmesDeTreinamento() {
		return this.filmeTreinamento;
	}

	public List<String> getFilmesDeTeste() {
		return this.filmesDeTeste;
	}
	
	//APAGAR - Lembrar direito desse m�todo/ Classificar r�tulo para cada flor de teste
	public List<Double> Classificador() throws IOException{
		List<Double> rotulos = new ArrayList<Double>();

		for(int x=0; x<filmesDeTeste.size();x++){
			List<Distancia> distancia = new ArrayList<Distancia>();
			
			for(int k=0; k<filmeTreinamento.size();k++){
				
				distancia.add(new Distancia(Distancia.calcularDistancia(filmeTreinamento.get(k), filmesDeTeste.get(x)), filmeTreinamento.get(k)));
				
				
			}
			//ORDENA AS DISTANCIAS ENCONTRADAS
			Collections.sort(distancia);
			//PEGA AS DISTANCIAS DE ACORDO COM O VALOR DE K
			List<Distancia> kProximos = distancia.subList(0, this.getValorK());

			rotulos.add(this.rotuloMaisFrequente(kProximos));
		}
		Gravador.gravar(rotulos, this.nomeDoArquivo);
		
		return rotulos;
		
	}
	

	
	//APAGAR - Lembrar melhor desse m�todo
	public double rotuloMaisFrequente(List<Distancia> kProximos){
		int rotulo1 = 0;
		int rotulo2 = 0;
		int rotulo3 = 0;
		int rotulo4 = 0;
		int rotulo5 = 0;
		//FAZ UM COUNT NOS ROTULOS QUE MAIS APARECEM DE ACORDO COM A DISTANCIA
		//ESPECIFICADA PELO VALOR K
		for(int k=0; k<kProximos.size(); k++){
			int tamanho = kProximos.get(k).getFilmeTreinamento().split(",").length;

			double kRotulo = Double.parseDouble(kProximos.get(k).getFilmeTreinamento().split(",")[tamanho-1]);
			if(kRotulo >= 0 && kRotulo <= 2){
				rotulo1++;
			}else if(kRotulo > 2 && kRotulo <= 4){
				rotulo2++;
			}else if(kRotulo > 4 && kRotulo <= 6){
				rotulo3++;
			} else if(kRotulo > 6 && kRotulo <= 8){
				rotulo4 ++;
			} else {
				rotulo5++;
			}
		}


		if(rotulo1 > rotulo2 && rotulo1 > rotulo3 && rotulo1 > rotulo4 && rotulo1 > rotulo5 ){
			return 1;
		} else if(rotulo2 > rotulo1 && rotulo2 > rotulo3 && rotulo2 > rotulo4 && rotulo2 > rotulo5){
			return 2;
		} else if(rotulo3 > rotulo1 && rotulo3 > rotulo2 && rotulo3 > rotulo4 && rotulo3 > rotulo5){
			return 3;
		} else if(rotulo4 > rotulo1 && rotulo4 > rotulo2 && rotulo4 > rotulo3 && rotulo4 > rotulo5){
			return 4;
		} else{
			return 5;
		}
	}
	
	
	
}
	
	
	
	
	
	
	
	
