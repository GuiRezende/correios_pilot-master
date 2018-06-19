/*package br.com.correios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.correios.dto.BuscaCepDTO;
import br.com.correios.repository.BuscaCepRepository;

@Controller
@RequestMapping("/buscaCep")
public class BuscaCepController {
	@Autowired
	private BuscaCepRepository buscaCepRepository;

	@GetMapping
	public String buscaCepEndereco() {
		return "BuscaCep";
	}

	@GetMapping(value="/buscaLocalidadeLogradouro")
	public ModelAndView resultadoBuscaCep(@RequestParam("UF") String UF, @RequestParam("Localidade")String Localidade,@RequestParam("Logradouro") String Logradouro) {
		
		List<BuscaCepDTO> buscaCeps = buscaCepRepository.buscaPorUfLogradouroLocalidade(UF, Localidade, Logradouro);	
		
		ModelAndView mv = new ModelAndView("ResultadoBuscaCep");
		mv.addObject("buscaCeps", buscaCeps);
		return mv;
	}

} 
*/
package br.com.correios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.correios.dto.BuscaCepDTO;
import br.com.correios.repository.BuscaCepRepository;
@Controller
@RequestMapping("/buscaCep")
public class BuscaCepController {
	@Autowired
	private BuscaCepRepository buscaCepRepository;
	
	@GetMapping
	public String buscaCep() {
		return "BuscaCep";
	}

	@GetMapping(value="/buscaLocalidadeLogradouro")
	public ModelAndView resultadoBuscaCep(@RequestParam ("UF") String UF,@RequestParam ("Localidade") String Localidade,
	@RequestParam ("Logradouro") String Logradouro,	RedirectAttributes attributes) {
		List<BuscaCepDTO> buscaCeps = buscaCepRepository.buscaPorUfLogradouroLocalidade(UF,Localidade,Logradouro);
		
		
		ModelAndView mv = new ModelAndView("ResultadoBuscaCep");
		mv.addObject("buscaCeps", buscaCeps);
		
		if(buscaCeps.isEmpty()) {
			mv.addObject("mensagem","A busca não retornou dados!");
		}else {
			mv.addObject("mensagem","Dados encontrados com sucesso!");			
		}
		
		return mv;
		
	}	
}