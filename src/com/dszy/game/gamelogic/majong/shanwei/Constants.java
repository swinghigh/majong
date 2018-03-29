package com.dszy.game.gamelogic.majong.shanwei;

public class Constants {
	
	/*
	 * 结算取负数时使用
	 */
	public static final int NEGATIVE_CALC= -1;
	
	/*
	 * 赢牌类型补充
	 */
	
	public static final int RESULT_DEFAULT= 0;
	
	/**
	 * 结算加成类型
	 */
	public static final String TYPE_FAN = "番";
	public static final String TYPE_FEN = "分";
	
	/*
	 * 自定义的Actionid
	 */
	public static final byte ACTION_ID_YANGMA = 94;//养马的actionid
	public static final String YANGMA_EVENT = "yangma_event";//养马的事件
	public static final String EXECUTE_YANGMA = "execute_yangma";//养马的事件
	public static final String YANGMA_STATE = "yangma_state";//养马的状态
	
	public static final byte ACTION_DIHU=10;
	public static final byte ACTION_DIHU_DIANPAO=11;
	
}
