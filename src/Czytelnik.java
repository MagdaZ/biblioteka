import java.io.Serializable;

public class Czytelnik implements Serializable {
	
	private static final long serialVersionUID = 605716303499853723L;
	String imie;
	String nazwisko;
	long id;

	/**
	 * @param imie
	 * @param nazwisko
	 * @param id
	 */
	public Czytelnik(String imie, String nazwisko, long id) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.id = id;
	}
	/**
	 * @return the imie
	 */
	public String getImie() {
		return imie;
	}
	/**
	 * @param imie the imie to set
	 */
	public void setImie(String imie) {
		this.imie = imie;
	}
	/**
	 * @return the nazwisko
	 */
	public String getNazwisko() {
		return nazwisko;
	}
	/**
	 * @param nazwisko the nazwisko to set
	 */
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return imie + " " + nazwisko + ", id=" + id;
	}
		
}
