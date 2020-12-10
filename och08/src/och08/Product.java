/*
 * Java Bean 연습
 * 
 * Product 클래스를 Product라는 테이블로 생각해보자
 * 
 */
package och08;

public class Product {
	private String code;
	private String name;
	private int price;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
