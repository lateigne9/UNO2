package cartes;

/**
 * carte de type super joker
 */
public class SuperJoker extends AbstractCarteAttaque implements Comparable<AbstractCarte>{

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
    public int compareTo(AbstractCarte carte) {
        return 0;
    }
}
