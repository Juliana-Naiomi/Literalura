package br.com.alura.alura_literalura;

import br.com.alura.alura_literalura.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraLiteraluraApplication implements CommandLineRunner {

	private final Principal principal;

	// Injeção da dependência Principal
	@Autowired
	public AluraLiteraluraApplication(Principal principal) {
		this.principal = principal;
	}

	public static void main(String[] args) {        SpringApplication.run(AluraLiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		principal.exibeMenu(); // Agora deve funcionar corretamente
	}
}
