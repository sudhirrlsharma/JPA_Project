package cybage.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CreaditCard extends BillingDetail  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	

	
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
