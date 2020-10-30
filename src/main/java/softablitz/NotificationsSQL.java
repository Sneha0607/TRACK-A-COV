package softablitz;

import java.sql.*;

public class NotificationsSQL {

    public static void NotificationsSQL() {
        NotificationsAPI notificationsAPI = new NotificationsAPI();
        Connection connection = SQLConnection.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE TABLE NOTIFICATIONS");

            Notifications notifications = notificationsAPI.NotificationsAPI();

            for (Notifications.LatestData.NotificationsData notification : notifications.data.notificationsData) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO NOTIFICATIONS VALUES (?,?)");
                preparedStatement.setString(1, notification.getTitle());
                preparedStatement.setString(2, notification.getLink());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(statement!=null){
                    statement.close();
                }
            }catch (SQLException e1){
                e1.printStackTrace();
            }
            try{
                if(connection!=null){
                    connection.close();
                }
            }catch(SQLException e2){
                e2.printStackTrace();
            }
        }
    }
}
