package kr.co.db_input.command;

import java.sql.SQLException;

import kr.co.db_input.dao.Dao_input;
import kr.co.db_input.dto.Dto_input;

public class UpdateOkCommand {
	public void execute(Dto_input dto_input) throws SQLException {
		Dao_input dao_input = new Dao_input();
		dao_input.update_ok(dto_input);
	}
}
