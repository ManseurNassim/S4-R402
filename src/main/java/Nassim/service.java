package Nassim;

import Nassim.Voiture;
import java.util.ArrayList;

public class service implements Statistique {
    private ArrayList<Voiture> Voitures;

    public service() {
        this.Voitures = new ArrayList<>();
    }

    @Override
    public void ajouter(Voiture voiture) {
        this.Voitures.add(voiture);
    }

    @Override
    public int prix() throws ArithmeticException {
        if (Voitures.isEmpty()) {
            throw new ArithmeticException("Aucune voiture est dans la liste");
        }

        int sommePrix = 0;
        for (Voiture voiture : Voitures) {
            sommePrix += voiture.getPrix();
        }

        int nombreVoitures = Voitures.size();
        int nombreRemises = nombreVoitures / 5;
        double remise = Math.min(nombreRemises * 0.05 * sommePrix, 20000.0);

        return (int) (sommePrix - remise);
    }

    public ArrayList<Voiture> getVoitures() {
        return Voitures;
    }

    public void setVoitures(ArrayList<Voiture> Voitures) {
        this.Voitures = Voitures;
    }

    @Override
    public String toString() {
        return "service{La liste de voitures=" + Voitures.toString() + "}";
    }
}
