package io.blotus.core.freemarker;

import java.io.IOException;
import java.io.Writer;
import java.math.BigInteger;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.core.Environment;
import freemarker.template.TemplateBooleanModel;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateNumberModel;
import freemarker.template.TemplateScalarModel;

/**
 * 
 * @author yaunde
 *
 */
public abstract class DirectiveHandler implements TemplateDirectiveModel {

	private final Logger log = LoggerFactory.getLogger(getClass());

	// 环境变量
	private Environment env;
	// 指令参数 （存储你所需要的值，随便什么key value）
	private Map<?, ?> params;
	// 返回的结果集
	private TemplateModel[] loopVars;
	private TemplateDirectiveBody body;

	/**
	 * env : 环境变量
	 * params : 指令参数 （存储你所需要的值，随便什么key value）
	 * loopVars : 循环变量
	 * body : 指令内容
	 * 
	 * 除了param 外， 其他的都允许为null
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		this.env = env;
		this.params = params;
		this.loopVars = loopVars;
		this.body = body;

		onRender();
	}

	public abstract void onRender();

	/**
	 * 在当前的命名空间设置一个变量. 这与FTL <#assign name = model>相对应。 这可以被认为是一个方便的简写：getCurrentNamespace（）.put（name，model）
	 * 
	 * @param key
	 * @param value
	 */
	protected void setVariable(String key, Object value) {
		try {
			env.setVariable(key, env.getConfiguration().getObjectWrapper().wrap(value));
		} catch (TemplateModelException e) {
			e.printStackTrace();
			log.error("setVariable(String key,Object value) is error!", e);
		}
		
	}
	
	/**
	 * freemarker 字符串为null时
	 * @param text
	 */
	protected void renderText(String text) {
		try {
			env.getOut().write(text == null ? "null" : text);
		} catch (IOException e) {
			log.error("DirectiveHandler renderText error", e);
		}
	}

	/**
	 * 
	 */
	protected void renderBody() {
		try {
			body.render(env.getOut());
		} catch (TemplateException e) {
			log.error("DirectiveHandler renderBody is error!", e);
		} catch (IOException e) {
			log.error("DirectiveHandler renderBody is error!", e);
		}
	}

	protected void renderBody(Writer writer) {
		try {
			body.render(writer);
		} catch (TemplateException e) {
			log.error("DirectiveHandler renderBody(Writer writer) is error!", e);
		} catch (IOException e) {
			log.error("DirectiveHandler renderBody(Writer writer) is error!", e);
		}
	}

	
	public TemplateModel[] getTemplateModels() {
		return this.loopVars;
	}

	public TemplateDirectiveBody getBody() {
		return body;
	}

	public Writer getWriter() {
		return env.getOut();
	}

	

