package com.example.pf_widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import java.text.SimpleDateFormat
import java.util.Date


class PriceWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {

        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }


internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val views = RemoteViews(context.packageName, R.layout.price_widget)
    val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
    val currentDate = sdf.format(Date())
    views.setTextViewText(R.id.buy_first_widget, currentDate.toString())
    var site_parcer : SiteParcer = SiteParcer()

    Thread{
        site_parcer.main()
        val updateIntent = Intent(context, PriceWidget::class.java)
        updateIntent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
        updateIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, intArrayOf(appWidgetId))

        val pendingIntent2 = PendingIntent.getBroadcast(context, 0, updateIntent, PendingIntent.FLAG_UPDATE_CURRENT)

        val views = RemoteViews(context.packageName, R.layout.price_widget)
        views.setOnClickPendingIntent(R.id.button_widget, pendingIntent2)
        views.setTextViewText(R.id.buy_first_widget, site_parcer.buy_first)
        views.setTextViewText(R.id.sell_first_widget, site_parcer.sell_first)
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        views.setOnClickPendingIntent(R.id.widget_id, pendingIntent)
        appWidgetManager.updateAppWidget(appWidgetId, views)
    }.start()


////    fun startThread() {
////        isRunning = true
////        myThread = Thread(
//            Runnable {
//                while (isRunning) {
//                    site_parcer.main()
//                    views.setTextViewText(R.id.buy_first_widget, site_parcer.buy_first)
//                    views.setTextViewText(R.id.sell_first_widget, site_parcer.sell_first)
//                    val intent = Intent(context, MainActivity::class.java)
//                    val pendingIntent: PendingIntent = PendingIntent.getActivity(
//                        context,
//                        0,
//                        intent,
//                        PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
//                    )
//                    views.setOnClickPendingIntent(R.id.widget_id, pendingIntent)
//                    appWidgetManager.updateAppWidget(appWidgetId, views)
//                    Thread.sleep(60000 )
//                }
////            }
////        )
////        myThread?.start()
////    }
//    startThread()
//    Thread.sleep(10000000)
}}