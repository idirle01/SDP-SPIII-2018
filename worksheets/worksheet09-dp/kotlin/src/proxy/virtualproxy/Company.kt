package proxy.virtualproxy

data class Company(
        var companyName: String,
        var companyAddress: String,
        var companyContactNo: String,
        var contactList: ContactList
) {
    init {
        println("Company object created...")
    }
}
