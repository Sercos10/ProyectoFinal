package SergioCosano.ProyectoFinal.Model;

import java.util.Date;

public class Inmueble {
    private int id_inmueble;
    private String desc_inmueble;
    private String ubic_inmueble;
    private float precio_inmueble;
    private Date fech_dispo;
    private String tipo_inmueble;
    private int id_cliente;
    private int indice;

    public Inmueble() {
    }

    public Inmueble(int id_inmueble, String desc_inmueble, String ubic_inmueble, float precio_inmueble, Date fech_dispo, String tipo_inmueble, int id_cliente, int indice) {
        this.id_inmueble = id_inmueble;
        this.desc_inmueble = desc_inmueble;
        this.ubic_inmueble = ubic_inmueble;
        this.precio_inmueble = precio_inmueble;
        this.fech_dispo = fech_dispo;
        this.tipo_inmueble = tipo_inmueble;
        this.id_cliente = id_cliente;
        this.indice = indice;
    }

    public int getId_inmueble() {
        return id_inmueble;
    }

    public void setId_inmueble(int id_inmueble) {
        this.id_inmueble = id_inmueble;
    }

    public String getDesc_inmueble() {
        return desc_inmueble;
    }

    public void setDesc_inmueble(String desc_inmueble) {
        this.desc_inmueble = desc_inmueble;
    }

    public String getUbic_inmueble() {
        return ubic_inmueble;
    }

    public void setUbic_inmueble(String ubic_inmueble) {
        this.ubic_inmueble = ubic_inmueble;
    }

    public float getPrecio_inmueble() {
        return precio_inmueble;
    }

    public void setPrecio_inmueble(float precio_inmueble) {
        this.precio_inmueble = precio_inmueble;
    }

    public Date getFech_dispo() {
        return fech_dispo;
    }

    public void setFech_dispo(Date fech_dispo) {
        this.fech_dispo = fech_dispo;
    }

    public String getTipo_inmueble() {
        return tipo_inmueble;
    }

    public void setTipo_inmueble(String tipo_inmueble) {
        this.tipo_inmueble = tipo_inmueble;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inmueble inmueble = (Inmueble) o;
        return id_inmueble == inmueble.id_inmueble;
    }

    @Override
    public String toString() {
        return "Inmueble{" +
                "id_inmueble=" + id_inmueble +
                ", desc_inmueble='" + desc_inmueble + '\'' +
                ", ubic_inmueble='" + ubic_inmueble + '\'' +
                ", precio_inmueble=" + precio_inmueble +
                ", fech_dispo=" + fech_dispo +
                ", tipo_inmueble=" + tipo_inmueble +
                ", id_cliente=" + id_cliente +
                ", indice=" + indice +
                '}';
    }
}
