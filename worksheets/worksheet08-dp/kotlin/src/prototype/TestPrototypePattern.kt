package prototype

fun main(args: Array<String>) {
    var userAccessControl: AccessControl =
            AccessControlProvider.getAccessControlObject("USER")
    var user = User("User A", "USER Level", userAccessControl)
    println("*".repeat(20))
    println(user)

    userAccessControl = AccessControlProvider.getAccessControlObject("USER")
    user = User("User B", "USER Level", userAccessControl)

    println("Changing access control of: " + user.userName)

    user.accessControl.access = "READ REPORTS"
    println(user)
    println("*".repeat(20))

    val managerAccessControl: AccessControl =
            AccessControlProvider.getAccessControlObject("MANAGER")
    user = User("User C", "MANAGER Level", managerAccessControl)
    println(user)
}
