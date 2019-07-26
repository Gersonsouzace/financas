package br.com.caelum.financas.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity //Anotação para falara que usar a classe como persistencia com HIBERNATE
public class Conta {
	
	@Id //Indica que o ID sera chave primaria tendo aassim uam estrategia
	@GeneratedValue(strategy = GenerationType.IDENTITY) //indica a estrategia que o ID sera gerenciado
	private Integer id;
	private String titular;
	private String numero;
	private String banco;
	private String agencia;
	
	@OneToMany  (mappedBy = "conta") //mapeando o relacionamento para que nao seja criado uma nova tabela.
	
	private List<Movimentacao> movimentacoes;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public List<Movimentacao> getMovimentacoes() {
		// TODO Auto-generated method stub
		return movimentacoes;
	}
	
	
	
}
