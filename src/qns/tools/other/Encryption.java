package qns.tools.other;

import java.util.UUID;

public class Encryption {
	/**
	 * ����36λkey
	 * @return 36λ��key
	 */
	public static final String makeKey(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}
