package org.ewarsztat.approach.common.service;

import org.ewarsztat.approach.common.model.Sheet;
import org.ewarsztat.approach.common.repository.SheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SheetService {

    @Autowired
    SheetRepository sheetRepository;

    public void save(Sheet sheet) {
        sheetRepository.save(sheet);
        // TODO ?
        // mail notification ?
        // sms notification ?
    }

    public List<Sheet> getAll() {
        return sheetRepository.findAll();
    }

    public Optional<Sheet> getById(Long id) {
        return sheetRepository.findById(id);
    }

    public void delete(Long id) {
        sheetRepository.deleteById(id);
    }
}
