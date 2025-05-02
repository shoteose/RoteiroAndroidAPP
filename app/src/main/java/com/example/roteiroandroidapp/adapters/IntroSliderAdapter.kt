package com.example.roteiroandroidapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roteiroandroidapp.R
import com.example.roteiroandroidapp.models.IntroSlide

class IntroSliderAdapter(private val context: Context) :
    RecyclerView.Adapter<IntroSliderAdapter.IntroSlideViewHolder>() {

        // Estes sao os 3 slides que vao ser usados
    private val slides = listOf(
        IntroSlide(
            R.drawable.introslider1,
            context.getString(R.string.introSlider1Titulo),
            context.getString(R.string.introSlider1Descricao)
        ),
        IntroSlide(
            R.drawable.introslider2,
            context.getString(R.string.introSlider2Titulo),
            context.getString(R.string.introSlider2Descricao)
        ),
        IntroSlide(
            R.drawable.introslider3,
            context.getString(R.string.introSlider3Titulo),
            context.getString(R.string.introSlider3Descricao)
        )
    )

    // viewHolder para cada slide
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.slide_item, parent, false
        )
        return IntroSlideViewHolder(view)
    }

    override fun getItemCount(): Int = slides.size

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
        holder.bind(slides[position])
    }

    // viewHolder para cada slide
    inner class IntroSlideViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imagemSlide = view.findViewById<ImageView>(R.id.imagemSlide)
        private val tituloSlide = view.findViewById<TextView>(R.id.tituloSlide)
        private val descricaoSlide = view.findViewById<TextView>(R.id.descricaoSlide)

        fun bind(introSlide: IntroSlide) {
            imagemSlide.setImageResource(introSlide.imagem)
            tituloSlide.text = introSlide.titulo
            descricaoSlide.text = introSlide.descricao
        }
    }

}