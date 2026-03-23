public class Subscription {

    int sub_id;
    String name;
    String plan;
    double price;
    int months;
    String status;

    public Subscription(String name, String plan, double price, int months, String status) {
        this.name = name;
        this.plan= plan;
        this.price = price;
        this.months = months;
        this.status = status;
    }
}
