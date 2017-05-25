package guitar.dao;

import java.util.List;

import guitar.domain.Guitar;
import guitar.domain.GuitarSpec;

public interface InventoryDao {
	List<Guitar> Search(Guitar searchGuitar);	
	boolean add(Guitar guitar);
	boolean del(String serialNumber);

}
