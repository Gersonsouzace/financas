package br.com.caelum.financas.teste;

//import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
//import javax.persistence.Query;
import javax.persistence.TypedQuery;

//import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(2);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		

		
//		MovimentacaoDAO dao = new MovimentacaoDAO(em);
		TypedQuery<Double> typedQuery = em.createNamedQuery("MedidasPorDiaETipo", Double.class);
		
		typedQuery.setParameter("pConta", conta);
		typedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);

//		dao.setEm(em);
		//List<Double> medias = dao.getMediasPorDiaETipo(TipoMovimentacao.SAIDA, conta);
		List<Double> medias = typedQuery.getResultList();	
		for(Double media : medias) {
			
			System.out.println("A media �:" + media);
		}
		
		em.getTransaction().commit();
		em.close();
	}
}
