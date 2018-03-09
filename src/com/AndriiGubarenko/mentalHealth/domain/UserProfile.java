package com.AndriiGubarenko.mentalHealth.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.tomcat.util.codec.binary.Base64;



@Entity
@Table(name = "USER_PROFILE")
public class UserProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@Column(name = "SURNAME", nullable = false)
	private String surname;
	
	@Column(name = "SPECIALITY", nullable = false)
	private String speciality;
	
	@Column(name = "LOCATION")
	private String location;
	
	@Column(name = "ESSAY", columnDefinition = "TEXT")
	private String essay;
	
	@Column(name = "PRICE", nullable = false)
	private Long price;
	
	@Column(name = "CURRENCY", nullable = false)
	private String currency;
	
	@Column(name = "EXPERIENCE")
	@Temporal(TemporalType.DATE)
	private Date experience;
	
	@Column(name = "BIRTHDAY")
	@Temporal(TemporalType.DATE)
	private Date birthday;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@Column(name = "IN")
	private String linkedin;
	
	@Column(name = "FB")
	private String facebook;
	
	@Column(name = "SKYPE")
	private String skype;
	
	@Column(name = "USER_PHOTO")
	@Lob
	private byte[] userPhoto;
	
	@Column(name = "USER_DIPLOMA")
	@Lob
	private byte[] userDiploma;
	
	@OneToMany(mappedBy = "userProfile")
	private Set<Comment> commentList = new HashSet<>();
	
	@OneToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String spesiality) {
		this.speciality = spesiality;
	}

	public String getEssay() {
		return essay;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setEssay(String essay) {
		this.essay = essay;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getExperience() {
		return experience;
	}

	public void setExperience(Date experience) {
		this.experience = experience;
	}
	
//------------------------------------------------------
	public byte[] getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		try {
			this.userPhoto = Base64.decodeBase64(userPhoto);
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}
 	}
	
	public byte[] getUserDiploma() {
		return userDiploma;
	}

	public void setUserDiploma(String userDiploma) {
		try {
			this.userDiploma = Base64.decodeBase64(userDiploma);
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
		}
 	}
//------------------------------------------------------

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		setUser(user, false);
	}
	
	public void setUser(User user, boolean otherSideHasBeenAlreadySet) {
		this.user = user;
		if(otherSideHasBeenAlreadySet) {
			return;
		}
		user.addUserProfile(this, true);
	}

	public Set<Comment> getCommentList() {
		return commentList;
	}

	public void addComment(Comment comment) {
		addComment(comment, false);
	}
	
	public void addComment(Comment comment, boolean otherSideHasBeenAlreadySet) {
		getCommentList().add(comment);
		if(otherSideHasBeenAlreadySet) {
			return;
		}
		comment.setUserProfile(this, true);
	}
	
	//TODO: implement correct method
	public void setComments(Collection<Comment> comments) {
		this.removeAllComments();
		comments.forEach(this::addComment);
	}
	
	public void removeAllComments() {
		getCommentList().stream().collect(Collectors.toList()).forEach(this::removeComment);
	}
	
	public void removeComment(Comment comment) {
		removeComment(comment, false);
	}
	
	public void removeComment(Comment comment, boolean otherSideRemoved) {
		this.getCommentList().remove(comment);
		if(otherSideRemoved) {
			return;
		}
		comment.removeUserProfile(true);
	}

	public int hash() {
		return Objects.hash(this.getId(), this.getName());
	}
	
	public boolean equals(Object object) {
		if(object == null) {
			return false;
		}
		
		if (!(object instanceof Comment)) {
			return false;
		}
		
		Comment that = (Comment) object;
		
		if(!Objects.equals(this.getId(), that.getId())) {
			return false;
		}
		
		if(!Objects.equals(this.getName(), that.getVisitorName())) {
			return false;
		}
		return true;
	}
}
