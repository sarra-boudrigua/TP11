package bowling;

public class Lancer {
	private int nbQuilles;

	public Lancer(int nbQuilles) {

		this.nbQuilles = nbQuilles;
	}
		public Lancer() {
			this(-1);
		}

		public int getNbQuilles() {
			return nbQuilles;
		}

		public void setNbQuilles(int nbQuilles) {
			if (nbQuilles > 10 || nbQuilles < 0){
				throw new IllegalArgumentException("nombres quille incorrect");
			}
			this.nbQuilles = nbQuilles;
		}
}
