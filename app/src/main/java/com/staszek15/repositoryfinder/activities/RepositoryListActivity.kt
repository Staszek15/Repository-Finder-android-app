package com.staszek15.repositoryfinder.activities

import RepositoryItem
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.staszek15.repositoryfinder.adapters.RepositoryListAdapter
import com.staszek15.repositoryfinder.databinding.ActivityRepositoryListBinding
import main

class RepositoryListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRepositoryListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepositoryListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createRecyclerView()
        main()
    }

    private fun createRecyclerView() {
        val adapter = RepositoryListAdapter(createBucketList())
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, 1))
    }

    private fun createBucketList(): List<RepositoryItem> {
        return buildList {
            add(RepositoryItem("Sugar Alarm", "Staszek15", "main", listOf("android","kotlin")))
            add(RepositoryItem("Bucket List", "Staszek15", "main-kt", listOf("mobile","bucket list","kotlin")))
        }
    }
}