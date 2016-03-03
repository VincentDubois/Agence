import java.util.Scanner;



public class Agence {


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


	public static void play(Jeu jeu){
		Scanner console = new Scanner(System.in); 

		while (jeu.tresorerie >=0){
			Debug.update();
			System.out.println("Entrez une commande : c# pour créer un nouveau dossier, w# pour travailler sur un dossier");
			String s = console.nextLine();
			int i = Integer.parseInt(s.substring(1));

			if (s.startsWith("c")){
				int j = createDossier(jeu,i);
				if (j!= -1) workOnDossier(jeu,j);
			} else if (s.startsWith("w")){
				workOnDossier(jeu,i);
			}
			update(jeu);

		}
	}

	private static Jeu CréerJeu() {
		// A compléter
		return new Jeu();
	}


	private static void update(Jeu jeu) {
		// TODO Auto-generated method stub

	}


	private static void workOnDossier(Jeu jeu, int j) {
		// TODO Auto-generated method stub

	}


	private static int createDossier(Jeu jeu, int i) {
		// TODO Auto-generated method stub
		return 0;
	}





	public static int getRandom(int min, int max){
		return (int) (min+ (max-min)*Math.random());
	}






	/**
	 * @param args
	 */
	public static void main(String[] args) {


		Jeu jeu = CréerJeu();

		Debug.create();
		Debug.target(jeu);

		play(jeu);


	}




}
