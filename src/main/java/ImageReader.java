import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageReader {

    private BufferedImage image;

    public ImageReader(String path) {
        try {
            image = ImageIO.read(new File(path)); // eventually C:\\ImageTest\\pic2.jpg
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] getPixelValues(int x, int y) {
        return image.getRaster().getPixel(x, y, new int[3]);
    }

    public BufferedImage getImage() {
        return image;
    }

    public void scaleImage(int width) {
        double scaleFactor = image.getWidth() / width;
        image =
                Scalr.resize(image, Scalr.Method.BALANCED, width, (int) (image.getHeight() / scaleFactor));
    }
}
