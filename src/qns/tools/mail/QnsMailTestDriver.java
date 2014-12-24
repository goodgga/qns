package qns.tools.mail;

public class QnsMailTestDriver {
	public static void main(String[] args) {
		QnsAuthenticator qa = new QnsAuthenticator("zhangqinghua", "wo0526g");
		QnsMail.check(qa);
	}
}
