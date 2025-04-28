package com.example.finalproject

// Import necessary Android and RecyclerView classes
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ContactListItemBinding  // Replace with your actual package name

// Adapter class for displaying the contact list in a RecyclerView
class ContactListAdapter(private val viewModel: MainViewModel) : RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {

    // List to hold contacts
    private var contactList: List<Contact>? = null

    // Binds each contact data to the item view
    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val contact = contactList?.get(listPosition)

        // Set contact name and phone number to the TextViews
        holder.binding.contactName.text = contact?.contactName
        holder.binding.contactPhone.text = contact?.contactPhone

        // Set delete icon and its click action
        holder.binding.garbageCan.setImageResource(R.drawable.baseline_delete_24)
        holder.binding.garbageCan.setOnClickListener {
            if (contact != null) {
                viewModel.deleteContact(contact.id)
            }
        }
    }

    // Set the contact list and refresh the RecyclerView
    fun setContactList(contact: List<Contact>) {
        contactList = contact
        notifyDataSetChanged()
    }

    // Creates a new ViewHolder when needed
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ContactListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    // ViewHolder class to hold view references
    class ViewHolder(val binding: ContactListItemBinding) : RecyclerView.ViewHolder(binding.root)

    // Returns the total number of items
    override fun getItemCount(): Int {
        return contactList?.size ?: 0
    }
}

