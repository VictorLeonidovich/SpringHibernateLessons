package jdbc.lesson04p310;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class JdbcContactDao implements ContactDao, InitializingBean {
	private DataSource dataSource;
	private NamedParameterJdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String findLastNameById(Long id) {
		String sql = "select last_name from contact where id= :contactId";
		Map<String, Object> map = new HashMap<>();
		map.put("contactId", id);
		return jdbcTemplate.queryForObject(sql, map, String.class);
	}

	@Override
	public List<Contact> findAll() {
		String sql = "select id, first_name, last_name, birth_date from contact";
		// return jdbcTemplate.query(sql, new ContactMapper());
		return jdbcTemplate.query(sql, (rs, rowNum) -> {
			Contact contact = new Contact();
			contact.setId(rs.getLong("id"));
			contact.setFirstName(rs.getString("first_name"));
			contact.setLastName(rs.getString("last_name"));
			contact.setBirthDate(rs.getDate("birth_date"));
			return contact;
		});
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (dataSource == null) {
			throw new BeanCreationException("Must set contactSource on contactDAO");
		}
		if (jdbcTemplate == null) {
			throw new BeanCreationException("Null jdbcTemplate on contactDAO");
		}
	}

	public static final class ContactMapper implements RowMapper<Contact> {

		@Override
		public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
			Contact contact = new Contact();
			contact.setId(rs.getLong("id"));
			contact.setFirstName(rs.getString("first_name"));
			contact.setLastName(rs.getString("last_name"));
			contact.setBirthDate(rs.getDate("birth_date"));
			return contact;
		}

	}
}
