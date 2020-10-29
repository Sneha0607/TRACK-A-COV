/*package softablitz;

import java.sql.*;

public class NotificationsSQL {
    static final String driver = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/";
    static final String user = "root";
    static final String pass = "Sneha@0607";

    public void NotificationsSQL() {
        NotificationsAPI notificationsAPI = new NotificationsAPI();
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();
            statement.executeUpdate("USE COVIDDATABASE");
            statement.executeUpdate("TRUNCATE TABLE NOTIFICATIONS");
            Notifications notifications = notificationsAPI.NotificationsAPI();
            for(Notifications.LatestData.NotificationsData notificationsData : notifications.data.notifications) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO NOTIFICATIONS VALUES (?,?)");
                preparedStatement.setString(1, notificationsData.getTitle());
                preparedStatement.setString(2, notificationsData.getLink());
                preparedStatement.executeUpdate();
            }


        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

    }
}
*/