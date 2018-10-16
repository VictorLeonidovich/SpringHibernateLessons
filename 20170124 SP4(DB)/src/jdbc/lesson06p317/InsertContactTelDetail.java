package jdbc.lesson06p317;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

public class InsertContactTelDetail extends BatchSqlUpdate {
	private static final String SQL_INSERT_CONTACT_TEL = "insert into contact_tel_detail (contact_id, tel_type, tel_number) values (:contact_id, :tel_type, :tel_number)";
	private static final int BATCH_SIZE = 10;
	
	public InsertContactTelDetail(DataSource dataSource) {
		super(dataSource, SQL_INSERT_CONTACT_TEL);
		super.declareParameter(new SqlParameter("contact_id", Types.INTEGER));
		super.declareParameter(new SqlParameter("tel_type", Types.VARCHAR));
		super.declareParameter(new SqlParameter("tel_number", Types.DATE));
		setBatchSize(BATCH_SIZE);;
	}
}
