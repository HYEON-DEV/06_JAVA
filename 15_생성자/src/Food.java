public class Food {
    private String name;
    private int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }    

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return String.format("Food { name: %s, price: %d원 }", this.getName(), this.getPrice() );
    }
}
