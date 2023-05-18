package cartes;

/**
 * Carte de type attaque
 */
public class Attaque extends AbstractCarteAttaque implements Comparable<AbstractCarte>{

    public Attaque(TypeAttaque attaque, Couleur couleur, boolean pouvoir) {
        super(attaque,couleur,pouvoir);
    }

    @Override
    public int compareTo(AbstractCarte carte) {
        return 0;
    }
}
