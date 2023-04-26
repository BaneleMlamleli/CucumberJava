Feature: Admin User Management page, adding and editing a user

    # I still need to fix this Background scenario or try to optimise it.
    # Background: Administrator has logged in successfully and is on the User Management page
    #     Scenario Outline: Check login is successful with valid credentials
    #     Given browser is open
    #     And user is on login page
    #     When user enters <admin_username> and <admin_password>
    #     And user clicks on login button
    #     Then user is navigated to the home page

    #     Examples:
    #     |admin_username |admin_password |
    #     |Admin          |admin123       |

    Scenario Outline: Administrator has logged in successfully and is on the User Management page
        Given browser is open
        And user is on login page
        When user enters <admin_username> and <admin_password>
        And user clicks on login button
        Then user is navigated to the home page
        # And user is on the admin page
        # And user clicks on the Admin button
        And user clicks on Add button
        And user select user role <user_role>
        And enter employee name <employee_name>
        And user select user status <status>
        And enter username <username>
        And user enters password <password> and confirmation password <confirms_password>
        And click on Save button
        And successful toaster box appears

        Examples:
        |user_role  |employee_name          |status     |username       |password       |confirms_password  |admin_username |admin_password |
        |Admin      |Adam Hill  Mackshaw    |Enabled    |PayrolAdmin    |P@yr0ll_Adm!n  |P@yr0ll_Adm!n      |Admin          |admin123       |
        # |ESS        |HR_Intern              |Disabled   |HR_Intern      |HR_Int3rn      |HR_Int3rn          |
        # |ESS        |PayrolAdmin            |Enabled    |Book_keeper    |B00k_k33p3r!   |B00k_k33p3r!       |
        # |Admin      |ESS_Admin              |Disabled   |ESS_Admin      |Ess_Adm!in01   |Ess_Adm!in01       |
        # |https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers  |ESS_Admin      |Admin      |ESS_Admin      | Disabled  |Ess_Adm!in01   |Ess_Adm!in01       |
