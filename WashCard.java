public class WashCard {

    int cardId, balance;
    String cardHolder;

    public WashCard(int Id, String cardHolder, int balance) {
        this.cardId = Id;
        this.cardHolder = cardHolder;
        this.balance = balance;
    }

    public int cardId() {
        return cardId;
    }

    public String cardHolder() {
        return cardHolder;
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int amount) {
        balance = balance + amount;
    }
    
    public void minusBalance(int amount){
        balance = balance - amount;
    }
    

}


