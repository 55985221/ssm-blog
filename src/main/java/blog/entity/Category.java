package blog.entity;

import java.util.List;

public class Category {
	Integer categoryid;
	Integer categorypid;
	String categoryname;
	String categorydescription;
	Integer intcategory_order;
	String category_icon;
	Category[]  category;
	Integer articlenumber;//非数据库数据标签文章数
	public Category() {
	}
	public Category(Integer categoryid) {
		this.categoryid=categoryid;
	}
	public Integer getArticlenumber() {
		return articlenumber;
	}
	public void setArticlenumber(Integer articlenumber) {
		this.articlenumber = articlenumber;
	}
	public Category[] getCategory() {
		return category;
	}
	public void setCategory(Category[] category) {
		this.category = category;
	}
	public Integer getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}
	public Integer getCategorypid() {
		return categorypid;
	}
	public void setCategorypid(Integer categorypid) {
		this.categorypid = categorypid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public String getCategorydescription() {
		return categorydescription;
	}
	public void setCategorydescription(String categorydescription) {
		this.categorydescription = categorydescription;
	}
	public Integer getIntcategory_order() {
		return intcategory_order;
	}
	public void setIntcategory_order(Integer intcategory_order) {
		this.intcategory_order = intcategory_order;
	}
	public String getCategory_icon() {
		return category_icon;
	}
	public void setCategory_icon(String category_icon) {
		this.category_icon = category_icon;
	}
}
