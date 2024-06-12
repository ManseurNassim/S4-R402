package Nassim;

public class Voiture {
    private String marque;
    private double prix;

    public Voiture(String m, double p){
        this.marque=m;
        this.prix=p;
    }

    public String getMarque(){
        return this.marque;
    }
    public double getPrix(){
        return this.prix;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}