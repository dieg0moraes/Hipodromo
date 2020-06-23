/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author alumnoFI
 */
public class Persistencia {
    
    private BaseDatos base = BaseDatos.getInstancia();
    private static Persistencia instancia = new Persistencia();

    public static Persistencia getInstancia() {
        return instancia;
    }
    private Persistencia() {
    }
    
    public int proximoOid(){
        try {
            String sql = "SELECT ultimo from oid";
            ResultSet rs = base.consultar(sql);
            if(!rs.next()){
                System.out.println("NO ESTA INICIALIZADO EL OID");
                return -1;
            }
            int ultimo = rs.getInt("ultimo");
            sql = "UPDATE oid set ultimo =" + (++ultimo) ;
            base.modificar(sql);
            return ultimo;
        } catch (SQLException ex) {
            System.out.println("Error al generar proximo oid:" + ex.getMessage());
            return -1;
        }
    }
    
    public void guardar(DataMapper o){
        if(o.getOid()==0){
            insertar(o);
        }else actualizar(o);
    }

    private void insertar(DataMapper o) {
        int oid = proximoOid();
        o.setOid(oid);
        ArrayList<String> sqls = o.getSqlInsertar();
        if(!base.transaccion(sqls)){
          o.setOid(0);
          System.out.println("Error al insertar el objeto");
        }
    }

    private void actualizar(DataMapper o) {
        ArrayList<String> sqls = o.getSqlActualizar();
        if(!base.transaccion(sqls)){
            System.out.println("Error al actualizar el objeto: " + o.getOid());
        }
    }
    public void borrar(DataMapper o){
        ArrayList<String> sqls = o.getSqlBorrar();
        if(base.transaccion(sqls)){
            o.setOid(0);
        }else{
            System.out.println("Error al borrar el objeto:" + o.getOid());
        }
    }
    public ArrayList obtenerTodos(DataMapper map){
        return buscar(map,null);
    }
    public ArrayList buscar(DataMapper map,String filtro){ //el filtro es el where
        
        String sql = map.getSqlSeleccionar();
        if(filtro!=null){
            sql+=" where " + filtro; //SOLO ANDA PARA SIMPLES
        }
        ResultSet rs = base.consultar(sql);
        ArrayList lista = new ArrayList();
        try {
            int oidActual, oidUltimoCambio = -1;
            while(rs.next()){
                oidActual = rs.getInt("object_id");//el campo se tiene que llamar oid 
                if(oidActual!=oidUltimoCambio){ //Debe estar seleccionado ordenado por oid
                    map.crearNuevo();
                    map.setOid(oidActual); 
                    Object obj = map.getObjeto();
                    lista.add(obj);
                    oidUltimoCambio = oidActual;
                    map.leerCompuesto(rs);
                }
                map.leerComponente(rs);
                
                
            }
            System.out.println(lista);
            return lista;
        } catch (SQLException ex) {
            System.out.println("Error al buscar: " + ex.getMessage());
            return null;
        }
        
    }
    
    
    
}
