package ao.com.api.produtos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ao.com.api.produtos.molelo.produtoModelo;
import ao.com.api.produtos.molelo.respostaModelo.respostaModelo;
import ao.com.api.produtos.repositorio.produtoRepositorio;

@Service
public class produtoServico {

    @Autowired
    private produtoRepositorio pr;

    @Autowired
    private respostaModelo rm;

    // Método para listar todos os produtos
    public Iterable<produtoModelo> listarProdutos() {
        return pr.findAll();
    }

    // Método para CADASTRAR ou ALTERAR Produtos
    public ResponseEntity<?> cadastrarAlterar(produtoModelo pModelo, String accao) {

        if (pModelo.getNome().isEmpty()) {
            rm.setMensagem("O nome do produto é Obrigatório!");
            return new ResponseEntity<respostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if (pModelo.getMarca().isEmpty()) {
            rm.setMensagem("A marca do produto é Obrigatório!");
            return new ResponseEntity<respostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else {
            if (accao.equals("cadstrar")) {
                return new ResponseEntity<produtoModelo>(pr.save(pModelo), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<produtoModelo>(pr.save(pModelo), HttpStatus.OK);
            }
        }

    }
     // Método para APAGAR Produtos
     public ResponseEntity<respostaModelo>remover(Long codigo){
        pr.deleteById(codigo);
        rm.setMensagem("O produto foi Apagado com Sucesso!");
        return new ResponseEntity<respostaModelo>(rm,HttpStatus.OK);
     }

}
