package com.example.clappapp

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var seekBar: SeekBar
    private var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        seekBar = findViewById(R.id.sbBark)

        val play = findViewById<FloatingActionButton>(R.id.fabPlay)
        val pause = findViewById<FloatingActionButton>(R.id.fabPause)
        val stop = findViewById<FloatingActionButton>(R.id.fabStop)

        play.setOnClickListener{
            if(mediaPlayer==null){
                //initialize the media player in the onCreate()
                mediaPlayer = MediaPlayer.create(this, R.raw.dog)
            }

            mediaPlayer?.start()
        }

        pause.setOnClickListener{
            mediaPlayer?.pause()
        }

        stop.setOnClickListener{
            mediaPlayer?.stop()
            mediaPlayer?.reset()
            mediaPlayer?.release()
            mediaPlayer = null
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initializeSeekBar(){
        
    }
}