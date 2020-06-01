package org.codeaction.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class JdbcUtils {
    private static DataSource dataSource;
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    //获取连接池对象
    public static DataSource getDataSource() {
          return dataSource;
    }

	@Autowired
	public void setDataSource(DataSource dataSource) {
		JdbcUtils.dataSource = dataSource;
	}

	//获取连接
    public static Connection getConnection() throws SQLException {
		System.out.println(dataSource);
    	Connection conn = tl.get();
    	if(conn == null) {
    		return dataSource.getConnection();
    	}
    	return conn;
    }
    //开启事务
    public static void beginTransaction() throws SQLException {
    	Connection conn = tl.get();
		if(conn != null) {
			throw new SQLException("已经开启事务，不能重复开启");
		}
		conn = getConnection();
		conn.setAutoCommit(false);
		tl.set(conn);
	}
    //提交事务
    public static void commitTransaction() throws SQLException {
    	Connection conn = tl.get();
		if(conn == null) {
			throw new SQLException("连接为空，不能提交事务");
		}
		conn.commit();
		conn.close();
		tl.remove();
	}
    //回滚事务
    public static void rollbackTransaction() throws SQLException {
		Connection conn = tl.get();
		if (conn == null) {
			throw new SQLException("连接为空，不能回滚事务");
		}
		conn.rollback();
		conn.close();
		tl.remove();
	}
}
