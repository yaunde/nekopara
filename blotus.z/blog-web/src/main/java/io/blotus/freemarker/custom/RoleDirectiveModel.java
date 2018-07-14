package io.blotus.freemarker.custom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import freemarker.core.Environment;
import freemarker.template.SimpleSequence;
import freemarker.template.TemplateBooleanModel;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateScalarModel;

@Service
public class RoleDirectiveModel implements TemplateDirectiveModel {

	protected final Logger log = LoggerFactory.getLogger(getClass());
 	/**
	 * env : 环境变量
	 * params : 指令参数 （存储你所需要的值，随便什么key value）
	 * loopVars : 循环变量，返回的结果
	 * 放进loopVars的应该都是TemplateModel的实现类
	 * body : 指令内容
     * 除了params之外，其他都能使用null。
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		log.info("==========================");
		
		// 获取第一参数
		TemplateScalarModel user = (TemplateScalarModel) params.get("user");
		// 获取第二个参数
		TemplateScalarModel role = (TemplateScalarModel) params.get("role");
		
		/*
		 * TEST:zhanzhiqiang
		 * 在当前的命名空间设置一个变量
		 * 
		 * setVariable:在当前命名空间中设置一个变量。 这与FTL <#assign name = model>相对应。 这可以被认为是一个方便的简写：getCurrentNamespace（）。put（name，model）
		 * wrap :如何将Java对象“包装”为TemplateModel实例的对象。
		 */
		env.setVariable("zhanzhiqiang", env.getConfiguration().getObjectWrapper().wrap("zhaoyirong"));
		
		if ("123456".equals(user.getAsString()) && "admin".equals(role.getAsString())) {
			// 第一个返回值
			loopVars[0] = TemplateBooleanModel.TRUE;
		}
		
		// 用户的权限
		List<String> otherRights = new ArrayList<>();
		otherRights.add("add");
		otherRights.add("delete");
		otherRights.add("update");
		
		// 第二个返回值
		loopVars[1] = new SimpleSequence(otherRights);
		
		// body用于最后把结果渲染出来
		body.render(env.getOut());
	}

}
