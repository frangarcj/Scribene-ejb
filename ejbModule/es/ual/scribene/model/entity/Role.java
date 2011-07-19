package es.ual.scribene.model.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.jboss.seam.annotations.security.management.RoleName;

@Entity
@Table(name = "T_ROLE")
public class Role {
	private Integer roleId;
	private String rolename;

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "RoleGenerator")
	@SequenceGenerator(name = "RoleGenerator")
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@RoleName
	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}