package com.oneHealth.DoctorFeedback.service;

import java.util.List;

import com.oneHealth.DoctorFeedback.entity.DoctorFeedback;
import com.oneHealth.DoctorFeedback.exception.DatabaseException;
import com.oneHealth.DoctorFeedback.exception.FeedbackNotFoundException;

/**
 * The DoctorFeedbackService interface defines the contract for performing operations related
 * to DoctorFeedback. It declares methods for saving, retrieving, updating, and deleting doctor feedback.
 * 
 
 * 
 * @author Madhavi
 * @version 1.0
 */
public interface DoctorFeedbackService {
	
	// Method to save a DoctorFeedback object in the database and handle DatabaseException
	DoctorFeedback saveDoctorFeedback(DoctorFeedback doctorfeedback) throws DatabaseException;
	
	// Method to retrieve DoctorFeedback by its ID and handle FeedbackNotFoundException if the feedback for the given feedbackId is not found
	DoctorFeedback getFeedbackByID(int feedbackId) throws FeedbackNotFoundException;
	
	// Method to retrieve a list of all DoctorFeedback objects from the database and handle DatabaseException if any occurs
	List<DoctorFeedback> getAllDoctorFeedback() throws DatabaseException;
	
	// Method to update DoctorFeedback by its ID and handle FeedbackNotFoundException if the feedback for the given feedbackId is not found
	DoctorFeedback updateFeedbackByID(int feedbackId, DoctorFeedback updatedFeedback) throws FeedbackNotFoundException;
	
	// Method to delete DoctorFeedback by its ID and handle FeedbackNotFoundException if the feedback for the given feedbackId is not found
	DoctorFeedback deleteFeedbackByID(int feedbackId) throws FeedbackNotFoundException;

}
