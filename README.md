# PieChart
点击后带旋转动画的饼图
------
![image](https://github.com/liyuqwe2010/PieChart/raw/master/example.jpg)
 
### 功能说明
这是一个展示百分比以及其数字大小的饼图类控件<br />
点击饼图的各区域即可顺时针旋转至该区域<br />
点击中间的圆圈可顺时针旋转一格，并显示相应的数值信息<br />
所占份数最大的会在初始位置，即顶端以蓝色显示<br />
顶部竖线颜色随着饼图顶部颜色的变化而变化

### 使用方法
    //XML添加控件
    <com.yu.pietable.PieTable
        android:id="@+id/pieTable"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#ffffff"/>
    
    //添加信息
    List<EntyExpenses> list = new ArrayList<EntyExpenses>();
		list.add(new EntyExpenses("哈哈", 20));
		list.add(new EntyExpenses("嘻嘻", 30));
		list.add(new EntyExpenses("呵呵", 30));
		list.add(new EntyExpenses("吼吼", 40)); 
		list.add(new EntyExpenses("擦擦", 40)); 

		PieTable pieTable = (PieTable) findViewById(R.id.pieTable);
		//初始化
		pieTable.initi(list);
		
### 注意事项
目前控件只含有5种初始颜色,自己添加颜色种类的具体方法：<br />
可以在com.yu.pietable下的Pie类下找到 colors类变量在其中自定义添加修改颜色<br />

		private final int[] colors = new int[]{0xff87CEFF,0xffFFC1C1,0xffFFF68F,0xff76EEC6,0xffCAFF70};<br />
		
PieTable里面为圆形区域触碰与绘图代码,LineText内为中间数值,顶部比例及竖线显示
    
### 其他
写代码的时间不长,第一次在github上发东西，还是有点小激动O(∩_∩)O~
