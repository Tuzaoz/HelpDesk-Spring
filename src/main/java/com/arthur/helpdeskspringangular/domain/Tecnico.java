package com.arthur.helpdeskspringangular.domain;

import com.arthur.helpdeskspringangular.domain.Pessoa;
import com.arthur.helpdeskspringangular.domain.dtos.TecnicoDTO;
import com.arthur.helpdeskspringangular.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Tecnico extends Pessoa {
    @Serial
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @OneToMany(mappedBy = "tecnico")
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        setPerfil(Perfil.CLIENTE);


    }
    public Tecnico(TecnicoDTO obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfil = obj.getPerfil().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCricao = obj.getDataCricao();
    }

    public Tecnico() {
        super();
        setPerfil(Perfil.CLIENTE);
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}
