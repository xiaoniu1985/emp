package cn.itcast.service;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.EmpDao;
import cn.itcast.domain.EmpQueryVo;
import cn.itcast.domain.Employee;
import cn.itcast.domain.Page;

@Service
@Transactional
public class EmpService {
	@Autowired
	private EmpDao empDao;

	public void addEmp(Employee emp) {
		empDao.insertEmp(emp);
	}

	public void deleteEmp(Integer[] ids)

	{
		EmpQueryVo eo = new EmpQueryVo();
		eo.setIds(ids);
		empDao.deleteEmp(eo);
	}

	public void updateEmp(Employee emp) {
		empDao.updateEmp(emp);
	}

	public Employee findEmpById(int id) throws Exception {
		return empDao.findEmpById(id);
	}

	// 多条件分页查询
	public Page<Employee> findEmpByEmpQueryVo(EmpQueryVo empQueryVo, HttpServletRequest request) throws Exception {
		int pc = getpc(request);
		int ps = 5;
		EmpQueryVo eo = empQueryVo;
		if (eo.getName() != null) {
			String name = eo.getName();

			String name1 = new String(name.getBytes("iso-8859-1"), "utf-8");

			eo.setName(name1);
		}
		eo.setPs(ps);
		eo.setPbegin((pc - 1) * ps);
		Page<Employee> pe = new Page<Employee>();
		List<Employee> list = empDao.findEmpsByEmpQueryVo(eo);
		int count = empDao.countEmpsByEmpQueryVo(eo);
		pe.setBeanList(list);
		pe.setTr(count);
		pe.setPc(pc);
		pe.setPs(ps);

		this.getBeginAndEnd(pe);
		this.getUrl(pe, request);
		return pe;
	}

	private int getpc(HttpServletRequest request) {
		String pc = request.getParameter("pc");
		if (pc != null)
			return Integer.parseInt(pc);
		else
			return 1;
	}

	public void getUrl(Page<Employee> pe, HttpServletRequest request) throws Exception {
		Enumeration<String> e = request.getParameterNames();
		String url = "";
		while (e.hasMoreElements()) {
			String key = e.nextElement();
			String value = request.getParameter(key);

			if (!key.equals("pc") && value != null && value != "")
				if (key.equals("name")) {
					value = new String(value.getBytes("iso-8859-1"), "utf-8");
				}

			url += "&" + key + "=" + value;
		}

		pe.setUrl(url);

	}

	private void getBeginAndEnd(Page<Employee> pe) {
		int begin = 0;
		int end = 0;
		int pc = pe.getPc();
		int tp = pe.getTp();

		if (tp <= 7)// 暂定每页显示7个页码。
		{
			begin = 1;
			end = tp;
		}

		else {
			begin = pc - 3;
			end = pc + 3;
			if (begin <= 0) {
				begin = 1;
				end = 7;
			}

			if (end > tp) {
				end = tp;
				begin = tp - 6;
			}

		}
		pe.setBegin(begin);
		pe.setEnd(end);
	}

}
