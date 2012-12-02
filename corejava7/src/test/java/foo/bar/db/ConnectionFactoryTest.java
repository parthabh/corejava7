package foo.bar.db;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.Rule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionFactoryTest {
	private final static Logger logger = LoggerFactory
			.getLogger(ConnectionFactoryTest.class);

	@Rule
	public ContiPerfRule i = new ContiPerfRule();

	@Test
	@PerfTest(invocations = 100, threads = 2)
	@Required(max = 150, average = 100)
	public void test() throws SQLException {
		Connection connection = ConnectionFactory.getOracleConnection("XE",
				"foobar", "foobar");
		assertNotNull(connection);
		connection.close();
	}
}
