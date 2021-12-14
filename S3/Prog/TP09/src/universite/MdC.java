package universite;

public class MdC extends Titulaire{

	public MdC(String nom) {
		super(nom, 192);
	}

	public String toString() {
		return "[MdC] " + super.toString();
	}
}
