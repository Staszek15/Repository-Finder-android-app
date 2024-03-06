package com.staszek15.repositoryfinder.adapters

import RepositoryItem
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.staszek15.repositoryfinder.databinding.RepositoryListItemBinding

class RepositoryListAdapter(private val repositoryListItems: List<RepositoryItem>):
    RecyclerView.Adapter<RepositoryListAdapter.MyViewHolder>() {

    inner class MyViewHolder(binding: RepositoryListItemBinding): ViewHolder(binding.root) {
        val repository = binding.textRepository
        val owner = binding.textOwner
        val branch = binding.textBranch
        val sha = binding.textSha
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val repositoryListItemBinding = RepositoryListItemBinding.inflate(inflater, parent, false)
        return MyViewHolder(repositoryListItemBinding)
    }

    override fun getItemCount(): Int {
        return repositoryListItems.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.repository.text = repositoryListItems[position].name
        holder.owner.text = repositoryListItems[position].owner
        holder.branch.text = repositoryListItems[position].default_branch
        holder.sha.text = repositoryListItems[position].topics.toString()
    }

}