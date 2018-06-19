package br.com.correios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.correios.dto.BuscaCepDTO;
import br.com.correios.model.Logradouro;

public interface BuscaCepRepository extends JpaRepository<Logradouro, Long> {

	@Query("Select new br.com.correios.dto.BuscaCepDTO(l.nome, l.bairro.nome, concat(l.bairro.cidade.nome, '/', l.bairro.cidade.estado.uf), l.cep) from Logradouro l where l.bairro.cidade.estado.uf like concat('%', :UF, '%') and l.bairro.cidade.nome like concat('%', :Localidade, '%') and l.nome like concat('%', :Logradouro, '%')")
	List<BuscaCepDTO> buscaPorUfLogradouroLocalidade(@Param("UF") String UF, @Param("Localidade") String Localidade, @Param("Logradouro") String Logradouro);
}
