package org.example.ihm;

import org.example.classes.Billet;
import org.example.classes.Evenement;
import org.example.classes.BilletIndisponibleException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ihm {
    private List<Evenement> evenements = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println(menu());
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> creerEvenement();
                case "2" -> ajouterBillet();
                case "3" -> supprimerBillet();
                case "4" -> afficherBillets();
                case "5" -> afficherInfosEvenement();
                case "6" -> {
                    System.out.println("Fin du programme.");
                    return;
                }
                default -> System.out.println("Choix invalide.");
            }
        }
    }

    private String menu() {
        return """
                === MENU PRINCIPAL ===
                1. Créer un événement
                2. Ajouter un billet
                3. Supprimer un billet
                4. Afficher tous les billets
                5. Afficher les infos de l’événement
                6. Quitter
                Entrez votre choix :
                """;
    }

    private void creerEvenement() {
        System.out.print("Nom de l'événement : ");
        String nom = scanner.nextLine();

        System.out.print("Lieu : ");
        String lieu = scanner.nextLine();

        System.out.print("Date (AAAA-MM-JJ) : ");
        String date = scanner.nextLine();

        System.out.print("Heure : ");
        String heure = scanner.nextLine();

        System.out.print("Nombre de places : ");
        int nbPlaces = Integer.parseInt(scanner.nextLine());

        Evenement evenement = new Evenement(nom, lieu, date, heure, nbPlaces);
        evenements.add(evenement);

        System.out.println("Événement créé avec succès !");
    }

    private Evenement choisirEvenement() {
        if (evenements.isEmpty()) {
            System.out.println("Aucun événement disponible.");
            return null;
        }

        System.out.println("Choisissez un événement :");
        for (int i = 0; i < evenements.size(); i++) {
            Evenement e = evenements.get(i);
            System.out.printf("%d. %s (%s)%n", i + 1, e.getNom(), e.getDate());
        }

        System.out.print("Numéro de l’événement : ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < evenements.size()) {
                return evenements.get(index);
            } else {
                System.out.println("Numéro invalide.");
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrée invalide.");
            return null;
        }
    }

    private void ajouterBillet() {
        Evenement evenement = choisirEvenement();
        if (evenement == null) return;

        try {

            System.out.print("Nom du client : ");
            String client = scanner.nextLine();

            System.out.print("Type de billet (STANDARD, GOLD, VIP) : ");
            String typeStr = scanner.nextLine().toUpperCase();
            Billet.TypeBillet type = Billet.TypeBillet.valueOf(typeStr);

            Billet billet = new Billet(client, evenement, type);
            evenement.ajouterBillet(billet);
            System.out.println("Billet ajouté !");
        } catch (IllegalArgumentException e) {
            System.out.println("Type de billet invalide.");
        } catch (BilletIndisponibleException e) {
            System.out.println(e.getMessage());
        }
    }

    private void supprimerBillet() {
        Evenement evenement = choisirEvenement();
        if (evenement == null) return;

        System.out.print("Numéro du billet à supprimer : ");
        String numero = scanner.nextLine();

        Billet billetASupprimer = null;
        for (Billet billet : evenement.getListeBillet()) {
            if (billet.getNumero().equals(numero)) {
                billetASupprimer = billet;
                break;
            }
        }

        if (billetASupprimer != null) {
            evenement.retirerBillet(billetASupprimer);
            System.out.println("Billet supprimé.");
        } else {
            System.out.println("Billet non trouvé.");
        }
    }

    private void afficherBillets() {
        Evenement evenement = choisirEvenement();
        if (evenement == null) return;

        if (evenement.getListeBillet().isEmpty()) {
            System.out.println("Aucun billet enregistré.");
        } else {
            System.out.println("Liste des billets :");
            for (Billet billet : evenement.getListeBillet()) {
                System.out.println("- " + billet.getNumero() + " | " + billet.getClient() + " | " + billet.getTypeBillet());
            }
        }
    }

    private void afficherInfosEvenement() {
        Evenement evenement = choisirEvenement();
        if (evenement == null) return;

        System.out.printf(
                """
                        === INFOS ÉVÉNEMENT ===
                        Nom : %s
                        Lieu : %s
                        Date : %s
                        Heure : %s
                        Nombre de places : %d
                        Billets vendus : %d
                        Billets disponibles : %d
                        %n""", evenement.getNom(),
        evenement.getLieu(),
        evenement.getDate(),
        evenement.getHeure(),
        evenement.getNombrePlace(),
        evenement.getNombreBilletVendu(),
        evenement.getNombreBilletDisponible()
);
    }
}
