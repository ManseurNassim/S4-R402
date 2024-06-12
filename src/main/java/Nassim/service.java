package Nassim;

import Nassim.Voiture;
import java.util.ArrayList;
import java.util.List;

public class service implements Statistique {
    private List<Voiture> listeVoiture;

    public service() {
        this.listeVoiture = new ArrayList<>();
    }

    @Override
    public void ajouter(Voiture     voiture) {
        this.listeVoiture.add(voiture);
    }

    @Override
    public int prix() throws ArithmeticException {
        if (listeVoiture.isEmpty()) {
            throw new ArithmeticException("La liste de voitures est vide");
        }

        int sommePrix = 0;
        for (Voiture voiture : listeVoiture) {
            sommePrix += voiture.getPrix();
        }

        int nombreVoitures = listeVoiture.size();
        int nombreRemises = nombreVoitures / 5;
        double remise = Math.min(nombreRemises * 0.05 * sommePrix, 20000.0);
        int prixFinal = (int) (sommePrix - remise);

        return prixFinal;
    }

    public List<Voiture> getListeVoiture() {
        return listeVoiture;
    }

    public void setListeVoiture(List<Voiture> listeVoiture) {
        this.listeVoiture = listeVoiture;
    }

    @Override
    public String toString() {
        return "service{" +
                "listeVoiture=" + listeVoiture +
                '}';
    }
}
