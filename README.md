# guitar3

guitar工厂类：

    public class InventoryDaoFactory {

	private static InventoryDao inventoryDao = null;// 注意此句必须放在实例化工厂类的语句之前，否者会在运行时被置为null
	private static InventoryDaoFactory inventoryDaoFactory = new InventoryDaoFactory();

	private InventoryDaoFactory() {
		Properties properties = new Properties();
		InputStream inStream = InventoryDaoFactory.class.getClassLoader()
			     .getResourceAsStream("daoConfig.properties");
		try {
			properties.load(inStream);
			String userDaoImpl = properties.getProperty("InventoryDao");
			inventoryDao = (InventoryDao) Class.forName(userDaoImpl).newInstance();
		} catch (Throwable e) {
			throw new ExceptionInInitializerError(e);// 此问题非常严重
		} finally {
			try {
				inStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static InventoryDaoFactory getInstance() {
		return inventoryDaoFactory;
	}

	public InventoryDao getInventoryDao() {
		return inventoryDao;
	}
  

查询界面：



查询结果：

删除结果：

更换数据库：修改配置文件


