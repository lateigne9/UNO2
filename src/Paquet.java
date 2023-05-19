import cartes.*;
import java.util.*;

public class Paquet {
    private final static int NOMBRE_DE_CARTES=108;
    private final Queue<AbstractCarte> paquet=new PriorityQueue<>(NOMBRE_DE_CARTES);

    public Paquet() {
        List<AbstractCarte> temp=new ArrayList<>(NOMBRE_DE_CARTES);
        for (int numero = 1; numero < 10; numero++) {
            for (int nombre = 0; nombre < 2; nombre++) {
                for (int couleur = 0; couleur < 4; couleur++) {
                    AbstractCarte carte=new Normale(numero,donneCouleur(couleur));
                    temp.add(carte);
                }
            }
        }
        for (int typeDAttaque = 0; typeDAttaque < 3; typeDAttaque++) {
            for (int nombre = 0; nombre < 2; nombre++) {
                for (int couleur = 0; couleur < 4; couleur++) {
                    AbstractCarteAttaque carte=new Attaque(donneAttaque(typeDAttaque),donneCouleur(couleur),true);
                    temp.add(carte);
                }
            }
        }
        for (int superJoker = 0; superJoker < 2; superJoker++) {
            for (int nombre = 0; nombre < 4; nombre++) {
                AbstractCarteAttaque carte=new SuperJoker(donneSuperAttaque(superJoker),true);
                temp.add(carte);
            }
        }
        Collections.shuffle(temp);
        paquet.addAll(temp);
    }

    public Queue<AbstractCarte> getPaquet() {
        return paquet;
    }

    private Couleur donneCouleur(int numero){
        return switch (numero % 4) {
            case 1 -> Couleur.BLEU;
            case 2 -> Couleur.VERT;
            case 3 -> Couleur.JAUNE;
            default -> Couleur.ROUGE;
        };
    }

    private TypeAttaque donneAttaque(int numero){
        return switch (numero%3){
            case 1-> TypeAttaque.PLUS_2;
            case 2-> TypeAttaque.INVERSION;
            default -> TypeAttaque.INTERDIT_DE_JOUER;
        };
    }

    private TypeAttaque donneSuperAttaque(int numero){
        return switch (numero%2){
          case 1-> TypeAttaque.PLUS_4;
          default -> TypeAttaque.CHANGE_COULEUR;
        };
    }


    /**
     * @return la premiere carte du paquet
     */
    public AbstractCarte donneCarte(){
        if (paquet.size()==0){
            new Paquet();
        }
        return paquet.remove();
    }

    @Override
    public String toString() {
        return "paquet=" + paquet;
    }
}
