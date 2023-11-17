package bowling;

public class Tour {
	private Lancer lancer1;
	private Lancer lancer2;
	private String res;
	private int scoreTour = 0;

	public Tour() {
		lancer1 = new Lancer();
		lancer2 = new Lancer();
		res = "Normal";
	}

	public int getScoreTour(Lancer l1, Lancer l2) {
		int l1Val =  Math.max(0, l1.getNbQuilles());
		int l2Val =  Math.max(0, l2.getNbQuilles());

		if (lancer1.getNbQuilles() == 10 ){
			this.scoreTour = lancer1.getNbQuilles() + l1Val + l2Val;
		}else if (lancer1.getNbQuilles() + lancer2.getNbQuilles() == 10) {
			this.scoreTour = lancer1.getNbQuilles() + lancer2.getNbQuilles() + l1Val;
		} else {
			this.scoreTour = Math.max(0, lancer1.getNbQuilles()) +  Math.max(0, lancer2.getNbQuilles());
		}
		return (this.scoreTour);
	}

	public void addScore(int nbQuilles) {
		if (nbQuilles < 0 || nbQuilles > 10){
			throw new IllegalArgumentException("nbQuille must be between 0 and 10");
		}
		if (this.getNumLancer() == 1) {
			addScore(nbQuilles, lancer1);
			if (nbQuilles == 10) {
				res = "Strike";
			}
		} else if (this.getNumLancer() == 2) {

			addScore(nbQuilles, lancer2);
			if (lancer1.getNbQuilles() + lancer2.getNbQuilles() == 10){
				res = "Spare";
			}
		}
	}

	public void addScore(int nbQuilles, Lancer lancer) {
		lancer.setNbQuilles(nbQuilles);
	}
	public int getScoreQuilleLancer(Lancer l) {
		return l.getNbQuilles();
	}

	public int getScoreQuilleLancer2(){
		return getScoreQuilleLancer(lancer2);
	}

	public int getNumLancer() {
		if (lancer1.getNbQuilles() == -1) {
			return 1;
		} else if (lancer2.getNbQuilles() == -1 && lancer1.getNbQuilles() != 10) {
			return 2;
		} else {
			return 0;
		}
	}

	public Lancer getLancer1() {
		return lancer1;
	}
	public Lancer getLancer2() {
		return lancer2;
		}
}
