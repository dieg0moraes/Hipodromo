package persistencia.data_mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.Apuesta;
import modelo.Caballo;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Participacion;
import persistencia.DataMapper;
import persistencia.StringBuilder;


public class CarreraDataMapper implements DataMapper {
    
    private Carrera carrera;
    private int hipodromoOid;

    public CarreraDataMapper(Carrera carrera, int hipodromo){
        this.carrera = carrera;
        this.hipodromoOid = hipodromo;
    }

    public CarreraDataMapper() {
        
    }
    
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
        ArrayList<String> sqls = new ArrayList<String>();
        StringBuilder build = new StringBuilder();
        build.setTable("Carrera");
        
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String mysqlDateString = formatter.format(this.carrera.getDate());
        
        String insertCarrera = build.insert().
                addValue("object_id", this.getOid()+"").
                addValue("numero", this.carrera.getNumero()+"").
                addValue("date", mysqlDateString).
                addValue("nombre", this.carrera.getNombre()).
                addValue("status", this.carrera.getStatus().toString()).
                addValue("ganador", this.carrera.getGanador().getOid()+"").get();
        sqls.add(insertCarrera);
        
        generarParticipaciones(sqls);
        generarApuestas(sqls);
                
        return sqls;
    }
    
    public void generarParticipaciones(ArrayList<String> sqls){
        
    }
    
    public void generarApuestas(ArrayList<String> sqls){
        
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
        String sql ="select c.object_id, c.numero, c.date, c.nombre, c.status, c.ganador, cp.participacion_id from Carreras c left join CarreraParticipaciones cp on c.object_id = cp.carrera_id" ;
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
        int caballo = rs.getInt("ganador");
        Caballo c = Fachada.getInstancia().buscarCaballosById(caballo);
        this.carrera.setGanador(c);
        
        
        
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {

        Fachada f = Fachada.getInstancia();
        
        int participacion = rs.getInt("participacion_id");
        if(!rs.wasNull()){  
            Participacion p = f.buscarParticipacionById(participacion);
            this.carrera.addParticipacion(p);   
        }
        
        

        
    }    
}
