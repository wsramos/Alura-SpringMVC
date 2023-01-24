package br.com.alura.mvc.mudi.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Pedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PedidoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Pedido> recuperaTodosOsPedidos() {
		return entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
	}

}
