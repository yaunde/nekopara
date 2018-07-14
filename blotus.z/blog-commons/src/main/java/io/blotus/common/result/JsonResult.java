package io.blotus.common.result;

import java.io.Serializable;

public class JsonResult<T> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2587980227757430552L;

	public static int SUCCESS_CODE = 0;
	public static int FAILURE_CODE = -1;

	private int code; // 处理状态：0: 成功
	private String message;
	private T data; // 返回数据

	private JsonResult() {
	}

	private JsonResult(int code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	/**
	 * 处理成功，并返回数据
	 * 
	 * @param data
	 * @return
	 * @since 1.0.0
	 */
	public static final <E> JsonResult<E> success(E data) {
		return new JsonResult<E>(JsonResult.SUCCESS_CODE, "操作成功", data);
	}

	/**
	 * 成功，返回消息，不返回数据
	 * 
	 * @param message
	 * @return
	 * @deprecated with 1.0.0
	 */
	public static final <E> JsonResult<E> success(String message) {
		return new JsonResult<E>(JsonResult.SUCCESS_CODE, message, null);
	}

	/**
	 * 成功，返回消息和数据
	 * 
	 * @param message
	 * @param data
	 * @return
	 */
	public static final <E> JsonResult<E> success(String message, E data) {
		return new JsonResult<E>(JsonResult.SUCCESS_CODE, message, data);
	}

	/**
	 * 处理失败，（一般为错误信息）
	 * 
	 * @param code
	 * @param message
	 * @return
	 */
	public static final <E> JsonResult<E> failure(int code, String message) {
		return new JsonResult<E>(code, message, null);
	}

	/**
	 * 处理失败，（一般为错误信息）
	 * 
	 * @param message
	 * @return
	 */
	public static final <E> JsonResult<E> failure(String message) {
		return failure(JsonResult.FAILURE_CODE, message);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "JsonResult [code=" + code + ", message=" + message + ", data=" + data + "]";
	}
}
