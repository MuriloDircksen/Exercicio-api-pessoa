package br.com.futurodev.controllers;

import br.com.futurodev.model.PessoaModel;
import br.com.futurodev.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<PessoaModel> cadastrar(@RequestBody PessoaModel pessoa){
        PessoaModel p =pessoaRepository.save(pessoa);

        return new ResponseEntity<PessoaModel>(p, HttpStatus.CREATED);
    }
    @GetMapping(value = "/{idPessoa}")
    public ResponseEntity<PessoaModel> getPessoabyId(@PathVariable Long idPessoa){
        PessoaModel p = pessoaRepository.findById(idPessoa).get();
        return new ResponseEntity<PessoaModel>(p, HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<PessoaModel> atualizar (@RequestBody PessoaModel pessoa){
        PessoaModel p = pessoaRepository.save(pessoa);

        return new ResponseEntity<PessoaModel>(p, HttpStatus.OK);
    }

    @DeleteMapping(value = "/")
    @ResponseBody
    public ResponseEntity<String> deletar(@RequestParam Long idPessoa){
        pessoaRepository.deleteById(idPessoa);

        return new ResponseEntity<String>("Pessoa Deletada", HttpStatus.OK);
    }
    @GetMapping(value = "/buscarPorNome", produces = "application/json")
    public ResponseEntity<List<PessoaModel>> getPessoaByNome (@RequestParam(name = "nome") String nome){

        List<PessoaModel> pessoas = pessoaRepository.getPessoaByNome(nome);

        return new ResponseEntity<List<PessoaModel>>(pessoas, HttpStatus.OK);
    }
}
