package ca.mv.projet;

public class Utilities {
    public static final double TAILLE_TUILE = 60;
    public static final double TAILLE_GRID_PANE = 480;
    public static final double SCENE_WIDTH = 1000;
    public static final double SCENE_HIEGHT = 800;
    public static final int NB_CASES_COTE = 8;
    public static final int DERNIERE_POS = NB_CASES_COTE - 1;
    public static final int PREMIERE_POS = 0;
    public static final String APP_TITLE = "Échecs";
    public static String j1_name = "blanc";
    public static String j2_name = "noir";

    public static int convertirPixelEnPos(double pixels) {
        return (int) Math.floor(pixels / TAILLE_TUILE);
    }
}
