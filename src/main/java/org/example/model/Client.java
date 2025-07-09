package org.example.model;

import java.util.List;

public class Client {
    private String nom;
    private String prenom;
    private String adresse;
    private String numeroTelephone;
    private int age;
    private List<Billet> listeBillet;

    public Client(String nom, String prenom, String adresse, String numeroTelephone, int age, List<Billet> listeBillet) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numeroTelephone = numeroTelephone;
        this.age = age;
        this.listeBillet = listeBillet;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Billet> getListeBillet() {
        return listeBillet;
    }

    public void setListeBillet(List<Billet> listeBillet) {
        this.listeBillet = listeBillet;
    }
}
