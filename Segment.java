import java.awt.Color;
import java.util.Random;

/**
 *
 * @author Usuario
 */
class Segment {
    //atributos para la clase.
    private int posiX;
    private int posiY;
    public static final int LONG_SEGMENTO = 15;
    private int direccion;
    private Color color;
    
    private Random aleatorio;
    
    //Constructor que inicializa para inicializar atributos.

    public Segment(int posiX, int posiY, int direccion) {
        this.posiX = posiX;
        this.posiY = posiY;
        this.direccion = (direccion != 0 && direccion != 90 && 
                direccion != 180 && direccion != 270 ) ? 180 : direccion;
        aleatorio = new Random();
        color = new Color(aleatorio.nextInt(225), aleatorio.nextInt(225),
                            aleatorio.nextInt(225));
    }
    
    
    
}