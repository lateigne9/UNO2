import cartes.*;

import java.util.InputMismatchException;
import java.util.Queue;
import java.util.Scanner;

public class TourJoueur {
    private AbstractCarte carteSurTable;
    private Joueur joueur;
    private Queue<AbstractCarte> pioche;

    public TourJoueur(AbstractCarte carteSurTable, Joueur joueur, Queue<AbstractCarte> pioche) {
        this.carteSurTable = carteSurTable;
        this.joueur = joueur;
        this.pioche = pioche;
    }

    public AbstractCarte tourJoueur() {
        boolean peutJouer=true;
        if (carteSurTable instanceof AbstractCarteAttaque && ((AbstractCarteAttaque) carteSurTable).isPouvoir()) {
            int typeAttaque = ((AbstractCarteAttaque) carteSurTable).attaque();
            switch (typeAttaque) {
                case 1 ->
                    /*todo implementer methode d'invertion de jeu*/
                        System.out.println("une inversion a ete joué");
                case 2, 4 -> {
                    attaquePlCarte(typeAttaque);
                    ((AbstractCarteAttaque) carteSurTable).setPouvoir(false);
                    peutJouer = false;
                }
                case 3 -> {
                    peutJouer = false;
                    System.out.println(joueur.getNom()+" s'est fait passé son tour");
                    ((AbstractCarteAttaque) carteSurTable).setPouvoir(false);
                }
            }
        }
        if (peutJouer){
            jouer();
        }
        return carteSurTable;
    }

    private void attaquePlCarte(int nombreCarte) {
        for (int i = 0; i < nombreCarte; i++) {
            if (pioche.size() != 0) {
                joueur.getMain().add(pioche.poll());
            }
        }
    }
    private void changeCouleur(SuperJoker carte){
        switch (templateDiscussionChangeCouleur()){
            case 1->carte.changeCouleur(Couleur.ROUGE);
            case 2-> carte.changeCouleur(Couleur.BLEU);
            case 3->carte.changeCouleur(Couleur.VERT);
            case 4-> carte.changeCouleur(Couleur.JAUNE);
        }
    }


    private void jouer() {
        System.out.println("Au tour de " + joueur.getNom() + " de jouer !\n");
        boolean finTour = false;
        int positionDeLaCarte;
        do {
            afficheTour();
            positionDeLaCarte = demandeCarteJoueur();
            if (positionDeLaCarte == 0) {
                pioche();
                finTour = true;
            } else if (verifieCarteEstJouable(positionDeLaCarte)) {
                joueCarte(positionDeLaCarte);
                if (carteSurTable instanceof SuperJoker){
                    changeCouleur((SuperJoker)carteSurTable);
                }
                finTour = true;
            }
        } while (!finTour);
        System.out.println("\nfin du tour de " + joueur.getNom()+'\n');

    }

    private void afficheTour() {
        System.out.println(carteSurTable.toString() + "\n\n" + joueur.afficheMain());
    }

    private int demandeCarteJoueur() {
        int retour;
        do {
            System.out.print("Quelle carte veux tu jouer ? (0=pioche) ");
            Scanner input = new Scanner(System.in);
            try {
                retour = input.nextInt();
            } catch (InputMismatchException e) {
                retour = -1;
                System.out.println("Merci de bien vouloir jouer un chiffre valide");
            }
        } while (retour < 0 || (retour > joueur.getMain().size()));
        return retour;
    }

    private void pioche() {
        joueur.getMain().add(pioche.remove());
    }

    /**
     * Verifie si la carte a la position donnee est jouable
     *
     * @param positionCarte position+1 de la carte a verifier
     * @return vrai si la carte est jouable
     */
    private boolean verifieCarteEstJouable(int positionCarte) {
        boolean retour;
        if (joueur.getMain().get(positionCarte - 1).estJouable(carteSurTable)) {
            retour = true;
        } else {
            System.out.println("Cette carte n'est pas jouable");
            retour = false;
        }
        return retour;
    }

    /**
     * Remplace la carte de la table par celle de la main du joueur et enleve celle
     * de la main du joueur
     *
     * @param position position de la carte
     */
    private void joueCarte(int position) {
        carteSurTable = joueur.getMain().remove(position - 1);
    }
    private int templateDiscussionChangeCouleur(){
        Scanner input= new Scanner(System.in);
        int retour;
        do {
            System.out.println("""
                    ====== Choix de couleur ======
                    Rouge = 1
                    Bleu = 2
                    Vert = 3
                    Jaune = 4
                    
                    Saisir le chiffre correspondant :
                    """);
            try{
                retour= input.nextInt();
            }catch (InputMismatchException e){
                retour=0;
            }
        }while (retour<1||retour>4);

        return retour;
    }

}
