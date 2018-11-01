package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.lotto.Lotto;

public class LottoTest {

	private Logger logger = LoggerFactory.getLogger(IocMain.class);

	@Test
	public void lottoTest() throws Exception {
		
		/***Given***/
		Lotto lotto = new Lotto();

		/***When***/
		int raffleNum = 55;
		lotto.setMaxNum(55);
		lotto.setRaffleNum(raffleNum);
		
		int[] result = lotto.execute();
		
		/***Then***/
		logger.debug(Arrays.toString(result));
		
		assertEquals(raffleNum, result.length);
		
	}

}
