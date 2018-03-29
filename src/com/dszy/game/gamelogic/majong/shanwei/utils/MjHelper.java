package com.dszy.game.gamelogic.majong.shanwei.utils;

//import static com.dszy.game.gamelogic.majong.data.Consts.CARDTYPE_PENG;
//import static com.dszy.game.gamelogic.majong.data.Consts.CARD_NONE;
import static com.dszy.game.gamelogic.majong.data.Consts.CARDTYPE_PENG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_1TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_1TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_1WAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_9TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_9TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_9WAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_BAI;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_BEI;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_DONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_FA;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_NAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_NONE;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_XI;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_ZHONG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.dszy.game.gamelogic.majong.data.Consts;
import com.dszy.game.gamelogic.majong.gameinfo.BaseGameInfo;
import com.dszy.game.gamelogic.majong.player.BasePlayer;
import com.dszy.game.gamelogic.majong.player.BasePlayer.OpenCard;
import com.dszy.game.gamelogic.majong.shanwei.ShanWeiGameInfo;
import com.dszy.game.gamelogic.majong.utils.ComplexHu.Jiang;
import com.dszy.game.gamelogic.majong.utils.ComplexHu.KeZi;
import com.dszy.game.gamelogic.majong.utils.ComplexHu.Pattern;
import com.dszy.game.gamelogic.majong.utils.Hu;
import com.dszy.game.gamelogic.majong.utils.Hu.HuStrategy;
import com.dszy.game.gamelogic.majong.utils.Hu.TingInfo;
import com.dszy.game.gamelogic.majong.utils.Hus;
import com.dszy.game.gamelogic.majong.utils.Lists;

/**
  * @Description:
  * @author palmshe 
  * add by gary
  * @date 2017年6月15日 下午12:20:09
  */
public class MjHelper {

	/**
	  * @Description：是否为万牌
	  * @param card
	  * @return
	  */
	public static boolean isWanPai(Byte card){
		return card/10== 1;
	}
	
	/**
	  * @Description：是否为条牌
	  * @param card
	  * @return
	  */
	public static boolean isTiaoPai(Byte card){
		return card/10== 2;
	}
	
	/**
	 * 是否为风牌
	 * @param card
	 * @return
	 */
	public static boolean isFengPai(Byte card) {
		return card==Consts.CARD_DONG || card==Consts.CARD_NAN || card==Consts.CARD_XI || card==Consts.CARD_BEI;
	}
	
	/**
	 * 是否为箭牌
	 * @param card
	 * @return
	 */
	public static boolean isJianPai(Byte card) {
		return card==Consts.CARD_ZHONG || card==Consts.CARD_FA || card==Consts.CARD_BAI;
	}
	
	/**
	  * @Description：是否为筒牌
	  * @param card
	  * @return
	  */
	public static boolean isTongPai(Byte card){
		return card/10== 3;
	}
	
	/**
	 * 是否为字牌
	 * @param card
	 * @return
	 */
	public static boolean isZiPai(Byte card) {
		return card/10 == 4;
	}
	
	/**
	  * @Description：是否为中牌
	  * @param card
	  * @return
	  */
	public static boolean isZhongPai(Byte card){
		return card== Consts.CARD_ZHONG;
	}
	
	/**
	  * @Description：是否为发牌
	  * @param card
	  * @return
	  */
	public static boolean isFaPai(Byte card){
		return card== Consts.CARD_FA;
	}
	
	/**
	  * @Description：是否为白牌
	  * @param card
	  * @return
	  */
	public static boolean isBaiPai(Byte card){
		return card== Consts.CARD_BAI;
	}
	
