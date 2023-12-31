package org.ait.demoqa.tests.form;

import org.ait.demoqa.data.StudentData;
import org.ait.demoqa.pages.HomePage;
import org.ait.demoqa.pages.SidePanel;
import org.ait.demoqa.pages.forms.PracticeFormPage;
import org.ait.demoqa.tests.TestBase;
import org.ait.demoqa.utils.DataProviders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormTests extends TestBase {
    @BeforeMethod

    public void precondition() {
        new HomePage(driver).getForms();
        new SidePanel(driver).selectPracticeForm().hideIframes();
    }

    @Test
    public void fillStudentFormTest() {
        // enter personal data(name, lastname,email,tel)
        new PracticeFormPage(driver).enterPersonalData(StudentData.FIRST_NAME, StudentData.LAST_NAME,
                        StudentData.EMAIL, StudentData.PHONE_NUMBER)
                // select gender
                .selectGender(StudentData.GENDER)
                // data of birth
               // .enterDate(StudentData.DATE)
                .selectDate("May","2001","15")
                // select subjects
                .selectSubjects(StudentData.SUBJECTS)
                //select hobbies
                .selectHobby(StudentData.HOBBIES)
                // download photos
                .uploadFile(StudentData.PHOTO_PATH)
                //enter address
                .enterAddress(StudentData.ADDRESS)
                // select state
                .selectState(StudentData.STATE)
                // select city
                .selectCity(StudentData.CITY)
                //click on submit button
                .submit()
                .assertSubmit("Thanks for submitting the form");


    }
@Test(dataProviderClass = DataProviders.class,dataProvider = "studentDataFromCSVFile")
    public void fillStudentFormUsingDataProviderTest(String name,String lastname,
                                                     String email,String phone,
                                                     String dataOfBirthday, String path,
                                                     String address) {
        // enter personal data(name, lastname,email,tel)
        new PracticeFormPage(driver).enterPersonalData(name,lastname,email,phone)
                // select gender
                .selectGender(StudentData.GENDER)
                // data of birth
                .enterDate(dataOfBirthday)
                // select subjects
                .selectSubjects(StudentData.SUBJECTS)
                //select hobbies
                .selectHobby(StudentData.HOBBIES)
                // download photos
                .uploadFile(path)
                //enter address
                .enterAddress(address)
                // select state
                .selectState(StudentData.STATE)
                // select city
                .selectCity(StudentData.CITY)
                //click on submit button
                .submit()
                .assertSubmit("Thanks for submitting the form");


    }

}
