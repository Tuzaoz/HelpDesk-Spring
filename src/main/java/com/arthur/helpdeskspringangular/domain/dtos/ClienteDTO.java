package com.arthur.helpdeskspringangular.domain.dtos;

import com.arthur.helpdeskspringangular.domain.Cliente;
import com.arthur.helpdeskspringangular.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClienteDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4333557115818058190L;
    protected Integer id;
    @NotNull(message = "Campo Nome obrigatório")
    protected String nome;
    @NotNull(message = "Campo CPF obrigatório")
    protected String cpf;
    @NotNull(message = "Campo EMAIL obrigatório")
    protected String email;
    @NotNull(message = "Campo Senha obrigatório")
    protected String senha;

    protected Set<Integer> perfil = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCricao = LocalDate.now();

    public ClienteDTO() {
        super();
        setPerfil(Perfil.CLIENTE);
    }

    public ClienteDTO(Cliente obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.perfil = obj.getPerfil().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
        this.dataCricao = obj.getDataCricao();
        setPerfil(Perfil.CLIENTE);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Perfil> getPerfil() {
        return perfil.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void setPerfil(Perfil perfil) {
        this.perfil.add(perfil.getCodigo());
    }

    public LocalDate getDataCricao() {
        return dataCricao;
    }

    public void setDataCricao(LocalDate dataCricao) {
        this.dataCricao = dataCricao;
    }
}
