package foo.bar.db;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionFactoryTest {
	private final static Logger logger = LoggerFactory
			.getLogger(ConnectionFactoryTest.class);

	@Test
	public void test() throws SQLException {
		Connection connection = ConnectionFactory.getOracleConnection("XE",
				"foobar", "foobar");
		assertNotNull(connection);
		connection.close();
	}

}
