package kode.boot.testjar.controller;

import kode.boot.testjar.domain.AppResource;
import kode.boot.testjar.domain.Product;
import kode.boot.testjar.service.AppUserService;
import kode.boot.testjar.util.ExcelUtils;
import org.elasticsearch.node.NodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @version 1.0
 * @since 2016/7/7
 */
@Controller
public class HomeController {

	//从配置文件中读取配置
	@Value("${name}")
	private String name;

	@Value("${desc}")
	private String desc;

	@Value("${test:defaultTestValue}")
	private String test;

	@Autowired
	private AppUserService appUserService;

//	@Autowired
//	public HomeController(AppUserService userService) {
//		this.appUserService = userService;
//	}

	@RequestMapping("/")
	String home(Model model) {
		model.addAttribute("message", "Hello world! <br/>"
				+ "desc: " + desc + "<br/>" +
				"test: " + test);
		model.addAttribute("userCount", appUserService.countAllUser());
		model.addAttribute("date", new Date());
		model.addAttribute("userStatus", 3);

		return "index";
	}

	//	@Secured({AppResource.USER_CREATE, AppResource.USER_QUERY})
	@PreAuthorize("hasAuthority('" + AppResource.USER_CREATE + "') or hasAuthority('" + AppResource.USER_QUERY + "')")
	@RequestMapping("test")
	String test(Model model) {
		model.addAttribute("message", "Hello world! ============== test sample ||| " + desc + " | test = " + test + " | devName = ");
		return "test";
	}

	@RequestMapping("access_denied")
	String accessDenied(Model model) {
		model.addAttribute("message", "您无此权限，请求被拒绝。");
		return "test";
	}

	@RequestMapping("hello")
	String hello() {
		return "test";
	}

	@RequestMapping("login")
	String login() {
		return "login";
	}

	@PreAuthorize("has('" + AppResource.USER_CREATE + "')")
	@RequestMapping("create")
	String create() {
		return "test";
	}

	@ResponseBody
	@RequestMapping("/es/{id}")
	String testElastic(@PathVariable Long id) {
		Product product = new Product();
		product.setId(id);
		product.setName("productName " + id);
		product.setDescription("productDescription " + id);


		NodeBuilder nodeBuilder = NodeBuilder.nodeBuilder();


		return "";
	}

	@RequestMapping("excel")
	String exportExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
		/*
		//创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		//建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet("成绩表");
		//在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		//创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		//设置单元格内容
		cell.setCellValue("学员考试成绩一览表");
		//合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		//在sheet里创建第二行
		HSSFRow row2 = sheet.createRow(1);
		//创建单元格并设置单元格内容
		row2.createCell(0).setCellValue("姓名");
		row2.createCell(1).setCellValue("班级");
		row2.createCell(2).setCellValue("笔试成绩");
		row2.createCell(3).setCellValue("机试成绩");
		//在sheet里创建第三行
		HSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("李明");
		row3.createCell(1).setCellValue("As178");
		row3.createCell(2).setCellValue(87);
		row3.createCell(3).setCellValue(78);
		//.....省略部分代码
		*/

		ExcelUtils util = new ExcelUtils();
		util.createSheet("我是第一页");
		util.setTitle("15年度成绩");
		util.setHeader(new LinkedHashMap<String, String>() {{
			put("姓名", "name");
			put("班级", "clazz");
			put("笔试成绩", "gradeOfPaper");
			put("机试成绩", "gradeOfComputer");
			put("备注", "remark");
		}});

		util.setData(Arrays.asList(new HashMap<String, Object>() {
									   {
										   put("name", "张三");
										   put("clazz", "2班");
										   put("gradeOfPaper", "89");
										   put("gradeOfComputer", "96");
									   }
								   },
				new HashMap<String, Object>() {{
					put("name", "李四");
					put("clazz", "1班");
					put("gradeOfPaper", "82");
					put("gradeOfComputer", "99");
				}}));

		util.createSheet("我是第2页");
		util.setTitle("16年度成绩");
		util.setHeader(new LinkedHashMap<String, String>() {{
			put("姓名", "name");
			put("班级", "clazz");
			put("笔试成绩", "gradeOfPaper");
			put("机试成绩", "gradeOfComputer");
		}});

		util.setData(Arrays.asList(new HashMap<String, Object>() {
									   {
										   put("name", "张三2");
										   put("clazz", "2班");
										   put("gradeOfPaper", "89");
										   put("gradeOfComputer", "96");
									   }
								   },
				new HashMap<String, Object>() {{
					put("name", "李四2");
					put("clazz", "1班");
					put("gradeOfPaper", "82");
					put("gradeOfComputer", "99");
				}}));


		//输出Excel文件
		OutputStream output = response.getOutputStream();
		response.reset();
		response.setHeader("Content-Disposition", "attachment; filename=details.xls");
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		util.export(output);
		output.close();
		return null;
	}
}
