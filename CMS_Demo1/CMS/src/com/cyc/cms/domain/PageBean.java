package com.cyc.cms.domain;

import java.util.List;

public class PageBean<T> {

	private int pc; // ��ǰҳ�� page code
	
	private int tr; // �ܼ�¼�� total record
	private int ps; // ÿҳ�ļ�¼���� page size
	private List<T> beanList; // ��ǰҳ�ļ�¼��

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
	 * ������ҳ��
	 * @return the tp
	 */
	public int getTp() {
		//ͨ���ܼ�¼����ÿҳ��¼����������ҳ��
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
