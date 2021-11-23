package com.muryno.reddits.presenter.utils

import android.content.Context
import android.graphics.Canvas
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.muryno.reddits.R
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator

abstract class SwipeGesture(val context: Context) : ItemTouchHelper
.SimpleCallback(0, ItemTouchHelper.LEFT){

    val deleteColor = ContextCompat.getColor(context, R.color.red)
    val addColor = ContextCompat.getColor(context, R.color.green)
    val deleteIcon = R.drawable.ic_delete
    val addIcon = R.drawable.ic_add
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean = false

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        RecyclerViewSwipeDecorator.Builder(c,recyclerView,viewHolder,dX,dY,actionState,isCurrentlyActive)
            .addSwipeLeftBackgroundColor(deleteColor)
            .addSwipeLeftActionIcon(deleteIcon)
            .create()
            .decorate();
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
    }
}