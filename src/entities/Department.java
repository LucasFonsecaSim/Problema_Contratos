package entities;
/* / Classe department. / */

public class Department {

	private String name;
	
	/* / Construtores. / */
	public Department() {
	}

	public Department(String name) {
		this.name = name;
	}
	
	/* / Funções get e set. / */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
