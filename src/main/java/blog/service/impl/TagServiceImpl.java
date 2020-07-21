package blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import blog.entity.Tag;
import blog.mapper.TagMapper;
import blog.mapper.TagrefMapper;
import blog.service.TagService;
@Service
public class TagServiceImpl implements TagService{
@Resource
TagMapper tagmapper;
@Resource
TagrefMapper tagrefmapper;
public Tag[] GatTag() {
	Tag[] tag=tagmapper.GetTag();
	for(int i=0;i<tag.length;i++) {
		tag[i].setArticlenumber(tagrefmapper.GetTagrefCount(tag[i].getTagid()));
	}
	return tag;
}
}
