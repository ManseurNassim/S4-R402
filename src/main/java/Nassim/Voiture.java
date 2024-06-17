package Nassim;

public class Voiture {
    private String marque;
    private int prix; // Changement de Double à int

    public Voiture(String m, int p){
        this.marque = m;
        this.prix = p;
    }

    public String getMarque(){
        return this.marque;
    }
    public int getPrix(){
        return this.prix;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    @Override
    public String toString() {
        return "Voiture{marque='" + marque + "', prix=" + prix + "}";
    }
}
