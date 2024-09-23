package org.example.tp.controllers;

import org.example.tp.dtos.CitaDTO;
import org.example.tp.entities.Cita;
import org.example.tp.interfaces.CitaService;
import org.example.tp.services.CitaServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CitaController {
    @Autowired
    private CitaServiceImpl citaServiceImpl;

    @GetMapping("/citas")
    public List<CitaDTO> obtenerCitas() {
        ModelMapper modelMapper= new ModelMapper();
        List<Cita> cita=citaServiceImpl.obtenercitas();
        List<CitaDTO> citaDTOS= Arrays.asList(modelMapper.map(cita, CitaDTO[].class));
        return citaDTOS;
    }

    @PostMapping("/cita")
    public CitaDTO registrar(@RequestBody CitaDTO citaDTO){
        ModelMapper mapper= new ModelMapper();
        Cita cita= mapper.map(citaDTO, Cita.class);
        cita=citaServiceImpl.registrar(cita);
        return mapper.map(cita, CitaDTO.class);
    }


    @DeleteMapping("/cita/{id}")
    public void eliminar(@PathVariable Integer id) throws Exception{
        ModelMapper mapper= new ModelMapper();
        try{
            citaServiceImpl.eliminar(id);
        } catch (Exception e) {
            throw new Exception("Disculpe la molestia, no se ha podido eliminar");
        }
    }

    @PutMapping("/cita")
    public ResponseEntity<CitaDTO> actualizar(@RequestBody CitaDTO citaDTO) throws Exception{
        ModelMapper mapper= new ModelMapper();
        try{
            Cita cita= mapper.map(citaDTO, Cita.class);
            cita=citaServiceImpl.actualizar(cita);
            citaDTO=mapper.map(cita, CitaDTO.class);
        } catch (Exception e) {
            return new ResponseEntity<>(citaDTO, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(citaDTO);
    }
}
