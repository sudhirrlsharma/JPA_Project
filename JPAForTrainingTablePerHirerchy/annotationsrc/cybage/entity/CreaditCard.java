package cybage.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
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
