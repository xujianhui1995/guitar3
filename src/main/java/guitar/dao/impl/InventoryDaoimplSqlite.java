package guitar.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import guitar.dao.InventoryDao;
import guitar.domain.Guitar;
import guitar.domain.GuitarSpec;
import util.JDBC;

public class InventoryDaoimplSqlite extends InventoryDaoimpl {
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return JDBC.getSqliteConnection();
	}
	
	

}
