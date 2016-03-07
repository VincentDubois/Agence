import java.util.Scanner;



public class Agence {


	//Définition des structures
	
	// A  compléter
	public static class Jeu {
		int tresorerie;
		Contrat[] contrat;        
		Dossier[] dossier;        
	}

	public static class Contrat {
	}

	public static class Dossier{
	}

	// fonctions du jeu (à compléter aussi)

	private static Jeu creerJeu() {
		Jeu jeu = new Jeu();
		return jeu;
	}


	private static void update(Jeu jeu) {
	}

	private static void workOnDossier(Jeu jeu, int j) {
	}


	private static int createDossier(Jeu jeu, int n) {
		return -1;
	}

	
	
	
	// Quelques fonctions utiles
	
	public static int alea(int min, int max){
		return (int) (min+ (max-min)*Math.random());
	}

	public static void play(Jeu jeu){
		Scanner console = new Scanner(System.in); 

		while (jeu.tresorerie >=0){
			Debug.update();
			// Ajoutez ici l'affichage du jeu
			
			System.out.println("Entrez une commande : c# pour créer un nouveau dossier, w# pour travailler sur un dossier");
			String s = console.nextLine();
			int i = Integer.parseInt(s.substring(1));

			if (s.startsWith("c")){
				int j = createDossier(jeu,i); 
				// remarque : la valeur de retour (j) indique
				// l'emplacement utilisé pour le nouveau dossier
				
				if (j!= -1) workOnDossier(jeu,j); 
			} else if (s.startsWith("w")){
				workOnDossier(jeu,i);
			}
			update(jeu);

		}
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Jeu jeu = creerJeu();

		// Une fois le programme débuggé, vous pouvez commenter ces  deux lignes.
		// et réorganiser les imports (ctrl-shift-o)
		// Le fichier Agence.java fonctionne alors seul (sans les autres fichiers du projet)
		
		Debug.create();
		Debug.target(jeu);

		play(jeu);
	}
}
