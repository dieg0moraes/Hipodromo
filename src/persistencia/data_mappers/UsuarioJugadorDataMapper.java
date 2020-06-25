package persistencia.data_mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Carrera;
import modelo.Fachada;
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
        return "select u.object_id, u.username, u.password, u.isStaff, u.saldo, u.nombre, u.apellido, a.object_id as 'apuesta', a.carrera as 'carrera' from Usuarios u left join Apuestas a on u.object_id = a.jugador where isStaff = false;";
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
        int apuesta = rs.getInt("apuesta");
        if(!rs.wasNull()){
            Apuesta a = Fachada.getInstancia().buscarApuestaById(apuesta);
            ((UsuarioJugador)this.user).addApuesta(a);
            a.setJugador((UsuarioJugador)this.user);
            int carrera = rs.getInt("carrera");
            Carrera carreraFound = Fachada.getInstancia().buscarCarreraById(carrera);
            a.setCarrera(carreraFound);
        }
        
        
        
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    
    
}
