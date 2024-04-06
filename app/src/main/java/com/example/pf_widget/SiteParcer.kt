package com.example.pf_widget

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.text.SimpleDateFormat
import java.util.Date

class SiteParcer {
    lateinit var doc : Document
    lateinit var buy_first : String
    lateinit var sell_first : String
    lateinit var buy_second : String
    lateinit var sell_second : String
    lateinit var buy_third : String
    lateinit var sell_third : String
    lateinit var buy_fourth : String
    lateinit var sell_fourth : String
    fun main() {
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val currentDate = sdf.format(Date())
        val second_part = "&date_req2="
        var site_string  = "https://www.cbr.ru/scripts/xml_metall.asp?date_req1=".plus(currentDate.toString()).plus(second_part).plus(currentDate.toString())
        doc = Jsoup.connect(site_string).get();
        var titleElement = doc.selectFirst("Metall");
        var recordElement1 = titleElement.selectFirst("Record")
        buy_first = recordElement1.selectFirst("Buy").text()
        sell_first = recordElement1.selectFirst("Sell").text()
        var recordElement2 = recordElement1.nextElementSibling()
        buy_second = recordElement2.selectFirst("Buy").text()
        sell_second = recordElement2.selectFirst("Sell").text()
        var recordElement3 = recordElement2.nextElementSibling()
        buy_third = recordElement3.selectFirst("Buy").text()
        sell_third = recordElement3.selectFirst("Sell").text()
        var recordElement4 = recordElement3.nextElementSibling()
        buy_fourth = recordElement4.selectFirst("Buy").text()
        sell_fourth = recordElement4.selectFirst("Sell").text()
    }
}