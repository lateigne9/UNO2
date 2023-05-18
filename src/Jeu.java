import cartes.AbstractCarte;

import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Jeu {
    private final static int NOMBRE_DE_CARTE_DEBUT=7;
    private Paquet paquet=new Paquet();
    private Collection<Joueur> listeJoueur=new ArrayList<>();
    private AbstractCarte table;
    private boolean finPartie=false;

    public Jeu() {
        nomjoueur(demandeNombreDeJoueurs());
        distribueCarte();
        table= paquet.donneCarte();
        while (!finPartie){
            for (Joueur joueur :listeJoueur) {
                TourJoueur joueurQuijoue=new TourJoueur(table ,joueur,paquet.getPaquet());
                table= joueurQuijoue.tourJoueur();


                if (joueur.getMain().size()==0){
                    finPartie=true;
                    break;
                }
            }
        }
    }

    /**Demande à l'utilisateur le nombre de joueur
     * @return le nombre de joueur
     */
    private int demandeNombreDeJoueurs(){
        int retour=0;
        boolean valide;
        do {
            Scanner input=new Scanner(System.in);
            System.out.print("Saisir le nombre de joueurs: ");
            try{
                retour= input.nextInt();
                valide=true;
            }catch (InputMismatchException exception){
                System.out.println("Inscrire un nombre de joueurs valide");
                valide=false;
            }
        }while (!valide);
        return retour;
    }

    /** Demande à l'utilisateur le nom de chaque joueur et les ajoute à la listeJoueur
     * @param nombreDeJoueur nombre de joueur qui jouent
     */
    private void nomjoueur(int nombreDeJoueur){
        for (int i = 0; i < nombreDeJoueur; i++) {
            Scanner input=new Scanner(System.in);
            System.out.print("Saisir le nom du joueur "+(i+1)+": ");
            listeJoueur.add(new Joueur(input.nextLine()));
        }
    }
    private void distribueCarte(){
        for (int i = 0; i < NOMBRE_DE_CARTE_DEBUT; i++) {
            for (Joueur joueur : listeJoueur) {
                joueur.getMain().add(paquet.donneCarte());
            }
        }
    }


    private void setFinPartie(Joueur joueur){
        if (joueur.getMain().size()==0){
            finPartie=true;
        }
    }
    public static void main(String[] args) {
        Jeu main=new Jeu();
    }

}
