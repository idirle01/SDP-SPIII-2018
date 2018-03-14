package proxy.virtualproxy

fun main(args: Array<String>) {
    var contactList: ContactList = ContactListProxyImpl()
    val company: Company =
            Company("ABC Company", "Alabama", "011-2845-8965", contactList)
    println("Company Name: " + company.companyName)
    println("Company Address: " + company.companyAddress)
    println("Company Contact No.: " + company.companyContactNo)
    println("Requesting for contact list")
    contactList = company.contactList
    contactList.employeeList.forEach { println(it) }
}
