package guitar.service.impl;

import java.util.List;

import guitar.dao.InventoryDao;
import guitar.dao.InventoryDaoFactory;
import guitar.dao.impl.InventoryDaoimplSqlite;
import guitar.domain.Guitar;
import guitar.domain.GuitarSpec;
import guitar.service.InventoryService;

public class InventoryServiceimpl implements InventoryService {
	private InventoryDao inventoryDao;

	public void setInventoryDao(InventoryDao inventoryDao) {
		this.inventoryDao = inventoryDao;
	}

	@Override
	public List<Guitar> Search(Guitar searchGuitar) {
		// TODO Auto-generated method stub
		InventoryDao InventoryDao = InventoryDaoFactory.getInstance().getInventoryDao();
		setInventoryDao(InventoryDao);
		return inventoryDao.Search(searchGuitar);
	}

	@Override
	public boolean add(Guitar guitar) {
		// TODO Auto-generated method stub
		InventoryDao InventoryDao = InventoryDaoFactory.getInstance().getInventoryDao();
		setInventoryDao(InventoryDao);
		return inventoryDao.add(guitar);
	}

	@Override
	public boolean del(String serialNumber) {
		// TODO Auto-generated method stub
		InventoryDao InventoryDao = InventoryDaoFactory.getInstance().getInventoryDao();
		setInventoryDao(InventoryDao);
		return inventoryDao.del(serialNumber);
	}

}
