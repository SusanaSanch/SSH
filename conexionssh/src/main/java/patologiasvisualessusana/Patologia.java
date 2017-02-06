package patologiasvisualessusana;

public class Patologia {
	
	private int id;
	private String nombre;
	private String descripcion;
	private String tratamiento;
	private String causa;
	
	public Patologia(int id, String nombre, String descripcion, String tratamiento, String causa) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tratamiento = tratamiento;
		this.causa = causa;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public String getCausa() {
		return causa;
	}
	public void setCausa(String causa) {
		this.causa = causa;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+". "+this.nombre;
	}
}