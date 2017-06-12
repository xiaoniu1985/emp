package cn.itcast.web;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.domain.EmpQueryVo;
import cn.itcast.domain.Employee;
import cn.itcast.domain.Info;
import cn.itcast.domain.Page;
import cn.itcast.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;

	@RequestMapping("/addemp")
	public void addEmp(Employee emp) {
		empService.addEmp(emp);
	}	

	@RequestMapping("/deleteemp")
	public void deleteEmp(Integer[] ids) {
		empService.deleteEmp(ids);

	}

	@RequestMapping("/findemp")
	public String findEmpByEmpQueryVo(EmpQueryVo eo, HttpServletRequest request, Model model,HttpServletResponse response) throws Exception {
       
		if (eo.getSHsalary() != null && eo.getSHsalary() != "")
			eo.setHsalary(new BigDecimal(eo.getSHsalary()));
		if (eo.getSLsalary() != null && eo.getSLsalary() != "")
			eo.setLsalary(new BigDecimal(eo.getSLsalary()));
		if (StringUtils.hasText(eo.getSsex()))
			eo.setSex(Integer.parseInt(eo.getSsex()));
		//gfdgdfgfdgfdg
		Page<Employee> pe = empService.findEmpByEmpQueryVo(eo, request);
		model.addAttribute("pe", pe);
		model.addAttribute("eo", eo);
		Cookie cookie=new Cookie("zhangsan","123");
		cookie.setPath("emp/");
		cookie.setMaxAge(60*60*24*30);
		response.addCookie(cookie);
		return "list";
	}

	@RequestMapping("/testemp")
	@ResponseBody
	public Info testemp(HttpServletResponse response) {
		Info info = new Info();
		info.setName("张青");
		info.setSex("男");
		return info;
	}

	@RequestMapping("/abcd")
	@ResponseBody
	public void abcd(String editor01) throws UnsupportedEncodingException {
		String editor02 = new String(editor01.getBytes("iso8859-1"), "utf-8");
		System.out.println(editor02);
	}

	@RequestMapping("/abc")
	public String abc(Model model) {
		model.addAttribute("ab", "1111");
		model.addAttribute("ab", "3111");
		return "abc";
	}

	@RequestMapping("/getexceltem")
	@ResponseBody
	public void getExceltemplate(HttpServletResponse response) throws Exception {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet();
		sheet.setDefaultColumnWidth(30);
		ArrayList<String> list = new ArrayList<String>();
		list.add("学号");
		list.add("姓名");
		list.add("原班级");
		list.add("现班级");
		list.add("原专业");
		list.add("现专业");
		createHeader(sheet, list, getStyleByName(wb, "style1"));
		createBody(sheet, getStyleByName(wb, "style"));
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String("转专业模板下载.xls".getBytes("utf-8"), "iso8859-1"));
		response.setContentType("application/ynd.ms-excel;charset=UTF-8");
		wb.write(response.getOutputStream());

	}

	private static HSSFCellStyle getStyleByName(HSSFWorkbook wb, String name) {
		HSSFCellStyle style1 = wb.createCellStyle();
		style1.setAlignment(CellStyle.ALIGN_CENTER);// 设置水平对齐
		HSSFFont font = wb.createFont();
		font.setFontName("微软雅黑");// 设置字体名
		font.setFontHeightInPoints((short) 12);
		style1.setFont(font);

		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(CellStyle.ALIGN_CENTER);// 设置水平对齐
		HSSFDataFormat format = wb.createDataFormat();
		style.setDataFormat(format.getFormat("@"));

		if (name.equals("style"))
			return style;
		if (name.equals("style1"))
			return style1;
		else
			return null;
	}

	private static void createBody(HSSFSheet sheet, HSSFCellStyle style) {
		for (int i = 0; i < 2000; i++) {
			HSSFRow row = sheet.createRow(i + 1);
			for (int j = 0; j < 6; j++) {
				Cell cell = row.createCell(j);
				cell.setCellStyle(style);

			}

		}
	}

	private static void createHeader(HSSFSheet sheet, ArrayList<String> list, HSSFCellStyle style) {
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < 6; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(list.get(i));
			cell.setCellStyle(style);
		}

	}

}
