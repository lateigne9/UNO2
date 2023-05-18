package cartes;

public interface CarteAttaque {
    enum TypeAttaque {
        PLUS_2, INVERSION, INTERDIT_DE_JOUER, PLUS_4, CHANGE_COULEUR
    }

    int attaque();
    boolean estJouable(AbstractCarteAttaque carteAttaque);
}
