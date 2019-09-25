import java.util.Scanner;

public class rpc {


    private static String message_Accueil ="-------------------------------------------------------\n" +
            "--------Bienvenue au jeu de roche-papier-ciseau--------\n" +
            "--------------------------------------------------------\n";

    private static Scanner clavier = new Scanner(System.in);

    public static void main(String[] args) {
        int nombreManches = 0;
        int pointsJoueur1 = 0;
        int pointsJoueur2 = 0;
        Pep8.stro(message_Accueil);
        Pep8.stro("Combien de manches voulez-vous jouer ?\n");
        nombreManches =Pep8.deci();


        if (nombreManches % 2 == 0){
            nombreManches += 1;

        }

        while ( nombreManches > 0 ){

            Pep8.stro("Il reste "+nombreManches +" manche(s) à jouer\n");

            Pep8.stro("JOUEUR 1, quel est votre choix? [r/p/c]\n");
            char  choix1 = Pep8.chari();
            Pep8.stro("JOUEUR 2, quel est votre choix? [r/p/c]\n");
            char choix2 = Pep8.chari();
            if((choix1!='r' && choix1!='p'&& choix1!='c') ||(choix2!='r' && choix2!='p'&& choix2!='c') ){
                Pep8.stop();
            }
            if((choix1=='r' && choix2 =='c') || (choix2 =='r' && choix1 =='c')){
                if(choix1 == 'r'){
                    ++pointsJoueur1;
                    Pep8.stro("JOUEUR 1 a gagné cette manche! Score:"+ pointsJoueur1+'-'+pointsJoueur2+'\n');
                }else if (choix2 == 'r'){
                    ++pointsJoueur2;
                    Pep8.stro("JOUEUR 2 a gagné cette manche! Score:"+ pointsJoueur1+'-'+pointsJoueur2+'\n');
                }
            }else  if((choix1=='c' && choix2 =='p')|| (choix2=='c' && choix1 =='p')){
                if(choix1 == 'c'){
                    ++pointsJoueur1;
                    Pep8.stro("JOUEUR 1 a gagné cette manche! Score:"+ pointsJoueur1+'-'+pointsJoueur2+'\n');

                }else if (choix2 == 'c'){
                    ++pointsJoueur2;
                    Pep8.stro("JOUEUR 2 a gagné cette manche! Score:"+ pointsJoueur1+'-'+pointsJoueur2+'\n');

                }

            }else if((choix1=='p' && choix2 =='r')||(choix2 =='p' && choix1 =='r')){
                if(choix1 == 'p'){
                    ++pointsJoueur1;
                    Pep8.stro("JOUEUR 1 a gagné cette manche! Score:"+ pointsJoueur1+'-'+pointsJoueur2+'\n');

                }else if (choix2 == 'p'){
                    ++pointsJoueur2;
                    Pep8.stro("JOUEUR 2 a gagné cette manche! Score:"+ pointsJoueur1+'-'+pointsJoueur2+'\n');

                }
            }else if (choix1==choix2){
                Pep8.stro("Manche nulle...\n");
            }
            --nombreManches;

        }

        if (pointsJoueur1 > pointsJoueur2){
            Pep8.stro("JOUEUR 1 A GAGNÉ LE MATCH! FÉLICITATIONS!\n");
            Pep8.stro("SCORE FINAL: "+ pointsJoueur1+'-'+pointsJoueur2);
        }
        else if(pointsJoueur1 < pointsJoueur2){
            Pep8.stro("JOUEUR 2 A GAGNÉ LE MATCH! FÉLICITATIONS!\n");
            Pep8.stro("SCORE FINAL: "+ pointsJoueur1+'-'+pointsJoueur2);
        }
        else if (pointsJoueur1 == pointsJoueur2){
            Pep8.stro("FÉLICITATIONS!\n");
            Pep8.stro("SCORE FINAL: "+ pointsJoueur1+'-'+pointsJoueur2);
        }
    }


}
