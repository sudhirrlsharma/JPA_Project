package cybage.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import cybage.model.Address;
import cybage.model.Versionable;

@Entity
@NamedQuery(name = "User.findByName", query = "SELECT u FROM User u " + "WHERE u.name = :name")
public class User implements Serializable,Versionable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7442650486916388018L;
	private Long id;
	private String name;
	private String companyName;
	private Double salary;
	private Address address;
	private Set<BillingDetail> billingDetail;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy = "user", cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	public Set<BillingDetail> getBillingDetail() {
		return billingDetail;
	}
	
	public void setBillingDetail(Set<BillingDetail> billingDetail) {
		this.billingDetail = billingDetail;
	}
	
	@Embedded
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getSalary() {
		return salary;
	}
	
	public void setSalary(Double salary) {
		this.salary = salary;
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
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Override
	public String toString() {
		return new StringBuilder(" [ Id : ").append(id).append(" , name : ").append(name).append(" , companyName : ").append(companyName)
				.append(" , salary : ").append(salary).append(" , Address : ").append(address).toString();
	}
}
