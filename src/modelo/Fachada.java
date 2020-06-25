package modelo;

import exceptions.AbrirCarreraException;
import exceptions.LoginException;
import exceptions.NewApuestaException;
import exceptions.NewCarreraException;
import exceptions.NewParticipacionException;
import java.util.ArrayList;
import java.util.Date;
import observer.Observable;

public class Fachada extends Observable{
    private static Fachada instancia;
    private SistemaUsuarios sistemaUsuarios;
    private SistemaHipodromos sistemaHipodromos;
    private SistemaCaballos sistemaCaballos;
    private SistemaApuestas sistemaApuestas;
    
    private Fachada(){
        this.sistemaUsuarios = new SistemaUsuarios();
        this.sistemaHipodromos = new SistemaHipodromos();
        this.sistemaCaballos = new SistemaCaballos();
        this.sistemaApuestas = new SistemaApuestas();
    }
    
    public SistemaApuestas getSistemaApuestas(){
        return this.sistemaApuestas;
    }

    public UsuarioJugador buscarJugadorById(int oid){
        return sistemaUsuarios.buscarJugadorById(oid);
    }    
    
    public Apuesta getUltimaApuesta(String usuario, String password) throws LoginException {
        return this.sistemaApuestas.getUltimaApuesta(usuario, password);
    }
    
    public Hipodromo getHipodromoDeCarrera(Carrera carrera){
        return this.sistemaHipodromos.getHipodromoDeCarrera(carrera);
    }
    
    public void cargarApuestas() {
        this.sistemaApuestas.cargarApuestas();
    }
    
    public enum Eventos{
        NUEVA_APUESTA
        
    }    
    
    public Caballo buscarCaballosById(int oid){
        return this.sistemaCaballos.buscarCaballoById(oid);
    } 
    
    public Participacion buscarParticipacionById(int oid){
        return this.sistemaHipodromos.buscarParticipacionById(oid);
    }
        
    public Carrera buscarCarreraById(int oid){
        return this.sistemaHipodromos.buscarCarreraById(oid);
    }
    
    public Jornada buscarJornadaById(int oid){
        return this.sistemaHipodromos.buscarJornadaById(oid);
    }
    
    public Apuesta buscarApuestaById(int oid){
        return this.sistemaApuestas.buscarApuestaById(oid);
    }
    
    public TipoApuesta buscarTipoApuestaById(int oid){
        return this.sistemaApuestas.buscarTipoApuestaById(oid);
    }
    
    public static Fachada getInstancia(){
        if(instancia == null){
            instancia = new Fachada();
        }
        return instancia;
    }
    
    public UsuarioAdmin loginAdmin(UsuarioAdmin user) 
            throws LoginException{
        return sistemaUsuarios.loginAdmin(user);
    }
    
    public UsuarioJugador loginJugador(UsuarioJugador usuario) 
            throws LoginException{
        return sistemaUsuarios.loginJugador(usuario);
    }
    
    public boolean agregarUsuarioJugador(UsuarioJugador usuario){
        return sistemaUsuarios.agregarUsuario(usuario);
    }
    
    public boolean agregarUsuarioAdmin(UsuarioAdmin usuario){
        return sistemaUsuarios.agregarUsuario(usuario);
    }
    
    public boolean agregarHipodromo(Hipodromo hipodromo){
        return this.sistemaHipodromos.agregarHipodromo(hipodromo);
    }
    
    public ArrayList<Hipodromo> getHipodromos(){
        return this.sistemaHipodromos.getHipodromos();
    }
    
    public Hipodromo getHipodromoByName(String nombre){
        return sistemaHipodromos.getHipodromoByName(nombre);
    }
    
    public boolean agregarCarrera(Carrera carrera, Hipodromo hipodromo) 
            throws NewCarreraException, NewParticipacionException{
        return this.sistemaHipodromos.agregarCarrera(carrera, hipodromo);
    }
    
    public ArrayList<Caballo> getCaballosDisponibles(Carrera carrera){
        return this.sistemaCaballos.getCaballosDisponibles(carrera);
    }
    
    public boolean agregarCaballo(Caballo caballo){
        return this.sistemaCaballos.agregarCaballo(caballo);
    }
    
    public boolean siCorreCaballo(Caballo caballo, Date date){
        return this.sistemaHipodromos.siCorreCaballo(caballo, date);
    } 

    public Jornada getJornadaDe(Hipodromo hipodromo, Date date) {
        return sistemaHipodromos.getJornadaDe(hipodromo, date);
    }
    
    public Carrera getNextCarrera(Hipodromo hipodromo) throws AbrirCarreraException{
        return this.sistemaHipodromos.getNextCarrera(hipodromo);
    }
    
    public Carrera crearCarrera(Date date, String nombre, Hipodromo hipodromo) 
            throws NewCarreraException, NewParticipacionException{
        return this.sistemaHipodromos.crearCarrera(date, nombre, hipodromo);
    }

    public boolean realizarApuesta(Apuesta apuesta) 
            throws NewApuestaException, LoginException{
        return this.sistemaApuestas.realizarApuesta(apuesta);
    }

    
    public void cargarHipodromos(){
        this.sistemaHipodromos.cargarHipodromos();
    }
    
    public void cargarCaballos(){
        this.sistemaCaballos.cargarCaballos();
    }
    
     public void cargarUsuarios(){
        this.sistemaUsuarios.cargarUsuarios();
    }
     
    public void cargarParticipaciones(){
         this.sistemaHipodromos.cargarParticipaciones();
    }
    
    public void cargarCarreras(){
        this.sistemaHipodromos.cargarCarreras();
    }
    
    public void cargarJornadas(){
        this.sistemaHipodromos.cargarJornadas();
    }
    
    public void cargarTipoApuestas(){
        this.sistemaApuestas.cargarTipoApuestas();
    }
    
    public ArrayList<Apuesta> getApuestasDeCarrera(Carrera carrera){
        return this.sistemaApuestas.getApuestasDeCarrera(carrera);
    }
    
    public void finalizarCarrera(Carrera carrera, Participacion participacion){
        this.sistemaHipodromos.finalizarCarrera(carrera, participacion);
    }
    
    public float getMontoTotalApostado(Carrera carrera, Caballo caballo){
        return this.sistemaApuestas.getMontoTotalApostado(carrera, caballo);
    }
    
    public float getMontoTotalApostado(Carrera carrera){
        return this.sistemaApuestas.getMontoTotalApostado(carrera);
    }
    
    public ArrayList<Participacion> getParticipacionesModificables(Carrera carrera){
        return this.sistemaApuestas.getParticipacionesModificables(carrera);
    }
    
    public ArrayList<UsuarioJugador> getGanadores(Carrera carrera){
        return this.sistemaApuestas.getGanadores(carrera);
    } 
    
    public float getMontoTotalPagado(Carrera carrera){
        return this.sistemaApuestas.getMontoTotalPagado(carrera);
    }
    
}

