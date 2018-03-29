package com.dszy.game.gamelogic.majong.shanwei;

import com.dszy.game.message.proto.room.PrivateRoomRankAwardMsg.PlayerInfo;

public class ShanWeiPlayInfo extends PlayerInfo {
	
	private int clearGangSum;//明杠次数
	
	private int addGangSum;//补杠次数
	
	private int anGangSum;//暗杠次数
	
	private int gangKaiSum;//杠开次数
	
	private int qiangGangSum;//抢杠次数
	
	private int beiQiangGangSum;//被抢杠次数

	public int getClearGangSum() {
		return clearGangSum;
	}

	public void setClearGangSum(int clearGangSum) {
		this.clearGangSum = clearGangSum;
	}

	public int getAddGangSum() {
		return addGangSum;
	}

	public void setAddGangSum(int addGangSum) {
		this.addGangSum = addGangSum;
	}

	public int getAnGangSum() {
		return anGangSum;
	}

	public void setAnGangSum(int anGangSum) {
		this.anGangSum = anGangSum;
	}
	
	public int getGangKaiSum() {
		return gangKaiSum;
	}

	public void setGangKaiSum(int gangKaiSum) {
		this.gangKaiSum = gangKaiSum;
	}

	public int getQiangGangSum() {
		return qiangGangSum;
	}

	public void setQiangGangSum(int qiangGangSum) {
		this.qiangGangSum = qiangGangSum;
	}

	public int getBeiQiangGangSum() {
		return beiQiangGangSum;
	}

	public void setBeiQiangGangSum(int beiQiangGangSum) {
		this.beiQiangGangSum = beiQiangGangSum;
	}
	
	
}
