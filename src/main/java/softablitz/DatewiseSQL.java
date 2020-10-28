package softablitz;

import java.sql.*;

public class DatewiseSQL {
    static final String driver = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/";
    static final String user = "root";
    static final String pass = "Sneha@0607";

    public static void DatewiseSQL() {
        DatewiseAPI datewiseAPI = new DatewiseAPI();
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
            statement = connection.createStatement();
            statement.executeUpdate("USE COVIDDATABASE");
            statement.executeUpdate("TRUNCATE TABLE DATEWISESUMMARY");
            Datewise datewise = datewiseAPI.DatewiseAPI();
            for(Datewise.DatewiseData national : datewise.data) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DATEWISESUMMARY VALUES (?,?,?,?,?,?,?)");
                preparedStatement.setString(1, national.getDay());
                preparedStatement.setInt(2, national.summary.getTotal());
                preparedStatement.setInt(3, national.summary.getConfirmedCasesIndian());
                preparedStatement.setInt(4, national.summary.getConfirmedCasesForeign());
                preparedStatement.setInt(5, national.summary.getDischarged());
                preparedStatement.setInt(6, national.summary.getDeaths());
                preparedStatement.setInt(7, national.summary.getConfirmedButLocationUnidentified());
                preparedStatement.executeUpdate();
            }

            /*
            statement.executeUpdate("TRUNCATE TABLE DATEWISEREGIONAL");
            for(Datewise.DatewiseData.RegionDatewise regionDatewise : Datewise.DatewiseData.regional) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DATEWISEREGIONAL VALUES (?,?,?,?,?,?)");
                preparedStatement.setString(1, regionDatewise.getLoc());
                preparedStatement.setInt(2, regionDatewise.getConfirmedCasesIndian());
                preparedStatement.setInt(3, regionDatewise.getConfirmedCasesForeign());
                preparedStatement.setInt(4, regionDatewise.getDischarged());
                preparedStatement.setInt(5, regionDatewise.getDeaths());
                preparedStatement.setInt(6, regionDatewise.getTotalConfirmed());
                preparedStatement.executeUpdate();
            }

            */

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
