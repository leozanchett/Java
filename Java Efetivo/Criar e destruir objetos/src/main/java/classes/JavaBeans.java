package classes;

// Permite a inconsistência, autoriza a imutabilidade
public class JavaBeans {
    private int servingSize;
    private int servings;
    private int calories;
    private int fat;
    private int sodium;
    private int carbohydrate;

    public JavaBeans() {

    }

    public void setServingSize(int val) {
        servingSize = val;
    }

    public void setServings(int val) {
        servings = val;
    }

    public void getCalories(int val) {
        calories = val;
    }

    public void getFat(int val) {
        fat = val;
    }

    public void getSodium(int val) {
        sodium = val;
    }

    public void getCarbohydrate(int val) {
        carbohydrate = val;
    }
}
