package br.com.restfull.controller;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.com.restfull.http.Product;
import br.com.restfull.repository.ProductRepository;
import br.com.restfull.repository.entity.ProductEntity;


/**
 * Essa classe vai expor os nosso métodos para serem acessasdos via http
 * 
 * @Path - Caminho para a chamada da classe que vai representar o nosso serviço
 * */
@Path("/service")
public class ServiceController {
		
	private final  ProductRepository repository = new ProductRepository();

	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 * Esse método cadastra uma nova TASK
	 * */
	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/")
	public String Cadastrar(Product product){
		
		if (product.getCd_product() > 0) {
			return this.Alterar(product);
		}else {
			ProductEntity entity = new ProductEntity();
			
			entity.setNmProduct(product.getNm_product());
			entity.setDsProduct(product.getDs_product());
			entity.setStatus(product.getStatus());
			
			repository.Salvar(entity);
			
			return "{\"cd_product\": \"" + entity.getCdProduct() + "\", \"nm_product\": \"" + entity.getNmProduct() + "\", \"ds_product\": \"" + entity.getDsProduct() + "\", \"status\": \"" + entity.getStatus() + "\"}";
			//return new Product(entity.getCdProduct(), entity.getNmProduct(), entity.getDsProduct(), entity.getStatus());
		}
	
	}
	
	/**
	 * Essse método altera uma TASK já cadastrada
	 * **/
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/")
	public String Alterar(Product product){
		
		ProductEntity entity = new ProductEntity();
		
		entity.setCdProduct(product.getCd_product());
		entity.setNmProduct(product.getNm_product());
		entity.setDsProduct(product.getDs_product());
		entity.setStatus(product.getStatus());
		
		repository.Alterar(entity);
		
		return "{\"cd_product\": \"" + entity.getCdProduct() + "\", \"nm_product\": \"" + entity.getNmProduct() + "\", \"ds_product\": \"" + entity.getDsProduct() + "\", \"status\": \"" + entity.getStatus() + "\"}";
			
	}
	
	/**
	 * Esse método lista todas as TASKS cadastradas na base
	 * */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/")
	public List<Product> AllProducts(){
		
		List<Product> product =  new ArrayList<Product>();
		
		List<ProductEntity> listaEntityProducts = repository.TodasPessoas();
		
		for (ProductEntity entity : listaEntityProducts) {
			
			product.add(new Product(entity.getCdProduct(), entity.getNmProduct(), entity.getDsProduct(), entity.getStatus()));
		}
		
		return product;
	}
	
	/**
	 * Excluindo uma TASK pelo código
	 * */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/{cd_product}")	
	public String Excluir(@PathParam("cd_product") Integer cd_product){	
			
		repository.Excluir(cd_product);
		return "{\"count\": \"" + cd_product + "\"}";
	
	}
	
}
