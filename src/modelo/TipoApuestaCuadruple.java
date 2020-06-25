package modelo;

public class TipoApuestaCuadruple extends TipoApuesta{
    /*  
    Para el tipo de apuesta Cuádruple, 
    se descontará del saldo del jugador lo apostado multiplicado por 2 y 
    en caso de ganar pagará monto apostado * el dividendo del caballo * 3 si dividendo del caballo es mayor o igual a  2 
    y monto apostado * el dividendo del caballo * 4 si es menor.
    
    */    

    @Override
    public float ganoApuesta(float dividendo, Apuesta apuesta, Carrera carrera) {
        int multiplier = dividendo >= 2 ? 3 : 4;
        float monto = apuesta.getMonto() * dividendo * multiplier;
        return monto;
        
    }

    @Override
    public float perdioApuesta(float dividendo,Apuesta apuesta, Carrera carrera) {
        float descuento = apuesta.getMonto() * 2;
        return descuento;
    }
    
}
