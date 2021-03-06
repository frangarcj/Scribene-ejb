package es.ual.scribene.model.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.jboss.seam.annotations.security.permission.PermissionAction;
import org.jboss.seam.annotations.security.permission.PermissionDiscriminator;
import org.jboss.seam.annotations.security.permission.PermissionRole;
import org.jboss.seam.annotations.security.permission.PermissionTarget;
import org.jboss.seam.annotations.security.permission.PermissionUser;

@Entity
@Table(name = "t_AccountPermission")
public class AccountPermission implements Serializable {

	private Integer permissionId;

	private String recipient;

	private String target;

	private String action;

	private String discriminator;

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "PermissionGenerator")
	@SequenceGenerator(name = "PermissionGenerator")
	public Integer getPermissionId() {

		return permissionId;

	}

	public void setPermissionId(Integer permissionId) {

		this.permissionId = permissionId;

	}

	@PermissionUser
	@PermissionRole
	public String getRecipient() {

		return recipient;

	}

	public void setRecipient(String recipient) {

		this.recipient = recipient;

	}

	@PermissionTarget
	public String getTarget() {

		return target;

	}

	public void setTarget(String target) {

		this.target = target;

	}

	@PermissionAction
	public String getAction() {

		return action;

	}

	public void setAction(String action) {

		this.action = action;

	}

	@PermissionDiscriminator
	public String getDiscriminator() {

		return discriminator;

	}

	public void setDiscriminator(String discriminator) {

		this.discriminator = discriminator;

	}

}
