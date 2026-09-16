package com.stefany.user.business;

import com.stefany.user.infrastructure.Exceptions.ConflictException;
import com.stefany.user.infrastructure.entity.Usuario;
import com.stefany.user.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletionException;

// server regra de negocio,
@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario){
        try {
                emailExiste(usuario.getEmail());
            return usuarioRepository.save(usuario);
                }
        catch (ConflictException e){
            throw new ConflictException("Email ja cadastrado");
        }
    }


    public void emailExiste(String email) {
        try {
          boolean existe = verificaEmailExistente(email);
          if(existe){
              throw new ConflictException("Email ja cadastrado"+ email);
          }
        }catch (ConflictException e){
            throw new ConflictException("Email ja cadastrado"+ e.getCause());
        }
    }


    public boolean verificaEmailExistente(String email){
        return usuarioRepository.existsByEmail(email);
    }
}
