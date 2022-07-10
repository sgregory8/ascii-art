import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileWriterWrapper writerWrapper = new FileWriterWrapper("C:/Users/Sam/Downloads/Dexter/2017_handsome_man.txt");
        String charMap = "$@B%8&WM#*oahkbdpqwmZO0QLCJUYXzcvunxrjft/\\|()1{}[]?-_+~<>i!lI;:,\"^`'. ";
//        charMap = new StringBuilder(charMap).reverse().toString();
        int charMapSize = charMap.length();
        double scaleFactor = (double) charMapSize/256;
        ImageReader imageReader = new ImageReader("C:/Users/Sam/Downloads/Dexter/2017_handsome_man.jpg");
//        imageReader = new ImageReader("C:/Users/Sam/Downloads/homer.jpg");
        imageReader = new ImageReader("C:/Users/Sam/Downloads/2017_handsome_man.jpg");
        imageReader.scaleImage(100);


        TerminalWrapper terminalWrapper = new TerminalWrapper();
        for (int j = 0; j < imageReader.getImage().getHeight(); j++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < imageReader.getImage().getWidth(); i++) {

                int red = imageReader.getPixelValues(i, j)[0];
                int blue = imageReader.getPixelValues(i, j)[1];
                int green = imageReader.getPixelValues(i, j)[2];

                // AVERAGE IMPL
                int value = (red + blue + green) / 3;

                // LUMINOUS IMPL
//                value = (int) (0.3 * red + 0.59 * green + 0.11 * blue);

                stringBuilder.append(charMap.charAt((int) (Math.floor(value * scaleFactor))));
            }
            terminalWrapper.drawString(stringBuilder.toString());
            writerWrapper.writeLine(stringBuilder.toString());
        }



    }
}
