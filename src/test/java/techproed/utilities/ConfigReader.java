package techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    /*
    properties uzantili  dosyaya erisebilmemi icin  Properties class'inda obje olusturmamiz gerekir.
    Bu olusturdugumuz obje ile akisa aldigimiz dosya yolunu load(fis) methodu ile properties dosyasindaki key degerini return edebiliriz.
    */

   static Properties properties;
    public static String getProperty(String key){
        try {
            FileInputStream fis = new FileInputStream("configuration.properties");//copy path ile dosya yolunu buraya yazdik.
            properties = new Properties();
            properties.load(fis);//fis'in okudugu bilgileri properties'e yukler
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String value = properties.getProperty(key);//getProperty(key) methodu properties dosyasindaki key'in degerini veriri.
        return value;
        //get property methodunu kullandigim da String olarak parametre isteyecek, ve getProperty(key) ile de bana getirecek

    }

}
