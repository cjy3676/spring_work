package kr.co.db_input.command;

import java.sql.SQLException;

import org.springframework.ui.Model;
import kr.co.db_input.dao.Dao_input;
import kr.co.db_input.dto.Dto_input;

public class ContentCommand {
	public Dto_input execute(String id, Model model) throws SQLException {
		Dao_input dao_input = new Dao_input();
		Dto_input dto_input = dao_input.content(id);
		/* model.addAttribute("dto_input",dto_input); */
		return dto_input;
	}
}
