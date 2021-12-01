/**
 * Cette classe implémente les ABR dont le contenu est un entier. Elle ne contient que des constructeurs, les méthodes
 * générales sur les ABR étant codées dans la clase ABR
 */
public class ABRInt extends ABR<Integer> {

	public ABRInt(ABRInt g, Integer c, ABRInt d) {
		super(g, c, d);
	}

	public ABRInt() {
		super();
	}

	public ABRInt(Integer c) {
		super(c);
	}

	public static void main(String[] args) {
		ABRInt ABRQcq = new ABRInt(new ABRInt(new ABRInt(), 6, new ABRInt(11)), 15,
			new ABRInt(new ABRInt(16), 18, new ABRInt(
				new ABRInt(new ABRInt(19), 19, new ABRInt()), 20, new ABRInt())));

		ABRQcq.parcoursInfixe();
	}
}
