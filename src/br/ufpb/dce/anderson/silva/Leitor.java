package br.ufpb.dce.anderson.silva;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Leitor {
	// Dados com os nomes dos atores e diretor lidos do arquivo e ainda não convertidos
	private static List<Filme> filmesDeTeste = new ArrayList<Filme>(); 
	private static List<String> dadosTreinamento = new ArrayList<String>(); // Dados convertidos em números
	private List<Filme> dadosFilmes = new ArrayList<Filme>(); // Filmes de treinamento para serem convertidos
	private Map<String,Float> nomesEValores = new HashMap<String, Float>(); // Nomes e valores dos dados
	private static List<String> dadosTeste = new ArrayList<String>(); // Dados de teste convertidos
	
	
	public void gerarTreinamento(){
		String diretor;
		String ator1;
		String ator2;
		String ator3;
		String ator4;
		float nota = 0;
		
		float mediaDiretor = 0;
		float mediaAtor1 = 0;
		float mediaAtor2 = 0;
		float mediaAtor3 = 0;
		float mediaAtor4 = 0;
		
		for(int i=0; i<dadosFilmes.size();i++){
			diretor = dadosFilmes.get(i).getDadosDoFilme()[0];
			ator1 = dadosFilmes.get(i).getDadosDoFilme()[1];
			ator2 = dadosFilmes.get(i).getDadosDoFilme()[2];
			ator3 = dadosFilmes.get(i).getDadosDoFilme()[3];
			ator4 = dadosFilmes.get(i).getDadosDoFilme()[4];
			nota = dadosFilmes.get(i).getNota();
	
			mediaDiretor = calcularMedia(diretor,this.dadosFilmes);
			mediaAtor1 = calcularMedia(ator1,this.dadosFilmes);
			mediaAtor2 = calcularMedia(ator2,this.dadosFilmes);
			mediaAtor3 = calcularMedia(ator3,this.dadosFilmes);
			mediaAtor4 = calcularMedia(ator4,this.dadosFilmes);
		
			String filme = mediaDiretor +","+mediaAtor1+","+mediaAtor2+","+mediaAtor3+","+mediaAtor4+","+nota;
			this.dadosTreinamento.add(filme);
			
			addNomesEValores(diretor, mediaDiretor);
			addNomesEValores(ator1, mediaAtor1);
			addNomesEValores(ator2, mediaAtor2);
			addNomesEValores(ator3, mediaAtor3);
			addNomesEValores(ator4, mediaAtor4);
//			System.out.println("Media "+diretor+" Diretor: "+mediaDiretor);
//			System.out.println("Media Ator: "+ator1+" "+ mediaAtor1);
//			System.out.println("Media Ator: "+ator2+" "+ mediaAtor2);
//			System.out.println("Media Ator: "+ator3+" "+ mediaAtor3);
//			System.out.println("Media Ator: "+ator4+" "+ mediaAtor4);
//			System.out.println("\n");
//			for (Map.Entry<String, Float> map:nomesEValores.entrySet()) {
//				System.out.println("Nome: "+map.getKey() + ", Valor: " + map.getValue());
//			}
		}
		
	}
	
	public float calcularMedia(String nome, List<Filme> dadosFilmes){
//		Retornar frequencia e a soma das notas
		int frequencia = 0;
		float somaDasNotas = 0;
		float media = 0;
		
//		Pega todos os filmes do treinamento
		for(int i=0; i<dadosFilmes.size(); i++){
//			Pega cada elemento do filme, ou seja, diretor e os atores
			for(int k=0; k<dadosFilmes.get(i).getDadosDoFilme().length;k++){
				if(nome.equals(dadosFilmes.get(i).getDadosDoFilme()[k])){
					somaDasNotas += dadosFilmes.get(i).getNota();
					frequencia++;
				}
			}
		}
		media = somaDasNotas/frequencia;
		return media;
	}
	
	public static List<String> getDadosTreinamentos(){
		return dadosTreinamento;
	}
	
	public static List<Filme> getFilmesTeste(){
		return filmesDeTeste;
	}

	public void addNomesEValores(String nome, float valor){
		if(!nomesEValores.containsKey(nome)){
			nomesEValores.put(nome, valor);
			System.out.println(nome + " " +valor);
		}
	}
	
	public void converterDadosTeste(){
		String diretor;
		String ator1;
		String ator2;
		String ator3;
		String ator4;
		
		for(int i=0; i < this.filmesDeTeste.size(); i++){
			String testesConvertidos;
			diretor = getValueMap(nomesEValores, filmesDeTeste.get(i).getDadosDoFilme()[0]);
			ator1 = getValueMap(nomesEValores, filmesDeTeste.get(i).getDadosDoFilme()[1]);
			ator2 = getValueMap(nomesEValores, filmesDeTeste.get(i).getDadosDoFilme()[2]);
			ator3 = getValueMap(nomesEValores, filmesDeTeste.get(i).getDadosDoFilme()[3]);
			ator4 = getValueMap(nomesEValores, filmesDeTeste.get(i).getDadosDoFilme()[4]);

			testesConvertidos = diretor +","+ator1+","+ator2+","+ator3+","+ator4;
			//testesConvertidos = ator1+","+ator2+","+ator3+","+ator4;
//			if(nomesEValores.containsKey(diretor)){
//				testesConvertidos += nomesEValores.get(diretor)+",";
//			}else{
//				testesConvertidos += "0,";
//			}
//			if(nomesEValores.containsKey(ator1)){
//				testesConvertidos += nomesEValores.get(ator1)+",";
//			}else{
//				testesConvertidos += "0,";
//			}
//			if(nomesEValores.containsKey(ator2)){
//				testesConvertidos += nomesEValores.get(ator2)+",";
//			}else{
//				testesConvertidos += "0,";
//			}
//			if(nomesEValores.containsKey(ator3)){
//				testesConvertidos += nomesEValores.get(ator3)+",";
//			}else{
//				testesConvertidos += "0,";
//			}
//			if(nomesEValores.containsKey(ator4)){
//				testesConvertidos += nomesEValores.get(ator4);
//			}else{
//				testesConvertidos += "0";
//			}
			dadosTeste.add(testesConvertidos);
		}
	}
	
	public String getValueMap(Map<String, Float> map, String key){
		if(map.containsKey(key)){
			return map.get(key)+"";
		} else {
			return "0";
		}
		 
	}
	
	public static List<String> getDadosTeste(){
		return dadosTeste;
	}
	
	//APAGAR - Rever este m�todo
	public void carregarFilmes(String nomeArquivo) throws IOException{ 	
		int quantidadeDeAtributosDoFilme = 5;
		int indexDaNota = 5;
		Scanner leitor = null;
		leitor = new Scanner(new FileReader(nomeArquivo));
		leitor.nextLine();
		
		//ENQUANTO TIVER CONTEUDO NA PRÓXIMA LINHA
		while(leitor.hasNextLine()) {
			
			//Pega a linha do arquivo, ignora a "," e adiciona os elementos no array
			String[] linhaDoArquivo = leitor.nextLine().split(",");
			String [] dadosDoFilme = new String[quantidadeDeAtributosDoFilme];
			
			//Salva o rótulo que está na linha do arquivo
			float nota = Float.parseFloat(linhaDoArquivo[indexDaNota]);
			
			for(int i=0; i < quantidadeDeAtributosDoFilme; i++){
				//Pega a primeira linha do arquivo e atribui ao array de medidas das flores
				dadosDoFilme[i] = String.valueOf(linhaDoArquivo[i]);
			}
			dadosFilmes.add(new Filme(nota,dadosDoFilme));

		}
		leitor.close();
	}

//	
	public void carregarFilmesTeste(String nomeArquivo) throws IOException{ 	
		
		int quantidadeDeAtributosDoFilme = 5;
		Scanner leitor = null;
		leitor = new Scanner(new FileReader(nomeArquivo));
		leitor.nextLine();
		
		//ENQUANTO TIVER CONTEUDO NA PROXIMA LINHA
		while(leitor.hasNextLine()) {
			
			//Pega a linha do arquivo, ignora a "," e adiciona os elementos no array
			String[] linhaDoArquivo = leitor.nextLine().split(",");
			String [] dadosDoFilme = new String[quantidadeDeAtributosDoFilme];
			
			
			
			for(int i=0; i < quantidadeDeAtributosDoFilme; i++){
				//Pega a primeira linha do arquivo e atribui ao array de medidas das flores
				dadosDoFilme[i] = String.valueOf(linhaDoArquivo[i]);
			}
			filmesDeTeste.add(new Filme(dadosDoFilme));

		}
		leitor.close();
	}
//	
//	//APAGAR - Quando eu digo carregar???
//	public List<Integer> carregarRotulosTeste(String nomeArquivo) throws IOException{ 	
//		List <Integer> rotulosTeste = new LinkedList<Integer>();
//		Scanner leitor = null;
//		leitor = new Scanner(new FileReader(nomeArquivo));
//		
//
//		//ENQUANTO TIVER CONTEUDO NA PROXIMA LINHA
//		while(leitor.hasNextLine()) {
//			
//			//Pega a linha do arquivo e adiciona na lista
//			String linhaDoArquivo = leitor.nextLine();
//			rotulosTeste.add(Integer.parseInt(linhaDoArquivo));
//		}
//		
//		leitor.close();
//		return rotulosTeste;
//	}
}