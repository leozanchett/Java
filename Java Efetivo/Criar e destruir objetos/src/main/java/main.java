import classes.JavaBeans;
import classes.PadraoBuilder;
import classes.TelescopingConstructor;

public class main {


    public static void main(String[] args) {
        TelescopingConstructor telescopingConstructor = new TelescopingConstructor(240, 8, 100, 0, 35, 27);
        // ----------------------------------------
        JavaBeans javaBeans = new JavaBeans();
        // settings
        javaBeans.setServings(240);
        javaBeans.setServings(8);
        // ----------------------------------------
        PadraoBuilder padraoBuilder = new PadraoBuilder.Builder(240, 8).calories(100).sodium(35).carbohydrate(27).build();
    }
}
