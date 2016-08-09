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
    
    /**
     * retorna la direccion del segmento: 0º se desplaza hacia la izquierda, 
     * 180º hacia la derecha, 90º hacia arriba, 270º hacia abajo.
     */
    public int getDireccion(){
        return direccion;
    }
    
    /**
     * serie de metodos getters que retornan las coordenadas del segmento.
     */
    public int getPosiX(){
        return posiX;
    }
    public int getPosiY(){
        return posiY;
    }
    public int getPosiFinalX(){
    int finalX = posiX;
    if(direccion == 0){
        finalX += LONG_SEGMENTO;
    }
    else if(direccion == 180){
        finalX -= posiX;
    }
    return finalX;
    }
    public int getPosiFinalY(){
        int finalY = posiY;
        if(direccion == 90){
            finalY -= LONG_SEGMENTO;
        }
        else if(direccion == 270){
            finalY += LONG_SEGMENTO;
        }
        return finalY;
    }
    
    
}