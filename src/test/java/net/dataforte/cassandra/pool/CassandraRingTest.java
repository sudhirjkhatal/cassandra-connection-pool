package net.dataforte.cassandra.pool;

import org.apache.cassandra.thrift.Cassandra.Client;
import org.junit.Ignore;

@Ignore
public class CassandraRingTest {

	public static final void main(String args[]) throws Exception {
		PoolConfiguration prop = new PoolProperties();
		prop.setHost("192.168.56.241");
		prop.setInitialSize(2);
		prop.setMinIdle(1);
		prop.setMaxIdle(4);
		prop.setMaxActive(4);
		prop.setRemoveAbandonedTimeout(3);
		prop.setLogAbandoned(true);
		prop.setJmxEnabled(true);
		prop.setAutomaticHostDiscovery(true);
		DataSource ds = new DataSource(prop);
		
		Client connection = ds.getConnection();
		Thread.sleep(1000);
		ds.releaseConnection(connection);
	
		Thread.sleep(6000);
		
		connection = ds.getConnection();
		Thread.sleep(1000);
		ds.releaseConnection(connection);
		
		Thread.sleep(6000);
		
		connection = ds.getConnection();
		Thread.sleep(1000);
		ds.releaseConnection(connection);
		
		Thread.sleep(6000);
		
		ds.close();
	}
}
