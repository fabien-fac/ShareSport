package sharesport

import org.apache.commons.lang.builder.HashCodeBuilder

class UserSecureRole implements Serializable {

    private static final long serialVersionUID = 1

    User user
    SecureRole secureRole

    boolean equals(other) {
        if (!(other instanceof UserSecureRole)) {
            return false
        }

        other.user?.id == user?.id &&
                other.secureRole?.id == secureRole?.id
    }

    int hashCode() {
        def builder = new HashCodeBuilder()
        if (user) builder.append(user.id)
        if (secureRole) builder.append(secureRole.id)
        builder.toHashCode()
    }

    static UserSecureRole get(long userId, long secureRoleId) {
        UserSecureRole.where {
            user == User.load(userId) &&
                    secureRole == SecureRole.load(secureRoleId)
        }.get()
    }

    static boolean exists(long userId, long secureRoleId) {
        UserSecureRole.where {
            user == User.load(userId) &&
                    secureRole == SecureRole.load(secureRoleId)
        }.count() > 0
    }

    static UserSecureRole create(User user, SecureRole secureRole, boolean flush = false) {
        def instance = new UserSecureRole(user: user, secureRole: secureRole)
        instance.save(flush: flush, insert: true)
        instance
    }

    static boolean remove(User u, SecureRole r, boolean flush = false) {
        if (u == null || r == null) return false

        int rowCount = UserSecureRole.where {
            user == User.load(u.id) &&
                    secureRole == SecureRole.load(r.id)
        }.deleteAll()

        if (flush) {
            UserSecureRole.withSession { it.flush() }
        }

        rowCount > 0
    }

    static void removeAll(User u, boolean flush = false) {
        if (u == null) return

        UserSecureRole.where {
            user == User.load(u.id)
        }.deleteAll()

        if (flush) {
            UserSecureRole.withSession { it.flush() }
        }
    }

    static void removeAll(SecureRole r, boolean flush = false) {
        if (r == null) return

        UserSecureRole.where {
            secureRole == SecureRole.load(r.id)
        }.deleteAll()

        if (flush) {
            UserSecureRole.withSession { it.flush() }
        }
    }

    static constraints = {
        secureRole validator: { SecureRole r, UserSecureRole ur ->
            if (ur.user == null) return
            boolean existing = false
            UserSecureRole.withNewSession {
                existing = UserSecureRole.exists(ur.user.id, r.id)
            }
            if (existing) {
                return 'userRole.exists'
            }
        }
    }

    static mapping = {
        id composite: ['secureRole', 'user']
        version false
    }
}
