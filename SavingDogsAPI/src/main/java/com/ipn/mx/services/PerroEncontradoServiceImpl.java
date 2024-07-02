package com.ipn.mx.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.domain.PerroEncontrado;
import com.ipn.mx.domain.perroPerdido;
import com.ipn.mx.domain.Usuario;
import com.ipn.mx.domain.perroPerdido;
import com.ipn.mx.domain.repository.PerroEncontradoRepository;
import com.ipn.mx.domain.repository.PerroPerdidoRepository;

@Service
public class PerroEncontradoServiceImpl implements PerroEncontradoService {
    
    @Autowired
    PerroEncontradoRepository encontradoRepository;

    @Autowired
    PerroPerdidoRepository perdidoRepository;
    
    @Override
    @Transactional(readOnly = true)
    public List<PerroEncontrado> findAll() {
        return (List<PerroEncontrado>) encontradoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public PerroEncontrado findById(Long id) {
        return encontradoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public PerroEncontrado save(PerroEncontrado perroencontrado) {
        return  encontradoRepository.save(perroencontrado);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        encontradoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public PerroEncontrado registroEncontrado(PerroEncontrado perroencontrado) {
        PerroEncontrado savedPerro = encontradoRepository.save(perroencontrado);

        List<perroPerdido> perrosPerdidos = perdidoRepository.findBycolorAndRaza(perroencontrado.getColor(), perroencontrado.getRaza());

        for (perroPerdido perdido : perrosPerdidos) {
            Usuario contacto = new Usuario();
            contacto.setNombre(perroencontrado.getNombre() + " " + perroencontrado.getAp() + " " + perroencontrado.getAm());
            contacto.setCorreo(perroencontrado.getCorreo());
        }

        return savedPerro;
    }
    
    @Override
    public List<PerroEncontrado> findByCorreo (String correo) {
        return encontradoRepository.findByCorreo(correo);
    }

    
}
