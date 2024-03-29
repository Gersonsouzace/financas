package br.com.caelum.financas.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import org.hibernate.cfg.JPAIndexHolder;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class PopulaMovimentacoesComCategoria {

	public static void main(String[] args) {

		Categoria categoria1 = new Categoria("Viagem");
//		categoria1.setNome("Viagem");

		Categoria categoria2 = new Categoria("Negocios");
//		categoria2.setNome("Negocios");
		
		//Criando a conta a ser referenciada a movimentacao
		Conta conta = new Conta();
		conta.setId(2);

		
		//Criando a primeira movimentacao
		Movimentacao movimentacao1 = new Movimentacao();

		movimentacao1.setData(Calendar.getInstance()); // calendar.getInstance para pegar a data de hoje.
		movimentacao1.setDescricao("Viagem � SP");
		movimentacao1.setTipo(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal("1500.0"));
		movimentacao1.setCategoria(Arrays.asList(categoria1, categoria2));
		movimentacao1.setConta(conta);

		
		//Criando a segunda movimentacao
		Movimentacao movimentacao2 = new Movimentacao();
		
		Calendar amanha = Calendar.getInstance();
		amanha.add(Calendar.DAY_OF_MONTH, 1);

		movimentacao2.setData(amanha); //data de amanha
		movimentacao2.setDescricao("Viagem � FOZ");
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("2000.0"));
		movimentacao2.setCategoria(Arrays.asList(categoria1));
		movimentacao2.setConta(conta);
		
		//Abrindo a Persistencia com JPA
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(categoria1);
		em.persist(categoria2);
		
		
		em.persist(movimentacao1);
		em.persist(movimentacao2);
		
		
		
		
		em.getTransaction().commit();
		em.close();

	}

}
