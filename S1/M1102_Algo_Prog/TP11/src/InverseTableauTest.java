import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InverseTableauTest {

	@Test
	final void testCréeTableauInversé() {
		int[] tabLongueurZéro = {};
		int[] attenduTabLongueurZéro = {};
		int[] observéTabLongueurZéro = InverseTableau.créeTableauInversé(tabLongueurZéro);
		assertArrayEquals(attenduTabLongueurZéro, observéTabLongueurZéro);
		assertNotSame(tabLongueurZéro, observéTabLongueurZéro);
		
		int[] tabLongueurUn = {3};
		int[] attenduTabLongueurUn = {3};
		int[] observéTabLongueurUn = InverseTableau.créeTableauInversé(tabLongueurUn);
		assertArrayEquals(attenduTabLongueurUn, observéTabLongueurUn);
		assertNotSame(tabLongueurUn, observéTabLongueurUn);

		int[] tabLongueurPaire = {1,2,3,4,5,6};
		int[] attenduTabLongueurPaire = {6,5,4,3,2,1};
		assertArrayEquals(attenduTabLongueurPaire, InverseTableau.créeTableauInversé(tabLongueurPaire));
		
		int[] tabLongueurImpaire = {1,2,3,4,5};
		int[] attenduTabLongueurImpaire = {5,4,3,2,1};
		assertArrayEquals(attenduTabLongueurImpaire, InverseTableau.créeTableauInversé(tabLongueurImpaire));		
	}
	
	@Test
	final void testInverseTableau() {
		int[] tabLongueurZéro = {};
		int[] attenduTabLongueurZéro = {};
		InverseTableau.inverseTableau(tabLongueurZéro);
		assertArrayEquals(attenduTabLongueurZéro, tabLongueurZéro);
		
		int[] tabLongueurUn = {3};
		int[] attenduTabLongueurUn = {3};
		InverseTableau.inverseTableau(tabLongueurUn);
		assertArrayEquals(attenduTabLongueurUn, tabLongueurUn);

		int[] tabLongueurPaire = {1,2,3,4,5,6};
		int[] attenduTabLongueurPaire = {6,5,4,3,2,1};
		InverseTableau.inverseTableau(tabLongueurPaire);
		assertArrayEquals(attenduTabLongueurPaire, tabLongueurPaire);
		
		int[] tabLongueurImpaire = {1,2,3,4,5};
		int[] attenduTabLongueurImpaire = {5,4,3,2,1};
		InverseTableau.inverseTableau(tabLongueurImpaire);
		assertArrayEquals(attenduTabLongueurImpaire, tabLongueurImpaire);		
	}



}
