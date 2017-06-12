package cn.itcast.domain;

import java.math.BigDecimal;
import java.util.Date;

/*CREATE TABLE  emp (
id INT PRIMARY KEY AUTO_INCREMENT,
`workcode` VARCHAR(10),
`name` VARCHAR(5),
sex  SMALLINT,
hirdate DATE,
salary DECIMAL(5,1),
deptno INT
)*/

public class Employee {
	private int id;
	private String workcode;
	private String name;
	private int sex;
	private Date hirdate;
	private BigDecimal salary;
	private int deptno;

	public Employee() {

	}

	public Employee(int id, String workcode, String name, int sex, Date hirdate, BigDecimal salary, int deptno) {
		super();
		this.id = id;
		this.workcode = workcode;
		this.name = name;
		this.sex = sex;
		this.hirdate = hirdate;
		this.salary = salary;
		this.deptno = deptno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getHirdate() {
		return hirdate;
	}

	public void setHirdate(Date hiredate) {
		this.hirdate = hiredate;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getWorkcode() {
		return workcode;
	}

	public void setWorkcode(String workcode) {
		this.workcode = workcode;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", workcode=" + workcode + ", name=" + name + ", sex=" + sex + ", hirdate="
				+ hirdate + ", salary=" + salary + ", deptno=" + deptno + "]"+"cccdddds ";
	}

}
