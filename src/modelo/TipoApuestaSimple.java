package modelo;

public class TipoApuestaSimple extends TipoApuesta{

    @Override
    public float ganoApuesta(float dividendo, Apuesta apuesta, Carrera carrera) {
        float montoGanado = apuesta.getMonto() * dividendo;
        return montoGanado;
        
    }

    @Override
    public float perdioApuesta(float dividendo, Apuesta apuesta, Carrera carrera) {
        return apuesta.getMonto();
    }
    
}
