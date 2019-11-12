package kr.co.db_input.command;

import java.sql.SQLException;
import kr.co.db_input.dao.Dao_input;

public class DeleteCommand {
	public void execute(String id) throws SQLException {
		Dao_input dao_input = new Dao_input();
		dao_input.delete(id);
	}
}
