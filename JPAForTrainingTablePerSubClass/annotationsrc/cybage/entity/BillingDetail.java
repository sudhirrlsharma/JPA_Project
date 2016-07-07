package cybage.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import cybage.model.Versionable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetail implements Serializable,Versionable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
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
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
		return new StringBuffer("ID : ").append(this.id).append(", billAmount : ").append(billSmount).toString();
	}
}
