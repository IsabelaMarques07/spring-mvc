package br.com.fiap.appprodutoteste.produto.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ModelAndView criar(ClienteDTO cliente) {
		ModelAndView model = new ModelAndView("clientes/criar");
		return model;
	}
	
	@PostMapping("clientes")
	public ModelAndView salvar(@Valid ClienteDTO cliente, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			System.out.println("Temos erros!");
			return new ModelAndView("/clientes/criar");
		}
		
		
		Cliente clienteEntity = modelMapper.map(cliente, Cliente.class);
		clienteRepository.save(clienteEntity);
		return new ModelAndView("redirect:/clientes");
	}
	
	@GetMapping("clientes/{id}")
	public ModelAndView mostrar(@PathVariable Long id) {
		
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if(cliente.isPresent()) {
			Cliente clienteGet = cliente.get();
			ModelAndView modelView = new ModelAndView("clientes/detalhe");
			modelView.addObject("cliente", clienteGet);
			return modelView;
		}
		System.out.println("não encontrado!");
		return new ModelAndView("redirect:/clientes");
	}
	
}


















