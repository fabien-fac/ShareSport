package sharesport

import grails.transaction.Transactional

/**
 * Created by fabien on 31/10/14.
 */
@Transactional
class SecureRoleService {

    private final String ROLE_ADMIN = "ROLE_ADMIN"
    private final String ROLE_USER = "ROLE_USER"

    SecureRole getRoleUser(){
        getRole(ROLE_USER)
    }

    SecureRole getRoleAdmin(){
        getRole(ROLE_ADMIN)
    }

    private SecureRole getRole(String role) {
        SecureRole userRole = SecureRole.findByAuthority(role)
        if(userRole == null){
            userRole = new SecureRole(authority: role).save()
        }
        userRole
    }
}
