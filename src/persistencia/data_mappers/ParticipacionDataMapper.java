package persistencia.data_mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Caballo;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return "select * from participaciones";
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
        
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        int idCaballo = rs.getInt("caballo");
        CaballoDataMapper caballoMapper = new CaballoDataMapper();
        ArrayList<Caballo> caballos = Persistencia.getInstancia().buscar(caballoMapper, "object_id = "+idCaballo);
        this.participacion.setCaballo(caballos.get(0));
        
        int idTipoApuesta = rs.getInt("tipo_apuesta");
        TipoApuestaDataMapper tipoMapper = new TipoApuestaDataMapper();
        ArrayList<TipoApuesta> tipo = Persistencia.getInstancia().buscar(tipoMapper, "object_id = "+idTipoApuesta);
        this.participacion.setTipoApuesta(tipo.get(0));
    }
    
}
