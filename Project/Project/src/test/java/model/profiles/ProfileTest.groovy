package model.profiles

class ProfileTest extends GroovyTestCase {
    Profile p;

    void setUp() {
        super.setUp();
        p = new Profile("NAME", "USER", "PASS", UserType.USER);
    }

    void testMatchPhoneNumberFormat() {
        assertTrue(Profile.matchPhoneNumberFormat("(000) 000-0000"));
        assertTrue(Profile.matchPhoneNumberFormat("(000)        000-0000"));
        assertTrue(Profile.matchPhoneNumberFormat("000-000-0000"));
        assertTrue(Profile.matchPhoneNumberFormat("000 000 0000"));
        assertTrue(Profile.matchPhoneNumberFormat("0000000000"));
        assertFalse(Profile.matchPhoneNumberFormat("000 A00-0000"));
        assertFalse(Profile.matchPhoneNumberFormat("00 000-0000"));
        assertFalse(Profile.matchPhoneNumberFormat("000 00-0000"));
        assertFalse(Profile.matchPhoneNumberFormat("000 000-000"));
        assertFalse(Profile.matchPhoneNumberFormat(""));
    }

    void matchEmailFormatTest() {
        assertTrue(Profile.matchEmailFormat("something@something.smth"));
        assertTrue(Profile.matchEmailFormat("JoeSchmo@gmail.com"));
        assertTrue(Profile.matchEmailFortmat("GBurdell27@gatech.edu"));
        assertTrue(Profile.matchEmailformat("AshKetchum@GottaCatchemAll.net"));
        assertTrue(Profile.matchEmailFormat("Anemail@awebsite.com"));
        assertFalse(Profile.matchEmailFormat("JoeSchmo@.com"));
        assertFalse(Profile.matchEmailFormat("JoeSchmogmail.com"));
        assertFalse(Profile.matchEmailFormat("something@something"));
        assertFalse(Profile.matchEmailFormat("something@something."));
        assertFalse(Profile.matchEmailFormat(""));
    }
}
