package org.example.tp.interfaces;

import org.example.tp.entities.Cita;

import java.util.List;

public interface CitaService {
    public List<Cita> obtenercitas();
    public Cita registrar(Cita cita);
    public void eliminar(Integer id);
    public Cita actualizar(Cita cita);
}
