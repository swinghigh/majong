package com.dszy.game.gamelogic.majong.shanwei;

import java.util.ArrayList;
import java.util.List;

import com.dszy.game.gamelogic.majong.player.BasePlayer;
import com.dszy.game.gamelogic.majong.utils.Copyable;

public class ShanWeiPlayer extends BasePlayer {
	
	@Copyable
	private int gangCount;//杠牌次数
	@Copyable
	private int zhigangcount;
	@Copyable
	private int anagangcount;
	@Copyable
	private int bugangcount;
	
	@Copyable
	private int gangKaiSum;//杠开次数
	
	
	@Copyable
	private int qghcount;
	@Copyable
	private int bqghcount;
	/**玩家能否胡地胡*/
	private boolean candihu=true;
	public boolean isCandihu() {
		return candihu;
	}

	public void setCandihu(boolean candihu) {
		this.candihu = candihu;
	}

	//可以自模胡
	private boolean canzimohu;
	
	//可以七花胡
	private boolean canqihuahu = true;
	
	private boolean canbahuahu =true;
	
	//判断胡牌是否成牌型
	private boolean makePaiXing = false;
	
	public boolean isCanbahuahu() {
		return canbahuahu;
	}

	public void setCanbahuahu(boolean canbahuahu) {
		this.canbahuahu = canbahuahu;
	}

	public int getGangKaiSum() {
		return gangKaiSum;
	}

	public boolean isMakePaiXing() {
		return makePaiXing;
	}

	public void setMakePaiXing(boolean makePaiXing) {
		this.makePaiXing = makePaiXing;
	}

	public void setGangKaiSum(int gangKaiSum) {
		this.gangKaiSum = gangKaiSum;
	}

	private ZhongMaPlayer zhongMaPlayer;
	
	//第一次不杠 先碰 第二次补杠的情况下 其他三家不用付钱
	private List<Byte> noFeeGangCards=new ArrayList<>();
	/**
	 * 每个玩家自己马牌
	 * 庄：1、5、9、东、春、梅
	      下家：2、6、南、中、夏、兰
	      对家：3、7、西、发、秋、竹
	      上家：4、8、北、白、冬、菊
	 * */
	private List<Byte> maCards=new ArrayList<>();
	
	/**
	 * 每个玩家自己正花牌
	 * 庄：春 梅
	      下家：夏 兰
	      对家：秋 竹
	      上家：冬 菊
	 * */
	private List<Byte> huaCards = new ArrayList<>();
	
	/**
	 * 每个玩家自己正字牌
	 * 庄：   东 中发白
	      下家：南  中发白
	      对家：西  中发白
	      上家：北  中发白
	 * */
	private List<Byte> ziCards = new ArrayList<>();
	
	/**
	 * 结算用到了  和显示马牌
	 * */
	private List<Byte> showjiangMaCards=new ArrayList<>();
	
	private List<Byte> showmaiMaCards=new ArrayList<>();
	
	private List<Byte> showzhengHuaCards=new ArrayList<>();
	
	private List<Byte> yangMaCards=new ArrayList<>();//可以养马哪些牌
	
	public ZhongMaPlayer getZhongMaPlayer() {
		return zhongMaPlayer;
	}

	public void setZhongMaPlayer(ZhongMaPlayer zhongMaPlayer) {
		this.zhongMaPlayer = zhongMaPlayer;
	}
	
	public List<Byte> getYangMaCards() {
		return yangMaCards;
	}

	public void setYangMaCards(List<Byte> yangMaCards) {
		this.yangMaCards = yangMaCards;
	}

	public List<Byte> getShowzhengHuaCards() {
		return showzhengHuaCards;
	}

	public void setShowzhengHuaCards(List<Byte> showzhengHuaCards) {
		this.showzhengHuaCards = showzhengHuaCards;
	}

	public int getGangCount() {
		return gangCount;
	}

	public void setGangCount(int gangCount) {
		this.gangCount = gangCount;
	}

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

	public List<Byte> getNoFeeGangCards() {
		return noFeeGangCards;
	}

	public void setNoFeeGangCards(List<Byte> noFeeGangCards) {
		this.noFeeGangCards = noFeeGangCards;
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

	public List<Byte> getMaCards() {
		return maCards;
	}

	public void setMaCards(List<Byte> maCards) {
		this.maCards = maCards;
	}
	
	public List<Byte> getHuaCards() {
		return huaCards;
	}

	public void setHuaCards(List<Byte> huaCards) {
		this.huaCards = huaCards;
	}

	public List<Byte> getZiCards() {
		return ziCards;
	}

	public void setZiCards(List<Byte> ziCards) {
		this.ziCards = ziCards;
	}

	public List<Byte> getShowjiangMaCards() {
		return showjiangMaCards;
	}

	public void setShowjiangMaCards(List<Byte> showjiangMaCards) {
		this.showjiangMaCards = showjiangMaCards;
	}

	public List<Byte> getShowmaiMaCards() {
		return showmaiMaCards;
	}

	public void setShowmaiMaCards(List<Byte> showmaiMaCards) {
		this.showmaiMaCards = showmaiMaCards;
	}
	
	public boolean isCanzimohu() {
		return canzimohu;
	}

	public void setCanzimohu(boolean canzimohu) {
		this.canzimohu = canzimohu;
	}
	
	public boolean isCanqihuahu() {
		return canqihuahu;
	}

	public void setCanqihuahu(boolean canqihuahu) {
		this.canqihuahu = canqihuahu;
	}


	/**选择买马玩法的时候 买的马 */
	private List<Byte> buyMaCards=new ArrayList<>();
	
	private boolean hdljia2;//海底捞
	private boolean gf2fan;
	
	private List<Byte> myCards=new ArrayList<>();//从开局到结束摸的牌
	
	public List<Byte> getBuyMaCards() {
		return buyMaCards;
	}

	public void setBuyMaCards(List<Byte> buyMaCards) {
		this.buyMaCards = buyMaCards;
	}

	public boolean isHdljia2() {
		return hdljia2;
	}

	public void setHdljia2(boolean hdljia2) {
		this.hdljia2 = hdljia2;
	}

	public boolean isGf2fan() {
		return gf2fan;
	}

	public void setGf2fan(boolean gf2fan) {
		this.gf2fan = gf2fan;
	}

	public List<Byte> getMyCards() {
		return myCards;
	}

	public void setMyCards(List<Byte> myCards) {
		this.myCards = myCards;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public static class  ZhongMaPlayer {
		private int  count;
		private long  userid;
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public long getUserid() {
			return userid;
		}
		public void setUserid(long userid) {
			this.userid = userid;
		}
	}
}
