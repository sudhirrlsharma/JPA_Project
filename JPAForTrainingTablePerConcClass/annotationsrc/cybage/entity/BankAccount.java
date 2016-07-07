package cybage.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankAccount extends BillingDetail  {
	

	private long accountNo;
	private String nominiName;

	public String getNominiName() {
		return nominiName;
	}

	public void setNominiName(String nominiName) {
		this.nominiName = nominiName;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	@Override
	public String toString() {
		return  new StringBuilder(super.toString()).append(" , accountNo : ").append(accountNo).append(" , nominiName : ").append(nominiName).toString();
	}

}
