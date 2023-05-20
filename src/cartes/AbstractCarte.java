package cartes;

/**
 * Classe mère de toutes les cartes
 */
public abstract class AbstractCarte implements Comparable<AbstractCarte> {
    private Couleur couleur;

    public AbstractCarte(Couleur couleur) {
        this.couleur = couleur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    protected void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    public boolean estJouable(AbstractCarte autrecarte) {
        return autrecarte.couleur == couleur;
    }

    @Override
    public String toString() {
        return couleur.toString();
    }
}
