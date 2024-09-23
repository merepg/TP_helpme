package org.example.tp.interfaces;

import org.example.tp.dtos.PsicologoDTO;
import org.example.tp.entities.Psicologo;

import java.util.List;

public interface PsicologoService {
    public List<Psicologo> obtenerPsicologos();
    public Psicologo registrar(PsicologoDTO psicologoDTO);
    public void eliminar(Integer id);
    public Psicologo actualizar (Psicologo psicologo);
}
