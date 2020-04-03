package hu.szokemate.citybro.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import hu.szokemate.citybro.R
import hu.szokemate.citybro.domain.model.CityBase
import hu.szokemate.citybro.ui.CityAdapter.CityViewHolder

class CityAdapter : ListAdapter<CityBase, CityViewHolder>(CityComparator) {

    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_city, parent, false)
        return CityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = getItem(position)
        holder.city = city

        // TODO set View data from city
    }

    inner class CityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO create View properties

        var city: CityBase? = null

        init {
            itemView.setOnClickListener {
                city?.let { listener?.onCityClicked(it) }
            }
        }
    }

    interface Listener {
        fun onCityClicked(city: CityBase)
    }

}
