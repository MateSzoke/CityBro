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
        holder.addFavoriteButton.load(if (city.isFavorite) R.drawable.ic_favorite_24px else R.drawable.ic_favorite_border_24px)
    }

    inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cityNameText: TextView = itemView.cityNameText
        val cityImage: ImageView = itemView.cityImage
        val addFavoriteButton: ImageView = itemView.addFavoriteButton
        private val showDetailsButton: Button = itemView.showDetailsButton

        var city: CityBase? = null

        init {
            itemView.setOnClickListener {
                city?.let { listener?.onCityClicked(it) }
            }
            showDetailsButton.setOnClickListener {
                city?.let { listener?.onCityClicked(it) }
            }
            addFavoriteButton.setOnClickListener {
                city?.let { city ->
                    addFavoriteButton.load(if (!city.isFavorite) R.drawable.ic_favorite_24px else R.drawable.ic_favorite_border_24px)
                    listener?.onFavoriteButtonClicked(
                        isAdd = !city.isFavorite,
                        urbanAreaId = city.urbanAreaId
                    )
                }
            }
        }
    }

    interface Listener {
        fun onCityClicked(city: CityBase)
        fun onFavoriteButtonClicked(isAdd: Boolean, urbanAreaId: String)
    }

}
