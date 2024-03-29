package fileupload;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

public class FileUtil {
	//파일 업로드(multipart/form-data 요청) 처리
	public static MultipartRequest uploadFile(HttpServletRequest req, 
			String saveDirectory, int maxPostSize) {
		try {
			//파일업로드
			return new MultipartRequest(req, saveDirectory, maxPostSize,"UTF-8");
		}
		catch(Exception e) {
			//업로드 실패
			e.printStackTrace();
			return null;
		}
	}
}
