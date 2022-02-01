package com.pumaray.lib.swing.dialog.tools;

public class Range {
	
	private int begin;
	private int end;
	
	public Range(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	public int[] getNumbers() {
		int[] numbers = new int[end-begin];
		for(int i = begin; i<end+1; i++) {
			numbers[i-begin] = i;
		}
		return numbers;
	}

}
