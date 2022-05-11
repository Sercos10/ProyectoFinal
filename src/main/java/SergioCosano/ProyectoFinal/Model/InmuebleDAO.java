package SergioCosano.ProyectoFinal.Model;

import SergioCosano.ProyectoFinal.Utils.SQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class InmuebleDAO {
    private Connection cn = SQL.getConnection("src/main/resources/SergioCosano/Xmls/sql.xml");

    public Collection<Inmueble> getAll(){
        ArrayList<Inmueble> lista= new ArrayList<>();
        String select="SELECT * FROM inmueble";
        ResultSet rq= SQL.execQuery(select,null);
        try {
            while(rq.next()){
                Inmueble aux= new Inmueble();
                aux.setId_inmueble(rq.getInt(1));
                aux.setDesc_inmueble(rq.getString(2));
                aux.setUbic_inmueble(rq.getString(3));
                aux.setPrecio_inmueble(rq.getFloat(4));
                aux.setFech_dispo(rq.getDate(5));
                aux.setTipo_inmueble(rq.getString(6));
                aux.setCRU(rq.getInt(7));
                aux.setId_cliente(rq.getInt(8));
                aux.setIndice(rq.getInt(9));
                lista.add(aux);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insert(Inmueble e){
        boolean metido=false;
        String insert="INSERT INTO `inmueble` (`id_inmueble`, `desc_inmueble`, `ubic_inmueble`, `precio_inmueble`, `fech_dispo`, `tipo_inmueble`, `CRU`, `id_cliente`, `indice`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?)";
        ArrayList<Object> params= new ArrayList<>();
        params.add(e.getDesc_inmueble());
        params.add(e.getUbic_inmueble());
        params.add(e.getPrecio_inmueble());
        params.add(e.getFech_dispo());
        params.add(e.getTipo_inmueble());
        params.add(e.getCRU());
        params.add(e.getId_cliente());
        params.add(e.getIndice());

        ResultSet rq= SQL.execQuery(insert,params);
        try {
            if (rq.next()){
                metido=true;
            }else{
                metido=false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return metido;
    }


}
