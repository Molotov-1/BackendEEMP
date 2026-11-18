package com.EEMP.userService.service;
import org.springframework.stereotype.Service;

import com.EEMP.userService.model.Usuario;
import com.EEMP.userService.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return repository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    public Optional<Usuario> update(Long id, Usuario datos) {
        return repository.findById(id).map(usuario -> {
            usuario.setNombre(datos.getNombre());
            usuario.setEmail(datos.getEmail());
            usuario.setCargo(datos.getCargo());
            usuario.setPassword(datos.getPassword());
            usuario.setActivo(datos.isActivo());
            return repository.save(usuario);
        });
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}