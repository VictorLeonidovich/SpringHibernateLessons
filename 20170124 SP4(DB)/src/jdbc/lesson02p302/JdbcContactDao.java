package jdbc.lesson02p302;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcContactDao implements ContactDao, InitializingBean{
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		MySQLErrorCodesTranslator errorTranslator = new MySQLErrorCodesTranslator();
		errorTranslator.setDataSource(dataSource);
		jdbcTemplate.setExceptionTranslator(errorTranslator);
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public String findLastNameById(Long id) {
		return jdbcTemplate.queryForObject("select first_name from contact where id=?", new Object[]{id}, String.class);
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
