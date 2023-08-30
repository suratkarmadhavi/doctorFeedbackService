package com.oneHealth.DoctorFeedback.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.oneHealth.DoctorFeedback.entity.DoctorFeedback;
import com.oneHealth.DoctorFeedback.exception.DatabaseException;
import com.oneHealth.DoctorFeedback.exception.FeedbackNotFoundException;
import com.oneHealth.DoctorFeedback.service.DoctorFeedbackService;
import java.util.List;

/**
 * Controller class for handling Doctor Feedback related HTTP requests.
 * 
 * This class defines methods for saving, retrieving, updating, and deleting doctor feedback.
 * It uses a service class, DoctorFeedbackService, to perform the actual business logic.
 * The controller maps HTTP endpoints to these methods, allowing clients to interact with the application.
 * Additionally, the class includes logging statements to log important events for monitoring and debugging.
 * 
 * @author Madhavi
 * @version 1.0
 */
//@CrossOrigin("*")
@RestController
@RequestMapping("/api/doctors/doctorFeedback")
public class DoctorFeedbackController {

    private final Logger logger = LoggerFactory.getLogger(DoctorFeedbackController.class);

    @Autowired
    private DoctorFeedbackService service;

    /**
     * Handles HTTP POST request to save the doctor's feedback information into the database.
     *
     * @param feedback The DoctorFeedback object containing the doctor's feedback details.
     * @return A ResponseEntity with the response message and HTTP status code.
     * @throws DatabaseException If there is an issue while interacting with the database.
     */
    @PostMapping("/savefeedback")
    public ResponseEntity<String> saveDoctorFeedback(@RequestBody DoctorFeedback feedback) throws DatabaseException {
        service.saveDoctorFeedback(feedback);
        logger.info("In Controller - Doctor Feedback Saved Successfully: " + feedback);
        return new ResponseEntity<>("Doctor Feedback Saved Successfully", HttpStatus.CREATED);
    }

    /**
     * Handles HTTP GET request to retrieve the doctor's feedback information by feedbackId from the database.
     *
     * @param feedbackId The ID of the feedback for which feedback information is to be retrieved.
     * @return A ResponseEntity with the DoctorFeedback object and HTTP status code.
     * @throws FeedbackNotFoundException If the feedback information is not found in the database.
     */
    @GetMapping("/getDoctorFeedback/{feedbackId}")
    public ResponseEntity<DoctorFeedback> getDoctorFeedback(@PathVariable(value = "feedbackId") int feedbackId) throws FeedbackNotFoundException {
        DoctorFeedback obj = service.getFeedbackByID(feedbackId);
        logger.info("In Controller - Doctor Feedback Retrieved: " + obj);
        return ResponseEntity.ok().body(obj);
    }

    /**
     * Handles HTTP GET request to retrieve the list of all doctors' feedback from the database.
     *
     * @return A ResponseEntity with the list of DoctorFeedback objects and HTTP status code.
     * @throws DatabaseException If there is an issue while interacting with the database.
     */
    @GetMapping("/getAllDoctorFeedback")
    public ResponseEntity<List<DoctorFeedback>> getAllDoctorFeedback() throws DatabaseException {
        List<DoctorFeedback> doctorFeedbackList = service.getAllDoctorFeedback();
        logger.info("In Controller - All Doctor Feedback Retrieved: " + doctorFeedbackList);
        return new ResponseEntity<>(doctorFeedbackList, HttpStatus.OK);
    }

    /**
     * Handles HTTP PUT request to update the doctor's feedback information by feedbackId in the database.
     *
     * @param feedbackID     The ID of the feedback that needs to be updated.
     * @param doctorFeedback The DoctorFeedback object containing the updated feedback details.
     * @return A ResponseEntity with the response message and HTTP status code.
     * @throws FeedbackNotFoundException If the feedback information is not found in the database.
     */
    @PutMapping("/updateDoctorFeedback/{feedbackID}")
    public ResponseEntity<String> updateDoctorFeedback(@PathVariable(value = "feedbackID") int feedbackID, @RequestBody DoctorFeedback doctorFeedback) throws FeedbackNotFoundException {
        service.updateFeedbackByID(feedbackID, doctorFeedback);
        logger.info("In Controller - Doctor Feedback Updated Successfully: " + doctorFeedback);
        return new ResponseEntity<>("Doctor Feedback updated Successfully", HttpStatus.CREATED);
    }

    /**
     * Handles HTTP DELETE request to delete the doctor's feedback information by feedbackId from the database.
     *
     * @param feedbackID The ID of the feedback that needs to be deleted.
     * @return A ResponseEntity with the response message and HTTP status code.
     * @throws FeedbackNotFoundException If the feedback information is not found in the database.
     */
    @DeleteMapping("/deleteDoctorFeedback/{feedbackID}")
    public ResponseEntity<String> deleteFeedbackByID(@PathVariable(value = "feedbackID") int feedbackID) throws FeedbackNotFoundException {
        service.deleteFeedbackByID(feedbackID);
        logger.info("In Controller - Doctor Feedback Deleted Successfully with ID: " + feedbackID);
        return new ResponseEntity<>("Doctor Feedback deleted Successfully", HttpStatus.OK);
    }
}
