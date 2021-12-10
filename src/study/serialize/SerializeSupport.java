package study.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

/**
 * Serialize,Deserialize Support
 */
public class SerializeSupport {
    public static String serialize(Object model) throws Exception {
        byte[] serialize;
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
                oos.writeObject(model);
                serialize = baos.toByteArray();
            }
        }
        return Base64.getEncoder().encodeToString(serialize);
    }

    public static Object deserialize(String data) throws Exception{
        byte[] serializedMember = Base64.getDecoder().decode(data);
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedMember)) {
            try (ObjectInputStream ois = new ObjectInputStream(bais)) {
                return ois.readObject();
            }
        }
    }
}
