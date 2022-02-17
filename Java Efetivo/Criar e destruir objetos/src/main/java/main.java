import classes.*;

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

        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL).addToping(Pizza.Topping.SAUSAGE).addToping(Pizza.Topping.ONION).build();
        Calzone calzone = new Calzone.Builder().addToping(Pizza.Topping.HAM).sauceInside().build();
    }
}
