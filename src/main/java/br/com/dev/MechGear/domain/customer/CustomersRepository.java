package br.com.dev.MechGear.domain.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<CustomersImpl, Long> {
}
