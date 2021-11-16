package lambdasBasic;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Gens {

    private String nom;
    private int age;

    public Gens(String nom, int num) {
        this.age = num;
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + age;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Gens other = (Gens) obj;
        if (nom == null) {
            if (other.nom != null) return false;
        } else if (!nom.equals(other.nom)) return false;
        if (age != other.age) return false;
        return true;
    }

    @Override
    public String toString() {
        return "Gens [nom=" + nom + ", age=" + age + "]";
    }

}
