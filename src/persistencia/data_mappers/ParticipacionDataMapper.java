package persistencia.data_mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Caballo;
import modelo.Fachada;
import modelo.Participacion;
import modelo.TipoApuesta;
import persistencia.DataMapper;
import persistencia.Persistencia;

public class ParticipacionDataMapper implements DataMapper{

    private Participacion participacion;
    
    @Override
    public int getOid() {
        return this.participacion.getOid();
    }

    @Override
    public void setOid(int oid) {
        this.participacion.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsertar() {
        ArrayList<String> sqls = new ArrayList<String>();
        persistencia.StringBuilder builder = new persistencia.StringBuilder();
        builder.setTable("Participaciones");
        String string = builder.insert().
                addValue("object_id", this.getOid()+"").
                addValue("caballo", this.participacion.getCaballo().getOid()+"").
                addValue("numero_caballo", this.participacion.getNumero()+"").
                addValue("dividendo", this.participacion.getDividendo()+"").
                addValue("tipo_apuesta", this.participacion.getTipoApuesta().getTipo()).get();
        
        return sqls;
        
    }

    @Override
    public ArrayList<String> getSqlActualizar() {
        throw new UnsupportedOperationException("Not s * upported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getSqlBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSeleccionar() {
        return "select * from Participaciones";
    }

    @Override
    public void crearNuevo() {
        this.participacion = new Participacion();
    }

    @Override
    public Object getObjeto() {
        return this.participacion;
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        int numero = rs.getInt("numero_caballo");
        this.participacion.setNumero(numero);
        
        float dividendo = rs.getFloat("dividendo");
        this.participacion.setDividendo(dividendo);
      
        int idCaballo = rs.getInt("caballo");
        Fachada f = Fachada.getInstancia();
        this.participacion.setCaballo(f.buscarCaballosById(idCaballo));   
    
        int idTipoApuesta = rs.getInt("tipo_apuesta");
        TipoApuesta a = f.buscarTipoApuestaById(idTipoApuesta);
        this.participacion.setTipoApuesta(a);
        
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        
    }
    
}
