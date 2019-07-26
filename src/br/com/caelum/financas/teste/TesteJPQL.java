package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPQL {
	
	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(2);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta" +
		"and m.tipo = :pTipo order by m.valor desc";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> resultados = query.getResultList();
		
		for (Movimentacao movimentacao : resultados) {
			
			System.out.println("Descrição:" + movimentacao.getDescricao());
			System.out.println("Conta.Id:" + movimentacao.getConta().getId());

		}
		
		em.getTransaction().commit();
		em.close();
	}

}
