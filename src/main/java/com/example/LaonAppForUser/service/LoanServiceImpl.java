package com.example.LaonAppForUser.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LaonAppForUser.model.Loan;
import com.example.LaonAppForUser.repository.LoanRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanRepository loanRepository;

	@Override
	public List<Loan> getAllLoans() {

		return this.loanRepository.findAll();
	}

	@Override
	public List<Loan> getAllLoansByCustomerId(int customerId) {

		return this.loanRepository.searchByCustomerId(customerId);
	}

	@Override
	public Loan createCustomerNewLoan(Loan loan) {

		return this.loanRepository.save(loan);
	}

	@Override
	public Loan updateLoan(Loan loan) throws Exception {
		Optional<Loan> productDb = this.loanRepository.findById(loan.getCustomerId());

		if (productDb.isPresent()) {
			Loan productUpdate = productDb.get();
			productUpdate.setCustomerId(loan.getCustomerId());
			productUpdate.setLoanType(loan.getLoanType());
			productUpdate.setLoanAmount(loan.getLoanAmount());

			loanRepository.save(productUpdate);
			return productUpdate;
		} else {
			throw new Exception("record not found " + loan.getCustomerId());
		}
	}

	@Override
	public void deleteLoan(int id) throws Exception {

		Optional<Loan> productDb = this.loanRepository.findById(id);
		if (productDb.isPresent()) {
			this.loanRepository.delete(productDb.get());
		} else {
			throw new Exception("record not found " + id);
		}
	}

}
