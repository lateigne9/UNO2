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
        premierAffichage();
        if (carteSurTable instanceof AbstractCarteAttaque) {/*si c'est une carte attaque*/
            if (((AbstractCarteAttaque) carteSurTable).isPouvoir()){/*si elle a son pouvoir*/
                ;
            }
        }
//        if (carteSurTable.isPouvoir()){
//            carteSurTable.attaque();
//            switch (carteSurTable.attaque()){
//                /*default 0 Change couleur
//                * 1 PLUS_4
//                * 2 PLUS_2
//                * 3 INTERDIT_DE_JOUEUR
//                * 4 CHANGEMENT DE SENS*/
//                //todo implementer les attaques
////                case 1->
////                case 2->
////                case 3->
////                case 4->
////                default->
//            }
//        }
        return carteSurTable;
    }

    private void premierAffichage(){
        System.out.println("Au tour de "+joueur.getNom()+ " de jouer !\n");
        boolean finTour=false;
        int positionDeLaCarte;
        do {
            afficheTour();
            positionDeLaCarte=demandeCarteJoueur();
            if (positionDeLaCarte==0){
                pioche();
                finTour=true;
            } else if (verifieCarteEstJouable(positionDeLaCarte)) {
                joueCarte(positionDeLaCarte);
                finTour=true;
            }
        }while (!finTour);
        System.out.println("fin du tour de "+joueur.getNom());

    }

    private void afficheTour() {
        System.out.println(carteSurTable.toString()+"\n"+joueur.afficheMain());
    }

    private int demandeCarteJoueur() {
        int retour=-1;
        do {
            System.out.print("Quelle carte veux tu jouer ? (0=pioche) ");
            Scanner input=new Scanner(System.in);
            try{
                retour= input.nextInt();
            }catch (InputMismatchException e){
                retour=-1;
                System.out.println("Merci de bien vouloir jouer un chiffre valide");
            }
        }while (retour<0|| (retour>joueur.getMain().size()));
        return retour;
    }

    private void pioche() {
        joueur.getMain().add(pioche.remove());
    }

    /**Verifie si la carte a la position donnee est jouable
     * @param positionCarte position+1 de la carte a verifier
     * @return vrai si la carte est jouable
     */
    private boolean verifieCarteEstJouable(int positionCarte){
        boolean retour;
        if (joueur.getMain().get(positionCarte-1).estjouable(carteSurTable)){
            retour= true;
        }else {
            System.out.println("Cette carte n'est pas jouable");
            retour= false;
        }
        return retour;
    }

    /**Remplace la carte de la table par celle de la main du joueur et enleve celle
     * de la main du joueur
     * @param position position de la carte
     */
    private void joueCarte(int position){
        carteSurTable=joueur.getMain().remove(position-1);
    }

}
