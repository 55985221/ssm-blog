package blog.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import blog.entity.Tag;
import blog.service.TagService;

@Controller
@RequestMapping("/tag")
public class TagController {
@Resource(name="tagServiceImpl")
TagService tagservice;
@RequestMapping("/tagall")
public String TagAll(Map map) {
Tag[] tag=tagservice.gatTag();
map.put("tags", tag);
return "/tag/tagall";	
}
}
