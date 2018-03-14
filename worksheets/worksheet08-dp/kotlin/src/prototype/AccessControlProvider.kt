package prototype

object AccessControlProvider {

    private var map: MutableMap<String, AccessControl> = TODO()

    init {
        println("Fetching data from external resources and creating access control objects...")

        map.put("USER", AccessControl("USER", "DO_WORK"))
        map.put("ADMIN", AccessControl("ADMIN", "ADD/REMOVE USERS"))
        map.put("MANAGER", AccessControl("MANAGER", "GENERATE/READ REPORTS"))
        map.put("VP", AccessControl("VP", "MODIFY REPORTS"))
    }

    fun getAccessControlObject(controlLevel: String): AccessControl {
        TODO()
    }

}
