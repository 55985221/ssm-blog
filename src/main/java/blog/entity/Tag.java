package blog.entity;

public class Tag {
	Integer tagid;
	String tagname;
	String tagdescription;
	Integer articlenumber;
	public Tag() {
	}
	public Tag(Integer tagid) {
		this.tagid=tagid;
	}
	public Integer getTagid() {
		return tagid;
	}
	public void setTagid(Integer tagid) {
		this.tagid = tagid;
	}
	public String getTagname() {
		return tagname;
	}
	public void setTagname(String tagname) {
		this.tagname = tagname;
	}
	public String getTagdescription() {
		return tagdescription;
	}
	public void setTagdescription(String tagdescription) {
		this.tagdescription = tagdescription;
	}
	public Integer getArticlenumber() {
		return articlenumber;
	}
	public void setArticlenumber(Integer articlenumber) {
		this.articlenumber = articlenumber;
	}
	
	
}
