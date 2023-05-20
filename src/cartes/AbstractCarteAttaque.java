package cartes;

public abstract class AbstractCarteAttaque extends AbstractCarte {

    private boolean pouvoir;
    private TypeAttaque attaque;

    public AbstractCarteAttaque(TypeAttaque attaque, Couleur couleur, boolean pouvoir) {
        super(couleur);
        this.attaque = attaque;
        this.pouvoir = pouvoir;
    }

    public TypeAttaque getAttaque() {
        return attaque;
    }

    public void setPouvoir(boolean pouvoir) {
        this.pouvoir = pouvoir;
    }

    public boolean isPouvoir() {
        return pouvoir;
    }

    /**
     * Donne le numero à l'attaque correspondante et passe le pouvoir de l'attaque sur false
     *
     * @return le numero de l'attaque
     */
    public int attaque() {
        pouvoir = false;
        return switch (attaque) {
            case INVERSION -> 1;
            case PLUS_2 -> 2;
            case INTERDIT_DE_JOUER -> 3;
            case PLUS_4 -> 4;
            case CHANGE_COULEUR -> 5;
        };

    }

    public boolean estJouable(AbstractCarteAttaque autreCarte) {
        return super.estJouable(autreCarte) || autreCarte.getAttaque() == attaque;
    }

    @Override
    public String toString() {
        if (getCouleur() == Couleur.NOIR) {
            switch (attaque) {
                case PLUS_4 -> {
                    return "+ 4";
                }
                case CHANGE_COULEUR -> {
                    return "Change couleur";
                }
                case PLUS_2 -> {
                    return "+ 2";
                }
                case INVERSION -> {
                    return "Changement de sens";
                }
                case INTERDIT_DE_JOUER -> {
                    return "Interdit de jouer";
                }
            }
            return attaque.name();
        } else {
            return attaque.name() + " " + super.toString();
        }
    }
}
