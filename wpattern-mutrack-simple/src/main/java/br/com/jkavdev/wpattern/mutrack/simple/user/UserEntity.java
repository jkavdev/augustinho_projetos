package br.com.jkavdev.wpattern.mutrack.simple.user;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.jkavdev.wpattern.mutrack.simple.permission.PermissionEntity;
import br.com.jkavdev.wpattern.mutrack.simple.utils.BaseEntity;

@Entity
@Table(name = "tb_user")
@AttributeOverride(name = "id", column = @Column(name = "pk_id"))
public class UserEntity extends BaseEntity<Long> {

	private static final long serialVersionUID = 1L;

	@Column(name = "name", length = 120, nullable = false)
	private String name;

	@Column(name = "email", length = 255, nullable = false, unique = true)
	private String email;

	@Column(name = "password", length = 128, nullable = false)
	private String password;
	
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
//	private List<PackageeEntity> packagees;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "tb_user_permission", 
			joinColumns = @JoinColumn(name = "user_id"), 
			inverseJoinColumns = @JoinColumn(name = "permission_id"))
	private List<PermissionEntity> permissions;

	public UserEntity() {
		super();
	}

	public UserEntity(String name, String email, String password) {
		this();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// public List<PackageeEntity> getPackagees() {
	// return packagees;
	// }
	//
	// public void setPackagees(List<PackageeEntity> packagees) {
	// this.packagees = packagees;
	// }

	public List<PermissionEntity> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<PermissionEntity> permissions) {
		this.permissions = permissions;
	}
}
