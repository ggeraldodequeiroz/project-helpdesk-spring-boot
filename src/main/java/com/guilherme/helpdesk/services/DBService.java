package com.guilherme.helpdesk.services;

import com.guilherme.helpdesk.domain.Chamado;
import com.guilherme.helpdesk.domain.Cliente;
import com.guilherme.helpdesk.domain.Tecnico;
import com.guilherme.helpdesk.domain.enums.Perfil;
import com.guilherme.helpdesk.domain.enums.Prioridade;
import com.guilherme.helpdesk.domain.enums.Status;
import com.guilherme.helpdesk.repositories.ChamadoRepository;
import com.guilherme.helpdesk.repositories.ClienteRepository;
import com.guilherme.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public void instanciaDB() {
        Tecnico tec1 = new Tecnico(null, "Guilherme Queiroz","103.667.976-46", "guilherme-si@live.com", encoder.encode("123"));
        tec1.addPerfil(Perfil.ADMIN);
        Tecnico tec2 = new Tecnico(null, "Richard Stallman", "903.347.070-56", "stallman@mail.com", encoder.encode("123"));
        Tecnico tec3 = new Tecnico(null, "Claude Elwood Shannon", "271.068.470-54", "shannon@mail.com", encoder.encode("123"));
        Tecnico tec4 = new Tecnico(null, "Tim Berners-Lee", "162.720.120-39", "lee@mail.com", encoder.encode("123"));
        Tecnico tec5 = new Tecnico(null, "Linus Torvalds", "778.556.170-27", "linus@mail.com", encoder.encode("123"));

        Cliente cli1 = new Cliente(null, "Linus Torvalds", "10796737246", "linus@gmail.com", encoder.encode("1234"));
        Cliente cli2 = new Cliente(null, "Marie Curie", "322.429.140-06", "curie@mail.com", encoder.encode("123"));
        Cliente cli3 = new Cliente(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", encoder.encode("123"));
        Cliente cli4 = new Cliente(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", encoder.encode("123"));
        Cliente cli5 = new Cliente(null, "Max Planck", "081.399.300-83", "planck@mail.com", encoder.encode("123"));

        Chamado ch1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
        Chamado ch2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Teste chamado 2", tec1, cli2);
        Chamado ch3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 3", "Teste chamado 3", tec2, cli3);
        Chamado ch4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 4", "Teste chamado 4", tec3, cli3);
        Chamado ch5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 5", "Teste chamado 5", tec2, cli1);
        Chamado ch6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 7", "Teste chamado 6", tec1, cli5);

        tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4, tec5));
        clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3, cli4, cli5));
        chamadoRepository.saveAll(Arrays.asList(ch1, ch2, ch3, ch4, ch5, ch6));
    }
}
