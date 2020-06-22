package persistencia.data_mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Carrera;
import modelo.Jornada;
import persistencia.DataMapper;
import persistencia.Persistencia;

public class JornadaDataMapper implements DataMapper{
    
    private Jornada jornada;

    @Override
    public int getOid() {
        return jornada.getOid();
    }

    @Override
    public void setOid(int oid) {
        this.jornada.setOid(oid);
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
        return "select j.object_id, j.date, j.next_carrera_id, j.carrera_actual, jh.carrera from Jornadas j inner join JornadaCarrera jh on j.object_id = jh.jornada;";
        
    }

    @Override
    public void crearNuevo() {
        this.jornada = new Jornada();
    }

    @Override
    public Object getObjeto() {
        return this.jornada;
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        this.jornada.setDate(rs.getDate("date"));
         int carrera = rs.getInt("next_carrera_id");
         this.jornada.setSiguienteCarrera(carrera);  
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {       
        CarreraDataMapper mapper = new CarreraDataMapper();                  
        int carreraActual = rs.getInt("carrera_actual");
        ArrayList<Carrera> carreras = Persistencia.getInstancia().buscar(mapper, "object_id = "+carreraActual);
        this.jornada.setCarreraActual(carreras.get(0));
        int carrera = rs.getInt("carrera");
        carreras = Persistencia.getInstancia().buscar(mapper, "object_id = "+carrera);
        for(Carrera c : carreras){
            this.jornada.getCarreras().add(c);
        }       
    }
    
}
