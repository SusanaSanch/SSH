package conexionssh;

public class Patologia {

	private int id_patologia;
	private String nombre_patologia;
	
	public int getId_patologia() {
		return id_patologia;
	}
	public void setId_patologia(int id_patologia) {
		this.id_patologia = id_patologia;
	}
	public String getNombre_patologia() {
		return nombre_patologia;
	}
	public void setNombre_patologia(String nombre_patologia) {
		this.nombre_patologia = nombre_patologia;
	}
	
	public Patologia(int id_patologia, String nombre_patologia) {
		super();
		this.id_patologia = id_patologia;
		this.nombre_patologia = nombre_patologia;
	}
	
	
	
	
}
