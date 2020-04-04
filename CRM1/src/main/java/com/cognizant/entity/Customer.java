package com.cognizant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="Required")
	@Size(min=5,max=15 , message = "enter valid name of 5 to 15 alphabate")
	@Pattern(regexp="^[A-Za-z]{2,15}" , message = "enter valid name of 2 to 15 alphabet without any space")
    @Column(name="first_name")
	private String firstName;
	
	@NotNull(message="Required")
	@Size(min=5,max=15 , message = "enter valid name of 5 to 15 alphabates")
	@Pattern(regexp="^[A-Za-z]{2,15}" , message = "enter valid name of 2 to 15 alphabet without any space")
	@Column(name="last_name")
	private String lastName;
	
	@NotNull(message="Required")
	@Size(min=5,max=15 , message = "enter valid name of 5 to 15 alphabates")
	@Pattern(regexp="^[A-Za-z]" , message = "enter valid name of 2 to 15 alphabates")
	@Email(message = "Enter valid email")
	@Column(name="email")
	private String email;
	@NotNull(message="Required")
	@Column(name="phone_number")
	private String phoneNumber;
	@NotNull(message="Required")
	@Column(name="gender")
	private String gender;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", gender=" + gender + "]";
	}
	
	
}
