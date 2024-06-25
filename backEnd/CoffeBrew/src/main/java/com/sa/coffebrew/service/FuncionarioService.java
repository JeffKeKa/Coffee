package com.sa.coffebrew.service;

import com.sa.coffebrew.entity.Funcionario;
import com.sa.coffebrew.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public Long incluirFuncionario(Funcionario funcionario) {
        if(funcionario.getNome() == null ||
               funcionario.getCpf() == null ||
               funcionario.getEmail() == null ||
               funcionario.getCpf().length() > 11 ||
               funcionario.getCpf().length() < 11 ||
               funcionario.getPerfil() == null){
                
               return null;
               }
        return funcionarioRepository.save(funcionario).getIdFuncionario();
    }

    public Boolean excluirFuncionario(Long idFuncionario) {
        try {
            funcionarioRepository.deleteById(idFuncionario);
            return true;
        } catch (Exception ex) {
            System.out.println("Erro ao excluir funcionario ID: " + idFuncionario + " Erro: " + ex.getLocalizedMessage());
            return false;
        }
    }

    public Optional<Funcionario> consultarFuncionario(Long idFuncionario) {
        return funcionarioRepository.findById(idFuncionario);
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Boolean atualizarFuncionario(Funcionario funcionario) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(funcionario.getIdFuncionario());
        if (optionalFuncionario.isPresent()) {
            Funcionario f = optionalFuncionario.get();
            f.setPerfil(funcionario.getPerfil());
            f.setNome(funcionario.getNome());
            f.setCpf(funcionario.getCpf());
            f.setEmail(funcionario.getEmail());
            funcionarioRepository.save(f);
            return true;
        } else {
            return false;
        }
    }
}
