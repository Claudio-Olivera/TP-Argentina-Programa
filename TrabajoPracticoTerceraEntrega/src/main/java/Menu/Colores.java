package Menu;

public class Colores {
    public static final String RESET = "\033[0m";
    public static final String NEGRO = "\033[30m";
    public static final String ROJO = "\033[31m";
    public static final String VERDE = "\033[32m";
    public static final String AMARILLO = "\033[33m";
    public static final String AZUL = "\033[34m";
    public static final String MORADO = "\033[35m";
    public static final String CIAN = "\033[36m";
    public static final String BLANCO = "\033[37m";

    public static final String NEGRO_BRILLANTE = "\033[90m";
    public static final String ROJO_BRILLANTE = "\033[91m";
    public static final String VERDE_BRILLANTE = "\033[92m";
    public static final String AMARILLO_BRILLANTE = "\033[93m";
    public static final String AZUL_BRILLANTE = "\033[94m";
    public static final String MORADO_BRILLANTE = "\033[95m";
    public static final String CIAN_BRILLANTE = "\033[96m";
    public static final String BLANCO_BRILLANTE = "\033[97m";

    public static String negro(String texto) {
        return NEGRO + texto + RESET;
    }

    public static String rojo(String texto) {
        return ROJO + texto + RESET;
    }

    public static String verde(String texto) {
        return VERDE + texto + RESET;
    }

    public static String amarillo(String texto) {
        return AMARILLO + texto + RESET;
    }

    public static String azul(String texto) {
        return AZUL + texto + RESET;
    }

    public static String morado(String texto) {
        return MORADO + texto + RESET;
    }

    public static String cian(String texto) {
        return CIAN + texto + RESET;
    }

    public static String negroBrillante(String texto) {
        return NEGRO_BRILLANTE + texto + RESET;
    }

    public static String rojoBrillante(String texto) {
        return ROJO_BRILLANTE + texto + RESET;
    }

    public static String verdeBrillante(String texto) {
        return VERDE_BRILLANTE + texto + RESET;
    }

    public static String amarilloBrillante(String texto) {
        return AMARILLO_BRILLANTE + texto + RESET;
    }

    public static String azulBrillante(String texto) {
        return AZUL_BRILLANTE + texto + RESET;
    }

    public static String moradoBrillante(String texto) {
        return MORADO_BRILLANTE + texto + RESET;
    }

    public static String cianBrillante(String texto) {
        return CIAN_BRILLANTE + texto + RESET;
    }

    public static String blancoBrillante(String texto) {
        return BLANCO_BRILLANTE + texto + RESET;
    }

    public static String blanco(String texto) {
        return BLANCO + texto + RESET;
    }
}


