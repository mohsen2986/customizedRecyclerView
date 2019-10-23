package com.example.company;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewTouchListener implements RecyclerView.OnItemTouchListener {
    private ClickListener listener;
    private RecyclerView recyclerView;
    private Context context;
    private GestureDetector gestureDetector;

    public RecyclerViewTouchListener(RecyclerView recyclerView , Context context , ClickListener listener){
        this.listener = listener;
        this.recyclerView = recyclerView;
        this.context = context;
        initGesture();
    }
    private void initGesture(){
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public void onLongPress(MotionEvent e) {
                super.onLongPress(e);
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

    }
    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (listener != null && child != null && gestureDetector.onTouchEvent(e))
            listener.OnClick(child, rv.getChildAdapterPosition(child));
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
    public interface ClickListener{
        void OnClick(View view , int position);
    }
}
