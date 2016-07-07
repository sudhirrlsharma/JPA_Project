package cybage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import cybage.model.Versionable;

@MappedSuperclass
public abstract class BillingDetail implements Serializable,Versionable {

	private long billSmount;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public long getBillSmount() {
		return billSmount;
	}
	
	public void setBillSmount(long billSmount) {
		this.billSmount = billSmount;
	}
	
	@Version
	@Column(name = "OBJ_VERSION")
	private int version;
	
	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}
	
	@Override
	public String toString() {
		return new StringBuffer(" billAmount : ").append(billSmount).toString();
	}
}
