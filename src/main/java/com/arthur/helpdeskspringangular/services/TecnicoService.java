package com.arthur.helpdeskspringangular.services;

import com.arthur.helpdeskspringangular.domain.Pessoa;
import com.arthur.helpdeskspringangular.domain.Tecnico;
import com.arthur.helpdeskspringangular.domain.dtos.TecnicoDTO;
import com.arthur.helpdeskspringangular.repositories.PessoaRepository;
import com.arthur.helpdeskspringangular.services.exceptions.DataIntegrityViolationException;
import com.arthur.helpdeskspringangular.services.exceptions.ObjectNotFoundExcpetion;
import com.arthur.helpdeskspringangular.repositories.TecnicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    public Tecnico findById(Integer id){
        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundExcpetion("Objeto não encontrado! id:"+id));
    }

    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    public Tecnico add(TecnicoDTO tecnicoDTO) {
        tecnicoDTO.setId(null);
        ValidCpfEmail(tecnicoDTO);
        Tecnico tecnico = new Tecnico(tecnicoDTO);
        tecnicoRepository.save(tecnico);
        return tecnico;
    }

    public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
        objDTO.setId(id);
        Tecnico oldObj = findById(id);
        ValidCpfEmail(objDTO);
        oldObj = new Tecnico(objDTO);
        return tecnicoRepository.save(oldObj);
    }

    private void ValidCpfEmail(TecnicoDTO tecnicoDTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(tecnicoDTO.getCpf());
        if(obj.isPresent() && obj.get().getId() != tecnicoDTO.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
        }

        obj = pessoaRepository.findByEmail(tecnicoDTO.getEmail());
        if(obj.isPresent() && obj.get().getId() != tecnicoDTO.getId()) {
            throw new DataIntegrityViolationException("email já cadastrado no sistema");
        }

    }
}
