package barqsoft.footballscores;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.widget.RemoteViews;

/**
 * Created by Pradeep on 1/25/16.
 */
public class WidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
//        final int count = appWidgetIds.length;
//        for (int i = 0; i < count; i++) {
//            int widgetId = appWidgetIds[i];
//            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),
//                    R.layout.layout_widget);
//            remoteViews.setTextViewText(R.id.tvScore, "Hey there");
//            Intent intent = new Intent(context, SimpleWidgetProvider.class);
//            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
//            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
//            PendingIntent pendingIntent = PendingIntent.getBroadcast(context,
//                    0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//            remoteViews.setOnClickPendingIntent(R.id.actionButton, pendingIntent);
//            appWidgetManager.updateAppWidget(widgetId, remoteViews);
//        }
    }

    public static void update(String packageName, AppWidgetManager appWidgetManager, int[] appWidgetIds, String homeName,
                              String awayName, String homeScore, String awayScore,
                              String matchTime) {
        Log.d("******", "here");
        final int count = appWidgetIds.length;
        for (int i = 0; i < count; i++) {
            int widgetId = appWidgetIds[i];
            RemoteViews remoteViews = new RemoteViews(packageName,
                    R.layout.layout_widget);
            remoteViews.setImageViewResource(R.id.ivHomeIcon,
                    Utilies.getTeamCrestByTeamName(homeName));
            remoteViews.setImageViewResource(R.id.ivAwayIcon,
                    Utilies.getTeamCrestByTeamName(awayName));
            remoteViews.setTextViewText(R.id.tvHomeName, homeName);
            remoteViews.setTextViewText(R.id.tvAwayNname, awayName);
            remoteViews.setTextViewText(R.id.tvScore, Utilies.getScores(Integer.parseInt(homeScore),
                    Integer.parseInt(awayScore)));
            remoteViews.setTextViewText(R.id.tvTime, matchTime);
            appWidgetManager.updateAppWidget(widgetId, remoteViews);

        }
    }

}