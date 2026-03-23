import java.sql.*;

public class SubscriptionDAO {

    // ADD PRODUCT
    public void addSubscription(Subscription p) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO Subscription(name,plan,price,months,status) VALUES(?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, p.name);
            ps.setString(2, p.plan);
            ps.setDouble(3, p.price);
            ps.setInt(4, p.months);
            ps.setString(5, p.status);
            
            ps.executeUpdate();

            System.out.println("Subscription Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ ALL
    public void getAllSubscription() {

        try {
            Connection conn = DBConnection.getConnection();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Subscription");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("sub_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("plan") + " | " +
                        rs.getDouble("price") + " | " +
                        rs.getInt("months") + " | " +
                        rs.getString("status")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ BY ID
    public void getSubscriptionById(int id) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM Subscription WHERE sub_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                        rs.getInt("sub_id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("plan") + " | " +
                        rs.getDouble("price") + " | " +
                        rs.getInt("months") + " | " +
                        rs.getString("status")
                );
            } else {
                System.out.println("Subscription Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public void updateSubscription(int id, String plan, int months) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE Subscription SET plan=?, months=? WHERE sub_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, plan);
            ps.setInt(2, months);
            ps.setInt(3, id);

            ps.executeUpdate();

            System.out.println("Subscription Updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void deleteSubscription(int Sub_id) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "DELETE FROM Subscription WHERE Sub_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Sub_id);

            ps.executeUpdate();

            System.out.println("Subscription Deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // PURCHASE PRODUCT (DECREASE STOCK)
    public void adSubscription(int id, int sub) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE Subscription SET plan = plan- ? WHERE sub_id=? AND plan>= ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, sub);
            ps.setInt(2, id);
            ps.setInt(3, sub);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Subscription Activated");
            else
                System.out.println("Subscription Deactivated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // RESTOCK PRODUCT (INCREASE STOCK)
    public void renewSubscription(int id, int sub) {

        try {
            Connection conn = DBConnection.getConnection();

            String sql = "UPDATE  Subscription SET plan = plan+ ? WHERE sub_id=?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, sub);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Subscription Renewed");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
