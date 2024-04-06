package com.example.pf_widget

import android.annotation.SuppressLint
import android.appwidget.AppWidgetManager
import android.os.Bundle
import android.widget.RemoteViews
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buy_first_view : TextView = findViewById(R.id.buy_first_view)
      val sell_first_view : TextView = findViewById(R.id.sell_first_view)

        val buy_second_view : TextView = findViewById(R.id.buy_second_view)
        val sell_second_view : TextView = findViewById(R.id.sell_second_view)

        val buy_third_view : TextView = findViewById(R.id.buy_third_view)
        val sell_third_view : TextView = findViewById(R.id.sell_third_view)

        val buy_fourth_view : TextView = findViewById(R.id.buy_fourth_view)
        val sell_fourth_view : TextView = findViewById(R.id.sell_fourth_view)

       var site_parcer : SiteParcer = SiteParcer()


        var temp_string : String = "2"

        Thread {
            site_parcer.main()
            buy_first_view.text = site_parcer.buy_first
            temp_string = site_parcer.buy_first
            sell_first_view.text = site_parcer.sell_first

            buy_second_view.text = site_parcer.buy_second
            sell_second_view.text = site_parcer.sell_second

            buy_third_view.text = site_parcer.buy_third
            sell_third_view.text = site_parcer.sell_third

            buy_fourth_view.text = site_parcer.buy_fourth
            sell_fourth_view.text = site_parcer.sell_fourth
        }.start()
        System.out.printf(temp_string)

    }
}