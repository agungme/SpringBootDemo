package com.springboot.jpahibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "username", length = 50, unique = true)
	@NotNull
	@Size(min = 3, max = 50)
	private String username;

	@Column(name = "password", length = 100)
	@Size(min = 4, max = 100)
	private String password;

	@Column(name = "firstname", length = 50)
	@Size(min = 2, max = 50)
	private String firstname;

	@Column(name = "lastname", length = 50)
	@Size(min = 2, max = 50)
	private String lastname;

	@Column(name = "email", length = 50)
	@Size(min = 4, max = 50)
	private String email;

	@Column(name = "age")
	private Integer age;

	@Column(name = "status")
	private boolean status;

}
