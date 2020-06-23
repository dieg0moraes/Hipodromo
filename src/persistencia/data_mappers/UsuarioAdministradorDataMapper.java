package persistencia.data_mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.UsuarioAdmin;
import persistencia.DataMapper;

public class UsuarioAdministradorDataMapper implements DataMapper{
    
    private UsuarioAdmin usuario;
    
    @Override
    public int getOid() {
        return this.usuario.getOid();
    }

    @Override
    public void setOid(int oid) {
       this.usuario.setOid(oid);
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
        return "select * from Usuarios where isStaff = true";
    }

    @Override
    public void crearNuevo() {
        this.usuario = new UsuarioAdmin();
    }

    @Override
    public Object getObjeto() {
        return this.usuario;
    }
    
    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        this.usuario.setNombreCompleto(rs.getString("nombre"), rs.getString("apellido"));
        this.usuario.setUsername(rs.getString("username"));
        this.usuario.setPassword(rs.getString("password"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        
    }
    
}
