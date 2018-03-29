package com.dszy.game.gamelogic.majong.shanwei.utils;

import static com.dszy.game.gamelogic.majong.data.Consts.CARD_1TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_1TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_1WAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_2TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_2TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_2WAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_3TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_3TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_3WAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_4TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_4TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_4WAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_5TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_5TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_5WAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_6TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_6TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_6WAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_7TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_7TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_7WAN;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_8TIAO;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_8TONG;
import static com.dszy.game.gamelogic.majong.data.Consts.CARD_8WAN;
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
import static com.dszy.game.gamelogic.majong.utils.Hu.cardToLaizi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dszy.game.gamelogic.majong.data.Consts;
import com.dszy.game.gamelogic.majong.utils.Bytes;
import com.dszy.game.gamelogic.majong.utils.Hu;
import com.dszy.game.gamelogic.majong.utils.Hu.HuStrategy;
import com.dszy.game.gamelogic.majong.utils.Hu.TingInfo;
import com.dszy.game.gamelogic.majong.utils.Lists;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/**
  * @Description:
  * @author palmshe
  * @date 2017年6月12日 上午9:48:43
  */
public class HuHelper {
	
	private static final byte[] CARDS=new byte[]{
			CARD_1WAN,CARD_2WAN,CARD_3WAN,CARD_4WAN,CARD_5WAN,CARD_6WAN,CARD_7WAN,CARD_8WAN,CARD_9WAN,
			CARD_1TIAO,CARD_2TIAO,CARD_3TIAO,CARD_4TIAO,CARD_5TIAO,CARD_6TIAO,CARD_7TIAO,CARD_8TIAO,CARD_9TIAO,
			CARD_1TONG,CARD_2TONG,CARD_3TONG,CARD_4TONG,CARD_5TONG,CARD_6TONG,CARD_7TONG,CARD_8TONG,CARD_9TONG,
			CARD_DONG,CARD_NAN,CARD_XI,CARD_BEI,CARD_ZHONG,CARD_FA,CARD_BAI};
	
