import java.util.Scanner;

/**
 * Programme qui représente un jeu de roche-papier-ciseau entre
 * deux joueurs humains. Si vous ne connaissez pas le jeu, chaque joueur choisit un des trois
 * objets, et on détermine qui a gagné la manche selon les simples règles suivantes:
 *   • roche gagne contre ciseau
 *   • ciseau gagne contre papier
 *   • papier gagne contre roche
 *
 * @groupe 92
 * @author : Saa Paul, Millimouno
 * @adresse: millimouno,saa-paul@couriel.uqam.ca
 * @code permanent: MILS30019703
 *
 * @author :Jaures-Xavier Bi Tizie,Gouli
 * @adress:Jauresgouli @gmail.com
 */
public class Rpc {

    //Message d'accueil!
    private static String message_Accueil ="-------------------------------------------------------\n" +
            "--------Bienvenue au jeu de roche-papier-ciseau--------\n" +
            "--------------------------------------------------------\n";


    /**
     *Methode principale qui utiliser la classe Pep8.java pour des entrées
     * et sortie des données et valeur
     *
     * @param args
     */
    public static void main(String[] args) {
        int nombreManches = 0;
        int pointsJoueur1 = 0;
        int pointsJoueur2 = 0;
        char vide =' ';
        Pep8.stro(message_Accueil);
        Pep8.stro("Combien de manches voulez-vous jouer ?\n");
        nombreManches =Pep8.deci();
            vide = Pep8.chari();


        int valeurAbritraire = nombreManches;
        if (nombreManches > 0) {
            for (int i = nombreManches; nombreManches > 0; --i) {
                nombreManches -= 2;

            }
            if (nombreManches == 0 || nombreManches == 2) {
                nombreManches = valeurAbritraire + 1;
            } else if (nombreManches <= 1) {
                nombreManches = valeurAbritraire;
            }
        }else {
            Pep8.stro("Fin du Programme");
            Pep8.stop();
        }
            valeurAbritraire  = nombreManches;
        while ( nombreManches > 0 ){

            Pep8.stro("Il reste "+nombreManches +" manche(s) à jouer\n");

            Pep8.stro("JOUEUR 1, quel est votre choix? [r/p/c]\n");
            char  choix1 = Pep8.chari();

            vide= Pep8.chari();

            while (vide != '\n' )vide =Pep8.chari();

            if(choix1!='r' && choix1!='p'&& choix1!='c') Pep8.stop();

            Pep8.stro("JOUEUR 2, quel est votre choix? [r/p/c]\n");

            char choix2 = Pep8.chari();
            vide = Pep8.chari();
            while (vide != '\n' )vide =Pep8.chari();
            if((choix2!='r' && choix2!='p'&& choix2!='c') ){ Pep8.stop(); }
            if((choix1=='r' && choix2 =='c') || (choix2 =='r' && choix1 =='c')){
                if(choix1 == 'r'){
                    ++pointsJoueur1;
                    Pep8.stro("JOUEUR 1 a gagné cette manche! Score:"
                            + pointsJoueur1+'-'+pointsJoueur2+'\n');
                }else if (choix2 == 'r'){
                    ++pointsJoueur2;
                    Pep8.stro("JOUEUR 2 a gagné cette manche! Score:" + pointsJoueur1+'-'+pointsJoueur2+'\n');
                }
            }else  if((choix1=='c' && choix2 =='p') || (choix2=='c' && choix1 =='p')){
                if(choix1 == 'c'){
                    ++pointsJoueur1;
                    Pep8.stro("JOUEUR 1 a gagné cette manche! Score:" + pointsJoueur1+'-'+pointsJoueur2+'\n');
                }else if (choix2 == 'c'){
                    ++pointsJoueur2;
                    Pep8.stro("JOUEUR 2 a gagné cette manche! Score:"
                            + pointsJoueur1+'-'+pointsJoueur2+'\n');
                }
            }else if((choix1=='p' && choix2 =='r') ||(choix2 =='p' && choix1 =='r')){
                if(choix1 == 'p'){
                    ++pointsJoueur1;
                    Pep8.stro("JOUEUR 1 a gagné cette manche! Score:" + pointsJoueur1+'-'+pointsJoueur2+'\n');
                }else if (choix2 == 'p'){
                    ++pointsJoueur2;
                    Pep8.stro("JOUEUR 2 a gagné cette manche! Score:" + pointsJoueur1+'-'+pointsJoueur2+'\n');
                }
            }else if (choix1==choix2){
                Pep8.stro("Manche nulle...\n");
                ++ nombreManches;
            }
            if(((valeurAbritraire - pointsJoueur1) < pointsJoueur1)
                    || ((valeurAbritraire - pointsJoueur2) < pointsJoueur2))
            { nombreManches = 0;
            }else { --nombreManches; }
            Pep8.stro("\n");
        }
        if (pointsJoueur1 > pointsJoueur2){
            Pep8.stro("JOUEUR 1 A GAGNÉ LE MATCH! FÉLICITATIONS!\n");
            Pep8.stro("SCORE FINAL: "+ pointsJoueur1+'-' +pointsJoueur2);
        }
        else if(pointsJoueur1 < pointsJoueur2){
            Pep8.stro("JOUEUR 2 A GAGNÉ LE MATCH! FÉLICITATIONS!\n");
            Pep8.stro("SCORE FINAL: "+ pointsJoueur1+'-'+pointsJoueur2);
        }
        else if (pointsJoueur1 == pointsJoueur2){
            Pep8.stro("!\n");
            Pep8.stro("SCORE FINAL: "+ pointsJoueur1+'-'+pointsJoueur2);
        }
    }


}
