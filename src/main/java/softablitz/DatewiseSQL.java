package softablitz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatewiseSQL {
    public static void DatewiseSQL() {
        DatewiseAPI datewiseAPI = new DatewiseAPI();
        Connection connection = SQLConnection.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("TRUNCATE TABLE DATEWISESUMMARY");

            Datewise datewise = datewiseAPI.DatewiseAPI();

            for(Datewise.NationalData nationalData : datewise.case_time_series) {
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `DATEWISESUMMARY` VALUES (?,?,?,?,?,?,?,?)");
                preparedStatement.setString(1, nationalData.getDailyconfirmed());
                preparedStatement.setString(2,nationalData.getDailydeceased());
                preparedStatement.setString(3,nationalData.getDailyrecovered());
                preparedStatement.setString(4,nationalData.getDate());
                preparedStatement.setString(5,nationalData.getDateymd());
                preparedStatement.setString(6,nationalData.getTotalconfirmed());
                preparedStatement.setString(7,nationalData.getTotaldeceased());
                preparedStatement.setString(8,nationalData.getTotalrecovered());
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

