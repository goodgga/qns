package qns.tools.other;

import java.util.UUID;

public class Encryption {
	/**
	 * 生成36位key
	 * @return 36位的key
	 */
	public static final String makeKey(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}
