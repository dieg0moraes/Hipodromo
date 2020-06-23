package persistencia.data_mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Apuesta;
import modelo.Fachada;
import modelo.Participacion;
import modelo.UsuarioJugador;
import persistencia.DataMapper;
import persistencia.Persistencia;

public class ApuestaDataMapper implements DataMapper{
    
    private Apuesta apuesta;

    @Override
    public int getOid() {
        return this.apuesta.getOid();
    }

    @Override
    public void setOid(int oid) {
        this.apuesta.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsertar() {
        ArrayList<String> sql = new ArrayList<String>();
        String sentence = "insert into Apuestas  values ("
                + this.getOid() +", "+ this.apuesta.getParticipacion().getOid() + ", "+ this.apuesta.getMonto();
    
        sql.add(sentence);
        return sql;
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
        return "select * from Apuestas order by object_id;";
    }

    @Override
    public void crearNuevo() {
        this.apuesta = new Apuesta();
    }

    @Override
    public Object getObjeto() {
        return this.apuesta;
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        this.apuesta.setMonto(rs.getFloat("monto"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        int participacionId = rs.getInt("participacion");
        int user = rs.getInt("user_id");
        
        this.apuesta.setParticipacion(Fachada.getInstancia().buscarParticipacionById(participacionId));
        this.apuesta.setJugador(Fachada.getInstancia().buscarJugadorById(user));
        
    }        
}    
