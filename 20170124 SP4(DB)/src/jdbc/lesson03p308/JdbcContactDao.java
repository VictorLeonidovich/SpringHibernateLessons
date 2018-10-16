package jdbc.lesson03p308;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
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
	public void afterPropertiesSet() throws Exception {
		if (dataSource == null) {
			throw new BeanCreationException("Must set contactSource on contactDAO");
		}
		if (jdbcTemplate == null) {
			throw new BeanCreationException("Null jdbcTemplate on contactDAO");
		}
	}

}
