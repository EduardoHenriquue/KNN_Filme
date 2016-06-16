package br.ufpb.dce.anderson.silva;

//Lembrar de perdir explica��o desse m�todo
public class Distancia implements Comparable<Distancia> {
	private double distancia;
	private String filmeTreinamento;
	
	public Distancia(double distancia, String filmeTreinamento){
		this.distancia = distancia;
		this.filmeTreinamento = filmeTreinamento;
	}
	
	public double getDistancia() {
		return distancia;
	}

	public String getFilmeTreinamento() {
		return filmeTreinamento;
	}


	public static double calcularDistancia(String filmeTreino, String filmeTeste){

		String[] filmeX = filmeTreino.split(",");
		String[] filmeY = filmeTeste.split(",");
		
		double diretor = Math.pow(Double.parseDouble(filmeX[0]) - Double.parseDouble(filmeY[0]), 2);
		double ator1 = Math.pow(Double.parseDouble(filmeX[1]) - Double.parseDouble(filmeY[1]), 2);
		double ator2 = Math.pow(Double.parseDouble(filmeX[2]) - Double.parseDouble(filmeY[2]), 2);
		double ator3 = Math.pow(Double.parseDouble(filmeX[3]) - Double.parseDouble(filmeY[3]), 2);
		double ator4 = Math.pow(Double.parseDouble(filmeX[4]) - Double.parseDouble(filmeY[4]), 2);
				
		return Math.sqrt(diretor+ator1+ator2+ator3+ator4);
	}
	
	public int compareTo(Distancia distancia) {
		if(this.distancia > distancia.getDistancia())
			return 1;
		else if(this.distancia < distancia.getDistancia())
			return -1;
		return 0;
	}
	
}