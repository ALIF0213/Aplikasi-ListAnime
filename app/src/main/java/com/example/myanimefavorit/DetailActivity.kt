package com.example.myanimefavorit

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val anime = intent.getParcelableExtra<Anime>("anime")


        findViewById<ImageView>(R.id.anime_image).setImageResource(anime?.photo ?: 0)
        findViewById<TextView>(R.id.anime_title).text = anime?.name
        findViewById<TextView>(R.id.anime_description).text = anime?.description
        findViewById<TextView>(R.id.anime_genre).text = "Genre: ${anime?.genre}"
        findViewById<TextView>(R.id.anime_rating_text).text = "Rating: ${anime?.rating.toString()}"

        val watchingButton: Button = findViewById(R.id.btn_watching)
        watchingButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bilibili.tv/id/anime"))
            startActivity(intent)
        }

        val shareButton: Button = findViewById(R.id.action_share)
        shareButton.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Cek anime ${anime?.name}! Rating: ${anime?.rating}")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Bagikan anime ini!"))
        }
    }
}