	/**
	 * 副不靠
	 */
	public static final HuStrategy HU_FUBUKAO_WITH_LAIZI=new HuStrategy() {

		@Override
		public List<List<Byte>> checkHu(List<Byte> checkedCards, int laiziCount) {
			List<Byte> tingCards= new ArrayList<>();
			byte[] cards=Lists.trans(checkedCards);
			boolean ret=true;
			if((cards.length+ laiziCount)!=14) ret=false;
			else{
				Arrays.sort(cards);
				byte[] cards147=new byte[]{
						CARD_1WAN,CARD_4WAN,CARD_7WAN,
						CARD_1TIAO,CARD_4TIAO,CARD_7TIAO,
						CARD_1TONG,CARD_4TONG,CARD_7TONG};
				byte[] cards258=new byte[]{
						CARD_2WAN,CARD_5WAN,CARD_8WAN,
						CARD_2TIAO,CARD_5TIAO,CARD_8TIAO,
						CARD_2TONG,CARD_5TONG,CARD_8TONG};
				byte[] cards369=new byte[]{
						CARD_3WAN,CARD_6WAN,CARD_9WAN,
						CARD_3TIAO,CARD_6TIAO,CARD_9TIAO,
						CARD_3TONG,CARD_6TONG,CARD_9TONG};
				byte[] cardszi=new byte[]{
						CARD_DONG,CARD_NAN,CARD_XI,CARD_BEI,
						CARD_ZHONG,CARD_FA,CARD_BAI};
				byte[][] allCards=new byte[][]{cards147,cards258,cards369,cardszi};
				for(byte target:cards){
					boolean find=false;
					for(byte[] a:allCards){
						int index=-1;
						if((index=Bytes.indexOf(a, target))!=-1){
							int color= target/10;
							if (color== 4) {
								cardszi[index]=  Consts.CARD_NONE;
							}else {
//								cards147[index]= 0;
//								cards258[index]= 0;
//								cards369[index]= 0;
								for (int i = 0; i < a.length; i++) {
									if (cards147[i] != Consts.CARD_NONE && (cards147[i]/10)==color && (Math.abs(cards147[i]- target)==0 || Math.abs(cards147[i]-target)== 1|| Math.abs(cards147[i]-target)== 2)) {
										cards147[i] = Consts.CARD_NONE;
									}
									if (cards258[i] != Consts.CARD_NONE && (cards258[i]/10)==color && (Math.abs(cards258[i]- target)==0 || Math.abs(cards258[i]-target)== 1|| Math.abs(cards258[i]-target)== 2)) {
										cards258[i] = Consts.CARD_NONE;
									}
									if (cards369[i] != Consts.CARD_NONE && (cards369[i]/10)==color && (Math.abs(cards369[i]- target)==0 || Math.abs(cards369[i]-target)== 1|| Math.abs(cards369[i]-target)== 2)) {
										cards369[i] = Consts.CARD_NONE;
									}
								}
							}
							find=true;
							break;
						}
					}
					if(!find){
						ret=false;
						break;
					}
				}
				
				for (byte temp : cards147) {
					if (temp!= Consts.CARD_NONE) {
						tingCards.add(Hu.cardToLaizi(temp));
					}
				}
				for (byte temp : cards258) {
					if (temp!= Consts.CARD_NONE) {
						tingCards.add(Hu.cardToLaizi(temp));
					}
				}
				for (byte temp : cards369) {
					if (temp!= Consts.CARD_NONE) {
						tingCards.add(Hu.cardToLaizi(temp));
					}
				}
				for (byte temp : cardszi) {
					if (temp!= Consts.CARD_NONE) {
						tingCards.add(Hu.cardToLaizi(temp));
					}
				}
			}
			if(ret){
//				checkedCards.addAll(tingCards);
//				Collections.sort(tingCards);
				Builder<List<Byte>> builder= ImmutableList.builder();
//				tingCards.stream().forEach((temp)->{
////					checkedCards.add(temp);
//				});
				builder.add(tingCards);
				return builder.build();
			}
			return Lists.emptyList();
		}
	};
	
	/**
	 * 十三幺
	 * 由1筒（饼）、9筒（饼）、1条（索）、9条（索）、1万、9万、东、南、西、北、中、发、白十三种牌统称幺九牌。
	 * 胡牌时这十三种牌某一种有两枚，而另十二种各一枚，共计十四枚，即构成十三幺。
	 */
	public static final HuStrategy HU_SHISANYAO=new HuStrategy() {

		@Override
		public List<List<Byte>> checkHu(List<Byte> checkedCards, int laiziCount) {
			if(checkedCards.size()==14){
				List<Byte> nCheckedCards=new ArrayList<>(checkedCards);
				Collections.sort(nCheckedCards);
				Set<Byte> set=new HashSet<>();
				byte repCard=CARD_NONE;
				for(byte card:nCheckedCards){
					if(is(card)){
						boolean suc=set.add(card);
						if(!suc){
							repCard=card;
						}
					}
				}
				if(set.size()==13 && set.contains(repCard)){
					Builder<List<Byte>> builder=ImmutableList.builder();
					builder.add(ImmutableList.copyOf(nCheckedCards));
					return builder.build();
				}
			}
			return Lists.emptyList();
		}
		
		private boolean is(byte card){
			return (card>40 || card%10==1 || card%10==9);
		}
	};
	