	/**
	  * 打掉这张牌后可以胡什么牌
	  * @param player
	  * @param playerCards
	  * @return
	  */
	public static List<Byte> isTingShiSanYao(BasePlayer player, List<Byte> playerCardsx) {
		List<Byte> tinghu = new ArrayList<Byte>();
		List<Byte> playerCards = new ArrayList<Byte>(playerCardsx);
		byte[] Allcard = new byte[] { 11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24, 25, 26, 27, 28, 29, 31, 32,
				33, 34, 35, 36, 37, 38, 39, 41, 42, 43, 44, 45, 46, 47 };
		if (playerCards.size() == 13) {
			for (int i = 0; i < Allcard.length; i++) {
				playerCards.add(Allcard[i]);
				if (!(Hu.checkHu(playerCards, Lists.emptyList(), Hus.HU_SHISANYAO).isEmpty())) {
					tinghu.add(Allcard[i]);
					playerCards.remove(playerCards.size() - 1);
				} else {
					playerCards.remove(playerCards.size() - 1);
				}
			}
		}
		return tinghu;
	}
	 /**
	  * 打什么牌进入胡牌提示
	  * @param player
	  * @param playerCards
	  * @return
	  */
	public static List<Byte> isShiSanYaoCanTing(BasePlayer player, List<Byte> playerCardsx) {
		List<Byte> tinghu = new ArrayList<Byte>();
		if (playerCardsx.size() == 14) {
			for (int i = 0; i < playerCardsx.size(); i++) {
				List<Byte> playerCards = new ArrayList<Byte>(playerCardsx);
				byte x = playerCards.get(i);
				playerCards.remove(playerCards.get(i));
				if (isTingShiSanYao(player, playerCards).size() > 0) {
					tinghu.add(x);
				}
			}
		}
		return tinghu;
	}
	
	
	/**
	 * 全字
	 */
	public static boolean isquanzi(BasePlayer player, List<Byte> huResult) {
		boolean hasWan = false;
		boolean hasTong = false;
		boolean hasTiao = false;
		boolean hasZi = false;

		List<OpenCard> openCards = player.getOpenCards();
		List<Byte> cards = new ArrayList<>();
		for (OpenCard openCard : openCards) {
			cards.addAll(openCard.getOpenCards());
		}
		cards.addAll(huResult);

		for (byte card : cards) {
			if (isWanPai(card)) {
				hasWan = true;
			} else if (isTongPai(card)) {
				hasTong = true;
			} else if (isTiaoPai(card)) {
				hasTiao = true;
			} else if (isZiPai(card)) {
				hasZi = true;
			}
		}

		if (hasZi && !hasWan && !hasTong && !hasTiao) {
			return true;
		}
		return false;
	}
	
	/**
	 * 是否七花
	 * @param player
	 * @return
	 */
	public static boolean isQiHua(BasePlayer player) {
		
		return player.getFlowerCount()==7;
	}
	
