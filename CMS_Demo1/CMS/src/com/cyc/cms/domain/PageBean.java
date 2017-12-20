package com.cyc.cms.domain;

import java.util.List;

public class PageBean<T> {

	private int pc; // 当前页码 page code
	
	private int tr; // 总记录数 total record
	private int ps; // 每页的记录数量 page size
	private List<T> beanList; // 当前页的记录数

	/**
	 * @return the pc
	 */
	public int getPc() {
		return pc;
	}

	/**
	 * @param pc
	 * the pc to set
	 */
	public void setPc(int pc) {
		this.pc = pc;
	}

	/**
	 * 计算总页数
	 * @return the tp
	 */
	public int getTp() {
		//通过总记录数除每页记录数来计算总页数
		int tp = (tr % ps == 0 ? (tr / ps) : ((int)(tr / ps) + 1));
		return tp;
	}

	/**
	 * @return the tr
	 */
	public int getTr() {
		return tr;
	}

	/**
	 * @param tr
	 * the tr to set
	 */
	public void setTr(int tr) {
		this.tr = tr;
	}

	/**
	 * @return the ps
	 */
	public int getPs() {
		return ps;
	}

	/**
	 * @param ps
	 * the ps to set
	 */
	public void setPs(int ps) {
		this.ps = ps;
	}

	/**
	 * @return the beanList
	 */
	public List<T> getBeanList() {
		return beanList;
	}

	/**
	 * @param beanList
	 * the beanList to set
	 */
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}

}
