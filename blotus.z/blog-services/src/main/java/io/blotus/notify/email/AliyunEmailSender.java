package io.blotus.notify.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 暂未实现
 */
public class AliyunEmailSender implements IEmailSender {
	@SuppressWarnings("unused")
	private final Logger log = LoggerFactory.getLogger(getClass());

	/**
	 * 文档：
	 * https://help.aliyun.com/document_detail/directmail/api-reference/sendmail
	 * -related/SingleSendMail.html?spm=5176.docdirectmail/api-reference/
	 * sendmail-related/BatchSendMail.6.118.Qd9yth
	 */
	@Override
	public void send(Email email) {

	}
}
