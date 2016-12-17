package br.com.jkavdev.wpattern.mutrack.simple.userpermission;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.jkavdev.wpattern.test.mutrack.simple.utils.BaseKey;

@Embeddable
public class UserPermissionKey extends BaseKey {

	private static final long serialVersionUID = 1L;

	@Column(name = "permission_id")
	private Long permissionId;
	
	@Column(name = "user_id")
	private Long userId;

	public UserPermissionKey() {
		super();
	}

	public UserPermissionKey(Long permissionId, Long userId) {
		this();
		this.permissionId = permissionId;
		this.userId = userId;
	}

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
