package com.party.parthverma.collegeapp;


import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by parthverma on 19/03/17.
 */

public class GridViewItemLayout extends LinearLayout {
    private static int[] mMaxRowHeight;

    // The number of columns in the grid view
    private static int mNumColumns;

    // The position of the view cell
    private int mPosition;

    // Public constructor
    public GridViewItemLayout(Context context) {
        super(context);
    }

    // Public constructor
    public GridViewItemLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * Set the position of the view cell
     * @param position
     */
    public void setPosition(int position) {
        mPosition = position;
    }

    /**
     * Set the number of columns and item count in order to accurately store the
     * max height for each row. This must be called whenever there is a change to the layout
     * or content data.
     *
     * @param numColumns
     * @param itemCount
     */
    public static void initItemLayout(int numColumns, int itemCount) {
        mNumColumns = numColumns;
        mMaxRowHeight = new int[itemCount];
        Log.d("init",Integer.toString(mMaxRowHeight.length));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // Do not calculate max height if column count is only one
        if(mNumColumns <= 1 || mMaxRowHeight == null || mMaxRowHeight.length==0) {
            return;
        }

        // Get the current view cell index for the grid row
        int rowIndex = mPosition / mNumColumns;
        // Get the measured height for this layout
        int measuredHeight = getMeasuredHeight();
        // If the current height is larger than previous measurements, update the array
        if(measuredHeight > mMaxRowHeight[rowIndex]) {
            mMaxRowHeight[rowIndex] = measuredHeight;
        }
        // Update the dimensions of the layout to reflect the max height
        setMeasuredDimension(getMeasuredWidth(), mMaxRowHeight[rowIndex]);
    }

    public void updateItemDisplay(Faculty item)
    {
        ImageView image = (ImageView) findViewById(R.id.faculty_image);
        TextView name = (TextView) findViewById(R.id.fac_name);
        TextView desg = (TextView) findViewById(R.id.fac_desg);

        name.setText(item.name);
        desg.setText(item.designation);
        Log.d("update",item.image_loc);

        Picasso.with(getContext()).load(item.image_loc).into(image);

    }
}

