package kr.or.bit.action;

//로직 제어 와 화면제어 전달 클래스
public class ActionForward {
	private boolean isRedirect = false; // 화면단 제어
	private String path = null; // 이동 경로

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
