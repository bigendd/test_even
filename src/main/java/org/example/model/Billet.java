package org.example.model;

public class Billet {
    private String numero;
    private String client;
    private Evenement evenement;
    private TypeBillet type;

    public enum TypeBillet {
        STANDARD,
        GOLD,
        VIP
    }

    public Billet( String client, Evenement evenement, TypeBillet type) {
        this.numero = genererNumeroAuto();
        this.client = client;
        this.evenement = evenement;
        this.type = type;
    }
    private String genererNumeroAuto(){
        return "BILLET-" + System.currentTimeMillis();
    }
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public TypeBillet getTypeBillet() {
        return type;
    }

    public void setTypeBillet(TypeBillet type) {
        this.type = type;
    }
}
