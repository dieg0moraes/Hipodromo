package observer;

import java.util.ArrayList;

public class Observable {
    private ArrayList<Observador> observadores;
    
    public Observable(){
        this.observadores = new ArrayList<Observador>();
    }
    
    public void agregar(Observador observador){
        this.observadores.add(observador);
    }
    
    public void notificar(Object event){
        for(Observador o : this.observadores){
            o.actualizar(event, this);
        }
    }
    
    
}
