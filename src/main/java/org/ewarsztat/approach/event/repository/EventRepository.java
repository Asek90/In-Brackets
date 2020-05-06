package org.ewarsztat.approach.event.repository;

import org.ewarsztat.approach.event.model.GenericEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<GenericEvent, Long> {
    List<GenericEvent> findAllByIdOrSheetId(Long id, Long id2);
}
