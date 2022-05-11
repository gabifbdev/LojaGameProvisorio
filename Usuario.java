package com.lojaGames.lojaGames.model;

public class Usuario {

	
	
	package com.blogpessoal.blogpessoal.model;

	import java.util.List;

	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;
	import javax.validation.constraints.Email;
	import javax.validation.constraints.NotBlank;
	import javax.validation.constraints.NotNull;
	import javax.validation.constraints.Size;

	import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name = "tb_usuarios")
	public class Usuario {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotNull(message = "O atributo Nome é Obrigatório!")
		private String nome;

		@NotNull(message = "O atributo Usuário é Obrigatório!")
		@Email(message = "O atributo Usuário deve ser um email válido!")
		private String usuario;

		@NotBlank(message = "O atributo Senha é Obrigatório!")
		@Size(min = 8, message = "A Senha deve ter no mínimo 8 caracteres")
		private String senha;

		private String foto;

		
		@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
		@JsonIgnoreProperties("usuario")
		private List<Postagem> postagem;

		
		
		
