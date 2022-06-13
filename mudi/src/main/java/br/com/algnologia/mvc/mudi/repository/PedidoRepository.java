package br.com.algnologia.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.algnologia.mvc.mudi.model.Pedido;
import br.com.algnologia.mvc.mudi.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	List<Pedido> findByStatus(StatusPedido status);
	
	// filtrar pedido com o nome de usuarios / achar todos os usuarios que compraram algum pedido
	@Query("select p from Pedido p join p.user u where u = :username")
	List<Pedido> findAllByUsuario(@Param("username") String username);
	
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	public List<Pedido> recuperaTodosOsPedidos() {
//		Query query = entityManager.createQuery("select p from Pedido p", Pedido.class);
//		return query.getResultList();
//	}
	
	

}
