package com.oneHealth.DoctorFeedback.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Entity class representing DoctorFeedback information.
 * This class is mapped to a database table to store feedback provided by patients for doctors.
 * 
 * Note: Make sure to import the required annotations from the appropriate packages.
 * 
 * @author Madhavi
 * @version 1
 */
@Entity
public class DoctorFeedback {

	@Id
	private int feedback_id; // Primary key field for the DoctorFeedback table
	private int patient_id; // Field representing the ID of the patient providing the feedback
	private int doctor_id; // Field representing the ID of the doctor receiving the feedback
	private int rating; // Field representing the rating given by the patient for the doctor
	private String description; // Field representing the description or comments provided by the patient

	public DoctorFeedback() {
		super();
	}

	// Parameterized constructor to initialize DoctorFeedback object with values
	public DoctorFeedback(int feedback_id, int patient_id, int doctor_id, int rating, String description) {
		super();
		this.feedback_id = feedback_id;
		this.patient_id = patient_id;
		this.doctor_id = doctor_id;
		this.rating = rating;
		this.description = description;
	}

	// Getter method for feedback_id
	public int getFeedback_id() {
		return feedback_id;
	}

	// Setter method for feedback_id
	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}

	// Getter method for patient_id
	public int getPatient_id() {
		return patient_id;
	}

	// Setter method for patient_id
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	// Getter method for doctor_id
	public int getDoctor_id() {
		return doctor_id;
	}

	// Setter method for doctor_id
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	// Getter method for rating
	public int getRating() {
		return rating;
	}

	// Setter method for rating
	public void setRating(int rating) {
		this.rating = rating;
	}

	// Getter method for description
	public String getDescription() {
		return description;
	}

	// Setter method for description
	public void setDescription(String description) {
		this.description = description;
	}

	// Override toString() method to print DoctorFeedback object as a string
	@Override
	public String toString() {
		return "DoctorFeedback [feedback_id=" + feedback_id + ", patient_id=" + patient_id + ", doctor_id=" + doctor_id
				+ ", rating=" + rating + ", description=" + description + "]";
	}
}
