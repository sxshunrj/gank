package com.sxshunrj.test;

import org.opencv.core.*;
import org.opencv.highgui.Highgui;
import org.opencv.objdetect.CascadeClassifier;

/**
 * Created by IntelliJ IDEA.
 * User: sunxs
 * Date: 2017/10/27 10:52
 */
public class OpencvTest {

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("\nRunning FaceDetector");
        String basePath = "D:\\workspace\\clone\\gank\\common\\opencv\\data\\";

        CascadeClassifier faceDetector = new CascadeClassifier(basePath+"haarcascades\\haarcascade_frontalface_alt.xml");
        Mat image = Highgui.imread(basePath+"mingx.jpg");

        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);

        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

        for (Rect rect : faceDetections.toArray()) {
            Core.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0));
        }

        String filename = basePath+"ouput.jpg";
        System.out.println(String.format("Writing %s", filename));
        Highgui.imwrite(filename, image);
    }
}
