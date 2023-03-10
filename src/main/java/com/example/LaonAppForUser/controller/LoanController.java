package com.example.LaonAppForUser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.LaonAppForUser.model.Loan;
import com.example.LaonAppForUser.service.LoanService;

@RestController
public class LoanController {

	@Autowired
	private LoanService loanService;
	
	@GetMapping("/loans")
	public ResponseEntity<List<Loan>> getAllLoans(){
		return ResponseEntity.ok().body(loanService.getAllLoans());
	}
	
	@GetMapping("/loans/{id}")
	public ResponseEntity<List<Loan>> getLoanByCustomerId(@PathVariable int id){
		return ResponseEntity.ok().body(loanService.getAllLoansByCustomerId(id));
	}
	
	@PostMapping("/loans")
	public ResponseEntity<Loan> createNewLoan(@RequestBody Loan loan){
		return ResponseEntity.ok().body(this.loanService.createCustomerNewLoan(loan));
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Loan> updateLoan(@PathVariable int id, @RequestBody Loan loans) throws Exception{
		loans.setCustomerId(id);
		return ResponseEntity.ok().body(this.loanService.updateLoan(loans));
	}
	
	@DeleteMapping("/products/{id}")
	public HttpStatus deleteLoans(@PathVariable int id) throws Exception {
		this.loanService.deleteLoan(id);
		return HttpStatus.OK;
	}
	
}
