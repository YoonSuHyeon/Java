package study.effectivejava.item3;

import java.io.*;

public class SerializeDemo implements Serializable {
    public static void main(String[] args) {
        SingletonEx4 singletonEx1 = SingletonEx4.INSTANCE;
        singletonEx1.setValue(1);


        //Serialize
        try {
            FileOutputStream fos = new FileOutputStream("out.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(singletonEx1);

            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        singletonEx1.setValue(2);

        //Deserialize
        SingletonEx4 singletonEx11 = null;
        try {
            FileInputStream fis = new FileInputStream("out.ser");
            ObjectInputStream in = new ObjectInputStream(fis);
            singletonEx11 = (SingletonEx4) in.readObject();
            in.close();
            fis.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("singletons.SingletonEnum class not found");
            c.printStackTrace();
        }

        if (singletonEx1 == singletonEx11) {
            System.out.println("Two objects are same");
        } else {
            System.out.println("Two objects are not same");
        }

        System.out.println(singletonEx1.getValue());
        System.out.println(singletonEx11.getValue());
    }
}
