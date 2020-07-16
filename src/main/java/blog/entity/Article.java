package blog.entity;

import java.util.Date;

public class Article {
	private Integer articleId;
	
    //�������µ��û�
    private Integer articleUserId;   

    //���±���
    private String articleTitle;

    //�������
    private Integer articleViewCount;

    //�ظ�����
    private Integer articleCommentCount;

    //ϲ������
    private Integer articleLikeCount;

    //����ʱ��
    private Date articleCreateTime;

    //����ʱ��
    private Date articleUpdateTime;

    //�Ƿ�ظ�
    private Integer articleIsComment;

    //״̬ (0 �ݸ�,1 �ѷ���)
    private Integer articleStatus;

    //����
    private Integer articleOrder;

    //��������
    private String articleContent;

    //���¸�Ҫ (�����������ݰѸ�ʽ��ǩȥ��,��ȡǰ����λ������)
    private String articleSummary;

    //�û�
    private User user;

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getArticleUserId() {
		return articleUserId;
	}

	public void setArticleUserId(Integer articleUserId) {
		this.articleUserId = articleUserId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public Integer getArticleViewCount() {
		return articleViewCount;
	}

	public void setArticleViewCount(Integer articleViewCount) {
		this.articleViewCount = articleViewCount;
	}

	public Integer getArticleCommentCount() {
		return articleCommentCount;
	}

	public void setArticleCommentCount(Integer articleCommentCount) {
		this.articleCommentCount = articleCommentCount;
	}

	public Integer getArticleLikeCount() {
		return articleLikeCount;
	}

	public void setArticleLikeCount(Integer articleLikeCount) {
		this.articleLikeCount = articleLikeCount;
	}

	public Date getArticleCreateTime() {
		return articleCreateTime;
	}

	public void setArticleCreateTime(Date articleCreateTime) {
		this.articleCreateTime = articleCreateTime;
	}

	public Date getArticleUpdateTime() {
		return articleUpdateTime;
	}

	public void setArticleUpdateTime(Date articleUpdateTime) {
		this.articleUpdateTime = articleUpdateTime;
	}

	public Integer getArticleIsComment() {
		return articleIsComment;
	}

	public void setArticleIsComment(Integer articleIsComment) {
		this.articleIsComment = articleIsComment;
	}

	public Integer getArticleStatus() {
		return articleStatus;
	}

	public void setArticleStatus(Integer articleStatus) {
		this.articleStatus = articleStatus;
	}

	public Integer getArticleOrder() {
		return articleOrder;
	}

	public void setArticleOrder(Integer articleOrder) {
		this.articleOrder = articleOrder;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public String getArticleSummary() {
		return articleSummary;
	}

	public void setArticleSummary(String articleSummary) {
		this.articleSummary = articleSummary;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}