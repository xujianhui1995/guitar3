package guitar.action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import guitar.dao.impl.InventoryDaoimplSqlite;
import guitar.domain.Guitar;
import guitar.domain.GuitarSpec;
import guitar.service.InventoryService;
import guitar.service.impl.InventoryServiceimpl;

public class Inventory extends ActionSupport {
	private String serialNumber, builder, model, type, backWood, topWood;
	private double price;
	private int numStrings;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getBuilder() {
		return builder;
	}

	public void setBuilder(String builder) {
		this.builder = builder;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBackWood() {
		return backWood;
	}

	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}

	public String getTopWood() {
		return topWood;
	}

	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNumStrings() {
		return numStrings;
	}

	public void setNumStrings(int numStrings) {
		this.numStrings = numStrings;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String search() {
		Guitar searchGuitar = new Guitar(serialNumber, price,
				new GuitarSpec(builder, model, type, numStrings, backWood, topWood));
		InventoryService GuitarService = new InventoryServiceimpl();
		GuitarService.Search(searchGuitar);
		ActionContext.getContext().put("guitar", GuitarService.Search(searchGuitar).get(0));
		return SUCCESS;

	}
	public String add() {
		Guitar guitar = new Guitar(serialNumber, price,
				new GuitarSpec(builder, model, type, numStrings, backWood, topWood));
		InventoryService GuitarService = new InventoryServiceimpl();
		GuitarService.add(guitar);
		return SUCCESS;

	}
	public String del() {
		InventoryService GuitarService = new InventoryServiceimpl();
		GuitarService.del(serialNumber);
		return SUCCESS;

	}

}
