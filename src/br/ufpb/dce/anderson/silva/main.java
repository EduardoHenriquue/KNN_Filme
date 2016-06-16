package br.ufpb.dce.anderson.silva;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class main {
	public static void main (String [] args) throws IOException{
		Leitor leitor = new Leitor();
//		leitor.carregarFilmes("dadosFilmes.txt");
		leitor.carregarFilmes("TREINAMENTO.txt");
		leitor.gerarTreinamento();
		
		leitor.carregarFilmesTeste("dadosTeste.txt");
		
		List<String> filmesDeTreinamento = Leitor.getDadosTreinamentos(); // Pega os filmes de treinamento
		List<Filme> filmesDeTeste = Leitor.getFilmesTeste(); // Pega os filmes de teste
		leitor.converterDadosTeste(); // Converte os dados de teste em números
		List<String> dadosDeTeste = Leitor.getDadosTeste();

		KNN knn = new KNN(50,filmesDeTreinamento,dadosDeTeste);

		List<Double> list = knn.Classificador();

		
	}
}
