package thy.coding.springboot;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	JdbcTemplate jdbcTemp;
	
	@Autowired
	public MainController(JdbcTemplate temp) {
		this.jdbcTemp=temp;
	}
	
	@RequestMapping("/board")
	
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		List<String> subjects =null;
		
		try {			
			Connection conn = jdbcTemp.getDataSource().getConnection();
			
			String sql="select subject from board";
			PreparedStatement ps= conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			subjects = new ArrayList<String>();
			
			while(rs.next()) {
				subjects.add(rs.getString("subject"));
			}
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		mv.addObject("subjects", subjects); //Model
		mv.setViewName("test/test1");
		return mv;
	}
	
}
