package com.dszy.game.gamelogic.majong.shanwei;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import com.dszy.game.annotation.Proto;
import com.dszy.game.message.BaseMsg;
import com.dszy.game.message.proto.game.MMajongPressCardMsg;
import com.dszy.game.utils.GsonUtil;

@Proto(type = 3, code = 31003, clazz = "", desc = " 麻将出牌 Server->Client")
public class ShanWeiMMajongPressCardMsg extends MMajongPressCardMsg {
	
	
//	private String plID = "";
//	private long pl;
//	private byte plC;
//	private long neP;
//	private byte Do;
	private byte[] yangMC;
//	private byte[] flC;
//	private byte[] ac0;
//	private byte[] adGC;
//	private byte[] anGC;
//	private byte[] tiC;
//	private int reC;
//	private int re;
//	private int toF;
//	private byte acC1;
//	private int fl;
//	private List<MjAction> ch = new ArrayList();
//	private byte neD;
//	private long cl;
//	private long se;
//	private boolean adF;
//	private boolean ch2;
//	private List<Byte> plFTC;
//	private List<List<Byte>> tiHC;
//	private List<List<Byte>> chC;

//	public String getPlayID() {
//		return this.plID;
//	}
//	
//	public MMajongPressCardMsg setPlayID(String playID) {
//		this.plID = playID;
//		return this;
//	}
//	
//	public long getPlayedby() {
//		return this.pl;
//	}
//
//	public MMajongPressCardMsg setPlayedby(long playedby) {
//		this.pl = playedby;
//		return this;
//	}
//
//	public byte getPlayCard() {
//		return this.plC;
//	}
//
//	public MMajongPressCardMsg setPlayCard(byte playCard) {
//		this.plC = playCard;
//		return this;
//	}
//
//	public long getNextPlayer() {
//		return this.neP;
//	}
//
//	public MMajongPressCardMsg setNextPlayer(long nextPlayer) {
//		this.neP = nextPlayer;
//		return this;
//	}
//
//	public byte getDoorcard() {
//		return this.Do;
//	}
//
//	public MMajongPressCardMsg setDoorcard(byte Doorcard) {
//		this.Do = Doorcard;
//		return this;
//	}
//
//	public byte[] getFlowerCards() {
//		return this.flC;
//	}
//
//	public MMajongPressCardMsg setFlowerCards(byte[] flowerCards) {
//		this.flC = flowerCards;
//		return this;
//	}
	
	public byte[] getYangMaCards() {
		return this.yangMC;
	}
	
