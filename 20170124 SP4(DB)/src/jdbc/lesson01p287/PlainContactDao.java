package jdbc.lesson01p287;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlainContactDao implements ContactDao {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
			e.printStackTrace();
		}
		//createDB();
		//insertDataIntoDB();
	}

	private static void createDB() {
		Connection connection = null;
		try {
			connection = getConnection();
			Statement statement = connection.createStatement();
			statement.execute("CREATE TABLE CONTACT ("
					+ "ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT "
					+ "BY 1)"
					+ ", FIRST_NAME VARCHAR(60) NOT NULL"
					+ ", LAST_NAME VARCHAR(40) NOT NULL"
					+ ", BIRTH_DATE DATE"
					+ ", UNIQUE (FIRST_NAME, LAST_NAME)"
					+ ", PRIMARY KEY (ID)"
					+ ") ");
			statement.execute("CREATE TABLE CONTACT_TEL_DETAIL("
					+ "ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT "
					+ "BY 1)"
					+ ", CONTACT_ID INT NOT NULL"
					+ ", TEL_TYPE VARCHAR (20) NOT NULL"
					+ ", TEL_NUMBER VARCHAR (20) NOT NULL"
					+ ", UNIQUE (CONTACT_ID, TEL_TYPE)"
					+ ", PRIMARY KEY (ID)"
					+ ", CONSTRAINT FK_CONTACT_TEL_DETAIL_1 FOREIGN KEY (CONTACT_ID)"
					+ "REFERENCES CONTACT (ID)"
					+ ") ");
		} catch (SQLException e) {
			System.out.println("SQLException in createDB() method");
			e.printStackTrace();
		}finally {
			closeConnection(connection);
		}
	}
	
	private static void insertDataIntoDB() {
		Connection connection = null;
			try {
				connection = getConnection();
				Statement statement = connection.createStatement();
				statement.execute("insert into contact (FIRST_NAME, LAST_NAME, BIRTH_DATE)"
						+ "values ('Chris', 'Schaefer', '1981-05-03')");
				statement.execute("insert into contact (FIRST_NAME, LAST_NAME, BIRTH_DATE)"
						+ "values ('Scott', 'Tiger', '1990-11-02')");
				statement.execute("insert into contact (FIRST_NAME, LAST_NAME, BIRTH_DATE)"
						+ "values ('John', 'Smith', '1964-02-28')");
				statement.execute("insert into contact_tel_detail (CONTACT_ID, TEL_TYPE, TEL_NUMBER)"
						+ "values ( 1, 'Mobile', '1234567890')");
				statement.execute("insert into contact_tel_detail (CONTACT_ID, TEL_TYPE, TEL_NUMBER)"
						+ "values (1, 'Home', '1234567890')");
				statement.execute("insert into contact_tel_detail (CONTACT_ID, TEL_TYPE, TEL_NUMBER)"
						+ "values (2, 'Home', '1234567890')");
			} catch (SQLException e) {
				System.out.println("SQLException in insertDataIntoDB() method");
				e.printStackTrace();
			}finally {
				closeConnection(connection);
			}
	}

	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:derby:jdbcDB");
	}
	
	private static void closeConnection(Connection connection) {
		if (connection == null) {
			return;
		}
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Connection can not close");
			e.printStackTrace();
		}
	}

	@Override
	public List<Contact> findAll() {
		List<Contact> result = new ArrayList<>();
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from contact");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Contact contact = new Contact();
				contact.setId(resultSet.getLong("id"));
				contact.setFirstName(resultSet.getString("first_name"));
				contact.setLastName(resultSet.getString("last_name"));
				contact.setBirthDate(resultSet.getDate("birth_date"));
				result.add(contact);
			}
		} catch (SQLException e) {
			System.out.println("SQLException in findAll() method");
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}
		return result;
	}

	@Override
	public List<Contact> findByFirstName(String firstName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findLastNameById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findFirstNameById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Contact contact) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(
					"insert into Contact (first_name, last_name, birth_date) values (?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, contact.getFirstName());
			statement.setString(2, contact.getLastName());
			statement.setDate(3, contact.getBirthDate());
			statement.execute();
			ResultSet generatedKeys = statement.getGeneratedKeys();
			if (generatedKeys.next()) {
				contact.setId(generatedKeys.getLong(1));
			}
		} catch (SQLException e) {
			System.out.println("SQLException in insert(Contact contact) method");
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}

	}

	@Override
	public void update(Contact contact) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long contactId) {
		Connection connection = null;
		try {
			connection = getConnection();
			PreparedStatement statement = connection.prepareStatement("delete from contact where id=?");
			statement.setLong(1, contactId);
			statement.execute();
		} catch (SQLException e) {
			System.out.println("SQLException in delete(Long contactId) method");
			e.printStackTrace();
		} finally {
			closeConnection(connection);
		}

	}

}
