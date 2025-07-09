package org.example.model;


import org.example.exeption.BilletIndisponibleException;

import java.util.ArrayList;
import java.util.List;

public class Evenement {
    private String nom;
    private String lieu;
    private String date;
    private String heure;
    private int nombrePlace;
    private List<Billet> listeBillet = new ArrayList<>();

    public Evenement(String nom, String lieu, String date, String heure, int nombrePlace) {
        this.nom = nom;
        this.lieu = lieu;
        this.date = date;
        this.heure = heure;
        this.nombrePlace = nombrePlace;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public int getNombrePlace() {
        return nombrePlace;
    }

    public void setNombrePlace(int nombrePlace) {
        this.nombrePlace = nombrePlace;
    }

    public List<Billet> getListeBillet() {
        return listeBillet;
    }

    public void setListeBillet(List<Billet> listeBillet) {
        this.listeBillet = listeBillet;
    }

    public void ajouterBillet(Billet billet){
        if(listeBillet.size()<nombrePlace){
            listeBillet.add(billet);
        }else{
            throw new BilletIndisponibleException("billet indisponible");
        }
    }
    public boolean retirerBillet(Billet billet) {
        if (listeBillet.contains(billet)) {
            listeBillet.remove(billet);
            return true;
        }
        return false;
    }
    public int getNombreBilletDisponible(){
        return nombrePlace-listeBillet.size();
    }
    public int getNombreBilletVendu(){
        return listeBillet.size();
    }
}
