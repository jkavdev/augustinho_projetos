package br.com.jkavdev.wpattern.mutrack.simple.userpermission;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.jkavdev.wpattern.mutrack.simple.utils.BaseEntity;

//Entidade que terá sua chave composta

@Entity
@Table(name = "tb_user_permission")
public class UserPermissionEntity extends BaseEntity<UserPermissionKey> {

	private static final long serialVersionUID = 1L;

}
