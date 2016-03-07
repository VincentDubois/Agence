import java.util.Scanner;



public class Agence {


	// A  compléter
	public static class Jeu {
		int tresorerie;
		Contrat[] contrat;        
		Dossier[] dossier;        
	}

	public static class Contrat {
		int duree;
		int deadline;
		int paye;
	}

	public static class Dossier{
		int travail;
		Contrat contrat;
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

	private static Jeu creerJeu() {
		Jeu jeu = new Jeu();
		jeu.tresorerie =  1000;
		jeu.contrat =  new Contrat[6];
		for(int i = 0; i< jeu.contrat.length;++i){
			jeu.contrat[i] = createContrat();
		}
		jeu.dossier = new Dossier[3];		
		return jeu;
	}


	private static Contrat createContrat() {		
		Contrat contrat = new Contrat();
		contrat.duree = getRandom(5,25);
		contrat.deadline = contrat.duree + getRandom(5,20);
		contrat.paye = contrat.duree*getRandom(80,150);
		return contrat ;
	}

	private static void update(Jeu jeu) {
		// TODO Auto-generated method stub

	}


	private static void workOnDossier(Jeu jeu, int j) {
		// TODO Auto-generated method stub

	}


	private static int createDossier(Jeu jeu, int n) {
		for(int i=0; i< jeu.dossier.length; ++i){
			if (jeu.dossier[i] == null){
				Dossier dossier = new Dossier();
				dossier.contrat = jeu.contrat[n];
				dossier.travail = 0;
				jeu.dossier[i] = dossier;
				return i;
			}
		}
		return -1;
	}





	public static int getRandom(int min, int max){
		return (int) (min+ (max-min)*Math.random());
	}






	/**
	 * @param args
	 */
	public static void main(String[] args) {


		Jeu jeu = creerJeu();
		createDossier(jeu,0);

		Debug.create();
		Debug.target(jeu);

		play(jeu);


	}




}
