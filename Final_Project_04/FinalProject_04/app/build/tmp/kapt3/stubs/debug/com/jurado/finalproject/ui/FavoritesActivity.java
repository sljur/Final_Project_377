package com.jurado.finalproject.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/jurado/finalproject/ui/FavoritesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "favoriteCityAdapter", "Lcom/jurado/finalproject/ui/FavoriteCityAdapter;", "favoriteCityViewModel", "Lcom/jurado/finalproject/viewmodel/FavoriteCityViewModel;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "navigateToWeatherActivity", "", "favoriteCity", "Lcom/jurado/finalproject/data/FavoriteCity;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class FavoritesActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.jurado.finalproject.viewmodel.FavoriteCityViewModel favoriteCityViewModel;
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private com.jurado.finalproject.ui.FavoriteCityAdapter favoriteCityAdapter;
    
    public FavoritesActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void navigateToWeatherActivity(com.jurado.finalproject.data.FavoriteCity favoriteCity) {
    }
}