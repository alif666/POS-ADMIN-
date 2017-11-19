package controller.salesReport;

import java.util.List;

import model.SalesDetails;
import model.SalesInfo;
import dao.SalesDetailsDao;
import dao.SalesInfoDao;

public class SalesController {
	SalesInfo salesInfo;
	List<SalesDetails> salesDetails;
	private List<SalesInfo> salesList;
	
	
	SalesController(){
		SalesInfoDao salesDao = new SalesInfoDao();
		setSalesList((List<SalesInfo>)salesDao.view());
		
	}
	
	SalesController(long sessionId){
        SalesDetailsDao salesDao = new SalesDetailsDao();    
        salesDetails = salesDao.getListFromSameSession(sessionId);
        SalesInfoDao salesInfoDao=new SalesInfoDao();
        salesInfo=(SalesInfo) salesInfoDao.checkDaoLong(sessionId);
		
	}

	public List<SalesInfo> getSalesList() {
		return salesList;
	}

	public void setSalesList(List<SalesInfo> salesList) {
		this.salesList = salesList;
	}
	


}
