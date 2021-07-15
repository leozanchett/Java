package entidades;

public class Veiculo {
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    private String model;

    public Veiculo(){

    }
    public Veiculo(String model) {
        this.model = model;
    }
}
