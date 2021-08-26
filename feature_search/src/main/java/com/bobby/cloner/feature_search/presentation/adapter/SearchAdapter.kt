package com.bobby.cloner.feature_search.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bobby.cloner.feature_search.databinding.ItemSuggestionBinding
import com.bobby.cloner.feature_search.domain.model.AutocompleteSuggestion
import com.bobby.cloner.feature_search.presentation.adapter.SearchAdapter.SearchViewHolder

/**
 * Created by Bobby Irawan on 25/08/21.
 */
class SearchAdapter: ListAdapter<AutocompleteSuggestion, SearchViewHolder>(SearchComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val binding = ItemSuggestionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SearchViewHolder(private val binding: ItemSuggestionBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(autocompleteSuggestion: AutocompleteSuggestion?) {
            binding.tvTitle.text = autocompleteSuggestion?.name
        }
    }

    class SearchComparator : DiffUtil.ItemCallback<AutocompleteSuggestion>() {
        override fun areItemsTheSame(oldItem: AutocompleteSuggestion, newItem: AutocompleteSuggestion): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: AutocompleteSuggestion, newItem: AutocompleteSuggestion): Boolean =
            oldItem == newItem

    }
}
