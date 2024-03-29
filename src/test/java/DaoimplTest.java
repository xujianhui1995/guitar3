
/*
 * This Java source file was generated by the Gradle 'init' task.
 */
import org.junit.Test;

import guitar.dao.InventoryDao;
import guitar.dao.InventoryDaoFactory;
import guitar.dao.impl.InventoryDaoimpl;
import guitar.dao.impl.InventoryDaoimplSqlite;
import guitar.domain.*;
import util.JDBC;

import static org.junit.Assert.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoimplTest {
	private String sql;
	private PreparedStatement pstmt;

	@Test
	public void add() {
		Guitar guitar = new Guitar("123", 1499.95, new GuitarSpec("ddd", "ddd", "ddd", 12, "ddd", "ddd"));
		InventoryDao InventoryDao = new InventoryDaoimplSqlite();
		InventoryDao.add(guitar);
	}

	@Test
	public void del() {
		InventoryDao InventoryDao = new InventoryDaoimplSqlite();
		System.out.println(InventoryDao.del("123"));
	}

	@Test
	public void getGuitarLinkedList() {
		sql = "select * from guitar;";
		List<Guitar> guitars = new LinkedList<Guitar>();
		try {
			pstmt = JDBC.getMysqlConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String serialNumber = rs.getString("serialNumber");
				Double price = rs.getDouble("price");
				String builder = rs.getString("builder");
				String model = rs.getString("model");
				String type = rs.getString("type");
				int numStrings = rs.getInt("numStrings");
				String backWood = rs.getString("backWood");
				String topWood = rs.getString("topWood");
				Guitar guitar = new Guitar(serialNumber, price,
						new GuitarSpec(builder, model, type, numStrings, backWood, topWood));
				guitars.add(guitar);

			}
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(guitars.get(0).getSerialNumber());

	}

	@Test
	public void getGuitarLinkedList2() {
		InventoryDaoimplSqlite gsp = new InventoryDaoimplSqlite();
		System.out.println(gsp.getGuitarLinkedList().get(0).getSerialNumber());
	}

	@Test
	public void Search() {
		Guitar searchGuitar = new Guitar("11277", 1499.95,
				new GuitarSpec("Collings", "CJ", "acoustic", 12, "Indian Rosewood", "Sitka"));
		InventoryDao InventoryDao = InventoryDaoFactory.getInstance().getInventoryDao();
		System.out.println(InventoryDao.Search(searchGuitar).get(0).getSerialNumber());

	}

}
