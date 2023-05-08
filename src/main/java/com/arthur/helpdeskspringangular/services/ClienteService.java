package com.arthur.helpdeskspringangular.services;

import com.arthur.helpdeskspringangular.domain.Pessoa;
import com.arthur.helpdeskspringangular.domain.Cliente;
import com.arthur.helpdeskspringangular.domain.dtos.ClienteDTO;
import com.arthur.helpdeskspringangular.repositories.ClienteRepository;
import com.arthur.helpdeskspringangular.repositories.PessoaRepository;
import com.arthur.helpdeskspringangular.services.exceptions.DataIntegrityViolationException;
import com.arthur.helpdeskspringangular.services.exceptions.ObjectNotFoundExcpetion;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PessoaRepository pessoaRepository;
    public Cliente findById(Integer id){
        Optional<Cliente> obj = clienteRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundExcpetion("Objeto não encontrado! id:"+id));
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente add(ClienteDTO ClienteDTO) {
        ClienteDTO.setId(null);
        ValidCpfEmail(ClienteDTO);
        Cliente Cliente = new Cliente(ClienteDTO);
        clienteRepository.save(Cliente);
        return Cliente;
    }

    public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
        objDTO.setId(id);
        Cliente oldObj = findById(id);
        ValidCpfEmail(objDTO);
        oldObj = new Cliente(objDTO);
        return clienteRepository.save(oldObj);
    }

    private void ValidCpfEmail(ClienteDTO ClienteDTO) {
        Optional<Pessoa> obj = pessoaRepository.findByCpf(ClienteDTO.getCpf());
        if(obj.isPresent() && obj.get().getId() != ClienteDTO.getId()){
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
        }

        obj = pessoaRepository.findByEmail(ClienteDTO.getEmail());
        if(obj.isPresent() && obj.get().getId() != ClienteDTO.getId()) {
            throw new DataIntegrityViolationException("email já cadastrado no sistema");
        }

    }

    public void delete(Integer id) {
        Cliente obj = findById(id);
        if (obj.getChamados().size() > 0){
            throw new DataIntegrityViolationException("Ordens de serviços em aberto");
        } clienteRepository.deleteById(id);
    }
}
