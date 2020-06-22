package modelo;

public class TipoApuestaSimple extends TipoApuesta{

    @Override
    public void ganoApuesta(float dividendo, UsuarioJugador usuario, Apuesta apuesta, Carrera carrera) {
        float montoGanado = apuesta.getMonto() * dividendo;
        usuario.aumentarSaldo(montoGanado);
    }

    @Override
    public void perdioApuesta(float dividendo, UsuarioJugador usuario, Apuesta apuesta, Carrera carrera) {
        usuario.decrementarSaldo(apuesta.getMonto());
    }
    
}
