package destiny.joe.utils;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;

// https://howtodoinjava.com/java/serialization/xmlencoder-and-xmldecoder-example/
public class XMLSerializer {

    private XMLSerializer() {
    }

    // serializeToXML
    public static <T> void saveObject(T file, String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.writeObject(file);
            encoder.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // deserializeFromXML
    @SuppressWarnings("unchecked")
    public static <T> T loadObject(String filePath) throws Exception {
        T decodedFile = null;
        try (FileInputStream fis = new FileInputStream(filePath);) {
            XMLDecoder decoder = new XMLDecoder(fis);
            decodedFile = (T) decoder.readObject();
            decoder.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return decodedFile;
    }

}
