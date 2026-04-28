package eu.dreamlabs.accounts.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

	/**
	 * Returns the current auditor of the application.
	 * this will handle @CreatedBy . @UpdatedBy value	 *
	 * @return the current auditor.
	 */
	@Override
	@NonNull
	public Optional<String> getCurrentAuditor() {
		return Optional.of("ACCOUNTS_MS");
	}
}