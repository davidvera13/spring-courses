package eu.dreamlabs.loans.mapper;

import eu.dreamlabs.loans.dto.LoanDto;
import eu.dreamlabs.loans.io.entity.LoanEntity;

public class LoanMapper {

    public static LoanDto mapToLoansDto(
            LoanEntity loanEntity,
            LoanDto loansDto) {
        loansDto.setLoanNumber(loanEntity.getLoanNumber());
        loansDto.setLoanType(loanEntity.getLoanType());
        loansDto.setMobileNumber(loanEntity.getMobileNumber());
        loansDto.setTotalLoan(loanEntity.getTotalLoan());
        loansDto.setAmountPaid(loanEntity.getAmountPaid());
        loansDto.setOutstandingAmount(loanEntity.getOutstandingAmount());
        return loansDto;
    }

    public static LoanEntity mapToLoans(
            LoanDto loanDto,
            LoanEntity loanEntity) {
        loanEntity.setLoanNumber(loanDto.getLoanNumber());
        loanEntity.setLoanType(loanDto.getLoanType());
        loanEntity.setMobileNumber(loanDto.getMobileNumber());
        loanEntity.setTotalLoan(loanDto.getTotalLoan());
        loanEntity.setAmountPaid(loanDto.getAmountPaid());
        loanEntity.setOutstandingAmount(loanDto.getOutstandingAmount());
        return loanEntity;
    }
}
