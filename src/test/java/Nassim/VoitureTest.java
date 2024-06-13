package Nassim;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VoitureTest {
    @Test
    public void testVoiture() {
        Voiture v = new Voiture("Audi", 50000.5);
        assertEquals("Audi", v.getMarque());
        assertEquals(50000.5, v.getPrix());
        Voiture v2 = new Voiture("Ferrari", 500000.5);
        v2.setMarque("Ferrari");
        assertEquals("Ferrari", v2.getMarque());
        Voiture v3 = new Voiture("Audi", 50000.5);
        v3.setPrix(5600.5);
        assertEquals(5600.5, v3.getPrix());
    }
}