	public MMajongPressCardMsg setYangMaCards(byte[] yangMC) {
		this.yangMC = yangMC;
		return this;
	}
	
//	public byte[] getActions() {
//		return this.ac0;
//	}
//
//	public MMajongPressCardMsg setActions(byte[] actions) {
//		this.ac0 = actions;
//		return this;
//	}
//
//	public byte[] getAddGangCards() {
//		return this.adGC;
//	}
//
//	public MMajongPressCardMsg setAddGangCards(byte[] addGangCards) {
//		this.adGC = addGangCards;
//		return this;
//	}
//
//	public byte[] getAnGangCards() {
//		return this.anGC;
//	}
//
//	public MMajongPressCardMsg setAnGangCards(byte[] anGangCards) {
//		this.anGC = anGangCards;
//		return this;
//	}
//
//	public byte[] getTingCards() {
//		return this.tiC;
//	}
//
//	public MMajongPressCardMsg setTingCards(byte[] tingCards) {
//		this.tiC = tingCards;
//		return this;
//	}
//
//	public int getRemainCount() {
//		return this.reC;
//	}
//
//	public MMajongPressCardMsg setRemainCount(int remainCount) {
//		this.reC = remainCount;
//		return this;
//	}
//
//	public int getRepeat() {
//		return this.re;
//	}
//
//	public MMajongPressCardMsg setRepeat(int repeat) {
//		this.re = repeat;
//		return this;
//	}
//
//	public int getTotalFan() {
//		return this.toF;
//	}
//
//	public MMajongPressCardMsg setTotalFan(int totalFan) {
//		this.toF = totalFan;
//		return this;
//	}
//
//	public byte getActionCard() {
//		return this.acC1;
//	}
//
//	public MMajongPressCardMsg setActionCard(byte actionCard) {
//		this.acC1 = actionCard;
//		return this;
//	}
//
//	public int getFlag() {
//		return this.fl;
//	}
//
//	public MMajongPressCardMsg setFlag(int flag) {
//		this.fl = flag;
//		return this;
//	}
//
//	public List<MjAction> getChance() {
//		return this.ch;
//	}
//
//	public MMajongPressCardMsg setChance(List<MjAction> chance) {
//		this.ch = chance;
//		return this;
//	}
//
//	public void addChance(MjAction param) {
//		this.ch.add(param);
//	}
//
//	public byte getNextDoorcard() {
//		return this.neD;
//	}
//
//	public MMajongPressCardMsg setNextDoorcard(byte nextDoorcard) {
//		this.neD = nextDoorcard;
//		return this;
//	}
//
//	public long getClienttime() {
//		return this.cl;
//	}
//
//	public MMajongPressCardMsg setClienttime(long clienttime) {
//		this.cl = clienttime;
//		return this;
//	}
//
//	public long getServertime() {
//		return this.se;
//	}
//
//	public MMajongPressCardMsg setServertime(long servertime) {
//		this.se = servertime;
//		return this;
//	}
//
//	public boolean getAddFlower() {
//		return this.adF;
//	}
//
//	public MMajongPressCardMsg setAddFlower(boolean addFlower) {
//		this.adF = addFlower;
//		return this;
//	}
//
//	public boolean getChecked() {
//		return this.ch2;
//	}
//
//	public MMajongPressCardMsg setChecked(boolean checked) {
//		this.ch2 = checked;
//		return this;
//	}
//
//	public List<Byte> getPlayForTingCards() {
//		return this.plFTC;
//	}
//
//	public MMajongPressCardMsg setPlayForTingCards(List<Byte> playForTingCards) {
//		this.plFTC = playForTingCards;
//		return this;
//	}
//
//	public List<List<Byte>> getTingHuCards() {
//		return this.tiHC;
//	}
//
//	public MMajongPressCardMsg setTingHuCards(List<List<Byte>> tingHuCards) {
//		this.tiHC = tingHuCards;
//		return this;
//	}
//
//	public List<List<Byte>> getChiCards() {
//		return this.chC;
//	}
//
//	public MMajongPressCardMsg setChiCards(List<List<Byte>> chiCards) {
//		this.chC = chiCards;
//		return this;
//	}
	
	public static MMajongPressCardMsg parseFromBytes(byte[] data) {
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
		MMajongPressCardMsg ins = new MMajongPressCardMsg();

		try {
//			ins.setPlayID(dis.readUTF());
//			ins.setPlayedby(dis.readLong());
//			ins.setPlayCard(dis.readByte());
//			ins.setNextPlayer(dis.readLong());
//			ins.setDoorcard(dis.readByte());
//			short e = dis.readShort();
//			byte[] bytes_flowerCards = new byte[e];
//			dis.read(bytes_flowerCards, 0, e);
//			ins.setFlowerCards(bytes_flowerCards);
//			short length_actions = dis.readShort();
//			byte[] bytes_actions = new byte[length_actions];
//			dis.read(bytes_actions, 0, length_actions);
//			ins.setActions(bytes_actions);
			short length_yangMaCards = dis.readShort();
			byte[] bytes_yangMaCards = new byte[length_yangMaCards];
			dis.read(bytes_yangMaCards, 0, length_yangMaCards);
			ins.setAddGangCards(bytes_yangMaCards);
//			short length_addGangCards = dis.readShort();
//			byte[] bytes_addGangCards = new byte[length_addGangCards];
//			dis.read(bytes_addGangCards, 0, length_addGangCards);
//			ins.setAddGangCards(bytes_addGangCards);
//			short length_anGangCards = dis.readShort();
//			byte[] bytes_anGangCards = new byte[length_anGangCards];
//			dis.read(bytes_anGangCards, 0, length_anGangCards);
//			ins.setAnGangCards(bytes_anGangCards);
//			short length_tingCards = dis.readShort();
//			byte[] bytes_tingCards = new byte[length_tingCards];
//			dis.read(bytes_tingCards, 0, length_tingCards);
//			ins.setTingCards(bytes_tingCards);
//			ins.setRemainCount(dis.readInt());
//			ins.setRepeat(dis.readInt());
//			ins.setTotalFan(dis.readInt());
//			ins.setActionCard(dis.readByte());
//			ins.setFlag(dis.readInt());
//			short length_chance = dis.readShort();
//			ArrayList list_chance = new ArrayList();
//
//			for (int i = 0; i < length_chance; ++i) {
//				list_chance.add(new MjAction(dis));
//			}
//
//			ins.setChance(list_chance);
//			ins.setNextDoorcard(dis.readByte());
//			ins.setClienttime(dis.readLong());
//			ins.setServertime(dis.readLong());
//			ins.setAddFlower(dis.readBoolean());
//			ins.setChecked(dis.readBoolean());
		} catch (IOException arg15) {
			arg15.printStackTrace();
		}

		return ins;
	}
	
