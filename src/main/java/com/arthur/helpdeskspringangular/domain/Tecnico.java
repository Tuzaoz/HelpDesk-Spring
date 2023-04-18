package com.arthur.helpdeskspringangular.domain;

import com.arthur.helpdeskspringangular.domain.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class Tecnico extends Pessoa {
    private List<Chamado> chamados = new ArrayList<>();

    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
    }

    public Tecnico() {
        super();
    }

    public List<Chamado> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
    }
}