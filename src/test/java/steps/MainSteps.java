package steps;


import io.qameta.allure.Step;

public class MainSteps {

    @Step("Business step for {keyword} ")
    public static void stepKeyword(String keyword) {
        System.out.println(keyword);
    }

    @Step("{description}")
    public static void step(String description) {
    }

}
