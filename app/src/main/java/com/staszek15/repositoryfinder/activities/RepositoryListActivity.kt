package com.staszek15.repositoryfinder.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.staszek15.bucketlist.RepositoryListAdapter
import com.staszek15.repositoryfinder.dataclasses.RepositoryItem
import com.staszek15.repositoryfinder.databinding.ActivityRepositoryListBinding

class RepositoryListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRepositoryListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRepositoryListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createRecyclerView()
    }

    private fun createRecyclerView() {
        val adapter = RepositoryListAdapter(createBucketList())
        binding.recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(DividerItemDecoration(this, 1))
    }

    private fun createBucketList(): List<RepositoryItem> {
        return buildList {
            add(RepositoryItem("Sugar Alarm", "Staszek15", "main", "09c231311gd123"))
            add(RepositoryItem("Bucket List", "Staszek15", "main-kt", "01h231888gd123"))
        }
    }
}