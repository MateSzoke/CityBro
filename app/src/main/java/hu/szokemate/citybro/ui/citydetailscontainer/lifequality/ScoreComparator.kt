package hu.szokemate.citybro.ui.citydetailscontainer.lifequality

import androidx.recyclerview.widget.DiffUtil
import hu.szokemate.citybro.domain.model.Score

object ScoreComparator : DiffUtil.ItemCallback<Score>() {

    override fun areItemsTheSame(oldItem: Score, newItem: Score): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Score, newItem: Score): Boolean {
        return oldItem == newItem
    }

}
