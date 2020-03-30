import com.codeborne.selenide.ElementsCollection;
import com.company.Product;
import org.junit.Test;

import java.util.ArrayList;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class citrusTesting {

        ArrayList<Product> phoneInf = new ArrayList<Product>(100);
        String phoneName;
        String phoneSale;
        String phoneSalePrice;
        String phonePrice;

        @Test
        public void findAllSales() {
            open("https://www.citrus.ua/uk/smartfony/");
           ElementsCollection phones  = $$x("//span[contains(@class, 'discount-program__sale')]" +
                   "/ancestor::div[contains(@class, 'product-card__overview')]").shouldHave(sizeGreaterThan(0));
            for(int i = 0; i < phones.size(); i++){
                phoneName = phones.get(i).$x(".//div[contains(@class, 'product-card__name')]").shouldHave(visible).text();
                phoneSale = phones.get(i).$x(".//span[contains(@class, 'discount-program__sale')]").shouldHave(visible).text();
                phoneSalePrice = phones.get(i).$x(".//div[contains(@class, 'prices__price')]/span[contains(@class, 'price')]").shouldHave(visible).text();
                phonePrice = phones.get(i).$x(".//div[contains(@class, 'prices__old-price')]").shouldHave(visible).text();
                phoneInf.add(new Product(phoneName, phoneSale, phoneSalePrice, phonePrice));
        }

        phoneInf.stream().filter(p->p.getPhoneSale()>20).forEach(System.out::println);

        }

}

