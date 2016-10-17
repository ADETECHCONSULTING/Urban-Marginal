/**
 * 
 */
package modele;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author JEAN
 *
 */
public class MurTest {
	private Mur mur1 = new Mur();
	private Mur mur2 = new Mur();
	/**
	 * Test method for {@link modele.Objet#toucheObjet(modele.Objet)}.
	 */
	@Test
	public void testToucheObjet() {
		mur1.posX = 10;
		mur1.posY = 10;
		mur2.posX = 54;
		mur2.posY = 79;
		assertTrue(mur1.toucheObjet(mur2));
		fail("Not yet implemented");
	}

}
