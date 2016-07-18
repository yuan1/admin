package com.funny.admin.controller;

import java.util.List;

import javax.annotation.Resource;

import com.funny.admin.service.sys.MenuService;
import com.funny.admin.shiro.Jurisdiction;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.util.Const;
import com.fh.util.PageData;
import com.fh.util.Tools;
import com.funny.common.result.JsonResult;
import com.funny.admin.domain.sys.Menu;


@Controller
public class LoginController {

	@Resource
	private MenuService menuService;
	/**访问登录页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/toLogin")
	public ModelAndView toLogin()throws Exception{
 		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	/**请求登录，验证用户
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/login")
	@ResponseBody
	public JsonResult login() throws Exception{
        JsonResult jsonResult = new JsonResult();
        jsonResult.setSuccess();
		return  jsonResult;
	}

	/**请求登录，验证用户
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/createMenuTree")
	@ResponseBody
	public JsonResult createMenuTree(){
		JsonResult jsonResult = new JsonResult();
		try {
			List<Menu> menuList = menuService.listSubMenuByParentId(0L);
			for(Menu menu:menuList){
				menu.setMenuList(menuService.listSubMenuByParentId(menu.getId()));
			}
			jsonResult.setSuccess();
			jsonResult.setResult(menuList);
		} catch (Exception e) {
			e.printStackTrace();
			jsonResult.setReturncode(500);
			jsonResult.setMessage(e.getMessage());
		}
		return jsonResult;
	}

	/**
	 * 用户注销
	 * @return
	 */
	@RequestMapping(value="/logout")
	public ModelAndView logout(){
		String USERNAME = Jurisdiction.getUsername();	//当前登录的用户名
		ModelAndView mv =  new ModelAndView();
		PageData pd = new PageData();
		Session session = Jurisdiction.getSession();	//以下清除session缓存
		session.removeAttribute(Const.SESSION_USER);
		session.removeAttribute(USERNAME + Const.SESSION_ROLE_RIGHTS);
		session.removeAttribute(USERNAME + Const.SESSION_allmenuList);
		session.removeAttribute(USERNAME + Const.SESSION_menuList);
		session.removeAttribute(USERNAME + Const.SESSION_QX);
		session.removeAttribute(Const.SESSION_userpds);
		session.removeAttribute(Const.SESSION_USERNAME);
		session.removeAttribute(Const.SESSION_USERROL);
		session.removeAttribute("changeMenu");
		//shiro销毁登录
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		pd.put("msg", pd.getString("msg"));
		pd.put("SYSNAME", Tools.readTxtFile(Const.SYSNAME)); //读取系统名称
		mv.setViewName("system/index/login");
		mv.addObject("pd",pd);
		return mv;
	}
}
