package com.oneHealth.DoctorFeedback.serviceImplementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.oneHealth.DoctorFeedback.entity.DoctorFeedback;
import com.oneHealth.DoctorFeedback.exception.DatabaseException;
import com.oneHealth.DoctorFeedback.exception.FeedbackNotFoundException;
import com.oneHealth.DoctorFeedback.repository.DoctorFeedbackRepository;
import com.oneHealth.DoctorFeedback.service.DoctorFeedbackService;

import java.util.List;

/**
 * The DoctorFeedbackServiceImpl class is responsible for implementing the business logic
 * for managing feedback details of doctors. It interacts with the DoctorFeedbackRepository to perform CRUD operations.
 *
 * Note: Make sure to import the required entities, exceptions, and repositories from the appropriate packages.
 *
 * @author Madhavi
 * @version 1
 */
@Service
public class DoctorFeedbackServiceImpl implements DoctorFeedbackService {

    private final Logger logger = LoggerFactory.getLogger(DoctorFeedbackServiceImpl.class);

    @Autowired
    private DoctorFeedbackRepository repo;

    // Method to save a DoctorFeedback object in the database and handle DatabaseException
    @Override
    public DoctorFeedback saveDoctorFeedback(DoctorFeedback doctorFeedback) throws DatabaseException {
        DoctorFeedback savedFeedback = repo.save(doctorFeedback);
        logger.info("In Service - Doctor Feedback saved: " + savedFeedback);
        return savedFeedback;
    }

    // Method to retrieve DoctorFeedback by its ID and handle FeedbackNotFoundException if the feedback for the given feedbackId is not found
    @Override
    public DoctorFeedback getFeedbackByID(int feedbackId) throws FeedbackNotFoundException {
        DoctorFeedback feedback = repo.findById(feedbackId)
                .orElseThrow(() -> new FeedbackNotFoundException("No Feedback Found with this ID " + feedbackId));
        logger.info("In Service - Doctor Feedback Retrieved: " + feedback);
        return feedback;
    }

    // Method to retrieve a list of all DoctorFeedback objects from the database and handle DatabaseException if any occurs
    @Override
    public List<DoctorFeedback> getAllDoctorFeedback() throws DatabaseException {
        List<DoctorFeedback> feedbackList = repo.findAll();
        logger.info("In Service - All Doctor Feedback Retrieved: " + feedbackList);
        return feedbackList;
    }

    // Method to update DoctorFeedback by its ID and handle FeedbackNotFoundException if the feedback for the given feedbackId is not found
    @Override
    public DoctorFeedback updateFeedbackByID(int feedbackId, DoctorFeedback updatedFeedback) throws FeedbackNotFoundException {
        DoctorFeedback doctorFeedback = repo.findById(feedbackId)
                .orElseThrow(() -> new FeedbackNotFoundException("No Doctor Feedback found with this ID: " + feedbackId));

        // Update properties with new values from updatedFeedback
        doctorFeedback.setPatient_id(updatedFeedback.getPatient_id());
        doctorFeedback.setDoctor_id(updatedFeedback.getDoctor_id());
        doctorFeedback.setRating(updatedFeedback.getRating());
        doctorFeedback.setDescription(updatedFeedback.getDescription());

        DoctorFeedback updatedFeedbackResult = repo.save(doctorFeedback);
        logger.info("In Service - Doctor Feedback Updated Successfully: " + updatedFeedbackResult);
        return updatedFeedbackResult;
    }

    // Method to delete DoctorFeedback by its ID and handle FeedbackNotFoundException if the feedback for the given feedbackId is not found
    @Override
    public DoctorFeedback deleteFeedbackByID(int feedbackId) throws FeedbackNotFoundException {
        DoctorFeedback doctorFeedback = repo.findById(feedbackId)
                .orElseThrow(() -> new FeedbackNotFoundException("No Doctor Feedback found with this ID: " + feedbackId));

        repo.delete(doctorFeedback);
        logger.info("In Service - Doctor Feedback Deleted Successfully with ID: " + feedbackId);
        return doctorFeedback;
    }
}
