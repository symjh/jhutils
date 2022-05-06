package jh.utils.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AutoRunWeb {

    private static final String DRIVER_PATH = "src/main/resources/other/chromedriver.exe";

    // 直接启动新的浏览器
    public static WebDriver startByNew(){
        System.setProperty("webdriver.chrome.driver",DRIVER_PATH);
        return new ChromeDriver();
    }

    /**
     * 在已有的浏览器上运行
     * 启动命令：chrome.exe --remote-debugging-port=9904 --user-data-dir="C:\temp\chrome-9904"
     * @return
     */
    public static WebDriver startByOld(){
        System.setProperty("webdriver.chrome.driver",DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress","127.0.0.1:9904");
        return new ChromeDriver(options);
    }

    public static void main(String[] args) {
        WebDriver driver = startByNew();
        driver.get("https://www.baidu.com/");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.id("kw"));
        element.sendKeys("css");
//        driver.findElements(By.xpath("//frame"));
    }

    /**
     * xpath示例
     *
     * /bookstore/book[1] 选取属于 bookstore 子元素的第一个 book 元素。
     * /bookstore/book[last()] 选取属于 bookstore 子元素的最后一个 book 元素。
     * /bookstore/book[last()-1] 选取属于 bookstore 子元素的倒数第二个 book 元素。
     * /bookstore/book[position()<3] 选取最前面的两个属于 bookstore 元素的子元素的 book 元素。
     * //title[@lang] 选取所有拥有名为 lang 的属性的 title 元素。
     * //title[@lang='eng'] 选取所有 title 元素，且这些元素拥有值为 eng 的 lang 属性。
     * /bookstore/book[price>35.00] 选取所有 bookstore 元素的 book 元素，且其中的 price 元素的值须大于 35.00。
     * /bookstore/book[price>35.00]/title 选取所有 bookstore 元素中的 book 元素的 title 元素，且其中的 price 元素的值须大于 35.00。
     *
     * /bookstore/* 选取 bookstore 元素的所有子节点
     * //* 选取文档中的所有元素
     * //title[@*] 选取所有带有属性的 title 元素。
     * //book/title | //book/price 选取所有 book 元素的 tilte 和 price 元素。
     * //title | //price 选取所有文档中的 title 和 price 元素。
     * /bookstore/book/title | //price 选取所有属于 bookstore 元素的 book 元素的 title 元素，以及文档中所有的 price 元素。
     *
     * ancestor 选取当前节点的所有先辈（父、祖父等）
     * ancestor-or-self 选取当前节点的所有先辈（父、祖父等）以及当前节点本身
     * attribute 选取当前节点的所有属性
     * child 选取当前节点的所有子元素。
     * descendant 选取当前节点的所有后代元素（子、孙等）。
     * descendant-or-self 选取当前节点的所有后代元素（子、孙等）以及当前节点本身。
     * following 选取文档中当前节点的结束标签之后的所有节点。
     * namespace 选取当前节点的所有命名空间节点
     * parent 选取当前节点的父节点。
     * preceding 选取文档中当前节点的开始标签之前的所有节点。
     * preceding-sibling 选取当前节点之前的所有同级节点。
     * self 选取当前节点。
     *
     */

}
