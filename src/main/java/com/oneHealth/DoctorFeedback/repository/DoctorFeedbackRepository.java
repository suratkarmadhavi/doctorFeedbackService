package com.oneHealth.DoctorFeedback.repository;

import com.oneHealth.DoctorFeedback.entity.DoctorFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The DoctorFeedbackRepository interface extends JpaRepository to perform CRUD operations on DoctorFeedback entity.
 * 
 * This repository provides the necessary methods to interact with the database and manage doctor feedback data.
 * It inherits basic CRUD operations from JpaRepository and supports additional custom queries if needed.
 * 
 * Note: Make sure to import the required entities and annotations from the appropriate packages.
 * 
 * @author Madhavi
 * @version 1
 */
@Repository
public interface DoctorFeedbackRepository extends JpaRepository<DoctorFeedback, Integer> {
 
}
