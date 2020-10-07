public class Tarea {

	private String nombre;
	private boolean done;
	
	public Tarea(String nombre){
		this.nombre = nombre;
		this.done = false;
	}
	
	private void setDone(boolean done) {
		this.done = done;
	}
	
	private String getNombre() {
		return this.nombre;
	}
	
	private Boolean getDone() {
		return this.done;
	}
	
    public JSONObject toJSON() {
        JSONObject jso = new JSONObject();
        jso.put("nombre", this.getNombre());
        jso.put("done", this.getDone());
        return jso;
    }

}
