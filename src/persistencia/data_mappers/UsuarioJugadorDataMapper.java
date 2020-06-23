package persistencia.data_mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.UsuarioJugador;
import persistencia.DataMapper;

public class UsuarioJugadorDataMapper implements DataMapper{
        
    private UsuarioJugador user;
    
    @Override
    public int getOid() {
        return this.user.getOid();
    }

    @Override
    public void setOid(int oid) {
        this.user.setOid(oid);
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
        return "select * from Usuarios where isStaff = false;";
    }

    @Override
    public void crearNuevo() {
        this.user = new UsuarioJugador();
    }

    @Override
    public Object getObjeto() {
        return this.user;
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        this.user.setNombreCompleto(rs.getString("nombre"), rs.getString("apellido"));
        this.user.setPassword(rs.getString("password"));
        this.user.setUsername(rs.getString("username"));
        this.user.setSaldo(rs.getFloat("saldo"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        
    }
    
}
