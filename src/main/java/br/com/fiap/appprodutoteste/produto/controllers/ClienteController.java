package br.com.fiap.appprodutoteste.produto.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.appprodutoteste.produto.dto.ClienteDTO;
import br.com.fiap.appprodutoteste.produto.model.Cliente;
import br.com.fiap.appprodutoteste.produto.repositories.ClienteRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/clientes")
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("clientes/index");
		
		List<Cliente> clientesDaRepository = clienteRepository.findAll();
		model.addObject("listarClientes", clientesDaRepository);
		
		//Cliente cliente = new Cliente();
		
		return model;
	}
	
	@GetMapping("/clientes/criar")
	public ModelAndView criar() {
		ModelAndView model = new ModelAndView("clientes/criar");
		return model;
	}
	
	@PostMapping("clientes")
	public String salvar(ClienteDTO cliente) {
		Cliente clienteEntity = modelMapper.map(cliente, Cliente.class);
		clienteRepository.save(clienteEntity);
		return "redirect:/clientes";
	}
	
}
