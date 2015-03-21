package com.yu.utils;

import java.util.Comparator;

public class CompareList implements Comparator<EntyExpenses>{

	@Override
	public int compare(EntyExpenses lhs, EntyExpenses rhs) {
		if(lhs.getExpensesNum()>rhs.getExpensesNum()){
			return -1;
		}
		else if(lhs.getExpensesNum()<rhs.getExpensesNum()){
			return 1;
		}
		return 0;
	}
}