	@Override
	public byte[] toByteArray() {
		byte[] _data = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);

		try {
//			dos.writeUTF(this.plID);
//			dos.writeLong(this.pl);
//			dos.writeByte(this.plC);
//			dos.writeLong(this.neP);
//			dos.writeByte(this.Do);
			int e;
			
			if (this.yangMC == null) {
				dos.writeShort(0);
			} else {
				e = this.yangMC.length;
				dos.writeShort(e);
				dos.write(this.yangMC);
			}
			
//			if (this.flC == null) {
//				dos.writeShort(0);
//			} else {
//				e = this.flC.length;
//				dos.writeShort(e);
//				dos.write(this.flC);
//			}
//
//			if (this.ac0 == null) {
//				dos.writeShort(0);
//			} else {
//				e = this.ac0.length;
//				dos.writeShort(e);
//				dos.write(this.ac0);
//			}
//
//			if (this.adGC == null) {
//				dos.writeShort(0);
//			} else {
//				e = this.adGC.length;
//				dos.writeShort(e);
//				dos.write(this.adGC);
//			}
//
//			if (this.anGC == null) {
//				dos.writeShort(0);
//			} else {
//				e = this.anGC.length;
//				dos.writeShort(e);
//				dos.write(this.anGC);
//			}
//
//			if (this.tiC == null) {
//				dos.writeShort(0);
//			} else {
//				e = this.tiC.length;
//				dos.writeShort(e);
//				dos.write(this.tiC);
//			}
//
//			dos.writeInt(this.reC);
//			dos.writeInt(this.re);
//			dos.writeInt(this.toF);
//			dos.writeByte(this.acC1);
//			dos.writeInt(this.fl);
//			e = this.ch.size();
//			dos.writeShort(e);

//			for (int i = 0; i < e; ++i) {
//				dos.write(((MjAction) this.ch.get(i)).toByteArray());
//			}
//
//			dos.writeByte(this.neD);
//			dos.writeLong(this.cl);
//			dos.writeLong(this.se);
//			dos.writeBoolean(this.adF);
//			dos.writeBoolean(this.ch2);
			dos.flush();
			_data = baos.toByteArray();
			dos.close();
		} catch (IOException arg5) {
			arg5.printStackTrace();
		}

		return _data;
	}
	
	public String toString() {
		return GsonUtil.toJson(this);
	}

	public int getCode() {
		return 3;
	}

	public int getSubCode() {
		return 31003;
	}

	public String toJsonString() {
		return GsonUtil.toJson(this);
	}

	public static BaseMsg parseFromJson(String str) {
		return (BaseMsg) GsonUtil.fromJson(str, MMajongPressCardMsg.class);
	}
}
