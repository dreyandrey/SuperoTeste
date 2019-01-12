package br.com.restfull.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.restfull.repository.entity.ProductEntity;



public class ProductRepository {

	private final EntityManagerFactory entityManagerFactory;
	
	private final EntityManager entityManager;
	
	public ProductRepository(){
		
		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_test_supero");
		
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void Salvar(ProductEntity productEntity){
		
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(productEntity);
		this.entityManager.getTransaction().commit();
	}
	
	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void Alterar(ProductEntity productEntity){
		
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(productEntity);
		this.entityManager.getTransaction().commit();
	}
	
	/**
	 * RETORNA TODAS AS TASKS CADASTRADAS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<ProductEntity> TodasPessoas(){
		
		return this.entityManager.createQuery("SELECT t FROM ProductEntity t").getResultList();
	}
	
	/**
	 * CONSULTA UM TASK CADASTRA PELO CÓDIGO
	 * */
	public ProductEntity GetProduct(Integer cd_product){
		
		return this.entityManager.find(ProductEntity.class, cd_product);
	}
	
	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void Excluir(Integer cd_product){
		
		ProductEntity product = this.GetProduct(cd_product);
		
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(product);
		this.entityManager.getTransaction().commit();
		
	}
}
