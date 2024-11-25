package wearetests.web.failuretomeetrequirements;

import com.testData.TestData;
import com.testData.UniqueNameGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import wearetests.core.WEAreBaseTest;

@Order(14)
public class WEAreCreateUserBVATest extends WEAreBaseTest {


    @Test
    public void createUserWithShortPassword() {
        addIssueAndLink("Jira-141", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-141");

        String uniqueName = UniqueNameGenerator.getInstance().generateUniqueName();

        registerWEArePage.navigate();
        registerWEArePage.submitRegisterForm(uniqueName, TestData.getValidEmail(),
                TestData.getShortPassword(),
                TestData.getShortConfPassword()
        );

        String actualPageTitle = registerWEArePage.getPasswordErrorTitle();

        Assertions.assertEquals("password must be minimum 8 characters", actualPageTitle, "Page title is not correct.");
    }


    @Test
    public void createUserWithLongUsername() {
        addIssueAndLink("Jira-142", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-142");

        String uniqueSecondName = UniqueNameGenerator.getInstance().generateUniqueName() + "BillyGibbonsTestUser";
        registerWEArePage.navigate();
        registerWEArePage.submitRegisterForm(uniqueSecondName, TestData.getValidEmail(),
                TestData.getValidPassword(),
                TestData.getConfValidPassword());


        String actualPageTitle = registerWEArePage.getUsernameErrorTitle();
        Assertions.assertEquals("username must be maximum 20 characters", actualPageTitle, "Page title is not correct.");

    }


    @Test
    public void createUserWithExistingEmail() {
        addIssueAndLink("Jira-143", "Jira Task", "https://a61-qa-team-1.atlassian.net/jira/software/c/projects/IAG/list?selectedIssue=IAG-143");

        String username = UniqueNameGenerator.getInstance().generateUniqueName();
        registerWEArePage.navigate();
        registerWEArePage.submitRegisterForm(username, TestData.getValidEmail(),
                TestData.getValidPassword(),
                TestData.getConfValidPassword()
        );


        String actualPageTitle = registerWEArePage.getEmailErrorTitle();
        Assertions.assertEquals("the email already exist", actualPageTitle, "Page title is not correct.");

    }
}

