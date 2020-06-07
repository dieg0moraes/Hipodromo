package gui.controllers;

import exceptions.NewCarreraException;
import gui.controllers.intefaces.INuevaCarrera;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Carrera;
import modelo.Fachada;
import modelo.Hipodromo;

public class NuevaCarreraController {
    private INuevaCarrera view;
    private Fachada fachada = Fachada.getInstancia();
    private Hipodromo hipodromo;
    
    public NuevaCarreraController(INuevaCarrera view, Hipodromo hipodromo ){
        this.view = view;
        this.hipodromo = hipodromo;
    }
    
    public Carrera crearCarrera(String nombre, String dateStr){
        Carrera carrera = null;
        Date date = null;  
        try {
            if(dateStr != null && !dateStr.isEmpty()){
                date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
            }else date = new Date();
            carrera = this.hipodromo.crearCarrera(date, nombre);
        }catch(ParseException | NewCarreraException ex){
            this.view.error(ex.getMessage());
        } 
            
        return carrera;
    }
    
}
