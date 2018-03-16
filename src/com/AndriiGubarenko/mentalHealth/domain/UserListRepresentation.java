/*package com.AndriiGubarenko.mentalHealth.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_LIST-REPRESENTATION")
public class UserListRepresentation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "BY_NAME")
	private String byName;
	
	@Column(name = "BY_SURNAME")
	private String bySurname;
	
	@Column(name = "BY_SPECIALITY")
	private String bySpeciality;
	
	@Column(name = "BY_LOCATION")
	private String byLocation;
	
	@Column(name = "BY_PRICE")
	private Long byPrice;
	
	@Column(name = "BY_CURRENCY")
	private String byCurrency;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getByName() {
		return byName;
	}

	public void setByName(String byName) {
		this.byName = byName;
	}

	public String getBySurname() {
		return bySurname;
	}

	public void setBySurname(String bySurname) {
		this.bySurname = bySurname;
	}

	public String getBySpeciality() {
		return bySpeciality;
	}

	public void setBySpeciality(String bySpeciality) {
		this.bySpeciality = bySpeciality;
	}

	public String getByLocation() {
		return byLocation;
	}

	public void setByLocation(String byLocation) {
		this.byLocation = byLocation;
	}

	public Long getByPrice() {
		return byPrice;
	}

	public void setByPrice(Long byPrice) {
		this.byPrice = byPrice;
	}

	public String getByCurrency() {
		return byCurrency;
	}

	public void setByCurrency(String byCurrency) {
		this.byCurrency = byCurrency;
	}
}
*/