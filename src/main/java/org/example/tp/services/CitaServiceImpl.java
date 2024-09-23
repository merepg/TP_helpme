package org.example.tp.services;

import jakarta.transaction.Transactional;
import org.example.tp.entities.Cita;
import org.example.tp.interfaces.CitaService;
import org.example.tp.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {
    @Autowired
    private CitaRepository citaRepository;

    @Override
    public List<Cita> obtenercitas() {
        return citaRepository.findAll();
    }

    @Transactional
    @Override
    public Cita registrar(Cita cita) {
        return citaRepository.save(cita);
    }

    @Transactional
    @Override
    public void eliminar(Integer id) {
        citaRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Cita actualizar(Cita cita) {
        if(citaRepository.findById(cita.getId()).isPresent()) {
            return citaRepository.save(cita);
        }
        return null;
    }
}
