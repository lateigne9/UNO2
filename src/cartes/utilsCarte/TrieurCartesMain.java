package cartes.utilsCarte;

import cartes.AbstractCarte;
import cartes.AbstractCarteAttaque;
import cartes.Normale;

import java.util.Comparator;

public class TrieurCartesMain implements Comparator<AbstractCarte> {
    @Override
    public int compare(AbstractCarte carte1, AbstractCarte carte2) {
        /*1= trier par couleur (rouge, bleu,vert, jaune)
        * 2= trier par numero*/
        int retour=carte1.getCouleur().ordinal()-carte2.getCouleur().ordinal();
        if (retour==0 && (carte1 instanceof Normale) && (carte1.getClass().isInstance(carte2))){
            retour=((Normale) carte1).getNumero()-((Normale)carte2).getNumero();
        } else if (retour==0 && (!carte1.getClass().isInstance(carte2.getClass()))) {
            if (carte1 instanceof Normale && carte2 instanceof AbstractCarteAttaque){
                retour=-1;
            }else {
                retour=1;
            }
        } else if (retour==0 && (carte1 instanceof AbstractCarteAttaque)&& (carte1.getClass().isInstance(carte2))){
            retour=((AbstractCarteAttaque)carte1).getAttaque().ordinal()-((AbstractCarteAttaque)carte2).getAttaque().ordinal();
        }
        return retour;
    }
}
