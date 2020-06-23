package modelo;

public class TipoApuestaTriple extends TipoApuesta{
    /*
        Para el tipo de apuesta Triple, se descontará del saldo del jugador lo apostado multiplicado por 1.5 y en caso de ganar 
        pagará monto apostado * el dividendo del caballo * 2, si el monto total apostado por todos los jugadores para 
        ese caballo en esa carrera es menor a 100.000,  y monto apostado * el dividendo del caballo * 3 si es mayor o igual a 100.000. 
    */

    @Override
    public void ganoApuesta(float dividendo, UsuarioJugador usuario, Apuesta apuesta, Carrera carrera) {
        float montoTotalApostado = carrera.getMontoTotalApostado(apuesta.getCaballo());
        int multiplier = montoTotalApostado >= 100000 ? 3 : 2;      
        float ganancia = apuesta.getMonto() * dividendo * multiplier;
        usuario.aumentarSaldo(ganancia);        
    }

    @Override
    public void perdioApuesta(float dividendo, UsuarioJugador usuario, Apuesta apuesta, Carrera carrera) {
        float descuento = apuesta.getMonto() * 1.5f;
        usuario.decrementarSaldo(descuento);
    }
    
}
