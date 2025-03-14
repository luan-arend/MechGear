package br.com.dev.MechGear.domain.items;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<ItemsImpl, Long> {
}
