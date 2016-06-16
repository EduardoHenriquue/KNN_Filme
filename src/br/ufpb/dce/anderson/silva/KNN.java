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
	private float quantTotalDeFloresASeremRotuladas = 45;  
	
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
	public List<Integer> Classificador() throws IOException{
		List<Integer> rotulos = new LinkedList<Integer>();
		//v�o ser dois for o primeiro baseado na filme de teste e o de dentro o de treinamento;
		for(int x=0; x<filmesDeTeste.size();x++){
			List<Distancia> distancia = new ArrayList<Distancia>();
			
			for(int k=0; k<filmeTreinamento.size();k++){
				
				distancia.add(new Distancia(Distancia.calcularDistancia(filmeTreinamento.get(k), filmesDeTeste.get(x)), filmeTreinamento.get(k)));
				
				
			}
			//ORDENA AS DISTANCIAS ENCONTRADAS
			Collections.sort(distancia);
			//PEGA AS DISTANCIAS DE ACORDO COM O VALOR DE K
			List<Distancia> kProximos = distancia.subList(0, this.getValorK());
			String rotulo = this.rotuloMaisFrequente(kProximos)+"";
			this.filmesDeTeste.get(x).concat(rotulo);
		
			rotulos.add(this.rotuloMaisFrequente(kProximos));
			System.out.println("Rotulo da "+x+": " + this.rotuloMaisFrequente(kProximos));
		}
		Gravador.gravar(rotulos, this.nomeDoArquivo);
		
		return rotulos;
		
	}
	
	public float porcentagemDeAcerto(List<Integer> rotulos, List<Integer> rotulosTeste){
		float porcentagem = 0;
		int count = 0;
		for(int x=0; x<rotulos.size(); x++){
			if(rotulos.get(x) == rotulosTeste.get(x)){
				count ++;
			}
		}

		System.out.println("count "+ count);
		System.out.println("total de rotulos "+this.quantTotalDeFloresASeremRotuladas);
		porcentagem = (count/ this.quantTotalDeFloresASeremRotuladas)*100;
		System.out.println("porcentagem "+ porcentagem);
		return porcentagem;
	}
	
	//APAGAR - Lembrar melhor desse m�todo
	public int rotuloMaisFrequente(List<Distancia> kProximos){
		int rotulo0 = 0;
		int rotulo1 = 0;
		int rotulo2 = 0;
		//FAZ UM COUNT NOS ROTULOS QUE MAIS APARECEM DE ACORDO COM A DISTANCIA
		//ESPECIFICADA PELO VALOR K
		for(int k=0; k<kProximos.size(); k++){
			if(kProximos.get(k).getRotuloFilmeTreinamento() == "0"){
				rotulo0 ++;
			}else if(kProximos.get(k).getRotuloFilmeTreinamento() == "1"){
				rotulo1 ++;
			}else{
				rotulo2 ++;
			}
		}
		int rotulo = 0;
		
		if(rotulo0 > rotulo1 && rotulo0 > rotulo2){
			rotulo = 0;
		}else if(rotulo1 > rotulo0 && rotulo1 > rotulo2){
			rotulo = 1;
		}else if(rotulo2 > rotulo0 && rotulo2 > rotulo1){
			rotulo = 2;
		}else{
			Random r = new Random();
			rotulo = r.nextInt(3);
		}
		return rotulo;
	}
	
	
	
}
	
	
	
	
	
	
	
	
