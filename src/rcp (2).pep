;Programme qui reprï¿½sente un jeu de roche-papier-ciseau entre
;deux joueurs humains. Si vous ne connaissez pas le jeu, chaque joueur choisit un des trois
;objets, et on dï¿½termine qui a gagnï¿½ la manche selon les simples rï¿½gles suivantes:
;  ? roche gagne contre ciseau
;  ? ciseau gagne contre papier
;  ? papier gagne contre roche
;@groupe 92
;@author : Saa Paul, Millimouno
;@adresse: millimouno,saa-paul@couriel.uqam.ca
;@code permanent: MILS30019703
;@author :Jaures-Xavier Bi Tizie,Gouli
;@adress:Jauresgouli@gmail.com
;@code permanent:GOUB03089709
         ldx 0,i
         lda 0,i
         stro accueil,d;
         stro sautLi,d
         stro question,d
         stro sautLi,d
         deci manches,d
         lda manches,d
         sta valArbri,d 
;cette loop verifie si le nombre de manches est paires ou impaire
         cpa 0,i
loop:    brle  finWhile
         suba 2,i
         sta manches,d
         br loop
finWhile: cpa 0,i            
         breq paire               
         brlt impaire
suivan1: cpa 0,i
boucle:  brle finBouc   ;debut de la boucle while (manches  >0){
         stro msgMnch1,d
         deco manches,d
         stro msgMnch2,d
         stro msgJ1,d
         chari choix1,d
;branchement de verification  1
         chari entrer,d
         ldbytex choix1,d
         cpx 'r',i
         brne verifP1     ; debut de la verification 
         br msg2
;verification des caractère entrer par le joueur
verifP1:  cpx 'p',i
         brne verifC1 
         br msg2
verifC1:  cpx 'c',i
         brne arret
         br msg2
msg2:    stro msgJ2,d
         chari choix2,d
         chari entrer,d
         ldbytex choix2,d
         cpx 'r',i
         Brne verifP2 ; debut de la verification 
         br veri
;verification des caractères entré par le joueur
verifP2: cpx 'p',i
         brne verifC2
         br veri
verifC2: cpx 'c',i
         brne arret
         br veri
         
  ;branchement de verification  1
veri:    ldbytex choix1,d
         cpx 'c',i
         breq verifCP
         br sotEQ
         br sotPR
verifCP: ldbytex choix2,d
         cpx 'p',i
         breq sotCP
         br sotEQ
         br sotPR
;ce branchement permet d verifier si les joueur on entrer le meme choix
sotEQ:   sta  manches,d
         ldbytea choix1,d
         ldbytex  choix2,d
         stx temp,d 
         cpa temp,d
         breq egal
         lda manches,d
         br sotPR
egal:    stro matchN,d
         lda manches,d
         adda 1,i
         br finIf
         br sotPR


;papier gagne contre roche
;debut du brachement si les joueurs on entrer comme choix P ou R

sotPR:   ldbytex choix1,d
         cpx  'p',i
         breq eqPR
         br sotPR2
eqPR:    ldbytex choix2,d
         cpx 'r',i 
         breq  incre
 ;debut du brachement si les joueurs on entrer comme choix R ou P
sotPR2:  ldbytex choix1,d
         cpx 'r',i
         breq eqPR2
eqPR2:   ldbytex choix2,d 
         cpx 'p',i
         breq incre2

     ;roche gagne contre ciseau
;debut du brachement si les joueurs on entrer comme choix R ou C 
sotRC:   ldbytex choix1,d
         cpx  'r',i
         breq eqRC
         br sotRC2
eqRC:    ldbytex choix2,d
         cpx 'c',i 
         breq  incre
         br sotRC2
;debut du brachement si les joueurs on entrer comme choix C ou R
sotRC2:  ldbytex choix1,d
         cpx 'c',i
         breq eqRC2
eqRC2:   ldbytex choix2,d 
         cpx 'r',i
         breq incre2
         br  sotCP

    ;ciseau gagne contre papier
;debut du brachement si les joueurs on entrer comme choix C ou P
sotCP:   ldbytex choix1,d   
         cpx  'c',i
         breq eqCP
         br sotCP2
eqCP:    ldbytex choix2,d
         cpx 'p',i 
         breq  incre
         br sotCP2 
;debut du brachement si les joueurs on entrer comme choix P ou C
sotCP2:  ldbytex choix1,d
         cpx 'p',i
         breq eqCP2
eqCP2:   ldbytex choix2,d 
         cpx 'c',i
         breq incre2
         br sotPR

  

         
     

;Incrementation des points du joueur
incre:   ldx pJoueur1,d        ;increment les points du joueur N1
         addx 1,i
         stx   pJoueur1,d
         stro vic1,d
         deco pJoueur1,d
         charo tiret,d
         deco pJoueur2,d
         stro sautLi,d
         br scvic1
incre2: ldx pJoueur2,d       ;increment les points du joueur N2
         addx  1,i
         stx pJoueur2,d
         stro vic2,d
         deco pJoueur1,d
         charo tiret,d
         deco pJoueur2,d
         stro sautLi,d
         br scvic1

 ;verification si la somme du des deux jdu score 
scvic1:  ldx valArbri,d 
         stx val,d     
         subx     pJoueur1,d
         cpx     pJoueur1,d
         brlt    dimMnch
         ldx val,d
         stx valArbri,d
         subx     pJoueur2,d
         cpx     pJoueur2,d
         brlt    dimMnch
         br finIf
dimMnch: lda     0,i
         br finIf
         


 ;l'instruction s'execute pour diminuer le nombre de manche         
finIf:   suba 1,i
         sta manches,d
         br boucle
finBouc: lda pJoueur1,d
         cpa pJoueur2,d
         brgt affic1 
         brle affic2

         

;Affichage du score si le joueur N1 a gagne 
affic1:  stro sco1,d
         stro score,d
         deco pJoueur1,d 
         charo tiret,d
         deco pJoueur2,d
         br arret 
;Affichage du score si le joueur N2 a gagne 
affic2:  stro sco2,d         
         stro score,d
         deco pJoueur1,d
         charo tiret,d
         deco pJoueur2,d
         br arret

         
stop             ;fin du programme
paire:  ldx valArbri,d         ;modifi le nombre de manches si la valeur entrer un monbre paire  
         addx 1,i
         stx manches,d
         ldx manches,d
         STX valArbri,d
         lda manches,d
         br suivan1          ;branchement qui retourne pour executé l'instructiion (remettre le registre au vsaleur vide )
impaire: ldx valArbri,d      ;modifie le nombre de manches si la valeur entrer un monbre impaire  
         stx manches,d 
         ldx manches,d
         STX valArbri,d
         lda manches,d       
         br suivan1          ;branchement qui retourne pour executé l'instructiion (remettre le registre au vsaleur vide )
;verification des caractere entrer
; par l'utilisateur 
;verifC: cpx 



accueil: .Ascii "-------------------------------------------------------\n" 
         .Ascii  "-------Bienvenu au jeu de roche-papier-ciseau----------\n" 
         .Ascii  "-------------------------------------------------------\n\x00" ;cette variable affiche le message d'accueil
manches: .word 0                  ; contient le nombre de manches 
pJoueur1: .word 0;                ;contient le nombre de points gagné par le joueur 1
pJoueur2: .word 0;                ;contient le nombre de points gagné par le joueur 2
question:.ascii "Combien de manches voulez-vous jouer ?\x00"  ; variable qui demande au joeur d'entrer le monbre de manches
valArbri:.word 0                  ; variable temporaire utiliser pour stocker les valeur reutilisable
val:     .word 0                  ; variable temporaire utiliser pour stocker les valeur reutilisable
msgMnch1:.ascii "Il reste \x00"
msgMnch2:.ascii " manche(s) à jouer\n\x00" 
msgJ1:   .ascii "JOUEUR 1, quel est votre choix? [r/p/c]\n \x00" 
msgJ2:   .ascii "JOUEUR 2, quel est votre choix? [r/p/c]\n \x00" 
choix1:  .block 1              ;contient le choix du joueur  N1
entrer:  .block 1             ; contient la valeur de la touche entrer
choix2:  .block 1            ;contient le choix du joueur  N2
temp:    .block 1            ; variable temporaire utiliser pour stocker les valeur temporaiment
vic1:    .ascii "JOUEUR 1 a gagné cette manche! Score: \x00"
vic2:    .ascii "JOUEUR 2 a gagné cette manche! Score: \x00"
tiret:   .byte '-'
sautLi:  .ascii "\n\n\x00"
arret:    stop               ;cette variable arrete le programme 
matchN:  .ascii "Manche nulle...\n\x00";

sco1:    .ascii  "JOUEUR 1 A GAGNÉ LE MATCH! FÉLICITATIONS!\n\x00";affiche le message de victoire pour le joueur N1
sco2:    .ascii  "JOUEUR 2 A GAGNÉ LE MATCH! FÉLICITATIONS!\n\x00" ;affiche le message de victoire pour le joueur N2
score:   .ascii   "SCORE FINAL: \x00" ;affiche le message du score

.END