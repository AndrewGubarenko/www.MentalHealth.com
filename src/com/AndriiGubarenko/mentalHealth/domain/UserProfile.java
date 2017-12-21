package com.AndriiGubarenko.mentalHealth.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
//Сделать ссылку по логину юзера
@Table(name = "USERPROFILE")
public class UserProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	//Сделать систему подсказок для заполнения
	@Column(name = "SPECIALITY", nullable = false)
	private String speciality;
	
	//Сделать систему подсказок для заполнения
	@Column(name = "ESSAY")
	private String essay;
	
	@Column(name = "PRICE", nullable = false)
	private Long price;
	
	//Сделать систему подсказок для заполнения
	@Column(name = "EXPERIENCE")
	@Temporal(TemporalType.TIME)
	private Date experience;
	
	@Column(name = "BIRTHDAY")
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	//Сделать систему рейтингов и задание изначального рейтинга новому юзеру
	@Column(name = "RAITING", nullable = false)
	private double raiting;
	
	//Сделать форму для отзывов
	@Column(name = "COMMENTS")
	private String comments;
	
	//Создать метод контакты (мыло, фб, линк, скайп и тел)
	@Column(name = "CONTACTS", nullable = false)
	private String contacts;
	
	//private File userPhoto;
	
	@OneToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public void setEssay(String essay) {
		this.essay = essay;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Date getExperience() {
		return experience;
	}

	public void setExperience(Date experience) {
		this.experience = experience;
	}

	public double getRaiting() {
		return raiting;
	}

	public void setRaiting(double raiting) {
		this.raiting = raiting;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	/*
	public BufferedImage getUserPhoto() {
		//сделать правильно путь к файлу
		String path = "src/UsersPics/photo.jpg";
		try {
			File file = new File(path);
			BufferedImage userPhoto = ImageIO.read(file);
			return userPhoto;
		} catch (FileNotFoundException ex) {
			ex.getMessage();
			return null;
		} catch (IOException ex) {
			ex.getMessage();
			return null;
		}
	}

	public void setUserPhoto(RenderedImage userPhoto) {
		try {
			String path = "src/UsersPics/photo.jpg";
			File file = new File(path);
			ImageIO.write(userPhoto, "jpg", file);
		} catch(IOException ex) {
			ex.getMessage();
		}
	}
	*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	
}
