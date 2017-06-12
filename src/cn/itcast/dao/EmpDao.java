package cn.itcast.dao;

import java.util.List;
import cn.itcast.domain.EmpQueryVo;
import cn.itcast.domain.Employee;

public interface EmpDao {
	public Employee findEmpById(int id) throws Exception;
 
	public List<Employee> findEmpsByEmpQueryVo(EmpQueryVo empQueryVo);

	public void insertEmp(Employee emp);

	public void deleteEmp(EmpQueryVo empQueryVo);

	public void updateEmp(Employee emp);
	
	public int countEmpsByEmpQueryVo(EmpQueryVo empQueryVo);
}
