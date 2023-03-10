package com.example.LaonAppForUser.service;

import java.util.List;

import com.example.LaonAppForUser.model.Loan;

public interface LoanService {

	List<Loan> getAllLoans();
	List<Loan> getAllLoansByCustomerId(int customerId);
	Loan createCustomerNewLoan(Loan loan);
	Loan updateLoan(Loan loan) throws Exception;
	void deleteLoan(int id) throws Exception;
}
