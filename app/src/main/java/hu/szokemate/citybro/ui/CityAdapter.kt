package hu.szokemate.citybro.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hu.szokemate.citybro.R
import hu.szokemate.citybro.domain.model.CityBase
import hu.szokemate.citybro.ui.CityAdapter.CityViewHolder
import hu.szokemate.citybro.util.glide.load
import kotlinx.android.synthetic.main.row_city.view.*

class CityAdapter : ListAdapter<CityBase, CityViewHolder>(CityComparator) {

    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_city, parent, false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = getItem(position)
        holder.city = city

        holder.cityNameText.text = city.name
        holder.cityImage.load(city.imgUrl)
    }

    inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cityNameText: TextView = itemView.cityNameText
        val cityImage: ImageView = itemView.cityImage
        val showDetailsButton: Button = itemView.showDetailsButton

        var city: CityBase? = null

        init {
            itemView.setOnClickListener {
                city?.let { listener?.onCityClicked(it) }
            }
            showDetailsButton.setOnClickListener {
                city?.let { listener?.onCityClicked(it) }
            }
        }
    }

    interface Listener {
        fun onCityClicked(city: CityBase)
    }

}
