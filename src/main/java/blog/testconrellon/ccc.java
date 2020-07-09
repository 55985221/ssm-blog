package blog.testconrellon;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ccc {
@RequestMapping("/test")
public String tet() {
	
	return "forward:index.jsp";
}
}
