package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
    @DataProvider
    public static Object[][] sehirVerileri() {
        return new Object[][]{{"Ankara","Ic Anadolu", "06"},
                {"Bursa","Marmara","16"},
                {"Trabzon","Karadeniz","61"}};
    }
}
