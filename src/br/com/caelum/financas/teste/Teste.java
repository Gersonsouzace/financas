package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;


public class Teste {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		
		conta.setTitular("Leonardo");
		conta.setAgencia("123");
		conta.setBanco("Caixa Economica");
		conta.setNumero("456");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();	
		
		
		em.close();
		//emf.close(); Linha retirada pois a cria��o do EntityManagerFactory foi para uma classe separada
	
	}
	


}
