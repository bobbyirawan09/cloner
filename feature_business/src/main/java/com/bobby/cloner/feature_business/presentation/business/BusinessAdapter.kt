package com.bobby.cloner.feature_business.presentation.business

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bobby.cloner.core.presentation.utils.loadUrlWithRoundedCorner
import com.bobby.cloner.feature_business.databinding.ItemBusinessBinding
import com.bobby.cloner.feature_business.domain.model.Business
import com.bobby.cloner.feature_business.presentation.business.BusinessAdapter.BusinessViewHolder
import com.bobby.cloner.utils.orFalse
import com.bobby.cloner.utils.orZero
import com.bobby.cloner.utils.showIf


/**
 * Created by Bobby Irawan on 30/07/21.
 */
class BusinessAdapter :
    ListAdapter<Business, BusinessViewHolder>(BusinessComparator()) {
    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {
        holder.bind(getItem(position), position + 1)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BusinessViewHolder {
        val binding = ItemBusinessBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BusinessViewHolder(binding)
    }

    class BusinessViewHolder(private val binding: ItemBusinessBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(business: Business?, position: Int) {
            binding.tvName.text = "$position. ${business?.name}"
            binding.tvAddress.text = business?.address
            binding.rbTotalReview.rating = business?.rating?.toFloat().orZero()
            binding.tvReviewCount.text = business?.reviewCount.orEmpty()
            binding.tvCategories.text = business?.category
            binding.tvDistance.text = business?.distance + " mi"
            val url = business?.imageUrl.orEmpty()
            binding.ivBusinessImage.loadUrlWithRoundedCorner(itemView.context, url)
            binding.groupPrice.showIf(business?.price?.isNotEmpty().orFalse())
            binding.tvPrice.text = business?.price
        }
    }

    class BusinessComparator : DiffUtil.ItemCallback<Business>() {
        override fun areItemsTheSame(oldItem: Business, newItem: Business): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Business, newItem: Business): Boolean =
            oldItem == newItem

    }

}
