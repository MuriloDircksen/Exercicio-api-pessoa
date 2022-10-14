package br.com.futurodev.repository;

import br.com.futurodev.model.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {

    @Query(value = "select p from PessoaModel p where p.nome like %?1%")
    ArrayList<PessoaModel> getPessoaByNome(String Nome);
}
