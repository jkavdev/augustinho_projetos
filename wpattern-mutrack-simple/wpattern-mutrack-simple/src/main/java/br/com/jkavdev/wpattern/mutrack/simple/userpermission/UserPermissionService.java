package br.com.jkavdev.wpattern.mutrack.simple.userpermission;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.wpattern.mutrack.simple.utils.GenericService;
import br.com.jkavdev.wpattern.mutrack.simple.utils.ServicePath;

@RestController
@RequestMapping(path = ServicePath.USERPERMISSION_PATH)
public class UserPermissionService extends GenericService<UserPermissionEntity, UserPermissionKey> {

}
