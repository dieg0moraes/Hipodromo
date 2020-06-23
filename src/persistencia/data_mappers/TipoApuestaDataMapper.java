package persistencia.data_mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.TipoApuesta;
import persistencia.DataMapper;

public class TipoApuestaDataMapper implements DataMapper{
    private TipoApuesta tipoApuesta;

    @Override
    public int getOid() {
        return this.tipoApuesta.getOid();
    }

    @Override
    public void setOid(int oid) {
        this.tipoApuesta.setOid(oid);
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
        return "select * from TiposApuestas";
    }

    @Override
    public void crearNuevo() {
        this.tipoApuesta = new TipoApuesta();
    }

    @Override
    public Object getObjeto() {
        return this.tipoApuesta;
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        String tipo = rs.getString("tipo");
        this.tipoApuesta.setTipo(tipo);
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
    
    }
    
    
    
}
