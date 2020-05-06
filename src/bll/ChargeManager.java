package lab2.bll;
import java.util.Hashtable;
import java.util.List;
import lab2.entity.Charge; 
import lab2.dao.ChargesDao; 

public class ChargeManager {
	
	private static ChargesDao chargeDao = lab2.util.SpringFactory.getChargesDao();
	
	@SuppressWarnings("unchecked")
	public java.util.List<Charge> getCharges(){
		return chargeDao.getCharges();
	}
	
	public java.util.List<Charge> getChargesByAct(String act){
		return chargeDao.getChargesByAct(act);
	}
	
	public void addCharge(Charge charge){
		chargeDao.addCharge(charge);
	}
	public void updateCharge(Charge charge){
		chargeDao.updateCharge(charge);
	}
	public void deleteCharge(Charge charge){
		chargeDao.deleteCharge(charge);
	}
}
