package org.example.classes;

public class Adresse {
    private final String rue;
    private final String ville;



    public Adresse(String rue, String ville) {
        this.rue = rue;
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }


}
