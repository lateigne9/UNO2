package cartes;

/**
 * Carte de type attaque
 */
public class Attaque extends AbstractCarteAttaque{

    public Attaque(TypeAttaque attaque, Couleur couleur, boolean pouvoir) {
        super(attaque,couleur,pouvoir);
    }

    @Override
    public int compareTo(AbstractCarte o) {
        return 0;
    }
}
