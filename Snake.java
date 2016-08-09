import java.util.ArrayList;
/**
 * @Francisco
 */
class Snake {
    private ArrayList<Segment> segmentos;
    public static final int LARGO_LIENZO = 500;
    public static final int ALTO_LIENZO = 500;

    public Snake() {
        segmentos = new ArrayList<>();
    }
    
    /**
     * devuelve true si el segmento colisiona con los bordes.
     */
    public boolean colisionBordes(Segment segmento){
        return ((segmento.getPosiX() == 0) || (segmento.getPosiX() == LARGO_LIENZO)) ||
                ((segmento.getPosiY() == 0) || (segmento.getPosiY() == ALTO_LIENZO));              
    }
  
    /**
     * devuelve si el segmento coliona con otros segmentos.
     */
    public boolean colisionConSegmentos(Segment segmento){
        boolean colision = false;
        for(Segment segment: segmentos){
            if(segment.colisionaCon(segmento)){
               colision = true;
            }
        }
        return colision;
    }
    
    /**
     * devuelve true si el segmento es válido para añadirse.
     */
    public boolean segmentValido(Segment segmento){
        return !colisionBordes(segmento) && !colisionBordes(segmento);
    }
}