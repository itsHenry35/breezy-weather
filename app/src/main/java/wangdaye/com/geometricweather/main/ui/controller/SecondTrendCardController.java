package wangdaye.com.geometricweather.main.ui.controller;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import android.view.View;
import android.widget.TextView;

import wangdaye.com.geometricweather.R;
import wangdaye.com.geometricweather.basic.GeoActivity;
import wangdaye.com.geometricweather.basic.model.location.Location;
import wangdaye.com.geometricweather.basic.model.option.CardOrder;
import wangdaye.com.geometricweather.main.ui.MainColorPicker;
import wangdaye.com.geometricweather.resource.provider.ResourceProvider;
import wangdaye.com.geometricweather.settings.SettingsOptionManager;
import wangdaye.com.geometricweather.ui.widget.trendView.TrendRecyclerView;
import wangdaye.com.geometricweather.ui.widget.trendView.TrendViewController;
import wangdaye.com.geometricweather.ui.widget.weatherView.WeatherView;

public class SecondTrendCardController extends AbstractMainItemController {

    private CardView card;

    private TextView title;
    private TextView subtitle;
    private TrendRecyclerView trendRecyclerView;

    @NonNull private WeatherView weatherView;

    public SecondTrendCardController(@NonNull Activity activity, @NonNull WeatherView weatherView,
                                     @NonNull ResourceProvider provider, @NonNull MainColorPicker picker) {
        super(activity, activity.findViewById(R.id.container_main_second_trend_card), provider, picker);

        this.card = view.findViewById(R.id.container_main_second_trend_card);
        this.title = view.findViewById(R.id.container_main_second_trend_card_title);
        this.subtitle = view.findViewById(R.id.container_main_second_trend_card_subtitle);
        this.trendRecyclerView = view.findViewById(R.id.container_main_second_trend_card_trendRecyclerView);

        this.weatherView = weatherView;
    }

    @Override
    public void onBindView(@NonNull Location location) {
        if (SettingsOptionManager.getInstance(context).getCardOrder() == CardOrder.DAILY_FIRST) {
            if (!isDisplay(SettingsOptionManager.CARD_HOURLY_OVERVIEW)) {
                view.setVisibility(View.GONE);
                return;
            } else {
                view.setVisibility(View.VISIBLE);
            }
        } else {
            if (!isDisplay(SettingsOptionManager.CARD_DAILY_OVERVIEW)) {
                view.setVisibility(View.GONE);
                return;
            } else {
                view.setVisibility(View.VISIBLE);
            }
        }

        if (location.getWeather() != null) {
            card.setCardBackgroundColor(picker.getRootColor(context));

            title.setTextColor(weatherView.getThemeColors(picker.isLightTheme())[0]);

            if (SettingsOptionManager.getInstance(context).getCardOrder() == CardOrder.DAILY_FIRST) {
                TrendViewController.setHourlyTrend(
                        (GeoActivity) context, title, subtitle, trendRecyclerView, provider, picker,
                        location.getWeather(), weatherView.getThemeColors(picker.isLightTheme()));
            } else {
                TrendViewController.setDailyTrend(
                        (GeoActivity) context, title, subtitle, trendRecyclerView, provider, picker,
                        location.getWeather(), weatherView.getThemeColors(picker.isLightTheme()));
            }
        }
    }

    @Override
    public void onDestroy() {
        trendRecyclerView.setAdapter(null);
    }
}
