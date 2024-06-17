package Nassim;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class servicetest {
    private service service;
    private Voiture v1 = new Voiture("Toyota", 6000);
    private Voiture v2 = new Voiture("Honda", 8000);
    private Voiture v3 = new Voiture("Nissan", 10000);
    private Voiture v4 = new Voiture("Ford", 12000);
    private Voiture v5 = new Voiture("Chevrolet", 5000);
    private Voiture v6 = new Voiture("Volkswagen", 7000);
    private Voiture v7 = new Voiture("Alpine", 1000000);

    @BeforeEach
    void setUp() {
        service = new service();
    }

    @Test
    void testAjouter() {
        service.ajouter(v3);
        service.ajouter(v2);
        service.ajouter(v5);
        assertEquals(3, service.getVoitures().size());
        assertEquals(v3, service.getVoitures().get(0));
    }

    @Test
    void testPrix() {
        service.ajouter(v5);
        service.ajouter(v3);
        assertEquals(15000, service.prix());
    }

    @Test
    void testPrixAvecRemise() {
        service.ajouter(v1);
        service.ajouter(v2);
        service.ajouter(v3);
        service.ajouter(v4);
        service.ajouter(v5); // 5 voitures -> 5% de remise
        assertEquals(38950, service.prix()); //

        service.ajouter(v6);
        service.ajouter(v7); // 7 voitures -> 5% de remise
        assertEquals(1028000, service.prix()); //
    }

    @Test
    void testPrixAvecRemiseMaximale() {
        // Ajout de nombreuses voitures pour atteindre la remise maximale
        for (int i = 0; i < 25; i++) {
            service.ajouter(new Voiture("VieilleVoiture" + i, 1000));
        }
        assertEquals(18750, service.prix()); //
    }

    @Test
    void testPrixSansVoiture() {
        assertThrows(ArithmeticException.class, () -> service.prix());
    }

    @Test
    void testSetVoitures() {
        ArrayList<Voiture> nouvellesVoitures = new ArrayList<>(Arrays.asList(v1, v4, v6));
        service.setVoitures(nouvellesVoitures);
        assertEquals(3, service.getVoitures().size());
        assertEquals(v1, service.getVoitures().get(0));
        assertEquals(v4, service.getVoitures().get(1));
        assertEquals(v6, service.getVoitures().get(2));
    }

    @Test
    void testToString() {
        service.ajouter(v1);
        service.ajouter(v2);
        service.ajouter(v3);
        String expectedString = "service{La liste de voitures=[Voiture{marque='Toyota', prix=6000}, Voiture{marque='Honda', prix=8000}, Voiture{marque='Nissan', prix=10000}]}";
        assertEquals(expectedString, service.toString());
    }
}