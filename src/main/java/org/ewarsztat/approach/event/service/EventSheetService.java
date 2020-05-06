package org.ewarsztat.approach.event.service;

import org.ewarsztat.approach.event.model.CreatedSheetEvent;
import org.ewarsztat.approach.event.model.GenericEvent;
import org.ewarsztat.approach.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventSheetService {


    @Autowired
    EventRepository createdSheetEventRepository;

    public List<GenericEvent> getAll(){
        return createdSheetEventRepository.findAll();
    }

    public List<GenericEvent> getById(Long id) {
        return createdSheetEventRepository.findAllByIdOrSheetId(id, id);
    }

    @EventListener
    public void handleContextStart(GenericEvent genericEvent) {
        createdSheetEventRepository.save(genericEvent);
    }
}
