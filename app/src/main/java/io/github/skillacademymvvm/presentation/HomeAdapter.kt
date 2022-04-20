package io.github.skillacademymvvm.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView.*
import io.github.skillacademymvvm.R
import io.github.skillacademymvvm.data.ResultResponse
import io.github.skillacademymvvm.databinding.ItemHomeBinding

class HomeAdapter(private val response: List<ResultResponse>): Adapter<HomeAdapter.HomeViewHolder>() {
    inner class HomeViewHolder(val binding: ItemHomeBinding) : ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_home, parent, false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.binding.apply {
            viewModel = HomeAdapterViewModel(response[holder.adapterPosition])
            executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        return response.count()
    }
}