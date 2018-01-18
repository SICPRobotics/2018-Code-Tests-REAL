import java.util.ArrayList; 
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs; 
import org.opencv.imgproc.Imgproc; 
import org.opencv.videoio.VideoCapture;
import org.opencv.core.Point; 
import java.lang.Thread; 


public class MAIN {
	public static void main(String[] args) {
		try{
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		VideoCapture captureGear = new VideoCapture(); 
		
		captureHG.open("http://10.58.22.72/mjpg/video.mjpg");
		
		Mat bgr = new Mat(); 
		captureHG.read(bgr);

		Imgcodecs.imwrite("/home/pi/dev/Vision/PiCode/PiPics/RawImage" + oneCount +".jpg", bgr);

		Mat hsvConvert = new Mat();
		Imgproc.cvtColor(bgr, hsvConvert, Imgproc.COLOR_BGR2HSV);
		
		Mat hsv = new Mat();
		int topH = 122; 
		int bottomH = 60;  
		int topS = 157; 
		int bottomS = 0;  
		int topV = 196; 
		int bottomV = 58; 
		Core.inRange(hsvConvert, new Scalar (bottomH, bottomS, bottomV), new Scalar (topH, topS, topV), hsv);

		ArrayList<MatOfPoint> contours = new ArrayList<MatOfPoint>();
		Mat mhierarchy = new Mat();
		Imgproc.findContours(hsv, contours, mhierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

		

	}
}
