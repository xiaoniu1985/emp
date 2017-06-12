package cn.itcast.domain;

import java.util.List;

/*分页类*/
public class Page<T> {
	private int tp; // 总的页数totalpage，由tr/ps 得到
	private int pc; // 当前页码 pagecode
	private int tr; // 总记录数 totalrecode
	private int ps; // 每页记录数 pagesize 自己定的，比如ps=10
	private int begin;// 分页的开始页码
	private int end;// 分页的结束页码
	private List<T> beanList;// 每页记录的对象列表
    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	private String url;// 存放参数列表的键值对sfdfsdfsdgshsfg

	public int getTp() {
		if (tr % ps == 0)
			return tr / ps;
		else
			return tr / ps + 1;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public int getTr() {
		return tr;
	}

	public void setTr(int tr) {
		this.tr = tr;
	}

	public int getPs() {
		return ps;
	}

	public void setPs(int ps) {
		this.ps = ps;
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

	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}

}
