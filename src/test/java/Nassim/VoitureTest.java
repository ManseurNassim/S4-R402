package Nassim;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class VoitureTest {
    @Test
    public void testVoiture() {
        Voiture v = new Voiture("Audi", 50000.5);
        assertEquals("Audi", v.getMarque());
        assertEquals(50000.5, v.getPrix());
    }
    @Test
    public void testMarque() {
        Voiture v = new Voiture("Ferrari", 500000.5);
        v.setMarque("Ferrari");
        assertEquals("Ferrari", v.getMarque());
    }
    @Test
    public void testPrix() {
        Voiture v = new Voiture("Audi", 50000.5);
        v.setPrix(5600.5);
        assertEquals(5600.5, v.getPrix());}
}