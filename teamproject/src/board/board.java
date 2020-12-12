package board;

public class board {
    private int storeNum;  // 스토어게시판넘버
    private String storeProduct; // 스토어제품명
    private String productInfo;  // 스토어제품설명
    private int productPrice;    // 스토어제품가격
    private String storeKgori;   // 스토어카테고리
    private String storecommt;   // 스토어댓글
    private int stCommtCont;     // 스토어댓글수
    private int stRecomCont;     // 스토어인기수
    private int grade;           // 스토어평점수
    private String storeDate;    // 스토어작성일
	private String storeImg;     // 이미지 경로
    
    public String getStoreImg() {
		return storeImg;
	}
	public void setStoreImg(String storeImg) {
		this.storeImg = storeImg;
	}
	public int getStoreNum() {
		return storeNum;
	}
	public void setStoreNum(int storeNum) {
		this.storeNum = storeNum;
	}
	public String getStoreProduct() {
		return storeProduct;
	}
	public void setStoreProduct(String storeProduct) {
		this.storeProduct = storeProduct;
	}
	public String getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getStoreKgori() {
		return storeKgori;
	}
	public void setStoreKgori(String storeKgori) {
		this.storeKgori = storeKgori;
	}
	public String getStorecommt() {
		return storecommt;
	}
	public void setStorecommt(String storecommt) {
		this.storecommt = storecommt;
	}
	public int getStCommtCont() {
		return stCommtCont;
	}
	public void setStCommtCont(int stCommtCont) {
		this.stCommtCont = stCommtCont;
	}
	public int getStRecomCont() {
		return stRecomCont;
	}
	public void setStRecomCont(int stRecomCont) {
		this.stRecomCont = stRecomCont;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getStoreDate() {
		return storeDate;
	}
	public void setStoreDate(String storeDate) {
		this.storeDate = storeDate;
	}
    
    
}
