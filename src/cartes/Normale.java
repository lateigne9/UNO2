package cartes;

/**
 * Carte normale avec un chiffre
 */
public class Normale extends AbstractCarte{
    private int numero;

    public Normale(int numero, Couleur couleur) {
        super(couleur);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public boolean estJouable(AbstractCarte autrecarte) {
        boolean retour=false;
        if (super.estJouable(autrecarte)||((Normale) autrecarte).getNumero()==numero){
            retour=true;
        }
        return retour;
    }

    @Override
    public String toString() {
        return numero+" "+getCouleur();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Normale normale = (Normale) o;
        return numero == normale.numero;
    }

    @Override
    public int compareTo(AbstractCarte o) {
        return 0;
    }
}
