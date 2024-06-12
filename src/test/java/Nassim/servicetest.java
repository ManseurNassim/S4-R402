package Nassim;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class servicetest {
    private service service;
    private Voiture v1 = new Voiture("Toyota", 6000);
    private Voiture v2 = new Voiture("Honda", 8000);
    private Voiture v3 = new Voiture("Nissan", 10000);
    private Voiture v4 = new Voiture("Ford", 12000);
    private Voiture v5 = new Voiture("Chevrolet", 5000);
    private Voiture v6 = new Voiture("Volkswagen", 7000);
    private Voiture v7 = new Voiture("Alpine", 1000000);

    @Test
    void testAjouter() {
        service = new service();
        service.ajouter(v3);
        service.ajouter(v2);
        service.ajouter(v5);
        assertEquals(3, service.getVoitures().size());
        assertEquals(v3, service.getVoitures().get(0));
    }

    @Test
    void testPrix() {
        service = new service();
        service.ajouter(v5);
        service.ajouter(v3);
        assertEquals(15000, service.prix());
    }

    @Test
    void testPrixAvecRemise() {
        service = new service();
        service.ajouter(v1);
        service.ajouter(v2);
        service.ajouter(v3);
        service.ajouter(v4);
        service.ajouter(v5); // 5 voitures -> 5% de remise
        assertEquals(41000 - (0.05 * 41000), service.prix());
        service.ajouter(v6);
        service.ajouter(v7);// 7 voitures -> toujours 5% de remise
        assertEquals(1048000 - (0.05 * 1048000), service.prix());
    }

    @Test
    void testPrixAvecRemiseMaximale() {
        service = new service();
        // Ajout de nombreuses voitures pour atteindre la remise maximale
        for (int i = 0; i < 25; i++) {
            service.ajouter(new Voiture("VieilleVoiture" + i, 1000));
        }
        assertEquals((25000 - 2000), service.prix());
    }

    @Test
    void testPrixSansVoiture() {
        service = new service();
        assertThrows(ArithmeticException.class, () -> service.prix());
    }
}
