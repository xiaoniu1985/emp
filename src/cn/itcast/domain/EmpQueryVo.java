package cn.itcast.domain;

import java.math.BigDecimal;
import java.util.Date;

public class EmpQueryVo {
	private Integer[] ids;
	private String name;
	private int sex = -1;
	private String Ssex;
	private Date hirdatepre;
	private Date hirdatenext;
	private String SHsalary;
	private String SLsalary;
	private BigDecimal Hsalary;
	private BigDecimal Lsalary;
	private int deptno;
	private String workcode;
	private int ps;// s分页查询中，查多少记录数
	private int pbegin;// 从哪条记录开始查。

	public String getSsex() {
		return Ssex;
	}

	public void setSsex(String ssex) {
		Ssex = ssex;
	}

	public String getSHsalary() {
		return SHsalary;
	}

	public void setSHsalary(String sHsalary) {
		SHsalary = sHsalary;
	}

	public String getSLsalary() {
		return SLsalary;
	}

	public void setSLsalary(String sLsalary) {
		SLsalary = sLsalary;
	}

	public BigDecimal getHsalary() {
		return Hsalary;
	}

	public void setHsalary(BigDecimal hsalary) {
		Hsalary = hsalary;
	}

	public BigDecimal getLsalary() {
		return Lsalary;
	}

	public void setLsalary(BigDecimal lsalary) {
		Lsalary = lsalary;
	}

	public String getWorkcode() {
		return workcode;
	}

	public void setWorkcode(String workcode) {
		this.workcode = workcode;
	}

	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public Date getHirdatepre() {
		return hirdatepre;
	}

	public void setHirdatepre(Date hirdatepre) {
		this.hirdatepre = hirdatepre;
	}

	public Date getHirdatenext() {
		return hirdatenext;
	}

	public void setHirdatenext(Date hirdatenext) {
		this.hirdatenext = hirdatenext;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public int getPs() {
		return ps;
	}

	public void setPs(int ps) {
		this.ps = ps;
	}

	public int getPbegin() {
		return pbegin;
	}

	public void setPbegin(int pbegin) {
		this.pbegin = pbegin;
	}
}
