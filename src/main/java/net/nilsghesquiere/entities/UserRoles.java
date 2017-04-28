package net.nilsghesquiere.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="userroles")
public class UserRoles implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	long userid;
	@Id
	long roleid;
}
