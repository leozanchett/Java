package models;

public class ImportedProduct extends Product{
    private final double customFee;

    public ImportedProduct(String name, double price, double customFee) {
        super(name, price);
        this.customFee = customFee;
    }

    @Override
    public String priceTag() {
        return "(Custom fee: "+customFee+" )";
    }

    public double totalPrice(){
        return customFee + price;
    }

}
