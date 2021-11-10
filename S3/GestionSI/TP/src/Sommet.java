import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Sommet {

	private String nom;
	
	private ArrayList<Sommet> plusCourtChemin;
	
	private Integer distance = Integer.MAX_VALUE;
	
	private Map<Sommet, Integer> sommetsVoisins;
	 
	
	public Sommet(String nom) {
		this.nom=nom;
		this.plusCourtChemin=new ArrayList<>();
		this.sommetsVoisins=new HashMap<>();
	}
     
    
    public String getNom() {
    	return this.nom;
    }
    
    public void ajouterDestination(Sommet destination, int distance) {
        sommetsVoisins.put(destination, distance);
    }
  
   
    public void setDistance(int d) {
    	this.distance=d;
    }
    
    public int getDistance() {
    	return this.distance;
    }
    
    public Map<Sommet, Integer> getSommetsVoisins() {
    	return this.sommetsVoisins;
    }
    
    public ArrayList<Sommet> getPlusCourtChemin() {
    	return this.plusCourtChemin;
    }
    
    public void setPlusCourtChemin(ArrayList<Sommet> liste) {
    	this.plusCourtChemin=liste;
    }
    
    public String toString() {
    	return this.nom+" "+this.distance;
    }
}
