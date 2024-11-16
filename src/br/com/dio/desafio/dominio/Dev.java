package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    
    public Dev(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    public void inscreverBootcamp(Bootcamp bootcamp) {
        if (bootcamp == null) {
            throw new IllegalArgumentException("Bootcamp não pode ser nulo.");
        }
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }
    
    public void progredir() {
    	conteudosInscritos.stream()
    	.findFirst()
        .ifPresentOrElse(conteudo -> { 
        	conteudosConcluidos.add(conteudo); 
        	conteudosInscritos.remove(conteudo);
        }, () -> System.err.println("Você não está matriculado em nenhum conteúdo!"));
    }

    public double calcularTotalXp() {
    	return conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
    	if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
    
    @Override
    public String toString() {
        return String.format("Dev{nome='%s', conteudosInscritos=%d, conteudosConcluidos=%d, totalXp=%.2f}",
                nome, conteudosInscritos.size(), conteudosConcluidos.size(), calcularTotalXp());
    }
}
