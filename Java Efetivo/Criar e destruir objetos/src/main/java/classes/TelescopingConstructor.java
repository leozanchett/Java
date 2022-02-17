package classes;

// padrão telescoping constructor -- não é escalável.
public class TelescopingConstructor {
    private final int servingSize;  // exigido
    private final int servings;     // exigido
    private final int calories;     // opcional
    private final int fat;          // opcional
    private final int sodium;       // opcional
    private final int carbohydrate; // opcional


    public TelescopingConstructor(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public TelescopingConstructor(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public TelescopingConstructor(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public TelescopingConstructor(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public TelescopingConstructor(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}
