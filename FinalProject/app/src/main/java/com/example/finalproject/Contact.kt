package com.example.finalproject

// Importing necessary Android and Room database libraries
import android.provider.ContactsContract.CommonDataKinds.Phone
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Marks this class as an Entity for the Room database, with the table name "contacts"
@Entity(tableName = "contacts")
class Contact {

    // Primary key for the contact, auto-generated
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contactId")
    var id: Int = 0

    // Column to store the contact's name
    @ColumnInfo(name = "contactName")
    var contactName: String? = null

    // Column to store the contact's phone number
    @ColumnInfo(name = "contactPhone")
    var contactPhone: String? = null

    // Empty constructor (required by Room)
    constructor() {}

    // Constructor to create a Contact with a name and phone number
    constructor(contactName: String, contactPhone: String) {
        this.contactName = contactName
        this.contactPhone = contactPhone
    }
}
