package com.bobby.cloner.feature_business.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bobby.cloner.feature_business.databinding.ItemBusinessBinding
import com.bobby.cloner.feature_business.domain.model.Business
import com.bobby.cloner.feature_business.presentation.BusinessAdapter.BusinessViewHolder

/**
 * Created by Bobby Irawan on 30/07/21.
 */
class BusinessAdapter :
    PagingDataAdapter<Business, BusinessViewHolder>(BusinessComparator) {
    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BusinessViewHolder {
        val binding = ItemBusinessBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BusinessViewHolder(binding)
    }

    class BusinessViewHolder(private val binding: ItemBusinessBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(business: Business?) {

        }
    }

    object BusinessComparator : DiffUtil.ItemCallback<Business>() {
        override fun areItemsTheSame(oldItem: Business, newItem: Business): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Business, newItem: Business): Boolean =
            oldItem == newItem

    }

}
