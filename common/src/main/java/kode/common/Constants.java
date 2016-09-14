package kode.common;

/**
 * 公用常量类。
 *
 * @author Stark
 * @since 1.0, 2016/8/2
 */
public abstract class Constants {
	/** 常用字符 */
	public static final String EMPTY = "";
	public static final String STAR = "*";
	public static final String SPACE = " ";
	public static final String LINE = "-";
	public static final String UNDERSCORE = "_";

	/** TOP默认时间格式 **/
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/** TOP Date默认时区 **/
	public static final String DATE_TIMEZONE = "GMT+8";

	/** UTF-8字符集 **/
	public static final String CHARSET_UTF8 = "UTF-8";

	/** GBK字符集 **/
	public static final String CHARSET_GBK = "GBK";

	/** TOP JSON 应格式 */
	public static final String FORMAT_JSON = "json";
	/** TOP XML 应格式 */
	public static final String FORMAT_XML = "xml";

	/** MD5签名方式 */
	public static final String SIGN_METHOD_MD5 = "md5";
	/** HMAC签名方式 */
	public static final String SIGN_METHOD_HMAC = "hmac";

	/** TQL分隔符 */
	public static final String TQL_SEPERATOR = "top_tql_seperator";

	/** 返回的错误码 */
	public static final String ERROR_RESPONSE = "error_response";
	public static final String ERROR_CODE = "code";
	public static final String ERROR_MSG = "msg";
	public static final String ERROR_SUB_CODE = "sub_code";
	public static final String ERROR_SUB_MSG = "sub_msg";
}

