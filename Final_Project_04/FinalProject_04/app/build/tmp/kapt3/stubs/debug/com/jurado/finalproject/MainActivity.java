package com.jurado.finalproject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/jurado/finalproject/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "cityAdapter", "Lcom/jurado/finalproject/ui/CityAdapter;", "cityInput", "Landroid/widget/EditText;", "cityRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "favoriteCityRepository", "Lcom/jurado/finalproject/data/FavoriteCityRepository;", "favoritesButton", "Landroid/widget/Button;", "submitButton", "navigateToWeatherActivity", "", "city", "Lcom/jurado/finalproject/data/CityData;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "saveCityToFavorites", "searchCities", "cityName", "", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.jurado.finalproject.ui.CityAdapter cityAdapter;
    private androidx.recyclerview.widget.RecyclerView cityRecyclerView;
    private android.widget.EditText cityInput;
    private android.widget.Button submitButton;
    private android.widget.Button favoritesButton;
    private com.jurado.finalproject.data.FavoriteCityRepository favoriteCityRepository;
    
    public MainActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void searchCities(java.lang.String cityName) {
    }
    
    private final void navigateToWeatherActivity(com.jurado.finalproject.data.CityData city) {
    }
    
    private final void saveCityToFavorites(com.jurado.finalproject.data.CityData city) {
    }
}