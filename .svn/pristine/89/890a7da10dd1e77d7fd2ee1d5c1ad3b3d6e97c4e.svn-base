package com.dszy.game.gamelogic.majong.shanwei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dszy.game.message.proto.game.MMajongGameOverMsg;

public class ShanWeiGameOverMessage extends MMajongGameOverMsg {
	
	private int fanmaTypeInfo;//1 奖马  2 买马  3 都不翻 4 都翻
	//翻马信息中买马的信息
	
	private Map<Long, List<Fanma>> maimainfo2 = new HashMap<Long, List<Fanma>>();
	
	private List<Fanma> maimaInfo = new ArrayList<>();
	public int getFanmaTypeInfo() {
		return fanmaTypeInfo;
	}
	
	public Map<Long, List<Fanma>> getMaimainfo2() {
		return maimainfo2;
	}

	public void setMaimainfo2(Map<Long,List<Fanma>> maimainfo2) {
		this.maimainfo2 = maimainfo2;
	}




	public void setFanmaTypeInfo(int fanmaTypeInfo) {
		this.fanmaTypeInfo = fanmaTypeInfo;
	}
	public List<MMajongGameOverMsg.Fanma> getMaimaInfo() {
		return maimaInfo;
	}
	public void setMaimaInfo(List<MMajongGameOverMsg.Fanma> maimaInfo) {
		this.maimaInfo = maimaInfo;
	}
}
