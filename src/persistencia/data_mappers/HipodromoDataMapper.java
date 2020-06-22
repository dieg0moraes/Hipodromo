package persistencia.data_mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Hipodromo;
import modelo.Jornada;
import persistencia.DataMapper;
import persistencia.Persistencia;

public class HipodromoDataMapper implements DataMapper{

    private Hipodromo hipodromo;
    
    @Override
    public int getOid() {
        return this.hipodromo.getOid();
    }

    @Override
    public void setOid(int oid) {
        this.hipodromo.setOid(oid);
    }

    @Override
    public ArrayList<String> getSqlInsertar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getSqlActualizar() {
        ArrayList<String> sql = new ArrayList<String>();
        String sqlString = "select h.name, h.direccion, j.jornada from Hipodromos h inner join JornadaHipodromo j on h.object_id = j.hipodromo;";
        sql.add(sqlString);
        return sql;
    }

    @Override
    public ArrayList<String> getSqlBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSqlSeleccionar() {
        String sqlString = "select h.name, h.direccion, j.jornada from Hipodromos h inner join JornadaHipodromo j on h.object_id = j.hipodromo;";
        return sqlString;
    }

    @Override
    public void crearNuevo() {
        this.hipodromo = new Hipodromo();
    }

    @Override
    public Object getObjeto() {
        return this.hipodromo;
    }

    @Override
    public void leerCompuesto(ResultSet rs) throws SQLException {
        this.hipodromo.setNombre(rs.getString("name"));
        this.hipodromo.setDireccion(rs.getString("direccion"));
    }

    @Override
    public void leerComponente(ResultSet rs) throws SQLException {
        int jornada = rs.getInt("jornada");
        Persistencia persistencia = Persistencia.getInstancia();
        JornadaDataMapper jornadaMapper = new JornadaDataMapper();
        ArrayList<Jornada> jornadas = persistencia.buscar(jornadaMapper, "object_id ="+jornada);
        for(Jornada j : jornadas){
            this.hipodromo.getJornadas().add(j);
        }    
    }   
}
