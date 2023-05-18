import cartes.AbstractCarte;
import cartes.utilsCarte.TrieurCartesMain;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private String nom;
    private List<AbstractCarte> main=new ArrayList<>();

    public Joueur(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom.toUpperCase();
    }

    /** methode qui affiche correctement la main du joueur
     * @return une chaine de charactère avec les numéros des cartes associé
     */
    public String afficheMain(){
        StringBuilder buffer= new StringBuilder();
        main.sort(new TrieurCartesMain());
        for (int i = 0; i < main.size(); i++) {
            if (i== main.size()-1){
                buffer.append('[').append(i + 1).append(']').append(" ").append(getMain().get(i));
            }else {
                buffer.append('[').append(i + 1).append(']').append(" ").append(getMain().get(i)).append(", ");
            }
        }
        return buffer.toString();
    }

    public List<AbstractCarte> getMain() {
        return main;
    }

    public void setMain(List<AbstractCarte> main) {
        this.main = main;
    }
}
