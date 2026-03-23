import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SubscriptionDAO dao = new SubscriptionDAO();

        while (true) {

            System.out.println("\n===== Subscription Management MENU =====");
            System.out.println("1. Add Subscription");
            System.out.println("2. View All Subscription");
            System.out.println("3. View Subscription by ID");
            System.out.println("4. Update Subscription");
            System.out.println("5. Delete Subscription");
            System.out.println("6. Renew Subscription");
            System.out.println("7. Activate/Deactivate Subscription");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Plan: ");
                    String plan = sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Months: ");
                    int months = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Status: ");
                    String status= sc.nextLine();

                    dao.addSubscription(new Subscription(name, plan, price, months, status));
                    break;

                case 2:
                    dao.getAllSubscription();
                    break;

                case 3:
                    System.out.print("Enter sub_ID: ");
                    dao.getSubscriptionById(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter  ID: ");
                    int id = sc.nextInt();

                    System.out.print("New Plan: ");
                    String newPlan = sc.nextLine();
                    sc.nextLine();
                    System.out.print("New months: ");
                    int newMonths= sc.nextInt();
                    sc.nextLine();

                    
                    dao.updateSubscription(id, newPlan, newMonths);
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    dao.deleteSubscription(sc.nextInt());
                    break;

                case 6:
                    System.out.print("Enter Product ID: ");
                    int rid = sc.nextInt();

                    System.out.print("Renew Subscription: ");
                    int rsub = sc.nextInt();

                    dao.renewSubscription(rid, rsub);
                    break;

                case 7:
                    System.out.print("Enter Sub_ID: ");
                    int sid = sc.nextInt();

                    System.out.print("Activate/Deactivate Subscription: ");
                    int sub = sc.nextInt();

                    dao.adSubscription(sid, sub);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
