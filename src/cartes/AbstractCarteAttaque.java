package cartes;

public abstract class AbstractCarteAttaque extends AbstractCarte implements CarteAttaque{
    private boolean pouvoir;
    private TypeAttaque attaque;

    public AbstractCarteAttaque(TypeAttaque attaque,Couleur  couleur, boolean pouvoir) {
        super(couleur);
        this.attaque=attaque;
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

    @Override
    public int attaque() {
            return switch (attaque){
                case INVERSION -> 1;
                case PLUS_2 -> 2;
                case INTERDIT_DE_JOUER -> 3;
                case PLUS_4 -> 4;
                case CHANGE_COULEUR -> 5;
            };
    }
    @Override
    public boolean estjouable(AbstractCarte autrecarte) {
            return super.estjouable(autrecarte);
    }
    @Override
    public boolean estJouable(AbstractCarteAttaque autreCarte){
        return super.estjouable(autreCarte)||autreCarte.getAttaque()==attaque;
    }

    @Override
    public String toString() {
        if (getCouleur()==Couleur.NOIR){
            return attaque.name();
        }else {
            return attaque.name()+" "+super.toString();
        }
    }
}
