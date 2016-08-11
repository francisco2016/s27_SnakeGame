import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
/**
 * @Francisco
 */
class Snake {
    private ArrayList<Segment> segmentos;
    private int largoLienzo;
    private int altoLienzo;
    private Color color;
    public static final int BORDE = 20; //---- borde del lienzo
    public static final int VALOR_GRADOS = 90;//--- facilita la dirección del segmento.
    public static final int NUM_SEGMENT = 15;
    
    public Snake( int largoLienzo, int altoLienzo) {
        segmentos = new ArrayList<>();
        this.segmentos = segmentos;
        this.largoLienzo = largoLienzo;
        this.altoLienzo = altoLienzo;
        for(int i = 0; i < NUM_SEGMENT; i ++){
            addSegment();
        }
    }

     public boolean colisionaConLosBordes(Segment segment) {
        boolean colisiona = false;
        if ( (segment.getPosiFinalX() >= largoLienzo - BORDE) ||
        (segment.getPosiFinalY() >= altoLienzo - BORDE) ||
        (segment.getPosiFinalX() <= BORDE) ||
        (segment.getPosiFinalY() <= BORDE))
        {
            colisiona = true;

        }
        return colisiona;
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
        return !colisionaConLosBordes(segmento) && !colisionConSegmentos(segmento);
    }

    /**
     * dibuja la serpiente. 
     */
    public void dibujar(Canvas lienzo){
        //teniendo en cuenta que la serpiente está formada por varios segmentos, creamos un bucle para
        //recorrer la colección de segmentos 
        for(Segment segment: segmentos){
            segment.dibujar(lienzo);
        }
        
    }

    /**
     * borra la serpiente.
     */
    public void borrar(Canvas lienzo){
        for(Segment segment: segmentos){
            segment.dibujar(lienzo);
        }
        
    }

    /**
     * mt para adiccionar un segmento a la serpiente.
     */
    public boolean addSegment(){

        boolean segmentAdd = false;
        // para adiccionar un segmento, 1º tenemos que saber si ya tenemos algún segmento en el lienzo, o no.
        // 2º saber si el segmento que vamos a adiccionar es válido o no lo es. 
        // 3º crear el objeto segmento con todos los parámetros que requiere su constructor y, añadirlo a la colección de Segmentos.
        Random aleatorio = new Random();
        //creo variables para las coordenadas del segmento.
        int posiX = aleatorio.nextInt(largoLienzo -(2* BORDE)) +BORDE;
        int posiY = aleatorio.nextInt(altoLienzo -(2* BORDE)) +BORDE;

        //teniendo en cuenta que ya puede haber segmentos en el lienzo, añado segmetos a los ya existentes.
        //para lo que necesitaré las coordenadas finales del último segmento.
        if(!segmentos.isEmpty()){ // si la colección no está vacía....
            posiX = segmentos.get(segmentos.size() -1).getPosiFinalX();
            posiY = segmentos.get(segmentos.size() -1).getPosiFinalY();
        }

        //otro de los parámetros necesarios para crear un segmento es la dirección. creo una colección de Integer
        //para poder elegir aleatoriamente la dirección que tendrá el segmento.
        ArrayList<Integer> direccion = new ArrayList<>();
        for(int i = 0; i < 4; i ++){
            direccion.add(i *VALOR_GRADOS);
        }

        //nos falta el parámetro color, para poder crear un objeto segmento.
        color = new Color(aleatorio.nextInt(225), aleatorio.nextInt(225), aleatorio.nextInt(225));

        Segment segment3 = null; //creo un nuevo objeto segmento, y compruebo si los parámetros que debe llevar y
        // que le puedo asignar de todos los que dispongo, son válidos.

        while(!segmentAdd && direccion.size() !=0){
            int direccion2 = direccion.remove(aleatorio.nextInt(direccion.size()));
            segment3 = new Segment(posiX, posiY, direccion2, color);
            segmentAdd = segmentValido(segment3);
        }

        if(segmentAdd){
            segmentos.add(segment3);
        }

        return segmentAdd;
    }
}

