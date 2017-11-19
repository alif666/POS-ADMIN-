package model;

public class TotalCalculation {
	
	
  private String subTotal;
  private String orderTotal;
  private String totalCash;
  private String totalCard;
  private String totalVat;
  public String getMonthName() {
	return monthName;
}
public void setMonthName(String monthName) {
	this.monthName = monthName;
}
private String monthName;

	public String getTotalVat() {
		return totalVat;
	}
	public void setTotalVat(String totalVat) {
		this.totalVat = totalVat;
	}
	public String getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}
	public String getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(String orderTotal) {
		this.orderTotal = orderTotal;
	}
	public String getTotalCash() {
		return totalCash;
	}
	public void setTotalCash(String totalCash) {
		this.totalCash = totalCash;
	}
	public String getTotalCard() {
		return totalCard;
	}
	public void setTotalCard(String totalCard) {
		this.totalCard = totalCard;
	}

}
