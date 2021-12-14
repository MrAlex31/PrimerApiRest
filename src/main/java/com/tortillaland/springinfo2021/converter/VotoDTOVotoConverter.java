package com.tortillaland.springinfo2021.converter;

import java.time.LocalDateTime;
import com.tortillaland.springinfo2021.dto.VotoDTO;
import com.tortillaland.springinfo2021.entity.Voto;
import com.tortillaland.springinfo2021.repository.EmprendimientoRepository;
import com.tortillaland.springinfo2021.repository.UsuarioRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VotoDTOVotoConverter implements Converter<VotoDTO, Voto> {
    public VotoDTOVotoConverter(EmprendimientoRepository emprendimientoRepository,
                                  UsuarioRepository usuarioRepository) {
    }
    @Override
    public Voto convert(VotoDTO votoDto) {
        Voto voto = new Voto();
        voto.setGenerado(votoDto.getGenerado());
        voto.setUsuarioId(votoDto.getUsuarioId());
        voto.setEmprendimientoId(votoDto.getEmprendimientoId());
        voto.setFechaDeCreacion(LocalDateTime.now());
        return voto;
    } 
}