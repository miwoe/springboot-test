package de.miwoe.repository;

import de.miwoe.model.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by mwoelm on 11.07.17.
 */
public interface MyEntityRepository extends JpaRepository<MyEntity, UUID> {
}
