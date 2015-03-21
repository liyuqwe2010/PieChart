package com.yu.pietable;

import java.math.BigDecimal;
import java.util.List;

import com.yu.utils.EntyExpenses;
import com.yu.utils.FormatString;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class LineText extends View{
	
	//提供数据源
	private List<EntyExpenses> list;
	
	private Paint showPaint;
	
	private Paint textPaint;
	
	private Pie pieTable;
	
	public List<EntyExpenses> getList() {
		return list;
	}
	
	public void setList(List<EntyExpenses> list) {
		this.list = list;
	}

	public void initi(List<EntyExpenses> list, Pie pieTable){
		this.list = list;
		this.pieTable = pieTable;
		this.invalidate();
	}
	
	public LineText(Context context, AttributeSet attrs) {
		super(context, attrs);
		showPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		showPaint.setStyle(Paint.Style.FILL);
		showPaint.setAntiAlias(true);
		
		textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
		textPaint.setStyle(Paint.Style.FILL);
		textPaint.setAntiAlias(true);
		textPaint.setTypeface(Typeface.DEFAULT);
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		
		textPaint.setColor(0x80000000);
		
		float height = this.getHeight();
		float width = this.getWidth();

		float mWidth = width*0.45f;
		float mHeight = height*0.45f;
		
		//移动中心
        canvas.translate(width*0.5f, height*0.5f);
        
        float centerRadius = getMin(mWidth, mHeight)*0.65f;
		
		//支出种类
		if( list == null || (list.get(0).getExpensesMainType()!=null && list.get(0).getExpensesMainType().equals("没有数据(⊙o⊙)哦"))){
			//没有数据
			textPaint.setColor(0xff87CEFF);
			textPaint.setTextSize(centerRadius*0.15f);
			canvas.drawText("没有数据", -textPaint.measureText("没有数据")/2f, -centerRadius*0.1f, textPaint);
			textPaint.setTextSize(centerRadius*0.16f);
			canvas.drawText("(⊙o⊙)", -textPaint.measureText("(⊙o⊙)")/2f, centerRadius*0.15f, textPaint);
		}
		else{
			showPaint.setColor(pieTable.getColorsUse().get(0));
			showPaint.setStyle(Style.FILL);
			showPaint.setStrokeWidth(0.015f*centerRadius);
			//绘制百分比文字
			textPaint.setTextSize(centerRadius*0.14f);
			String text = String.valueOf(FormatString.keep1AfterPoint(new BigDecimal(String.valueOf(list.get(0).getExpensesPersent()*100f)))) + " %";
			float widthText = textPaint.measureText(text);
			canvas.drawText(text, -widthText/2f, -1.44f*centerRadius, textPaint);
			//绘制圆圈内文字
			textPaint.setTextSize(centerRadius*0.16f);
			String textC = list.get(0).getExpensesMainType();
			float widthTextC = textPaint.measureText(textC);
			canvas.drawText(textC, -widthTextC/2f, -centerRadius*0.05f, textPaint);
			//具体金额
			textC = FormatString.keep1AfterPoint(new BigDecimal(String.valueOf(list.get(0).getExpensesNum())));
			widthTextC = textPaint.measureText(textC);
			
			canvas.drawText(textC, -widthTextC/2f, 0.15f*centerRadius, textPaint);
			//绘制直线
			canvas.drawLine(0, -centerRadius, 0, -1.4f*centerRadius, showPaint);
			
			showPaint.setStyle(Style.STROKE);
			RectF oval = new RectF(-0.25f*centerRadius, -1.400001f*centerRadius,
					0.25f*centerRadius, -1.4f*centerRadius);
			//绘制横线平台
			canvas.drawRoundRect(oval, 35f, 35f, showPaint);
		}
		
	}
	
	public float getMin(float mWidth, float mHeight){
		float min;
		if(mWidth<=mHeight){
			min = mWidth;
		}
		else{
			min = mHeight;
		}
		return min;
	}

}
