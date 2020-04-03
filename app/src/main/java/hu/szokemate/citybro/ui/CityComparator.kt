package hu.szokemate.citybro.ui

import androidx.recyclerview.widget.DiffUtil
import hu.szokemate.citybro.domain.model.CityBase

object CityComparator : DiffUtil.ItemCallback<CityBase>() {

    override fun areItemsTheSame(oldItem: CityBase, newItem: CityBase): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CityBase, newItem: CityBase): Boolean {
        return oldItem == newItem
    }

}
