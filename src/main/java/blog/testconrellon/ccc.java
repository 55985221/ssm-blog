package blog.testconrellon;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import blog.entity.AdminInfo;
import blog.mapper.AdminInfoMapper;

@Controller
public class ccc {
	@Resource
	AdminInfoMapper adminInfoMapper;
@RequestMapping("/test")
public String tet() {
	AdminInfo ad=adminInfoMapper.get(1);
	System.out.println(ad.getId());
	return "forward:index.jsp";
}
}
