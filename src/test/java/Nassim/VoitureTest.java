package Nassim;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoitureTest {
    @Test
    public void testVoiture() {
        Voiture v = new Voiture("Audi", 50000);
        assertEquals("Audi", v.getMarque());
        assertEquals(50000, v.getPrix());
        Voiture v2 = new Voiture("Ferrari", 500000);
        v2.setMarque("Ferrari");
        assertEquals("Ferrari", v2.getMarque());
        Voiture v3 = new Voiture("Audi", 50000);
        v3.setPrix(5600);
        assertEquals(5600, v3.getPrix());
    }
}