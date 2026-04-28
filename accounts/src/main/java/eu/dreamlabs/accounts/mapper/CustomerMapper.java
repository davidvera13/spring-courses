package eu.dreamlabs.accounts.mapper;

import eu.dreamlabs.accounts.dto.CustomerDto;
import eu.dreamlabs.accounts.io.entity.CustomerEntity;

public class CustomerMapper {
	public static CustomerDto mapToCustomerDto(CustomerEntity customer, CustomerDto customerDto) {
		customerDto.setName(customer.getName());
		customerDto.setEmail(customer.getEmail());
		customerDto.setMobileNumber(customer.getMobileNumber());
		return customerDto;
	}

	public static CustomerEntity mapToCustomer(CustomerDto customerDto, CustomerEntity customer) {
		customer.setName(customerDto.getName());
		customer.setEmail(customerDto.getEmail());
		customer.setMobileNumber(customerDto.getMobileNumber());
		return customer;
	}
}
