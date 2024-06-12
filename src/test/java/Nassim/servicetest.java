package Nassim;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class servicetest {
    private service service;
    private Voiture v1;
    private Voiture v2;
    private Voiture v3;
    private Voiture v4;
    private Voiture v5;
    private Voiture v6;

    @BeforeEach
    void setUp() {
        service = new service();
        v1 = new Voiture("Toyota", 6000);
        v2 = new Voiture("Honda", 8000);
        v3 = new Voiture("Nissan", 10000);
        v4 = new Voiture("Ford", 12000);
        v5 = new Voiture("Chevrolet", 5000);
        v6 = new Voiture("Volkswagen", 7000);
    }

    @Test
    void testAjouter() {
        service.ajouter(v1);
        assertEquals(1, service.getListeVoiture().size());
        assertEquals(v1, service.getListeVoiture().get(0));
    }

    @Test
    void testPrix() {
        service.ajouter(v1);
        service.ajouter(v2);
        assertEquals(14000, service.prix());
    }

    @Test
    void testPrixAvecRemise() {
        service.ajouter(v1);
        service.ajouter(v2);
        service.ajouter(v3);
        service.ajouter(v4);
        service.ajouter(v5); // 5 voitures -> 5% de remise
        assertEquals(41000 - (0.05 * 41000), service.prix());
        service.ajouter(v6); // 6 voitures -> toujours 5% de remise
        assertEquals(48000 - (0.05 * 48000), service.prix());
    }

    @Test
    void testPrixAvecRemiseMaximale() {
        // Ajout de nombreuses voitures pour atteindre la remise maximale
        for (int i = 0; i < 25; i++) {
            service.ajouter(new Voiture("Voiture" + i, 10000));
        }
        assertEquals((250000 - 20000), service.prix());
    }

    @Test
    void testPrixSansVoiture() {
        assertThrows(ArithmeticException.class, () -> service.prix());
    }
}
