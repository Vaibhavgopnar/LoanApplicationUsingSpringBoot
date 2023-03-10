package com.example.LaonAppForUser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.LaonAppForUser.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer>{
	
//	@Query(value = "select * from loans l where l.customerId=?l", nativeQuery = true)
	
	List<Loan> searchByCustomerId(int customerId);  // updated List<Loan> to Loan
}
