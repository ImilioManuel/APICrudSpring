package ao.com.api.produtos.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ao.com.api.produtos.molelo.produtoModelo;

@Repository
public interface produtoRepositorio  extends CrudRepository<produtoModelo,Long>{
    
}
