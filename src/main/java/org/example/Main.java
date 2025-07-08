package org.example;


import org.example.classes.Billet;
import org.example.classes.Evenement;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Evenement concert = new Evenement("Test", "Paris", "2028-08-08", "20:00", 100, new ArrayList<>());

        Billet billet1 = new Billet("001", "Amar", concert, Billet.TypeBillet.VIP);

        concert.ajouterBillet(billet1);

        System.out.println("Client : " + billet1.getClient());

        System.out.println("Événement : " + billet1.getEvenement().getNom());
        System.out.println("Type de billet : " + billet1.getTypeBillet());

        System.out.println("Nombre de billet disponible : " + concert.getNombreBilletDisponible());
        System.out.println("Nombre de billet vendu : " + concert.getListeBillet().size());

        if(concert.retirerBillet(billet1)){
            System.out.println("le billet a ete bien annuller");
        }else {
            System.out.println("le billet n'a pas ete bien annuller");
        }
        System.out.println("Nombre de billet disponible : " + concert.getNombreBilletDisponible());

    }
    }
