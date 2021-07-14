package classes;

public class SavingAccount extends Account {
    private Double interestRate;

    public SavingAccount() {
        super();
    }

    public SavingAccount(Integer number, String holder, double balance, double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    // final não permite que o método seja sobreposto.
    // public final void withDraw(double amount) {
    public final void withDraw(double amount) {
        //super.withDraw(amount); // chama o método da classe pai.
        balance -= amount;
    }

    public void updateBalance() {
        balance += balance * interestRate;
    }
}
