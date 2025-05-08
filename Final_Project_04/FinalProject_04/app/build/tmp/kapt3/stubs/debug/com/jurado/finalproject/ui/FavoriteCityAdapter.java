package com.jurado.finalproject.ui;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B-\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fH\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/jurado/finalproject/ui/FavoriteCityAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/jurado/finalproject/data/FavoriteCity;", "Lcom/jurado/finalproject/ui/FavoriteCityAdapter$FavoriteCityViewHolder;", "onRemoveClick", "Lkotlin/Function1;", "", "onItemClick", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "FavoriteCityViewHolder", "app_debug"})
public final class FavoriteCityAdapter extends androidx.recyclerview.widget.ListAdapter<com.jurado.finalproject.data.FavoriteCity, com.jurado.finalproject.ui.FavoriteCityAdapter.FavoriteCityViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.jurado.finalproject.data.FavoriteCity, kotlin.Unit> onRemoveClick = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.jurado.finalproject.data.FavoriteCity, kotlin.Unit> onItemClick = null;
    
    public FavoriteCityAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jurado.finalproject.data.FavoriteCity, kotlin.Unit> onRemoveClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.jurado.finalproject.data.FavoriteCity, kotlin.Unit> onItemClick) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.jurado.finalproject.ui.FavoriteCityAdapter.FavoriteCityViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.jurado.finalproject.ui.FavoriteCityAdapter.FavoriteCityViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/jurado/finalproject/ui/FavoriteCityAdapter$FavoriteCityViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "cityNameTextView", "Landroid/widget/TextView;", "getCityNameTextView", "()Landroid/widget/TextView;", "removeCityButton", "Landroid/widget/Button;", "getRemoveCityButton", "()Landroid/widget/Button;", "app_debug"})
    public static final class FavoriteCityViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView cityNameTextView = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.Button removeCityButton = null;
        
        public FavoriteCityViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getCityNameTextView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.Button getRemoveCityButton() {
            return null;
        }
    }
}