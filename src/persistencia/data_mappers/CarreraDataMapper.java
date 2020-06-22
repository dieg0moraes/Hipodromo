package persistencia.data_mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import modelo.Apuesta;
import modelo.Caballo;
import modelo.Carrera;
import modelo.Participacion;
import persistencia.DataMapper;
import persistencia.Persistencia;

public class CarreraDataMapper implements DataMapper {
    
    private Carrera carrera;

    @Override
    public int getOid() {
        return this.carrera.getOid();
    }

    @Override
    public void setOid(int oid) {
        this.carrera.setOid(oid);
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
        String sql ="select c.object_id, c.numero, c.date, c.nombre, c.status, c.ganador, cp.participacion_id from Carreras c left join CarreraParticipaciones cp on c.object_id = cp.carrera_id left join CarreraApuesta ca on c.object_id = ca.carrera;";
        return sql;               
    }

    @Override
    public void crearNuevo() {
        this.carrera = new Carrera();
    }

    @Override
    public Object getObjeto() {
        return this.carrera;
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        String name = rs.getString("nombre");
        this.carrera.setNombre(name);
        Date date = rs.getDate("date");
        this.carrera.setDate(date);
        String status = rs.getString("status"); 
        Carrera.Status statusEnum = Carrera.Status.valueOf(status);
        this.carrera.setStatus(statusEnum);
        int numero = rs.getInt("numero");
        this.carrera.setNumero(numero);
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        CaballoDataMapper caballoMap = new CaballoDataMapper();
        int caballo = rs.getInt("ganador");
    
        ArrayList<Caballo> caballos = Persistencia.getInstancia().buscar(caballoMap, "object_id = "+caballo);
        for(Caballo c : caballos){
            this.carrera.getCaballos().add(c);
        }
        
        ParticipacionDataMapper participacionMap = new ParticipacionDataMapper();
        int participacion = rs.getInt("participacion_id");
        ArrayList<Participacion> participaciones = Persistencia.getInstancia().buscar(participacionMap, "object_id = "+participacion);
        for(Participacion p : participaciones){
            this.carrera.getParticipaciones().add(p);
        }
        
        ApuestaDataMapper apuestasDm = new ApuestaDataMapper();
        int apuesta = rs.getInt("apuesta");
        if(!rs.wasNull()){
            ArrayList<Apuesta> apuestas = Persistencia.getInstancia().buscar(apuestasDm, "object_id = "+apuesta);
            for(Apuesta a : apuestas){
                this.carrera.getApuestas().add(a);
            }
        }
    }
    
}
