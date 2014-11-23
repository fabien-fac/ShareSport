package sharesport

class User {

	transient springSecurityService

	String username
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
    byte[] picture

    String email
    Integer score = 0

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true, minSize: 4, maxSize: 20
		password blank: false, password: true
        score min: 0
        email email: true, unique: true, blank: false
        picture nullable: true, maxSize: 1024*1024
	}

	static mapping = {
		password column: '`password`'
	}

	Set<SecureRole> getAuthorities() {
		UserSecureRole.findAllByUser(this).collect { it.secureRole }
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}
}
