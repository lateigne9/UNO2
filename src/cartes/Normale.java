package cartes;

/**
 * Carte normale avec un chiffre
 */
public class Normale extends AbstractCarte implements Comparable<AbstractCarte>{
    private int numero;

    public Normale(int numero, Couleur couleur) {
        super(couleur);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public boolean estjouable(AbstractCarte autrecarte) {
        boolean retour=false;
        if (super.estjouable(autrecarte)||((Normale) autrecarte).getNumero()==numero){
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
    public int compareTo(AbstractCarte carte) {
        return 0;
    }
}
