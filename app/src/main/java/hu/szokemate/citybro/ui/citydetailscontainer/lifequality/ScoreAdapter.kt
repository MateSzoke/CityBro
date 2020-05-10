package hu.szokemate.citybro.ui.citydetailscontainer.lifequality

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hu.szokemate.citybro.R
import hu.szokemate.citybro.domain.model.Score
import hu.szokemate.citybro.ui.citydetailscontainer.lifequality.ScoreAdapter.ScoreViewHolder
import kotlinx.android.synthetic.main.row_score.view.*

class ScoreAdapter : ListAdapter<Score, ScoreViewHolder>(ScoreComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_score, parent, false)
        return ScoreViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        val score = getItem(position)
        val value = (score.value * 10).toInt()

        holder.scoreNameText.text = score.name
        holder.scoreValueText.text = "${value}/100"
        holder.scoreProgress.progress = value
    }

    inner class ScoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val scoreNameText: TextView = itemView.scoreNameText
        val scoreValueText: TextView = itemView.scoreValueText
        val scoreProgress: ProgressBar = itemView.scoreProgress
    }

}