	/**
	 * 获取指令中的参数，并转成字符串
	 * @param key
	 * @return
	 */
	public String getParam(String key) {
		TemplateModel model = (TemplateModel) params.get(key);
		if (model == null) {
			return null;
		}
		try {
			if (model instanceof TemplateScalarModel) {
				return ((TemplateScalarModel) model).getAsString();
			}
			if ((model instanceof TemplateNumberModel)) {
				return ((TemplateNumberModel) model).getAsNumber().toString();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return null;
	}
	public String getParam(String key, String defaultValue) {
		String value = getParam(key);
		if (value != null)
			return value;

		return defaultValue;
	}

	

	/**
	 * 获取指令中的参数，并转成long
	 * @param key
	 * @return
	 */
	public Long getParamToLong(String key) {
		TemplateModel model = (TemplateModel) params.get(key);

		if (model == null) {
			return null;
		}

		try {
			if (model instanceof TemplateNumberModel) {
				return ((TemplateNumberModel) model).getAsNumber().longValue();
			}

			if (model instanceof TemplateScalarModel) {
				String string = ((TemplateScalarModel) model).getAsString();
				if (null == string || "".equals(string.trim())) {
					return null;
				}
				return Long.parseLong(string);
			}
		} catch (Exception e) {
			throw new RuntimeException("must number!", e);
		}

		return null;
	}
	public Long getParamToLong(String key, long defaultValue) {
		Long value = getParamToLong(key);
		if (value != null)
			return value;

		return defaultValue;
	}
	
	/**
	 * 获取指令中的变量，并转成BigInteger
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public BigInteger getParamToBigInteger(String key, BigInteger defaultValue) {
		BigInteger value = getParamToBigInteger(key);
		if (value != null) {
			return value;
		}
		return defaultValue;
	}
	public BigInteger getParamToBigInteger(String key) {
		TemplateModel model = (TemplateModel) params.get(key);
		if (model == null) {
			return null;
		}
		try {
			if (model instanceof TemplateNumberModel) {
				long number = ((TemplateNumberModel) model).getAsNumber().longValue();
				return BigInteger.valueOf(number);
			}
			
			if (model instanceof TemplateScalarModel) {
				String string = ((TemplateScalarModel) model).getAsString();
				if (null == string || "".equals(string.trim())) {
					return null;
				}
				return new BigInteger(string);
			}
		} catch (Exception e) {
			throw new RuntimeException("must number!", e);
		}
		
		return null;
	}

	/**
	 * 获取指令中的变量，并转成整型
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public Integer getParamToInt(String key, Integer defaultValue) {

		Integer value = getParamToInt(key);
		if (null != value)
			return value;

		return defaultValue;
	}
	public Integer getParamToInt(String key) {
		TemplateModel model = (TemplateModel) params.get(key);
		if (model == null) {
			return null;
		}

		try {
			if (model instanceof TemplateNumberModel) {
				return ((TemplateNumberModel) model).getAsNumber().intValue();
			}

			if (model instanceof TemplateScalarModel) {
				String string = ((TemplateScalarModel) model).getAsString();
				if (null == string || "".equals(string.trim())) {
					return null;
				}

				return Integer.parseInt(string);

			}
		} catch (Exception e) {
			throw new RuntimeException("must number!", e);
		}

		return null;

	}

	/**
	 * 获取指令中的变量，并转成整型数组
	 * @param key
	 * @return
	 */
	public Integer[] getParamToIntArray(String key) {
		String string = getParam(key);
		if (null == string || "".equals(string.trim())) {
			return null;
		}

		if (!string.contains(",")) {
			return new Integer[] { Integer.valueOf(string.trim()) };
		}

		String[] array = string.split(",");
		Integer[] ids = new Integer[array.length];
		int i = 0;
		try {
			for (String str : array) {
				ids[i++] = Integer.valueOf(str.trim());
			}
			return ids;
		} catch (NumberFormatException e) {
			throw e;
		}
	}

	/**
	 * 获取指令中的变量，并转成long数组
	 * @param key
	 * @return
	 */
	public Long[] getParamToLongArray(String key) {
		String string = getParam(key);
		if (null == string || "".equals(string.trim())) {
			return null;
		}

		if (!string.contains(",")) {
			return new Long[] { Long.valueOf(string.trim()) };
		}

		String[] array = string.split(",");
		Long[] ids = new Long[array.length];
		int i = 0;
		try {
			for (String str : array) {
				ids[i++] = Long.valueOf(str.trim());
			}
			return ids;
		} catch (NumberFormatException e) {
			throw e;
		}
	}
	
	/**
	 * 获取指令中的变量，并转成BigInteger数组
	 * @param key
	 * @return
	 */
	public BigInteger[] getParamToBigIntegerArray(String key) {
		String string = getParam(key);
		if (null == string || "".equals(string.trim())) {
			return null;
		}
		
		if (!string.contains(",")) {
			return new BigInteger[] { new BigInteger(string.trim()) };
		}
		
		String[] array = string.split(",");
		BigInteger[] ids = new BigInteger[array.length];
		int i = 0;
		try {
			for (String str : array) {
				ids[i++] = new BigInteger(str.trim());
			}
			return ids;
		} catch (NumberFormatException e) {
			throw e;
		}
	}

	public String[] getParamToStringArray(String key) {
		String string = getParam(key);
		if (null == string || "".equals(string.trim())) {
			return null;
		}

		if (!string.contains(",")) {
			return new String[] { string };
		}

		return string.split(",");
	}

	public Boolean getParamToBool(String key, Boolean defaultValue) {
		Boolean value = getParamToBool(key);
		if (value != null)
			return value;

		return defaultValue;
	}

	public Boolean getParamToBool(String key) {
		TemplateModel model = (TemplateModel) params.get(key);
		if (model == null) {
			return null;
		}

		try {
			if (model instanceof TemplateBooleanModel) {
				return ((TemplateBooleanModel) model).getAsBoolean();
			}

			if (model instanceof TemplateNumberModel) {
				return !(((TemplateNumberModel) model).getAsNumber().intValue() == 0);
			}

			if (model instanceof TemplateScalarModel) {
				String string = ((TemplateScalarModel) model).getAsString();
				if (null != string && !"".equals(string.trim())) {
					return !(string.equals("0") || string.equalsIgnoreCase("false"));
				} else {
					return null;
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("param must is \"0\",\"1\"  or \"true\",\"false\"", e);
		}

		return null;
	}

}
