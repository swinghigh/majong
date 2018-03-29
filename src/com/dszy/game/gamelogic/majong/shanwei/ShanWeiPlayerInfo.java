package com.dszy.game.gamelogic.majong.shanwei;

import com.dszy.game.message.proto.room.PrivateRoomRankAwardMsg.PlayerInfo;

public class ShanWeiPlayerInfo extends PlayerInfo {

	private int zhigangcount;
	private int anagangcount;
	private int bugangcount;
	//抢杠胡次数
	private int qghcount;
	//被抢杠胡次数
	private int bqghcount;
	
	public int getZhigangcount() {
		return zhigangcount;
	}
	public void setZhigangcount(int zhigangcount) {
		this.zhigangcount = zhigangcount;
	}
	public int getAnagangcount() {
		return anagangcount;
	}
	public void setAnagangcount(int anagangcount) {
		this.anagangcount = anagangcount;
	}
	public int getBugangcount() {
		return bugangcount;
	}
	public void setBugangcount(int bugangcount) {
		this.bugangcount = bugangcount;
	}
	public int getQghcount() {
		return qghcount;
	}
	public void setQghcount(int qghcount) {
		this.qghcount = qghcount;
	}
	public int getBqghcount() {
		return bqghcount;
	}
	public void setBqghcount(int bqghcount) {
		this.bqghcount = bqghcount;
	}
}
