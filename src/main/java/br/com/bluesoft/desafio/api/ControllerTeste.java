package br.com.bluesoft.desafio.api;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.bluesoft.desafio.model.Fornecedor;
import br.com.bluesoft.desafio.model.Pedido;
import br.com.bluesoft.desafio.model.Preco;
import br.com.bluesoft.desafio.service.FornecedorService;
import br.com.bluesoft.desafio.service.PedidoService;

@RestController
public class ControllerTeste {

  @Autowired
  FornecedorService fornecedorService;
  
  @Autowired
  PedidoService pedidoService;
  
  @GetMapping("testa")
  public  List<Pedido> teste(){
    Map<String, Integer> mapPedido = new HashMap<>();
    mapPedido.put("7894900011517",1);
    mapPedido.put("7891910000197",10);
    mapPedido.put("7892840222949",7);

    return pedidoService.teste(mapPedido);
  }
  
  
  public List<Fornecedor> listaDeFornecedores() {
    return Arrays.asList(
    new Fornecedor("56.918.868/0001-20","Fornecedor1",listaDePrecos(1,1)),
    new Fornecedor("56.918.868/0001-20","Fornecedor2",listaDePrecos(2,1)));
  }

  public List<Fornecedor> listaDeFornecedores(int quantidadeMinima) {
    return Arrays.asList(
    new Fornecedor("56.918.868/0001-20","Fornecedor1",listaDePrecos(1,quantidadeMinima)),
    new Fornecedor("56.918.868/0001-20","Fornecedor2",listaDePrecos(2,quantidadeMinima)));
  }

  public List<Preco> listaDePrecos(int tipo,int quantidadeMinima) {
    List<Preco> precos;
    if(tipo == 1){
      precos = Arrays.asList(new Preco(2.5, quantidadeMinima),new Preco(2.0, 10));
    }else{
      precos = Arrays.asList(new Preco(2.7, quantidadeMinima),new Preco(1.5, 15));
    }
    return precos;
  }



}
