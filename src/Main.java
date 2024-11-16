import java.time.LocalDate;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {
	public static void main(String[] args) {
		// Criando e configurando os cursos
		Curso cursoJava = criarCurso("Curso Java", "Descrição Curso Java", 8);
		Curso cursoJS = criarCurso("Curso JS", "Descrição Curso JS", 4);

		// Criando e configurando a mentoria
		Mentoria mentoriaJava = criarMentoria("Mentoria Java", "Descrição Mentoria Java");

		// Criando e configurando o Bootcamp
		Bootcamp bootcampJavaDev = criarBootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer",
				cursoJava, cursoJS, mentoriaJava);

		// Criando e configurando o Dev Camila
		Dev camila = criarDev("Camila", bootcampJavaDev);
		progressoDev(camila);

		// Criando e configurando o Dev João
		Dev joao = criarDev("Joao", bootcampJavaDev);
		progressoDev(joao);
	}

	// Método para criar e configurar cursos
	private static Curso criarCurso(String titulo, String descricao, int cargaHoraria) {
		Curso curso = new Curso();
		curso.setTitulo(titulo);
		curso.setDescricao(descricao);
		curso.setCargaHoraria(cargaHoraria);
		return curso;
	}

	// Método para criar e configurar mentoria
	private static Mentoria criarMentoria(String titulo, String descricao) {
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo(titulo);
		mentoria.setDescricao(descricao);
		mentoria.setData(LocalDate.now());
		return mentoria;
	}

	// Método para criar e configurar Bootcamp
	private static Bootcamp criarBootcamp(String nome, String descricao, Conteudo... conteudos) {
		Bootcamp bootcamp = new Bootcamp(nome, descricao);
		for (Conteudo conteudo : conteudos) {
			bootcamp.getConteudos().add(conteudo);
		}
		return bootcamp;
	}

	// Método para criar e configurar um Dev
	private static Dev criarDev(String nome, Bootcamp bootcamp) {
		Dev dev = new Dev(nome); // Usando o novo construtor que recebe o nome
		dev.inscreverBootcamp(bootcamp);
		System.out.println(dev); // Chamando toString para mostrar status inicial do dev
		return dev;
	}

	// Método para simular progresso de um Dev
	private static void progressoDev(Dev dev) {
		dev.progredir();
		dev.progredir();
		System.out.println("-");
		System.out.println(dev); // Chamando toString para mostrar progresso do dev
		System.out.println("-------");
	}
}
