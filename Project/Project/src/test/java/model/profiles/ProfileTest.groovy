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
}
