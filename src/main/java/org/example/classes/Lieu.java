package org.example.classes;

public class Lieu extends Adresse{
    private final String capacite;

    public Lieu(String rue, String ville, String capacite) {
        super(rue, ville);
        this.capacite = capacite;
    }
    public String getCapacite() {
        return capacite;
    }
    public String setRue(){
        return super.getRue();
    }
    public String setVille(){
        return super.getVille();
    }
}
