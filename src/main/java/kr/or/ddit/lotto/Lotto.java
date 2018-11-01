package kr.or.ddit.lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Lotto {
	
	private int maxNum;
	private int ballNum;
	
	public int[] execute() throws Exception {
		
		if(maxNum < 0 || ballNum < 0 || ballNum > maxNum) {
			throw new Exception("올바르지 않은 입력");
		}
		
		Set<Integer> winSet = new HashSet<Integer>();
		
		while(winSet.size() < ballNum) {
			
			int ranNum = (int) ((Math.random() * maxNum) + 1); 
			winSet.add(ranNum);
			
		}
		
		Integer[] winNums = new Integer[ballNum];
		winSet.toArray(winNums);
		
		int[] winNumsInt = new int[ballNum];
		for(int i = 0; i < winNumsInt.length ; i++) {
			winNumsInt[i] = winNums[i];
		}
		
		Arrays.sort(winNumsInt);
		
		return winNumsInt; 
	}
	
	
	
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	public int getRaffleNum() {
		return ballNum;
	}
	public void setRaffleNum(int raffleNum) {
		this.ballNum = raffleNum;
	}
	
	
	
	
	
	
}
