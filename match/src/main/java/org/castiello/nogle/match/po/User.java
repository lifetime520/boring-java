package org.castiello.nogle.match.po;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "m_user")
@Getter
@Setter
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private boolean active;

}