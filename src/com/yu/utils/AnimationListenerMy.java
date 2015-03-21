package com.yu.utils;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.yu.pietable.LineText;
import com.yu.pietable.Pie;

public class AnimationListenerMy implements AnimationListener {
	
	private View view;
	private boolean isRotate;
	private int currentFlag;
	private List<Integer> colorsUse;
	private List<EntyExpenses> list;
	private LineText line;
	
	public AnimationListenerMy(View view, boolean isRotate){
		this.view = view;
		this.isRotate = isRotate;
	}
	
	public AnimationListenerMy(View view, LineText line, boolean isRotate, int currentFlag, List<Integer> colorsUse,
			List<EntyExpenses> list) {
		this(view, isRotate);
		this.currentFlag = currentFlag;
		this.colorsUse = colorsUse;
		this.list = list;
		this.line = line;
	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnimationEnd(Animation animation) {
		if(!isRotate){
			view.setX(view.getWidth());
			view.setY(view.getY());
			view.clearAnimation();
		}
		else{
			Pie pieTable = (Pie) view;
			
			//list数据源位置调换
			List<EntyExpenses> listNew = new ArrayList<EntyExpenses>();
			List<Integer> colors = new ArrayList<Integer>();
			
			for(int i=currentFlag; i<list.size(); i++){
				listNew.add(list.get(i));
				colors.add(colorsUse.get(i));
			}
			for(int i=0; i<currentFlag; i++){
				listNew.add(list.get(i));
				colors.add(colorsUse.get(i));
			}
			pieTable.fresh(listNew, colors);
			line.setList(listNew);
			line.invalidate();
			pieTable.clearAnimation();
		}
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub
		
	}

}