	/**
	 * 判断是否是对对胡
	 */
	public static boolean isduiduiHu(BasePlayer player, List<Pattern> patterns) {
		for (Pattern p : patterns) {
			if (player.getOpenCards().size() + p.getKezi().size() == 4
					&& (p.getShunzi() == null || p.getShunzi().size() == 0)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 清一色
	 */
	public static boolean isqingyise(BasePlayer player, List<Byte> huResult) {
		boolean hasWan = false;
		boolean hasTong = false;
		boolean hasTiao = false;
		boolean hasZi = false;

		List<OpenCard> openCards = player.getOpenCards();
		List<Byte> cards = new ArrayList<>();
		for (OpenCard openCard : openCards) {
			cards.addAll(openCard.getOpenCards());
		}
		cards.addAll(huResult);
		for (byte card : cards) {
			if (isWanPai(card)) {
				hasWan = true;
			} else if (isTongPai(card)) {
				hasTong = true;
			} else if (isTiaoPai(card)) {
				hasTiao = true;
			} else if (isZiPai(card)) {
				hasZi = true;
			}
		}

		if (hasWan && !hasTong && !hasTiao && !hasZi) {
			return true;
		} else if (hasTong && !hasWan && !hasTiao && !hasZi) {
			return true;
		} else if (hasTiao && !hasTong && !hasWan && !hasZi) {
			return true;
		}
		return false;
	}

	/**
	 * 混一色
	 */
	public static boolean ishunyise(BasePlayer player, List<Byte> huResult) {
		boolean hasWan = false;
		boolean hasTong = false;
		boolean hasTiao = false;
		boolean hasZi = false;

		List<OpenCard> openCards = player.getOpenCards();
		List<Byte> cards = new ArrayList<>();
		for (OpenCard openCard : openCards) {
			cards.addAll(openCard.getOpenCards());
		}
		cards.addAll(huResult);

		for (byte card : cards) {
			if (isWanPai(card)) {
				hasWan = true;
			} else if (isTongPai(card)) {
				hasTong = true;
			} else if (isTiaoPai(card)) {
				hasTiao = true;
			} else if (isZiPai(card)) {
				hasZi = true;
			}
		}

		if (hasWan && !hasTong && !hasTiao && hasZi) {
			return true;
		} else if (hasTong && !hasWan && !hasTiao && hasZi) {
			return true;
		} else if (hasTiao && !hasTong && !hasWan && hasZi) {
			return true;
		}
		return false;
	}
	
	/**
	 * 验证计算相同的牌的多少
	 */
	public static int countInArray(byte card,List<Byte> cards){
		int j=0;
		for(int i=0;i<cards.size();i++){
			if(cards.get(i)==card){
				j++;
			}
		}
		return j;
	}
	
	/**
	 * 小三元
	 * @param player
	 * @param huResult
	 * @return
	 */
	public static boolean isXiaoSanYuan(List<Pattern> ps) {
		Boolean flag1 = false;
		Boolean flag2 = false;
		int count = 0;
		for (Pattern pattern : ps) {
			LinkedList<KeZi> kezi = pattern.getKezi();
			LinkedList<Jiang> jiangzi = pattern.getJiang();
			for (int i = 0; i < kezi.size(); i++) {
				for (int j = 0; j < 3; j++) {
					if (isJianPai(kezi.get(i).getCard1())) {
						flag1=true;
						count++;
					}
//					flag1 = isJianPai(kezi.get(i).getCard1());
				}
			}
			for (int i = 0; i < jiangzi.size(); i++) {
				for (int j = 0; j < 2; j++) {
					//判断将子牌型
					flag2 = isJianPai(jiangzi.get(i).getCard1());
				}
			}
			if (count/3==2 && jiangzi.size()==1 && flag1 && flag2) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 大小三元
	 */
	public static int isDaXiao3Yuan(BasePlayer player,List<Byte> checkedCards){
		int falg=0;
		boolean falg2=false;
		List<Byte> closeCards=checkedCards;
		List<OpenCard> openCards=player.getOpenCards();
		 int countZC = countInArray(CARD_ZHONG, closeCards);
		 int countFC = countInArray(CARD_FA, closeCards);
		 int countBC = countInArray(CARD_BAI, closeCards);
		 boolean youZO=false;
		 boolean youFO=false;
		 boolean youBO=false;
		 for(OpenCard openCard : openCards){
			 if(openCard.getOpenCardsOrig()==CARD_ZHONG){
				 youZO=true;
			 }
            if(openCard.getOpenCardsOrig()==CARD_FA){
            	youFO=true;
			 }
            if(openCard.getOpenCardsOrig()==CARD_BAI){
            	youBO=true;
			 }
		 }
		 if(countZC>=3||youZO){
			 falg++;
		 }
		 if(countFC>=3||youFO){
			 falg++;
		 }
		 if(countBC>=3||youBO){
			 falg++;
		 }
		 if(falg==2){
			 if(countZC==2){
				 falg2=true;
			 }
			 if(countFC==2){
				 falg2=true;
			 }
			 if(countBC==2){
				 falg2=true;
			 } 
		 }
		 if(falg>=3){
			 return 1;
		 }
		 if(falg2){
			 return 2;
		 }
		 return 0;
	}
	
	/**
	 * 大小四喜
	 */
	public static int isDaXiao4Xi(BasePlayer player,List<Byte> checkedCards){
		int falg=0;
		boolean falg2=false;
		List<Byte> closeCards=checkedCards;
		List<OpenCard> openCards=player.getOpenCards();
		int countDC = countInArray(CARD_DONG, closeCards);
		 int countXC = countInArray(CARD_XI, closeCards);
		 int countNC = countInArray(CARD_NAN, closeCards);
		 int countBC = countInArray(CARD_BEI, closeCards);
		 boolean youDO=false;
		 boolean youXO=false;
		 boolean youNO=false;
		 boolean youBC=false;
		 for(OpenCard openCard : openCards){
			 if(openCard.getOpenCardsOrig()==CARD_DONG){
				 youDO=true;
			 }
            if(openCard.getOpenCardsOrig()==CARD_XI){
            	youXO=true;
			 }
            if(openCard.getOpenCardsOrig()==CARD_NAN){
            	youNO=true;
			 }
            if(openCard.getOpenCardsOrig()==CARD_BEI){
            	youBC=true;
			 }
		 }
		 if(countDC>=3||youDO){
			 falg++;
		 }
        if(countXC>=3||youXO){
        	falg++;
		 }
         if(countNC>=3||youNO){
        	 falg++;
        }
        if(countBC>=3||youBC){
        	falg++;
          }
        if(falg==3){
        	 if(countDC==2){
        		 falg2=true;
    		 }
            if(countXC==2){
            	 falg2=true;
    		 }
             if(countNC==2){
            	 falg2=true;
            }
            if(countBC==2){
            	 falg2=true;
              }
        }
        if(falg>=4){
        	return 1;
        }else if(falg==3&&falg2){
        	return 2;
        }
		return 0;
	}
	
	
	/**
	 * 大三元
	 * @param ps
	 * aborted
	 * @return
	 */
	public static boolean isDaSanYuan(List<Pattern> ps) {
		Boolean flag = false;
		int count =0;
		for (Pattern pattern : ps) {
			LinkedList<KeZi> lists = pattern.getKezi();
			for (int i = 0; i < lists.size(); i++) {
				for (int j = 0; j < 3; j++) {
					//判断刻子牌型
					if (isJianPai(lists.get(i).getCard1())) {
						flag= true;
						count++;
					}
//					flag = isJianPai(lists.get(i).getCard1());
				}
			}
			if (count/3==3 && flag) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 大四喜
	 * @param ps
	 *  aborted
	 * @return
	 */
	public static boolean isDaSiXi(List<Pattern> ps) {
		Boolean flag = false;
		int count =0;
//		List<OpenCard> openCards = player.getOpenCards();
//		List<Byte> cards = new ArrayList<>();
//		for (OpenCard openCard : openCards) {
//			cards.addAll(openCard.getOpenCards());
//		}
//		cards.addAll(huResult);
		for (Pattern pattern : ps) {
			LinkedList<KeZi> lists = pattern.getKezi();
			for (int i = 0; i < lists.size(); i++) {
				for (int j = 0; j < 3; j++) {
					//判断刻子牌型
					if (isFengPai(lists.get(i).getCard1())) {
						flag = true;
						count++;
					}
//					flag = isFengPai(lists.get(i).getCard1());
				}
			}
			if (count/3==4 && flag) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 小四喜
	 * @param ps
	 *  aborted
	 * @return
	 */
	public static boolean isXiaoSiXi(List<Pattern> ps) {
		Boolean flag1 = false;
		Boolean flag2 = false;
		int count = 0;
		for (Pattern pattern : ps) {
			LinkedList<KeZi> kezi = pattern.getKezi();
			LinkedList<Jiang> jiangzi = pattern.getJiang();
			for (int i = 0; i < kezi.size(); i++) {
				for (int j = 0; j < 3; j++) {
					//判断刻子牌型
					if (isFengPai(kezi.get(i).getCard1())) {
						flag1 = true;
						count++;
					}
//					flag1 = isFengPai(kezi.get(i).getCard1());
				}
			}
			for (int i = 0; i < jiangzi.size(); i++) {
				for (int j = 0; j < 2; j++) {
					//判断将子牌型
					flag2 = isFengPai(jiangzi.get(i).getCard1());
				}
			}
			if (count/3==3 && jiangzi.size()==1 && flag1 && flag2) {
				return true;
			}
		}
		return false;
	}
	
	public static List<TingInfo> checkTing19z(List<Byte> checkedCards){
		List<Byte> card19z=Arrays.asList(CARD_1WAN,CARD_1TIAO,CARD_1TONG,CARD_9WAN,CARD_9TIAO,CARD_9TONG,CARD_DONG,CARD_NAN,CARD_XI,CARD_BEI,CARD_ZHONG,CARD_FA,CARD_BAI);
		List<TingInfo> tis=new ArrayList<>();
		if(checkedCards.size()==14){
			for (byte rpc : checkedCards) {
				List<Byte> cards=new ArrayList<>(checkedCards);
				cards.remove(cards.indexOf(rpc));
				Set<Byte> tingCards=new HashSet<>();
				for (byte card : card19z) {
					List<Byte> cards_=new ArrayList<>(cards);
					cards_.add(card);
					if(!Hu.checkHu(cards_, Lists.emptyList(), Hus.HU_SHISANYAO).isEmpty()){
						tingCards.add(card);
					}
				}
				if(!tingCards.isEmpty()){
					boolean needAdd=true;
					for(TingInfo ti:tis){
						if(ti.getPlayForTingCard()==rpc){
							tingCards.addAll(ti.getTingCards());
							List<Byte> tmp=new ArrayList<Byte>();
							tmp.addAll(tingCards);
							ti.setTingCards(tmp);
							needAdd=false;
							break;
						}
					}
					if(needAdd){
						TingInfo ti=new TingInfo();
						ti.setPlayForTingCard(rpc);
						List<Byte> tmp=new ArrayList<Byte>();
						tmp.addAll(tingCards);
						ti.setTingCards(tmp);
						tis.add(ti);
					}
				}
				
			}
		}
		return tis;
	}
	
	
	/**
	 * 十三幺
	 * @param player
	 * @param huResult
	 * @return
	 */
/*	public static boolean isShiSanYao(BasePlayer player, List<Byte> huResult) {
		boolean is19 = false;
		List<OpenCard> openCards = player.getOpenCards();
		List<Byte> cards = new ArrayList<>();
		for (OpenCard openCard : openCards) {
			cards.addAll(openCard.getOpenCards());
		}
		cards.addAll(huResult);
		for (byte card : cards) {
			 is19 = card>40 || card%10==1 || card%10==9;
		}
		
		return is19 && huResult.size()==14;
	}*/
	
	/**
	 * @Description：喊听后是否能明杠
	 * @param player
	 * @param actionCard
	 * @return
	 */
	public static boolean canClearGangAfterTing(BaseGameInfo gameInfo, BasePlayer checkedPlayer, Byte actionCard, HuStrategy...huStrategies) {
		boolean isCan = checkedPlayer.getCloseCards().stream().filter(card -> {
			return card == actionCard;
		}).count() == 3;
		if (!isCan) {
			return false;
		}
		List<Byte> tempCloseCards = new LinkedList<>(checkedPlayer.getCloseCards());
		tempCloseCards.removeIf(card -> {
			return card == actionCard;
		});
		tempCloseCards.add(CARD_NONE);
		List<Byte> laizies = new ArrayList<>();
		if (gameInfo.getLaizi()!= 0) {	
			laizies.add(gameInfo.getLaizi());
		}
		List<TingInfo> tempResult = Hu.checkTing(tempCloseCards, laizies, huStrategies);
		if (tempResult.isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * @Description：喊ting后能否加杠
	 * @return
	 */
	public static boolean canAddGangAfterTing(BaseGameInfo gameInfo, BasePlayer checkedPlayer, Byte doorCard, HuStrategy...huStrategies) {
		List<OpenCard> openCards = checkedPlayer.getOpenCards();
		List<Byte> closeCards = checkedPlayer.getCloseCards();
		List<Byte> addGangCards = new ArrayList<>();
		for (OpenCard openCard : openCards) {
			if (openCard.getOpenCardsType() == CARDTYPE_PENG) {
				if (openCard.getOpenCardsOrig() == doorCard) {
					addGangCards.add(openCard.getOpenCards().get(0));
				}
			}
		}
		checkedPlayer.setAddGangCards(addGangCards);
		boolean isCan = !addGangCards.isEmpty();
		if (!isCan) {
			return false;
		}
		List<Byte> tempCloseCards = new LinkedList<>(closeCards);
		tempCloseCards.removeIf(card -> {
			return card == doorCard;
		});
		tempCloseCards.add(CARD_NONE);
		List<Byte> laizies = new ArrayList<>();
		if (gameInfo.getLaizi()!= 0) {
			laizies.add(gameInfo.getLaizi());
		}
		List<TingInfo> tempResult = Hu.checkTing(tempCloseCards, laizies, huStrategies);
		if (tempResult.isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * @Description：喊ting后能否暗杠
	 * @return
	 */
	public static boolean canAnGangAfterTing(BaseGameInfo gameInfo, BasePlayer checkedPlayer, Byte doorCard, HuStrategy...huStrategies) {

		Map<Byte, Integer> counter = new HashMap<>();
		for (byte card : checkedPlayer.getCloseCards()) {
			if (counter.containsKey(card)) {
				counter.put(card, counter.get(card) + 1);
			} else {
				counter.put(card, 1);
			}
		}
		List<Byte> anGangCards = new ArrayList<>();
		for (Entry<Byte, Integer> e : counter.entrySet()) {
			if (e.getValue() >= 4 && !Hu.isLaizi(e.getKey()) && e.getKey() == doorCard)
				anGangCards.add(e.getKey());
		}
		checkedPlayer.setAnGangCards(anGangCards);
		boolean isCan = !anGangCards.isEmpty();
		if (!isCan) {
			return false;
		}
		List<Byte> tempCloseCards = new LinkedList<>(checkedPlayer.getCloseCards());
		tempCloseCards.removeIf(card -> {
			return card == doorCard;
		});
		tempCloseCards.add(Consts.CARD_NONE);
		List<Byte> laizies = new ArrayList<>();
		if (gameInfo.getLaizi()!= 0) {
			laizies.add(gameInfo.getLaizi());
		}
		List<TingInfo> tempResult = Hu.checkTing(tempCloseCards, laizies, huStrategies);
		if (tempResult.isEmpty()) {
			return false;
		}
		return true;
	}
	
	/**
	  * @Description：设置杠钱底分和胡牌底分
	  * @param gameInfo
	  * @param base
	  */
	public static void setBase(ShanWeiGameInfo gameInfo, int base){
		gameInfo.setBase(base);
		int gangBase= 0;
		if (base== 2) {
			gangBase= 1;
		}else if (base== 4) {
			gangBase= 2;
		}else if (base== 10) {
			gangBase= 5;
		}else if (base== 20) {
			gangBase= 10;
		}
		gameInfo.setGangBase(gangBase);
	}
	
	
	
	
	public static void main(String[] args) {
//		List<Byte> huResult = {};
//		isShiSanYao(new ShanWeiPlayer(), huResult );
	}
	
}