	public static final HuStrategy HU_NORMAL_WITH_LAIZI_SPECIAL_01 = new HuStrategy(){

		@Override
		public List<List<Byte>> checkHu(List<Byte> checkedCards, int laiziCount) {
			if((checkedCards.size()+laiziCount)%3!=2){
				return Lists.emptyList();
			}
			Builder<List<Byte>> ans=ImmutableList.builder();
			Map<Byte,Integer> _checkedCards=new HashMap<>();
			for(Byte b:checkedCards){
				if(_checkedCards.containsKey(b)){
					_checkedCards.put(b, _checkedCards.get(b)+1);
				}else{
					_checkedCards.put(b, 1);
				}
			}
			checkHu(ans,_checkedCards,new ArrayList<>(),true,false,laiziCount,0);
			return ans.build();
		}
		/**
		 * 算法思路:深度优先+动态规划
		 * 癞子替换需要考虑剪枝和牌型重复问题
		 */
		private void checkHu(
				Builder<List<Byte>> ans,Map<Byte,Integer> checkedCards,List<Byte> checkedAns,
				boolean findJiang,boolean findKe,
				int laiziCount,int index){
			boolean isEmpty=true;
			for(Integer value:checkedCards.values()){
				if(value>0){
					isEmpty=false;
					break;
				}
			}
			if(isEmpty){
				List<Byte> nCheckedAns=new ArrayList<>(checkedAns);
				while(laiziCount-->0){
					nCheckedAns.add(cardToLaizi(CARD_NONE));
				}
//				if(!ans.contains(nCheckedAns)) 
				ans.add(nCheckedAns);
				return;
			}
			if(findJiang){
				for(int i=0;i<CARDS.length;i++){
					Integer oldValue=checkedCards.get(CARDS[i]);
					if(oldValue!=null){
						if(oldValue.intValue()>=  2 ){
							checkedCards.put(CARDS[i], oldValue-2);
							checkedAns.add(CARDS[i]);checkedAns.add(CARDS[i]);
							checkHu(ans,checkedCards,checkedAns,false,true,laiziCount,0);
							checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
							checkedCards.put(CARDS[i], oldValue);
						}
					}
				}
				return;
			}
			if(findKe){
				for(int i=index;i<CARDS.length;i++){
					Integer oldValue=checkedCards.get(CARDS[i]);
					if(oldValue!=null){
						if(oldValue.intValue()>=3){
							checkedCards.put(CARDS[i], oldValue-3);
							checkedAns.add(CARDS[i]);checkedAns.add(CARDS[i]);checkedAns.add(CARDS[i]);
							checkHu(ans,checkedCards,checkedAns,false,true,laiziCount,i);
							checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
							checkedCards.put(CARDS[i], oldValue);
						}
						if(oldValue.intValue()==2 && laiziCount>=1){
							checkedCards.put(CARDS[i], oldValue-2);
							checkedAns.add(CARDS[i]);checkedAns.add(CARDS[i]);checkedAns.add(cardToLaizi(CARDS[i]));
							checkHu(ans,checkedCards,checkedAns,false,true,laiziCount-1,i);
							checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
							checkedCards.put(CARDS[i], oldValue);
						}
						if(oldValue.intValue()==1 && laiziCount>=2){
							checkedCards.put(CARDS[i], oldValue-1);
							checkedAns.add(CARDS[i]);checkedAns.add(cardToLaizi(CARDS[i]));checkedAns.add(cardToLaizi(CARDS[i]));
							checkHu(ans,checkedCards,checkedAns,false,true,laiziCount-2,i);
							checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
							checkedCards.put(CARDS[i], oldValue);
						}
					}
				}
			}
			for(int i=findKe?0:index;i<CARDS.length;i++){
				byte card2=CARDS[i];
				byte card1=(byte)(card2-1);
				byte card3=(byte)(card2+1);
				Integer s1=checkedCards.get(card1);
				Integer s2=checkedCards.get(card2);
				Integer s3=checkedCards.get(card3);
				boolean has1=s1!=null;
				boolean has2=s2!=null;
				boolean has3=s3!=null;
				if(card1>=Consts.CARD_1WAN && card3<Consts.CARD_DONG && (card1%10)!=0 && (card2%10)!=0 && (card3%10)!=0){
					if( has1 && s1.intValue()>0
						&& has2 && s2.intValue()>0
						&& has3 && s3.intValue()>0){
						checkedCards.put(card1, s1-1);checkedCards.put(card2, s2-1);checkedCards.put(card3, s3-1);
						checkedAns.add(card1);checkedAns.add(card2);checkedAns.add(card3);
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card1, s1);checkedCards.put(card2, s2);checkedCards.put(card3, s3);
					}else if( has2 && s2.intValue()>0
						&& has3 && s3.intValue()>0 && laiziCount>=1){
						checkedCards.put(card2, s2-1);checkedCards.put(card3, s3-1);
						checkedAns.add(cardToLaizi(card1));checkedAns.add(card2);checkedAns.add(card3);
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount-1,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card2, s2);checkedCards.put(card3, s3);
					}else if( has1 && s1.intValue()>0
						&& has3 && s3.intValue()>0 && laiziCount>=1){
						checkedCards.put(card1, s1-1);checkedCards.put(card3, s3-1);
						checkedAns.add(card1);checkedAns.add(cardToLaizi(card2));checkedAns.add(card3);
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount-1,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card1, s1);checkedCards.put(card3, s3);
					}else if( has1 && s1.intValue()>0
						&& has2 && s2.intValue()>0 && laiziCount>=1){
						checkedCards.put(card1, s1-1);checkedCards.put(card2, s2-1);
						checkedAns.add(card1);checkedAns.add(card2);checkedAns.add(cardToLaizi(card3));
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount-1,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card1, s1);checkedCards.put(card2, s2);
					}else if( has1 && s1.intValue()>0 && laiziCount>=2){
						checkedCards.put(card1, s1-1);
						checkedAns.add(card1);checkedAns.add(cardToLaizi(card2));checkedAns.add(cardToLaizi(card3));
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount-2,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card1, s1);
					}else if( has2 && s2.intValue()>0 && laiziCount>=2){
						checkedCards.put(card2, s2-1);
						checkedAns.add(cardToLaizi(card1));checkedAns.add(card2);checkedAns.add(cardToLaizi(card3));
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount-2,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card2, s2);
					}else if( has3 && s3.intValue()>0 && laiziCount>=2){
						checkedCards.put(card3, s3-1);
						checkedAns.add(cardToLaizi(card1));checkedAns.add(cardToLaizi(card2));checkedAns.add(card3);
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount-2,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card3, s3);
					}
				}
			}
		}
	
	};
	
	public static final HuStrategy HU_NORMAL_WITH_LAIZI_SPECIAL_02 = new HuStrategy(){

		@Override
		public List<List<Byte>> checkHu(List<Byte> checkedCards, int laiziCount) {
			if((checkedCards.size()+laiziCount)%3!=2){
				return Lists.emptyList();
			}
			Builder<List<Byte>> ans=ImmutableList.builder();
			Map<Byte,Integer> _checkedCards=new HashMap<>();
			for(Byte b:checkedCards){
				if(_checkedCards.containsKey(b)){
					_checkedCards.put(b, _checkedCards.get(b)+1);
				}else{
					_checkedCards.put(b, 1);
				}
			}
			checkHu(ans,_checkedCards,new ArrayList<>(),true,false,laiziCount,0);
			return ans.build();
		}
		/**
		 * 算法思路:深度优先+动态规划
		 * 癞子替换需要考虑剪枝和牌型重复问题
		 */
		private void checkHu(
				Builder<List<Byte>> ans,Map<Byte,Integer> checkedCards,List<Byte> checkedAns,
				boolean findJiang,boolean findKe,
				int laiziCount,int index){
			boolean isEmpty=true;
			for(Integer value:checkedCards.values()){
				if(value>0){
					isEmpty=false;
					break;
				}
			}
			if(isEmpty){
				List<Byte> nCheckedAns=new ArrayList<>(checkedAns);
				while(laiziCount-->0){
					nCheckedAns.add(cardToLaizi(CARD_NONE));
				}
//				if(!ans.contains(nCheckedAns)) 
				ans.add(nCheckedAns);
				return;
			}
			if(findJiang){
				for(int i=0;i<CARDS.length;i++){
					Integer oldValue=checkedCards.get(CARDS[i]);
					if(oldValue!=null){
						if(oldValue.intValue()>= 1 && laiziCount>=1){
							checkedCards.put(CARDS[i], oldValue-1);
							checkedAns.add(CARDS[i]);checkedAns.add(cardToLaizi(CARDS[i]));
							checkHu(ans,checkedCards,checkedAns,false,true,laiziCount-1,0);
							checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
							checkedCards.put(CARDS[i], oldValue);
						}
					}
				}
				return;
			}
			if(findKe){
				for(int i=index;i<CARDS.length;i++){
					Integer oldValue=checkedCards.get(CARDS[i]);
					if(oldValue!=null){
						if(oldValue.intValue()>=3){
							checkedCards.put(CARDS[i], oldValue-3);
							checkedAns.add(CARDS[i]);checkedAns.add(CARDS[i]);checkedAns.add(CARDS[i]);
							checkHu(ans,checkedCards,checkedAns,false,true,laiziCount,i);
							checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
							checkedCards.put(CARDS[i], oldValue);
						}
						if(oldValue.intValue()==2 && laiziCount>=1){
							checkedCards.put(CARDS[i], oldValue-2);
							checkedAns.add(CARDS[i]);checkedAns.add(CARDS[i]);checkedAns.add(cardToLaizi(CARDS[i]));
							checkHu(ans,checkedCards,checkedAns,false,true,laiziCount-1,i);
							checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
							checkedCards.put(CARDS[i], oldValue);
						}
						if(oldValue.intValue()==1 && laiziCount>=2){
							checkedCards.put(CARDS[i], oldValue-1);
							checkedAns.add(CARDS[i]);checkedAns.add(cardToLaizi(CARDS[i]));checkedAns.add(cardToLaizi(CARDS[i]));
							checkHu(ans,checkedCards,checkedAns,false,true,laiziCount-2,i);
							checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
							checkedCards.put(CARDS[i], oldValue);
						}
					}
				}
			}
			for(int i=findKe?0:index;i<CARDS.length;i++){
				byte card2=CARDS[i];
				byte card1=(byte)(card2-1);
				byte card3=(byte)(card2+1);
				Integer s1=checkedCards.get(card1);
				Integer s2=checkedCards.get(card2);
				Integer s3=checkedCards.get(card3);
				boolean has1=s1!=null;
				boolean has2=s2!=null;
				boolean has3=s3!=null;
				if(card1>=Consts.CARD_1WAN && card3<Consts.CARD_DONG && (card1%10)!=0 && (card2%10)!=0 && (card3%10)!=0){
					if( has1 && s1.intValue()>0
						&& has2 && s2.intValue()>0
						&& has3 && s3.intValue()>0){
						checkedCards.put(card1, s1-1);checkedCards.put(card2, s2-1);checkedCards.put(card3, s3-1);
						checkedAns.add(card1);checkedAns.add(card2);checkedAns.add(card3);
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card1, s1);checkedCards.put(card2, s2);checkedCards.put(card3, s3);
					}else if( has2 && s2.intValue()>0
						&& has3 && s3.intValue()>0 && laiziCount>=1){
						checkedCards.put(card2, s2-1);checkedCards.put(card3, s3-1);
						checkedAns.add(cardToLaizi(card1));checkedAns.add(card2);checkedAns.add(card3);
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount-1,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card2, s2);checkedCards.put(card3, s3);
					}else if( has1 && s1.intValue()>0
						&& has3 && s3.intValue()>0 && laiziCount>=1){
						checkedCards.put(card1, s1-1);checkedCards.put(card3, s3-1);
						checkedAns.add(card1);checkedAns.add(cardToLaizi(card2));checkedAns.add(card3);
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount-1,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card1, s1);checkedCards.put(card3, s3);
					}else if( has1 && s1.intValue()>0
						&& has2 && s2.intValue()>0 && laiziCount>=1){
						checkedCards.put(card1, s1-1);checkedCards.put(card2, s2-1);
						checkedAns.add(card1);checkedAns.add(card2);checkedAns.add(cardToLaizi(card3));
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount-1,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card1, s1);checkedCards.put(card2, s2);
					}else if( has1 && s1.intValue()>0 && laiziCount>=2){
						checkedCards.put(card1, s1-1);
						checkedAns.add(card1);checkedAns.add(cardToLaizi(card2));checkedAns.add(cardToLaizi(card3));
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount-2,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card1, s1);
					}else if( has2 && s2.intValue()>0 && laiziCount>=2){
						checkedCards.put(card2, s2-1);
						checkedAns.add(cardToLaizi(card1));checkedAns.add(card2);checkedAns.add(cardToLaizi(card3));
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount-2,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card2, s2);
					}else if( has3 && s3.intValue()>0 && laiziCount>=2){
						checkedCards.put(card3, s3-1);
						checkedAns.add(cardToLaizi(card1));checkedAns.add(cardToLaizi(card2));checkedAns.add(card3);
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount-2,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card3, s3);
					}
				}
			}
		}
	
	};
	
	public static final HuStrategy HU_NORMAL_WITH_LAIZI_SPECIAL_03 = new HuStrategy(){

		@Override
		public List<List<Byte>> checkHu(List<Byte> checkedCards, int laiziCount) {
			if((checkedCards.size()+laiziCount)%3!=2){
				return Lists.emptyList();
			}
			Builder<List<Byte>> ans=ImmutableList.builder();
			Map<Byte,Integer> _checkedCards=new HashMap<>();
			for(Byte b:checkedCards){
				if(_checkedCards.containsKey(b)){
					_checkedCards.put(b, _checkedCards.get(b)+1);
				}else{
					_checkedCards.put(b, 1);
				}
			}
			checkHu(ans,_checkedCards,new ArrayList<>(),true,false,laiziCount,0);
			return ans.build();
		}
		/**
		 * 算法思路:深度优先+动态规划
		 * 癞子替换需要考虑剪枝和牌型重复问题
		 */
		private void checkHu(
				Builder<List<Byte>> ans,Map<Byte,Integer> checkedCards,List<Byte> checkedAns,
				boolean findJiang,boolean findKe,
				int laiziCount,int index){
			boolean isEmpty=true;
			for(Integer value:checkedCards.values()){
				if(value>0){
					isEmpty=false;
					break;
				}
			}
			if(isEmpty){
				List<Byte> nCheckedAns=new ArrayList<>(checkedAns);
				while(laiziCount-->0){
					nCheckedAns.add(cardToLaizi(CARD_NONE));
				}
//				if(!ans.contains(nCheckedAns)) 
				ans.add(nCheckedAns);
				return;
			}
			if(findJiang){
				for(int i=0;i<CARDS.length;i++){
					Integer oldValue=checkedCards.get(CARDS[i]);
					if (oldValue== null) {
						if (laiziCount >= 2) {
							checkedAns.add(cardToLaizi(CARD_NONE));checkedAns.add(cardToLaizi(CARD_NONE));
							checkHu(ans,checkedCards,checkedAns,false,true,laiziCount-2,0);
							checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						}
					}
				}
				return;
			}
			if(findKe){
				for(int i=index;i<CARDS.length;i++){
					Integer oldValue=checkedCards.get(CARDS[i]);
					if(oldValue!=null){
						if(oldValue.intValue()>=3){
							checkedCards.put(CARDS[i], oldValue-3);
							checkedAns.add(CARDS[i]);checkedAns.add(CARDS[i]);checkedAns.add(CARDS[i]);
							checkHu(ans,checkedCards,checkedAns,false,true,laiziCount,i);
							checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
							checkedCards.put(CARDS[i], oldValue);
						}
						if(oldValue.intValue()==2 && laiziCount>=1){
							checkedCards.put(CARDS[i], oldValue-2);
							checkedAns.add(CARDS[i]);checkedAns.add(CARDS[i]);checkedAns.add(cardToLaizi(CARDS[i]));
							checkHu(ans,checkedCards,checkedAns,false,true,laiziCount-1,i);
							checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
							checkedCards.put(CARDS[i], oldValue);
						}
						if(oldValue.intValue()==1 && laiziCount>=2){
							checkedCards.put(CARDS[i], oldValue-1);
							checkedAns.add(CARDS[i]);checkedAns.add(cardToLaizi(CARDS[i]));checkedAns.add(cardToLaizi(CARDS[i]));
							checkHu(ans,checkedCards,checkedAns,false,true,laiziCount-2,i);
							checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
							checkedCards.put(CARDS[i], oldValue);
						}
					}
				}
			}
			for(int i=findKe?0:index;i<CARDS.length;i++){
				byte card2=CARDS[i];
				byte card1=(byte)(card2-1);
				byte card3=(byte)(card2+1);
				Integer s1=checkedCards.get(card1);
				Integer s2=checkedCards.get(card2);
				Integer s3=checkedCards.get(card3);
				boolean has1=s1!=null;
				boolean has2=s2!=null;
				boolean has3=s3!=null;
				if(card1>=Consts.CARD_1WAN && card3<Consts.CARD_DONG && (card1%10)!=0 && (card2%10)!=0 && (card3%10)!=0){
					if( has1 && s1.intValue()>0
						&& has2 && s2.intValue()>0
						&& has3 && s3.intValue()>0){
						checkedCards.put(card1, s1-1);checkedCards.put(card2, s2-1);checkedCards.put(card3, s3-1);
						checkedAns.add(card1);checkedAns.add(card2);checkedAns.add(card3);
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card1, s1);checkedCards.put(card2, s2);checkedCards.put(card3, s3);
					}else if( has2 && s2.intValue()>0
						&& has3 && s3.intValue()>0 && laiziCount>=1){
						checkedCards.put(card2, s2-1);checkedCards.put(card3, s3-1);
						checkedAns.add(cardToLaizi(card1));checkedAns.add(card2);checkedAns.add(card3);
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount-1,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card2, s2);checkedCards.put(card3, s3);
					}else if( has1 && s1.intValue()>0
						&& has3 && s3.intValue()>0 && laiziCount>=1){
						checkedCards.put(card1, s1-1);checkedCards.put(card3, s3-1);
						checkedAns.add(card1);checkedAns.add(cardToLaizi(card2));checkedAns.add(card3);
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount-1,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card1, s1);checkedCards.put(card3, s3);
					}else if( has1 && s1.intValue()>0
						&& has2 && s2.intValue()>0 && laiziCount>=1){
						checkedCards.put(card1, s1-1);checkedCards.put(card2, s2-1);
						checkedAns.add(card1);checkedAns.add(card2);checkedAns.add(cardToLaizi(card3));
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount-1,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card1, s1);checkedCards.put(card2, s2);
					}else if( has1 && s1.intValue()>0 && laiziCount>=2){
						checkedCards.put(card1, s1-1);
						checkedAns.add(card1);checkedAns.add(cardToLaizi(card2));checkedAns.add(cardToLaizi(card3));
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount-2,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card1, s1);
					}else if( has2 && s2.intValue()>0 && laiziCount>=2){
						checkedCards.put(card2, s2-1);
						checkedAns.add(cardToLaizi(card1));checkedAns.add(card2);checkedAns.add(cardToLaizi(card3));
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount-2,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card2, s2);
					}else if( has3 && s3.intValue()>0 && laiziCount>=2){
						checkedCards.put(card3, s3-1);
						checkedAns.add(cardToLaizi(card1));checkedAns.add(cardToLaizi(card2));checkedAns.add(card3);
						checkHu(ans,checkedCards,checkedAns,false,false,laiziCount-2,i);
						checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);checkedAns.remove(checkedAns.size()-1);
						checkedCards.put(card3, s3);
					}
				}
			}
		}
	
	};

	private static List<TingInfo> checkTingWithoutLaizies(List<Byte> checkedCards,List<Byte> laizies,HuStrategy...huStrategies){
		com.google.common.collect.ImmutableList.Builder<TingInfo> builder=ImmutableList.builder();
		//剃掉癞子
		List<Byte> nCheckedCards=new LinkedList<>(checkedCards);
		Iterator<Byte> it=nCheckedCards.iterator();
		int laiziCount=0;
		while(it.hasNext()){
			if(laizies.contains(it.next())){
				it.remove();
				laiziCount++;
			}
		}
		List<TingInfo> tingInfos=new ArrayList<>();
		for(int i=0;i<nCheckedCards.size();i++){
			TingInfo tingInfo=new TingInfo();
			Byte ori=nCheckedCards.remove(i);//换成癞子
			tingInfo.setPlayForTingCard(ori);
			if(tingInfos.contains(tingInfo)){
				nCheckedCards.add(i, ori);
				continue;
			}
			for(HuStrategy huStrategy:huStrategies){
				List<List<Byte>> result=huStrategy.checkHu(nCheckedCards,laiziCount+1);
				if(!result.isEmpty()){
					for(List<Byte> r:result){
						for(Byte c:r){
							if(Hu.isLaizi(c)){
								byte realCard=Hu.laiziToCard(c);
								if(!tingInfo.getTingCards().contains(realCard)){
									tingInfo.getTingCards().add(realCard);
								}
							}
						}
					}
				}
			}
			nCheckedCards.add(i, ori);
			if(!tingInfo.getTingCards().isEmpty()){
				Collections.sort(tingInfo.getTingCards());
				tingInfos.add(tingInfo);
			}
		}
		builder.addAll(tingInfos);
		return builder.build();
	}
	
	private static List<TingInfo> checkTingWithLaizies(List<Byte> checkedCards,List<Byte> laizies,HuStrategy...huStrategies){
		com.google.common.collect.ImmutableList.Builder<TingInfo> builder=ImmutableList.builder();
		List<TingInfo> tingInfoList= new ArrayList<>();
		byte laizi= laizies.get(0);
		if (checkedCards.contains(laizi)) {
			TingInfo tingInfo= new TingInfo();
			tingInfo.setPlayForTingCard(laizi);
			Map<HuStrategy, List<List<Byte>>> resultMap= Hu.checkHu(checkedCards, laizies, huStrategies);
			Collection<List<List<Byte>>> resultList= resultMap.values();
			if (resultList!= null) {
				resultList.stream().forEach(tempResult->{
					tempResult.stream().forEach(tempR->{
						tempR.stream().forEach(c->{
							if (Hu.isLaizi(c)) {
								byte realCard= Hu.laiziToCard(c);
								if (!tingInfo.getTingCards().contains(realCard)) {
									tingInfo.getTingCards().add(realCard);
								}
							}
						});
					});
				});
			}
			if (!tingInfo.getTingCards().isEmpty()) {
				Collections.sort(tingInfo.getTingCards());
				tingInfoList.add(tingInfo);
			}
		}
		builder.addAll(tingInfoList);
		return builder.build();
	}
	
	
	public static List<TingInfo> checkTing(List<Byte> checkedCards,List<Byte> laizies,HuStrategy...huStrategies){
		List<TingInfo> tingInfoList01= checkTingWithoutLaizies(checkedCards, laizies, huStrategies);
		List<TingInfo> tingInfoList02= checkTingWithLaizies(checkedCards, laizies, huStrategies);
		List<TingInfo> tingInfoList= new ArrayList<>();
		tingInfoList.addAll(tingInfoList01);
		tingInfoList.addAll(tingInfoList02);
		return tingInfoList;
	}
}
