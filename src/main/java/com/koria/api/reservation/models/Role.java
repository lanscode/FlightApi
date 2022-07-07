package com.koria.api.reservation.models;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;


@Entity
public class Role extends AbstractEntity implements GrantedAuthority {
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private String name;
	@Getter @Setter
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	@Override
	public String getAuthority() {
		return name;
	}
}
