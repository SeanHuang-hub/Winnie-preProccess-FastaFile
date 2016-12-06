package entity;

public class Data {
	String mark;
	String species;
	char[] squence;
	double similarity;
	
	public String getSpecies() {
		return species;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public char[] getSquence() {
		return squence;
	}
	public void setSquence(char[] squence) {
		this.squence = squence;
	}
	public double getSimilarity() {
		return similarity;
	}
	public void setSimilarity(double similarity) {
		this.similarity = similarity;
	}
}
