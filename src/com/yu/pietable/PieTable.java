package com.yu.pietable;

import java.util.List;

import com.yu.utils.EntyExpenses;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class PieTable extends FrameLayout{
	
	private Pie pie;
	private LineText lineText;

	public PieTable(Context context, AttributeSet attrs) {
		super(context, attrs);
		pie = new Pie(context, attrs);
		lineText = new LineText(context, attrs);
		addView(pie, LayoutParams.MATCH_PARENT);
		lineText.setBackgroundColor(0x00000000);
		addView(lineText, LayoutParams.MATCH_PARENT);
		
	}
	
	public void initi(List<EntyExpenses> list){
		pie.initi(list, lineText);
		lineText.initi(list, pie);
	}
	
}
