package persistencia.data_mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Caballo;
import persistencia.DataMapper;

public class CaballoDataMapper implements DataMapper{

    private Caballo caballo;

    @Override
    public int getOid() {
        return this.caballo.getOid();
    }

    @Override
    public void setOid(int oid) {
        this.caballo.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsertar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getSqlActualizar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getSqlBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSeleccionar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void crearNuevo() {
        this.caballo = new Caballo();
    }

    @Override
    public Object getObjeto() {
        return this.caballo;
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        this.caballo.setNombre(rs.getString("name"));
        this.caballo.setResponsable(rs.getString("cuidador"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
