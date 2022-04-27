package SergioCosano.ProyectoFinal.Model;

public class Cliente {
    private int id_cliente;
    private String nombre_cliente;
    private String apellidos_cliente;
    private String correo_cliente;
    private String dni_cliente;
    private String contrasena;

    public Cliente() {
    }

    public Cliente(int id_cliente, String nombre_cliente, String apellidos_cliente, String correo_cliente, String dni_cliente, String contrasena) {
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.apellidos_cliente = apellidos_cliente;
        this.correo_cliente = correo_cliente;
        this.dni_cliente = dni_cliente;
        this.contrasena = contrasena;
    }

    public Cliente(String correo_cliente, String contrasena) {
        this.correo_cliente = correo_cliente;
        this.contrasena = contrasena;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellidos_cliente() {
        return apellidos_cliente;
    }

    public void setApellidos_cliente(String apellidos_cliente) {
        this.apellidos_cliente = apellidos_cliente;
    }

    public String getCorreo_cliente() {
        return correo_cliente;
    }

    public void setCorreo_cliente(String correo_cliente) {
        this.correo_cliente = correo_cliente;
    }

    public String getDni_cliente() {
        return dni_cliente;
    }

    public void setDni_cliente(String dni_cliente) {
        this.dni_cliente = dni_cliente;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id_cliente == cliente.id_cliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id_cliente=" + id_cliente +
                ", nombre_cliente='" + nombre_cliente + '\'' +
                ", apellidos_cliente='" + apellidos_cliente + '\'' +
                ", correo_cliente='" + correo_cliente + '\'' +
                ", dni_cliente='" + dni_cliente + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
