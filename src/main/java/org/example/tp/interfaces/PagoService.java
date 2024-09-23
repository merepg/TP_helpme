package org.example.tp.interfaces;

import org.example.tp.entities.Pago;

import java.util.List;

public interface PagoService {
    public List<Pago> obtenerPagos();
    public Pago registrar(Pago pago);
    public void eliminar(Integer id);
    public Pago actualizar(Pago pago);
}
