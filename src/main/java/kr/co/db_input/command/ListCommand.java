package kr.co.db_input.command;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.ui.Model;
import kr.co.db_input.dao.Dao_input;
import kr.co.db_input.dto.Dto_input;

public class ListCommand {
	public void execute(Model model) throws SQLException {
		// Dao_input에 있는 list관련 메소드를 호출
		Dao_input di = new Dao_input();
		ArrayList<Dto_input> list = di.list();
		model.addAttribute("list",list);
	}
}
