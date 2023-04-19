package com.arthur.helpdeskspringangular;

import com.arthur.helpdeskspringangular.domain.Chamado;
import com.arthur.helpdeskspringangular.domain.Cliente;
import com.arthur.helpdeskspringangular.domain.Tecnico;
import com.arthur.helpdeskspringangular.domain.enums.Perfil;
import com.arthur.helpdeskspringangular.domain.enums.Prioridade;
import com.arthur.helpdeskspringangular.domain.enums.Status;
import com.arthur.helpdeskspringangular.domain.repositories.ChamadoRepository;
import com.arthur.helpdeskspringangular.domain.repositories.ClienteRepository;
import com.arthur.helpdeskspringangular.domain.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelpdeskSpringAngularApplication implements CommandLineRunner {
    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;
    public static void main(String[] args) {
        SpringApplication.run(HelpdeskSpringAngularApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Tecnico tec1 = new Tecnico(null, "Valdir Cezar", "123.123.123-12","valdircezar@gmaiç.com","123455");
        tec1.setPerfil(Perfil.ADMIN);
        Cliente cli1 = new Cliente(null, "linus turvalds", "234.232.234-23","linus@gmail.com","12341234");
        Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1,cli1);
        tecnicoRepository.save(tec1);
        clienteRepository.save(cli1);
        chamadoRepository.save(c1);

    }
}
