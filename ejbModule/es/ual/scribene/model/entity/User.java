package es.ual.scribene.model.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.jboss.seam.annotations.security.management.UserEnabled;
import org.jboss.seam.annotations.security.management.UserFirstName;
import org.jboss.seam.annotations.security.management.UserLastName;
import org.jboss.seam.annotations.security.management.UserPassword;
import org.jboss.seam.annotations.security.management.UserPrincipal;
import org.jboss.seam.annotations.security.management.UserRoles;

@Entity
@Table(name = "T_USER")
public class User {

	private Integer userId;

	private String username;

	private String passwordHash;

	private String firstname;

	private String lastname;

	private boolean enabled;

	private Set<Role> roles;

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "UserGenerator")
	@SequenceGenerator(name = "UserGenerator")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@UserPrincipal
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@UserPassword(hash = "md5")
	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	@UserFirstName
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@UserLastName
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@UserEnabled
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@UserRoles
	@ManyToMany(targetEntity = Role.class)
	@JoinTable(name = "T_UserRoles",

	joinColumns = @JoinColumn(name = "UserId"),

	inverseJoinColumns = @JoinColumn(name = "RoleId"))
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}