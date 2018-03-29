package com.dszy.game.gamelogic.majong.shanwei;

import com.dszy.game.message.proto.game.MMajongResumeMsg;

public class ShanWeiMMajongResumeMsg extends MMajongResumeMsg {
	private byte[] yangMC;

	public byte[] getYangMC() {
		return yangMC;
	}

	public void setYangMC(byte[] yangMC) {
		this.yangMC = yangMC;
	}
	
}
