import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Graphe {

    private Set<Sommet> sommets;


    public Graphe() {
        this.sommets=new HashSet<>();
    }

    public void ajouterSommet(Sommet sommetA) {
        sommets.add(sommetA);
    }

    public static Graphe plusCourtCheminDeLaSource(Graphe graph, Sommet source) {
        source.setDistance(0);

        Set<Sommet> sommetsVisites = new HashSet<>();
        Set<Sommet> sommetsNonVisites = new HashSet<>();

        sommetsNonVisites.add(source);

        while (sommetsNonVisites.size() != 0) {
            Sommet sommetCourant = getSommetLePlusProche(sommetsNonVisites);
            sommetsNonVisites.remove(sommetCourant);
            for (Map.Entry<Sommet,Integer> voisin: sommetCourant.getSommetsVoisins().entrySet()){
                Sommet voisinCle = voisin.getKey();
                Integer aretePoids = voisin.getValue();
                if (!sommetsVisites.contains(voisinCle)) {
                    CalculeMinimumDistance(voisinCle, aretePoids, sommetCourant);
                    sommetsNonVisites.add(voisinCle);
                }
            }
            sommetsVisites.add(sommetCourant);
        }
        return graph;
    }

    private static Sommet getSommetLePlusProche(Set < Sommet > sommetsNonVisites) {
        Sommet sommetLePlusProche = null;
        int plusPetiteDistance = Integer.MAX_VALUE;
        for (Sommet node: sommetsNonVisites) {
            int nodeDistance = node.getDistance();
            if (nodeDistance < plusPetiteDistance) {
                plusPetiteDistance = nodeDistance;
                sommetLePlusProche = node;
            }
        }
        return sommetLePlusProche;
    }

    public Set<Sommet> sommetsDuGraphe(){
        return this.sommets;
    }



    private static void CalculeMinimumDistance(Sommet sommetEvalue,
                                               Integer poidsArete, Sommet sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if (sourceDistance + poidsArete < sommetEvalue.getDistance()) {
            sommetEvalue.setDistance(sourceDistance + poidsArete);
            ArrayList<Sommet> cheminLePlusCourt = new ArrayList<>(sourceNode.getPlusCourtChemin());
            cheminLePlusCourt.add(sourceNode);
            sommetEvalue.setPlusCourtChemin(cheminLePlusCourt);
        }
    }

    public String toString() {
        Iterator<Sommet> it = this.sommets.iterator();
        String affichage="";
        while (it.hasNext()) {
            affichage=affichage+(it.next().toString()+"\n");
        }
        return affichage;
    }

}
