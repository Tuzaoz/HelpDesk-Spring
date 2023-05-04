package com.arthur.helpdeskspringangular.config;

import com.arthur.helpdeskspringangular.domain.Chamado;
import com.arthur.helpdeskspringangular.domain.Cliente;
import com.arthur.helpdeskspringangular.domain.Tecnico;
import com.arthur.helpdeskspringangular.domain.enums.Perfil;
import com.arthur.helpdeskspringangular.domain.enums.Prioridade;
import com.arthur.helpdeskspringangular.domain.enums.Status;
import com.arthur.helpdeskspringangular.repositories.ChamadoRepository;
import com.arthur.helpdeskspringangular.repositories.ClienteRepository;
import com.arthur.helpdeskspringangular.repositories.TecnicoRepository;
import com.arthur.helpdeskspringangular.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;
    @Bean
    public void instanciadb(){
        this.dbService.instanciaDB();
    }

}
