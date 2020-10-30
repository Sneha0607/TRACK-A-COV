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

/*
Priyansh, [30.10.20 23:21]
package softablitz;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatewiseSQL {
    static class PooledDataSource {
        private static BasicDataSource basicDS;
        {
            try {
                basicDS = new BasicDataSource();
                Properties properties = new Properties();
                // Loading properties file
                InputStream inputStream = new FileInputStream("resources/db.properties");
                properties.load(inputStream);
                basicDS.setDriverClassName(properties.getProperty("com.mysql.jdbc.Driver")); //loads the jdbc driver
                basicDS.setUrl(properties.getProperty("jdbc:mysql://localhost/"));
                basicDS.setUsername(properties.getProperty("root"));
                basicDS.setPassword(properties.getProperty("kame"));
                // Parameters for connection pooling
                basicDS.setInitialSize(10);
                basicDS.setMaxTotal(10);

            }catch(IOException e) {
                e.printStackTrace();
            }
        }

        public static DataSource getDataSource() {
            return basicDS;
        }
    }
    public void DatewiseSQL() throws IOException, InterruptedException, NamingException {


        Connection connection = null;
        try{
            DataSource dataSource = PooledDataSource.getDataSource();
            connection = dataSource.getConnection();
        Statement statement = null;
        DatewiseAPI datewiseAPI = new DatewiseAPI();
        Datewise datewise = datewiseAPI.DatewiseAPI();

            statement = connection.createStatement();
            for(Datewise.NationalData nationalData: datewise.nationalData){
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Datewisenational VALUES(?,?,?,?)");
                preparedStatement.setString(1, nationalData.getDateymd());
                preparedStatement.setString(2, nationalData.getDailyconfirmed());
                preparedStatement.setString(3, nationalData.getDailyrecovered());
                preparedStatement.setString(4, nationalData.getDailydeceased());

                preparedStatement.executeUpdate();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
 */
