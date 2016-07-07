package cybage.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn
public class CreaditCard extends BillingDetail  {
	
	public String creaditCardNo;
	
	public String getCreaditCardNo() {
		return creaditCardNo;
	}
	
	public void setCreaditCardNo(String creaditCardNo) {
		this.creaditCardNo = creaditCardNo;
	}
	
	@Override
	public String toString() {
		return  new StringBuilder(super.toString()).append(" , creaditCardNo : ").append(creaditCardNo).toString();
	}

	
}
