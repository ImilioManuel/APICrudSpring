package ao.com.api.produtos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ao.com.api.produtos.molelo.produtoModelo;
import ao.com.api.produtos.molelo.respostaModelo.respostaModelo;
import ao.com.api.produtos.servico.produtoServico;

@RestController
@CrossOrigin(origins = "*")
public class produtoControle {
    @Autowired
    private produtoServico ps;

    @GetMapping("/ListarProdutos")
        public Iterable<produtoModelo> ListarProdutos(){
            return ps.listarProdutos();
        }
    
    @PutMapping("/Alterar")
    public ResponseEntity<?> alterar(@RequestBody produtoModelo pmModelo){
        return ps.cadastrarAlterar(pmModelo,"alterar"); 
    }

    @PostMapping("/Cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody produtoModelo pmModelo){
        return ps.cadastrarAlterar(pmModelo,"cadastrar"); 
    }
    @DeleteMapping("/Remover/{codigo}")
    public ResponseEntity<respostaModelo> remover(@PathVariable Long codigo){
        return ps.remover(codigo);


    }

}
