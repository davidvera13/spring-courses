package eu.dreamlabs.accounts.io.repository;

import eu.dreamlabs.accounts.io.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	// derived name method
	Optional<CustomerEntity> findByMobileNumber(String mobileNumber);
}
