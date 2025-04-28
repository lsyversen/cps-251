package com.example.finalproject

// Import necessary Android and RecyclerView libraries
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.databinding.ActivityMainBinding
import java.util.Locale

// Main Activity of the app
class MainActivity : AppCompatActivity() {

    // Binding to access views
    private lateinit var binding: ActivityMainBinding

    // Adapter for RecyclerView
    private var adapter: ContactListAdapter? = null

    // ViewModel to manage UI-related data
    private val viewModel: MainViewModel by viewModels()

    // Called when the activity is first created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up button listeners
        listenerSetup()

        // Set up LiveData observers
        observerSetup()

        // Set up RecyclerView
        recyclerSetup()
    }

    // Clear text fields after adding a contact
    private fun clearFields() {
        binding.enterContactName.setText("")
        binding.enterPhone.setText("")
    }

    // Set up click listeners for buttons
    private fun listenerSetup() {
        // Add contact button
        binding.addButton.setOnClickListener {
            val name = binding.enterContactName.text.toString()
            val phone = binding.enterPhone.text.toString()

            if (name != "" && phone != "") {
                val contact = Contact(name, Integer.parseInt(phone).toString())
                viewModel.insertContact(contact)
                clearFields()
            }
        }

        // Find contact button
        binding.findButton.setOnClickListener {
            val nameSearch = binding.enterContactName.text.toString()
            if (nameSearch == "") {
                Toast.makeText(this, "There are no contacts that match your search", Toast.LENGTH_SHORT).show()
                //return@setOnClickListener
            }
            viewModel.findContact(binding.enterContactName.text.toString())
        }

        // Sort contacts ascending button
        binding.ascButton.setOnClickListener {
            viewModel.getAllContactsAsc().observe(this) { contact ->
                adapter?.setContactList(contact)
            }
        }

        // Sort contacts descending button
        binding.descButton.setOnClickListener {
            viewModel.getAllContactsDesc().observe(this) { contact ->
                adapter?.setContactList(contact)
            }
        }
    }

    // Set up observers to update UI when data changes
    private fun observerSetup() {
        // Observe all contacts
        viewModel.getAllContacts()?.observe(this) { contact ->
            contact?.let {
                adapter?.setContactList(it)
            }
        }

        // Observe search results
        viewModel.getSearchResults().observe(this) { contact ->
            contact?.let {
                adapter?.setContactList(it)
            }
        }
    }

    // Set up the RecyclerView
    private fun recyclerSetup() {
        adapter = ContactListAdapter(viewModel)
        binding.contactRecycler.layoutManager = LinearLayoutManager(this)
        binding.contactRecycler.adapter = adapter
    }
}
