package br.com.bluesoft.desafio.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.data.form.DataFormulario;
import br.com.bluesoft.desafio.service.PedidoService;

@RestController
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;

	@GetMapping("pedido/all")
	public  Iterable<Pedido> AllPedidos(){
		return pedidoService.getAllPedidos();
	}
	
	@PostMapping(value ="pedido/salva",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Pedido> salva(@RequestBody  List<DataFormulario> pedidos){
		Map<String, Integer> mapPedido = new HashMap<>();
		mapPedido.put("7894900011517",1);
		mapPedido.put("7891910000197",10);
		mapPedido.put("7892840222949",7);
		
		return pedidoService.montaPedidos(pedidos);
	}
}