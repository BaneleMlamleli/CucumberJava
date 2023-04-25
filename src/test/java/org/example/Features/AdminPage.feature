Feature: Admin User Management page, adding and editing a user

    # I still need to fix this Background scenario or try to optimise it.
    Background: Administrator has logged in successfully and is on the User Management page
        Scenario Outline: Check login is successful with valid credentials
        Given browser is open
        And user is on login page
        When user enters <username> and <password>
        And user clicks on login button
        Then user is navigated to the home page

        Examples:
        |username   |password   |
        |Admin      |admin123   |

    Scenario Outline: Add a user providing valid information
        # Given user is on the admin page
        And user clicks on the Admin button
        And user clicks on Add button
        When user select user role <user_role>
        And enter employee name <employee_name>
        And user select user status <status>
        And enter username <username>
        And user enters password <password> and confirmation password <confirms_password>
        Then click on Save button
        And successful toaster box appears

        Examples:
        |user_role  |employee_name          |status     |username       |password       |confirms_password  |
        |Admin      |Adam Hill  Mackshaw    |Enabled    |PayrolAdmin    |P@yr0ll_Adm!n  |P@yr0ll_Adm!n      |
        # |ESS        |HR_Intern              |Disabled   |HR_Intern      |HR_Int3rn      |HR_Int3rn          |
        # |ESS        |PayrolAdmin            |Enabled    |Book_keeper    |B00k_k33p3r!   |B00k_k33p3r!       |
        # |Admin      |ESS_Admin              |Disabled   |ESS_Admin      |Ess_Adm!in01   |Ess_Adm!in01       |
        # |https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers  |ESS_Admin      |Admin      |ESS_Admin      | Disabled  |Ess_Adm!in01   |Ess_Adm!in01       |
