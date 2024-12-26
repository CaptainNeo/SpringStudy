package lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {
	
	private String url;
	
	public NetworkClient() {
		System.out.println("생성자 호출, url = " + url);
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	//서비스 시작시 호출
	public void connect() {
		System.out.println("connect: " + url);
	}
	
	public void call(String message) {
		System.out.println("call: " + url + " message = " + message);
	}
	
	// 서비스 종료시 호출
	public void disconnect() {
		System.out.println("close: " + url);
	}

	@PostConstruct
	public void init() throws Exception {
		// 초기화 빈 
		// 의존관계 주입이 끝나면 콜백호출
		System.out.println("NetworkClient.init");
		connect();
		call("초기화 연결 메시지");
		
	}

	@PreDestroy
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("NetworkClient.close");
		disconnect();
	}

}
