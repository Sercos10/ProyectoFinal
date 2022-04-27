package SergioCosano.ProyectoFinal.Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQL {
    private static SQL instance;
    private static Connection cn;
    private static ConnectionData info;
    private SQL(){

    }
    private SQL(String url){
        info = new ConnectionData(url);
    }
    public static Connection getConnection(String url){
        if(instance == null){
            instance = new SQL(url);
        }
        if(cn == null){
            try {
                cn = DriverManager.getConnection("jdbc:mysql://"+info.getServer()+"/"+info.getDatabase(),info.getUser(), info.getPassword());
            } catch (SQLException e) {
                cn = null;
            }
        }
        return cn;
    }

    public static void disconnect() {
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException e) {

            }
        }
    }

    private static PreparedStatement prepareQuery(String q, List<Object> params){
        PreparedStatement ps = null;
        if (cn != null){
            try {
                ps = cn.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
            } catch (SQLException e) {

            }

            if (params != null && ps != null) {
                int i = 1;
                for (Object o : params) {
                    try {
                        ps.setObject(i++, o);
                    } catch (SQLException e) {

                    }
                }
            }
        }

        return ps;
    }

    public static ResultSet execQuery(String q, List<Object> params) {
        ResultSet result;
        if (cn != null) {
            PreparedStatement ps = prepareQuery(q, params);
            try {
                result = ps.executeQuery();
            } catch (SQLException e) {
                result = null;
            }
        } else {
            result = null;
        }
        return result;
    }

    public static long execUpdate(String q, List<Object> params, boolean insert) {

        long result;
        if (cn != null) {
            try (PreparedStatement ps = prepareQuery(q, params)) {
                result = ps.executeUpdate();
                if (insert) {
                    try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                        if (generatedKeys.next())
                            result = generatedKeys.getLong(1);
                        else
                            result = -1;
                    } catch (SQLException e) {

                    }
                }
            } catch (SQLException e) {
                result = -1;
            }
        } else {
            result = -1;
        }
        return result;
    }

}
