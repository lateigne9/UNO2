package cartes;

/**
 * carte de type super joker
 */
public class SuperJoker extends AbstractCarteAttaque {

    public SuperJoker(TypeAttaque attaque, boolean pouvoir) {
        super(attaque,Couleur.NOIR, pouvoir);
    }

    /**Change la couleur du superJoker pour correspondre a une des 4 couleurs
     * @param couleur Couleur dont la carte deviendra
     */
    public void changeCouleur(Couleur couleur) {
        setCouleur(couleur);
    }

    @Override
    public boolean estJouable(AbstractCarteAttaque autreCarte){
        /*parce que toute les carte super joker sont jouables en tout temps*/
        return true;
    }

    @Override
    public int compareTo(AbstractCarte o) {
        return 0;
    }
}
