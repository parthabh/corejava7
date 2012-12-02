package foo.bar.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ConnectionFactory {
	private final static Logger logger = LoggerFactory.getLogger(ConnectionFactory.class);

	public static Connection getOracleConnection(String db, String username, String password) {
		Connection connection = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			logger.debug("Connecting to the database...");
			connection = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:"+db,
							username, password);
			Statement statement = connection.createStatement();
			ResultSet resultset = statement
					.executeQuery("select 'Connected' from dual");
			resultset.next();
			String s = resultset.getString(1);
			logger.debug(s);
			statement.close();
		} catch (Exception e) {
			System.out.println("The exception raised is:" + e);
		}
		return connection;
	}

}
