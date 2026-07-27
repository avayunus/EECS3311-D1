package scheduler.randoop;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest0 {

    public static boolean debug = false;

    @Test
    public void test001() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test001");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.register(bookingObserver1);
        scheduler.strategy.PricingStrategy pricingStrategy8 = null;
        scheduler.model.Booking booking9 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy8);
        scheduler.strategy.PricingStrategy pricingStrategy10 = null;
        booking9.setPricingStrategy(pricingStrategy10);
        // The following exception was thrown during execution in test generation
        try {
            boolean boolean12 = bookingManager0.addBooking(booking9);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalStateException; message: BookingManager.initialize(repo, rules) must be called before use.");
        } catch (java.lang.IllegalStateException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
    }

    @Test
    public void test002() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test002");
        scheduler.model.BookingFactory bookingFactory0 = new scheduler.model.BookingFactory();
    }

    @Test
    public void test003() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test003");
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy0 = new scheduler.strategy.PartnerPricingStrategy();
        double double1 = partnerPricingStrategy0.getHourlyRate();
        java.lang.Class<?> wildcardClass2 = partnerPricingStrategy0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double1 + "' != '" + 50.0d + "'", double1 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass2);
    }

    @Test
    public void test004() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test004");
        scheduler.strategy.PricingStrategy pricingStrategy5 = null;
        scheduler.model.Booking booking6 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy5);
        scheduler.strategy.PricingStrategy pricingStrategy7 = null;
        booking6.setPricingStrategy(pricingStrategy7);
        java.lang.String str9 = booking6.getRoomId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "hi!" + "'", str9.equals("hi!"));
    }

    @Test
    public void test005() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test005");
        // The following exception was thrown during execution in test generation
        try {
            scheduler.model.TimeSlot timeSlot2 = new scheduler.model.TimeSlot(10, (int) (short) 1);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: endHour must be after startHour (got 10-1)");
        } catch (java.lang.IllegalArgumentException e) {
        // Expected exception.
        }
    }

    @Test
    public void test006() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test006");
        scheduler.rules.NoOverlapRule noOverlapRule0 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy6 = null;
        scheduler.model.Booking booking7 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy6);
        scheduler.booking.BookingManager bookingManager8 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList9 = bookingManager8.getBookings();
        boolean boolean10 = noOverlapRule0.isAllowed(booking7, bookingList9);
        java.lang.String str11 = booking7.toString();
        java.lang.String str12 = booking7.getUserId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]" + "'", str11.equals("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
    }

    @Test
    public void test007() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test007");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getAccountType();
        java.lang.String str8 = user6.getAccountType();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "" + "'", str8.equals(""));
    }

    @Test
    public void test008() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test008");
        scheduler.strategy.PricingStrategy pricingStrategy5 = null;
        scheduler.model.Booking booking6 = new scheduler.model.Booking("", "hi!", "Booking[ room=hi! user= 52-0]", 10, 0, pricingStrategy5);
        java.lang.Class<?> wildcardClass7 = booking6.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test009() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test009");
        scheduler.rules.NoOverlapRule noOverlapRule0 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository1 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList2 = inMemoryBookingRepository1.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy8 = null;
        scheduler.model.Booking booking9 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy8);
        scheduler.strategy.PricingStrategy pricingStrategy10 = null;
        booking9.setPricingStrategy(pricingStrategy10);
        java.lang.String str12 = booking9.toString();
        inMemoryBookingRepository1.save(booking9);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository14 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList15 = inMemoryBookingRepository14.findAll();
        boolean boolean16 = noOverlapRule0.isAllowed(booking9, bookingList15);
        // The following exception was thrown during execution in test generation
        try {
            double double17 = booking9.calculateTotalCost();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"scheduler.strategy.PricingStrategy.calculateCost(int)\" because \"this.pricingStrategy\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str12.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
    }

    @Test
    public void test010() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test010");
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy10 = new scheduler.strategy.PartnerPricingStrategy();
        double double12 = partnerPricingStrategy10.calculateCost((int) '4');
        double double14 = partnerPricingStrategy10.calculateCost((int) (byte) -1);
        scheduler.model.Booking booking15 = scheduler.model.BookingFactory.createBooking("hi!", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) '#', (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy10);
        scheduler.model.Booking booking16 = scheduler.model.BookingFactory.createBooking("User[  type= verified=true]", "User[  type= verified=true]", "hi!", (int) (byte) 10, (int) 'a', (scheduler.strategy.PricingStrategy) partnerPricingStrategy10);
        double double17 = partnerPricingStrategy10.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 2600.0d + "'", double12 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + (-50.0d) + "'", double14 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double17 + "' != '" + 50.0d + "'", double17 == 50.0d);
    }

    @Test
    public void test011() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test011");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule18 = new scheduler.rules.NoOverlapRule();
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository17, (scheduler.rules.IConflictRules) noOverlapRule18);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository20 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList21 = inMemoryBookingRepository20.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy27 = null;
        scheduler.model.Booking booking28 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy27);
        scheduler.strategy.PricingStrategy pricingStrategy29 = null;
        booking28.setPricingStrategy(pricingStrategy29);
        java.lang.String str31 = booking28.toString();
        inMemoryBookingRepository20.save(booking28);
        boolean boolean33 = bookingManager0.addBooking(booking28);
        // The following exception was thrown during execution in test generation
        try {
            double double34 = booking28.getUpfrontDeposit();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"scheduler.strategy.PricingStrategy.getHourlyRate()\" because \"this.pricingStrategy\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str31 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str31.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
    }

    @Test
    public void test012() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test012");
        scheduler.rules.NoOverlapRule noOverlapRule0 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy6 = null;
        scheduler.model.Booking booking7 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy6);
        scheduler.booking.BookingManager bookingManager8 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList9 = bookingManager8.getBookings();
        boolean boolean10 = noOverlapRule0.isAllowed(booking7, bookingList9);
        int int11 = booking7.getEndHour();
        java.lang.String str12 = booking7.getRoomId();
        int int13 = booking7.getEndHour();
        // The following exception was thrown during execution in test generation
        try {
            double double14 = booking7.calculateTotalCost();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"scheduler.strategy.PricingStrategy.calculateCost(int)\" because \"this.pricingStrategy\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + (-1) + "'", int11 == (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "hi!" + "'", str12.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + (-1) + "'", int13 == (-1));
    }

    @Test
    public void test013() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test013");
        scheduler.model.User user6 = new scheduler.model.User("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "35-100", "35-100", true);
        int int7 = user6.getHourlyRate();
        boolean boolean8 = user6.isVerified();
        java.lang.String str9 = user6.getEmail();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 50 + "'", int7 == 50);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]" + "'", str9.equals("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]"));
    }

    @Test
    public void test014() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test014");
        scheduler.model.TimeSlot timeSlot2 = new scheduler.model.TimeSlot((int) '#', (int) (short) 100);
        int int3 = timeSlot2.getStartHour();
        java.lang.String str4 = timeSlot2.toString();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 35 + "'", int3 == 35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "35-100" + "'", str4.equals("35-100"));
    }

    @Test
    public void test015() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test015");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy5 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking6 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy5);
        double double7 = staffPricingStrategy5.getHourlyRate();
        double double8 = staffPricingStrategy5.getHourlyRate();
        double double10 = staffPricingStrategy5.calculateCost(1);
        double double12 = staffPricingStrategy5.calculateCost((int) (byte) 1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double7 + "' != '" + 40.0d + "'", double7 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 40.0d + "'", double8 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 40.0d + "'", double10 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 40.0d + "'", double12 == 40.0d);
    }

    @Test
    public void test016() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test016");
        java.lang.Object obj0 = new java.lang.Object();
        java.lang.Class<?> wildcardClass1 = obj0.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass1);
    }

    @Test
    public void test017() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test017");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy9 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking10 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy9);
        double double11 = staffPricingStrategy9.getHourlyRate();
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy9);
        java.lang.String str13 = booking12.getUserId();
        java.lang.String str14 = booking12.toString();
        java.lang.String str15 = booking12.getId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 40.0d + "'", double11 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "" + "'", str13.equals(""));
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertTrue("'" + str14 + "' != '" + "Booking[b-aa890e84 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]" + "'", str14.equals("Booking[b-aa890e84 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]"));
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertTrue("'" + str15 + "' != '" + "b-aa890e84" + "'", str15.equals("b-aa890e84"));
    }

    @Test
    public void test018() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test018");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.model.Booking booking4 = bookingManager0.findById("");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy10 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking11 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy10);
        boolean boolean12 = bookingManager0.addBooking(booking11);
        bookingManager0.notifyObservers();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertNull(booking4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
    }

    @Test
    public void test019() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test019");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.model.Booking booking4 = bookingManager0.findById("");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy10 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking11 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy10);
        boolean boolean12 = bookingManager0.addBooking(booking11);
        double double13 = booking11.calculateTotalCost();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertNull(booking4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + (-1800.0d) + "'", double13 == (-1800.0d));
    }

    @Test
    public void test020() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test020");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.model.Booking booking4 = bookingManager0.findById("");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy10 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking11 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy10);
        boolean boolean12 = bookingManager0.addBooking(booking11);
        double double13 = booking11.getUpfrontDeposit();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertNull(booking4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + 40.0d + "'", double13 == 40.0d);
    }

    @Test
    public void test021() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test021");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule18 = new scheduler.rules.NoOverlapRule();
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository17, (scheduler.rules.IConflictRules) noOverlapRule18);
        inMemoryBookingRepository17.delete("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
    }

    @Test
    public void test022() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test022");
        scheduler.rules.NoOverlapRule noOverlapRule0 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository1 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList2 = inMemoryBookingRepository1.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy8 = null;
        scheduler.model.Booking booking9 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy8);
        scheduler.strategy.PricingStrategy pricingStrategy10 = null;
        booking9.setPricingStrategy(pricingStrategy10);
        java.lang.String str12 = booking9.toString();
        inMemoryBookingRepository1.save(booking9);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository14 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList15 = inMemoryBookingRepository14.findAll();
        boolean boolean16 = noOverlapRule0.isAllowed(booking9, bookingList15);
        scheduler.rules.NoOverlapRule noOverlapRule17 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository18 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList19 = inMemoryBookingRepository18.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy25 = null;
        scheduler.model.Booking booking26 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy25);
        scheduler.strategy.PricingStrategy pricingStrategy27 = null;
        booking26.setPricingStrategy(pricingStrategy27);
        java.lang.String str29 = booking26.toString();
        inMemoryBookingRepository18.save(booking26);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository31 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList32 = inMemoryBookingRepository31.findAll();
        boolean boolean33 = noOverlapRule17.isAllowed(booking26, bookingList32);
        scheduler.rules.NoOverlapRule noOverlapRule34 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy40 = null;
        scheduler.model.Booking booking41 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy40);
        scheduler.booking.BookingManager bookingManager42 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList43 = bookingManager42.getBookings();
        boolean boolean44 = noOverlapRule34.isAllowed(booking41, bookingList43);
        boolean boolean45 = noOverlapRule0.isAllowed(booking26, bookingList43);
        java.lang.String str46 = booking26.getRoomId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str12.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList19);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str29 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str29.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList32);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList43);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + true + "'", boolean44 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + true + "'", boolean45 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str46 + "' != '" + "hi!" + "'", str46.equals("hi!"));
    }

    @Test
    public void test023() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test023");
        scheduler.model.TimeSlot timeSlot2 = new scheduler.model.TimeSlot((int) '#', (int) (short) 100);
        java.lang.String str3 = timeSlot2.toString();
        java.lang.String str4 = timeSlot2.toString();
        int int5 = timeSlot2.getEndHour();
        int int6 = timeSlot2.getStartHour();
        java.lang.Class<?> wildcardClass7 = timeSlot2.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "35-100" + "'", str3.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "35-100" + "'", str4.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 35 + "'", int6 == 35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass7);
    }

    @Test
    public void test024() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test024");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getAccountType();
        java.lang.String str10 = user6.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "hi!" + "'", str10.equals("hi!"));
    }

    @Test
    public void test025() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test025");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy9 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking10 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy9);
        double double11 = staffPricingStrategy9.getHourlyRate();
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy9);
        java.lang.String str13 = booking12.getUserId();
        java.lang.String str14 = booking12.toString();
        scheduler.strategy.PricingStrategy pricingStrategy20 = null;
        scheduler.model.Booking booking21 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy20);
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy22 = new scheduler.strategy.PartnerPricingStrategy();
        double double24 = partnerPricingStrategy22.calculateCost((int) '4');
        booking21.setPricingStrategy((scheduler.strategy.PricingStrategy) partnerPricingStrategy22);
        booking12.setPricingStrategy((scheduler.strategy.PricingStrategy) partnerPricingStrategy22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 40.0d + "'", double11 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "" + "'", str13.equals(""));
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertTrue("'" + str14 + "' != '" + "Booking[b-62cf4af2 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]" + "'", str14.equals("Booking[b-62cf4af2 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double24 + "' != '" + 2600.0d + "'", double24 == 2600.0d);
    }

    @Test
    public void test026() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test026");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        java.util.List<scheduler.model.Booking> bookingList17 = inMemoryBookingRepository3.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy23 = null;
        scheduler.model.Booking booking24 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy23);
        scheduler.strategy.PricingStrategy pricingStrategy25 = null;
        booking24.setPricingStrategy(pricingStrategy25);
        java.lang.String str27 = booking24.toString();
        inMemoryBookingRepository3.save(booking24);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str27 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str27.equals("Booking[ room=hi! user= 52-0]"));
    }

    @Test
    public void test027() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test027");
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy5 = new scheduler.strategy.PartnerPricingStrategy();
        double double7 = partnerPricingStrategy5.calculateCost((int) '4');
        scheduler.model.Booking booking8 = new scheduler.model.Booking("35-100", "hi!", "", (int) (byte) 0, (int) ' ', (scheduler.strategy.PricingStrategy) partnerPricingStrategy5);
        double double9 = partnerPricingStrategy5.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double7 + "' != '" + 2600.0d + "'", double7 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 50.0d + "'", double9 == 50.0d);
    }

    @Test
    public void test028() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test028");
        // The following exception was thrown during execution in test generation
        try {
            scheduler.model.TimeSlot timeSlot2 = new scheduler.model.TimeSlot(0, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: endHour must be after startHour (got 0-0)");
        } catch (java.lang.IllegalArgumentException e) {
        // Expected exception.
        }
    }

    @Test
    public void test029() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test029");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getOrgOrStudentId();
        java.lang.String str10 = user6.getPassword();
        java.lang.String str11 = user6.getId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "hi!" + "'", str10.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "" + "'", str11.equals(""));
    }

    @Test
    public void test030() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test030");
        scheduler.strategy.PricingStrategy pricingStrategy5 = null;
        scheduler.model.Booking booking6 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy5);
        java.lang.String str7 = booking6.getUserId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
    }

    @Test
    public void test031() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test031");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy10 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking11 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy10);
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("User[  type= verified=true]", "35-100", "", 50, (int) (short) 100, (scheduler.strategy.PricingStrategy) staffPricingStrategy10);
        java.lang.String str13 = booking12.toString();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "Booking[User[  type= verified=true] room=35-100 user= 50-100]" + "'", str13.equals("Booking[User[  type= verified=true] room=35-100 user= 50-100]"));
    }

    @Test
    public void test032() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test032");
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy9 = new scheduler.strategy.PartnerPricingStrategy();
        double double11 = partnerPricingStrategy9.calculateCost((int) '4');
        double double13 = partnerPricingStrategy9.calculateCost((int) (byte) -1);
        scheduler.model.Booking booking14 = scheduler.model.BookingFactory.createBooking("hi!", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) '#', (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy9);
        double double16 = partnerPricingStrategy9.calculateCost((int) (short) -1);
        scheduler.model.Booking booking17 = scheduler.model.BookingFactory.createBooking("Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "Booking[ room=hi! user= 52-0]", 35, (int) (short) 100, (scheduler.strategy.PricingStrategy) partnerPricingStrategy9);
        int int18 = booking17.getEndHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 2600.0d + "'", double11 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + (-50.0d) + "'", double13 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + (-50.0d) + "'", double16 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 100 + "'", int18 == 100);
    }

    @Test
    public void test033() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test033");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getAccountType();
        scheduler.strategy.PricingStrategy pricingStrategy10 = user6.getPricingStrategy();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy10);
    }

    @Test
    public void test034() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test034");
        scheduler.model.TimeSlot timeSlot2 = new scheduler.model.TimeSlot((int) (short) 1, (int) (byte) 100);
    }

    @Test
    public void test035() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test035");
        scheduler.strategy.PricingStrategy pricingStrategy5 = null;
        scheduler.model.Booking booking6 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy5);
        scheduler.strategy.PricingStrategy pricingStrategy7 = null;
        booking6.setPricingStrategy(pricingStrategy7);
        java.lang.String str9 = booking6.toString();
        java.lang.String str10 = booking6.getRoomId();
        // The following exception was thrown during execution in test generation
        try {
            double double11 = booking6.calculateTotalCost();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"scheduler.strategy.PricingStrategy.calculateCost(int)\" because \"this.pricingStrategy\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str9.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "hi!" + "'", str10.equals("hi!"));
    }

    @Test
    public void test036() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test036");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getId();
        java.lang.String str10 = user6.toString();
        java.lang.String str11 = user6.getOrgOrStudentId();
        java.lang.String str12 = user6.toString();
        scheduler.strategy.PricingStrategy pricingStrategy13 = user6.getPricingStrategy();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "User[  type= verified=true]" + "'", str10.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "" + "'", str11.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "User[  type= verified=true]" + "'", str12.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy13);
    }

    @Test
    public void test037() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test037");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        boolean boolean7 = room5.isBookable();
        int int8 = room5.getCapacity();
        int int9 = room5.getCapacity();
        java.lang.String str10 = room5.getName();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 10 + "'", int8 == 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 10 + "'", int9 == 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "" + "'", str10.equals(""));
    }

    @Test
    public void test038() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test038");
        scheduler.strategy.PricingStrategy pricingStrategy5 = null;
        scheduler.model.Booking booking6 = new scheduler.model.Booking("Booking[ room=hi! user= 52-0]", "hi!", "hi!", (int) (short) -1, (int) (short) 10, pricingStrategy5);
        java.lang.String str7 = booking6.getId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str7.equals("Booking[ room=hi! user= 52-0]"));
    }

    @Test
    public void test039() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test039");
        scheduler.model.User user6 = new scheduler.model.User("Booking[ room=hi! user= 52-0]", "hi!", "Booking[ room=hi! user= 52-0]", "Booking[ room=hi! user= 52-0]", "", true);
        scheduler.strategy.PricingStrategy pricingStrategy7 = user6.getPricingStrategy();
        java.lang.String str8 = user6.getOrgOrStudentId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "" + "'", str8.equals(""));
    }

    @Test
    public void test040() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test040");
        scheduler.model.User user6 = new scheduler.model.User("35-100", "Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]", "hi!", "Booking[b-aa890e84 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "", false);
        java.lang.String str7 = user6.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "hi!" + "'", str7.equals("hi!"));
    }

    @Test
    public void test041() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test041");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy26 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking27 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy26);
        double double28 = staffPricingStrategy26.getHourlyRate();
        scheduler.model.Booking booking29 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy26);
        java.lang.String str30 = booking29.getUserId();
        inMemoryBookingRepository3.save(booking29);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking27);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double28 + "' != '" + 40.0d + "'", double28 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking29);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str30 + "' != '" + "" + "'", str30.equals(""));
    }

    @Test
    public void test042() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test042");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        boolean boolean4 = bookingManager0.cancelBooking("Booking[ room=hi! user= 52-0]");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean4 + "' != '" + false + "'", boolean4 == false);
    }

    @Test
    public void test043() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test043");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        boolean boolean7 = room5.isBookable();
        int int8 = room5.getCapacity();
        java.lang.String str9 = room5.getBuilding();
        java.lang.String str10 = room5.getStatus();
        java.lang.String str11 = room5.getName();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 10 + "'", int8 == 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "hi!" + "'", str9.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "35-100" + "'", str10.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "" + "'", str11.equals(""));
    }

    @Test
    public void test044() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test044");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.booking.BookingObserver bookingObserver17 = null;
        bookingManager0.unregister(bookingObserver17);
        scheduler.model.Booking booking20 = bookingManager0.findById("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]");
        bookingManager0.notifyObservers();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(booking20);
    }

    @Test
    public void test045() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test045");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.register(bookingObserver1);
        scheduler.booking.BookingObserver bookingObserver3 = null;
        bookingManager0.register(bookingObserver3);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository5 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList6 = inMemoryBookingRepository5.findAll();
        scheduler.booking.BookingManager bookingManager7 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver8 = null;
        bookingManager7.unregister(bookingObserver8);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository10 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList11 = inMemoryBookingRepository10.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule12 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy18 = null;
        scheduler.model.Booking booking19 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy18);
        scheduler.booking.BookingManager bookingManager20 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList21 = bookingManager20.getBookings();
        boolean boolean22 = noOverlapRule12.isAllowed(booking19, bookingList21);
        bookingManager7.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository10, (scheduler.rules.IConflictRules) noOverlapRule12);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository24 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule25 = new scheduler.rules.NoOverlapRule();
        bookingManager7.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository24, (scheduler.rules.IConflictRules) noOverlapRule25);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository5, (scheduler.rules.IConflictRules) noOverlapRule25);
        bookingManager0.notifyObservers();
        boolean boolean30 = bookingManager0.cancelBooking("Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking19);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean30 + "' != '" + false + "'", boolean30 == false);
    }

    @Test
    public void test046() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test046");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        java.lang.String str7 = room5.getName();
        boolean boolean8 = room5.isBookable();
        java.lang.String str9 = room5.toString();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str9.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
    }

    @Test
    public void test047() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test047");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy5 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking6 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy5);
        double double7 = staffPricingStrategy5.getHourlyRate();
        double double9 = staffPricingStrategy5.calculateCost((int) (short) 0);
        double double11 = staffPricingStrategy5.calculateCost(0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double7 + "' != '" + 40.0d + "'", double7 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 0.0d + "'", double9 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 0.0d + "'", double11 == 0.0d);
    }

    @Test
    public void test048() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test048");
        scheduler.strategy.PricingStrategy pricingStrategy5 = null;
        scheduler.model.Booking booking6 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy5);
        scheduler.strategy.PricingStrategy pricingStrategy7 = null;
        booking6.setPricingStrategy(pricingStrategy7);
        java.lang.String str9 = booking6.getUserId();
        // The following exception was thrown during execution in test generation
        try {
            double double10 = booking6.calculateTotalCost();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"scheduler.strategy.PricingStrategy.calculateCost(int)\" because \"this.pricingStrategy\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
    }

    @Test
    public void test049() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test049");
        // The following exception was thrown during execution in test generation
        try {
            scheduler.model.TimeSlot timeSlot2 = new scheduler.model.TimeSlot((int) (short) 0, (int) (short) 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: endHour must be after startHour (got 0-0)");
        } catch (java.lang.IllegalArgumentException e) {
        // Expected exception.
        }
    }

    @Test
    public void test050() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test050");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.register(bookingObserver1);
        scheduler.booking.BookingObserver bookingObserver3 = null;
        bookingManager0.unregister(bookingObserver3);
        boolean boolean6 = bookingManager0.cancelBooking("Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test051() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test051");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy9 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking10 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy9);
        double double11 = staffPricingStrategy9.getHourlyRate();
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy9);
        java.lang.String str13 = booking12.getUserId();
        java.lang.String str14 = booking12.getUserId();
        double double15 = booking12.calculateTotalCost();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 40.0d + "'", double11 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "" + "'", str13.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str14 + "' != '" + "" + "'", str14.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double15 + "' != '" + 1360.0d + "'", double15 == 1360.0d);
    }

    @Test
    public void test052() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test052");
        scheduler.model.User user6 = new scheduler.model.User("Booking[ room=hi! user= 52-0]", "hi!", "Booking[ room=hi! user= 52-0]", "Booking[ room=hi! user= 52-0]", "", true);
        java.lang.String str7 = user6.getOrgOrStudentId();
        java.lang.String str8 = user6.getId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str8.equals("Booking[ room=hi! user= 52-0]"));
    }

    @Test
    public void test053() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test053");
        scheduler.model.Room room5 = new scheduler.model.Room("User[  type= verified=true]", "Booking[User[  type= verified=true] room=35-100 user= 50-100]", (int) (byte) 1, "Booking[b-62cf4af2 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "User[  type= verified=true]");
    }

    @Test
    public void test054() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test054");
        scheduler.model.User user6 = new scheduler.model.User("Booking[User[  type= verified=true] room=35-100 user= 50-100]", "Booking[ room=hi! user= 52-0]", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "User[  type= verified=true]", "Booking[b-62cf4af2 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", false);
    }

    @Test
    public void test055() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test055");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.model.Booking booking4 = bookingManager0.findById("");
        java.util.List<scheduler.model.Booking> bookingList5 = bookingManager0.getBookings();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(booking4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList5);
    }

    @Test
    public void test056() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test056");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule18 = new scheduler.rules.NoOverlapRule();
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository17, (scheduler.rules.IConflictRules) noOverlapRule18);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository20 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList21 = inMemoryBookingRepository20.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy27 = null;
        scheduler.model.Booking booking28 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy27);
        scheduler.strategy.PricingStrategy pricingStrategy29 = null;
        booking28.setPricingStrategy(pricingStrategy29);
        java.lang.String str31 = booking28.toString();
        inMemoryBookingRepository20.save(booking28);
        boolean boolean33 = bookingManager0.addBooking(booking28);
        java.lang.String str34 = booking28.toString();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str31 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str31.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str34 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str34.equals("Booking[ room=hi! user= 52-0]"));
    }

    @Test
    public void test057() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test057");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", (int) (short) -1, "Booking[ room=hi! user= 52-0]", "hi!");
    }

    @Test
    public void test058() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test058");
        scheduler.model.User user6 = new scheduler.model.User("Booking[ room=hi! user= 52-0]", "hi!", "Booking[ room=hi! user= 52-0]", "Booking[ room=hi! user= 52-0]", "", true);
        java.lang.String str7 = user6.getAccountType();
        java.lang.String str8 = user6.getOrgOrStudentId();
        scheduler.strategy.PricingStrategy pricingStrategy9 = user6.getPricingStrategy();
        java.lang.String str10 = user6.getOrgOrStudentId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str7.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "" + "'", str8.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "" + "'", str10.equals(""));
    }

    @Test
    public void test059() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test059");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.model.Booking booking4 = bookingManager0.findById("");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy10 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking11 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy10);
        boolean boolean12 = bookingManager0.addBooking(booking11);
        java.util.List<scheduler.model.Booking> bookingList13 = bookingManager0.getBookings();
        scheduler.model.Booking booking15 = bookingManager0.findById("Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertNull(booking4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(booking15);
    }

    @Test
    public void test060() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test060");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy13 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking14 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy13);
        double double15 = staffPricingStrategy13.getHourlyRate();
        scheduler.model.Booking booking16 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy13);
        scheduler.model.Booking booking17 = scheduler.model.BookingFactory.createBooking("hi!", "User[  type= verified=true]", (int) '#', (int) (short) 10, (scheduler.strategy.PricingStrategy) staffPricingStrategy13);
        java.lang.String str18 = booking17.getUserId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double15 + "' != '" + 40.0d + "'", double15 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str18 + "' != '" + "User[  type= verified=true]" + "'", str18.equals("User[  type= verified=true]"));
    }

    @Test
    public void test061() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test061");
        scheduler.strategy.PricingStrategy pricingStrategy5 = null;
        scheduler.model.Booking booking6 = new scheduler.model.Booking("Booking[ room=hi! user= 52-0]", "hi!", "hi!", (int) (short) -1, (int) (short) 10, pricingStrategy5);
        java.lang.String str7 = booking6.getRoomId();
        java.lang.Class<?> wildcardClass8 = booking6.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "hi!" + "'", str7.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass8);
    }

    @Test
    public void test062() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test062");
        scheduler.rules.NoOverlapRule noOverlapRule0 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository1 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList2 = inMemoryBookingRepository1.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy8 = null;
        scheduler.model.Booking booking9 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy8);
        scheduler.strategy.PricingStrategy pricingStrategy10 = null;
        booking9.setPricingStrategy(pricingStrategy10);
        java.lang.String str12 = booking9.toString();
        inMemoryBookingRepository1.save(booking9);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository14 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList15 = inMemoryBookingRepository14.findAll();
        boolean boolean16 = noOverlapRule0.isAllowed(booking9, bookingList15);
        scheduler.rules.NoOverlapRule noOverlapRule17 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository18 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList19 = inMemoryBookingRepository18.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy25 = null;
        scheduler.model.Booking booking26 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy25);
        scheduler.strategy.PricingStrategy pricingStrategy27 = null;
        booking26.setPricingStrategy(pricingStrategy27);
        java.lang.String str29 = booking26.toString();
        inMemoryBookingRepository18.save(booking26);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository31 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList32 = inMemoryBookingRepository31.findAll();
        boolean boolean33 = noOverlapRule17.isAllowed(booking26, bookingList32);
        scheduler.rules.NoOverlapRule noOverlapRule34 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy40 = null;
        scheduler.model.Booking booking41 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy40);
        scheduler.booking.BookingManager bookingManager42 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList43 = bookingManager42.getBookings();
        boolean boolean44 = noOverlapRule34.isAllowed(booking41, bookingList43);
        boolean boolean45 = noOverlapRule0.isAllowed(booking26, bookingList43);
        scheduler.strategy.PricingStrategy pricingStrategy51 = null;
        scheduler.model.Booking booking52 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy51);
        int int53 = booking52.getEndHour();
        scheduler.booking.BookingManager bookingManager54 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver55 = null;
        bookingManager54.register(bookingObserver55);
        scheduler.model.Booking booking58 = bookingManager54.findById("hi!");
        java.util.List<scheduler.model.Booking> bookingList59 = bookingManager54.getBookings();
        boolean boolean60 = noOverlapRule0.isAllowed(booking52, bookingList59);
        java.lang.String str61 = booking52.getUserId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str12.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList19);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str29 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str29.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList32);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList43);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + true + "'", boolean44 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + true + "'", boolean45 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking52);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int53 + "' != '" + (-1) + "'", int53 == (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager54);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(booking58);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList59);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean60 + "' != '" + true + "'", boolean60 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str61 + "' != '" + "" + "'", str61.equals(""));
    }

    @Test
    public void test063() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test063");
        scheduler.model.User user16 = new scheduler.model.User("Booking[ room=hi! user= 52-0]", "hi!", "Booking[ room=hi! user= 52-0]", "Booking[ room=hi! user= 52-0]", "", true);
        java.lang.String str17 = user16.getAccountType();
        java.lang.String str18 = user16.getOrgOrStudentId();
        scheduler.strategy.PricingStrategy pricingStrategy19 = user16.getPricingStrategy();
        scheduler.model.Booking booking20 = new scheduler.model.Booking("", "Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]", 100, 0, pricingStrategy19);
        scheduler.model.Booking booking21 = scheduler.model.BookingFactory.createBooking("Booking[b-62cf4af2 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "35-100", "", 0, 0, pricingStrategy19);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str17 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str17.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str18 + "' != '" + "" + "'", str18.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy19);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking21);
    }

    @Test
    public void test064() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test064");
        scheduler.rules.NoOverlapRule noOverlapRule0 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy6 = null;
        scheduler.model.Booking booking7 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy6);
        scheduler.booking.BookingManager bookingManager8 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList9 = bookingManager8.getBookings();
        boolean boolean10 = noOverlapRule0.isAllowed(booking7, bookingList9);
        int int11 = booking7.getEndHour();
        java.lang.String str12 = booking7.getRoomId();
        int int13 = booking7.getEndHour();
        int int14 = booking7.getStartHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + (-1) + "'", int11 == (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "hi!" + "'", str12.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int13 + "' != '" + (-1) + "'", int13 == (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int14 + "' != '" + (-1) + "'", int14 == (-1));
    }

    @Test
    public void test065() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test065");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getAccountType();
        java.lang.String str10 = user6.getOrgOrStudentId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "" + "'", str10.equals(""));
    }

    @Test
    public void test066() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test066");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.getName();
        java.lang.String str7 = room5.getId();
        java.lang.String str8 = room5.getStatus();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "" + "'", str6.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str7.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "35-100" + "'", str8.equals("35-100"));
    }

    @Test
    public void test067() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test067");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy10 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking11 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy10);
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("User[  type= verified=true]", "35-100", "", 50, (int) (short) 100, (scheduler.strategy.PricingStrategy) staffPricingStrategy10);
        double double13 = staffPricingStrategy10.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + 40.0d + "'", double13 == 40.0d);
    }

    @Test
    public void test068() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test068");
        scheduler.strategy.PricingStrategy pricingStrategy5 = null;
        scheduler.model.Booking booking6 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy5);
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy7 = new scheduler.strategy.PartnerPricingStrategy();
        double double9 = partnerPricingStrategy7.calculateCost((int) '4');
        booking6.setPricingStrategy((scheduler.strategy.PricingStrategy) partnerPricingStrategy7);
        double double11 = partnerPricingStrategy7.getHourlyRate();
        double double13 = partnerPricingStrategy7.calculateCost((int) '4');
        double double15 = partnerPricingStrategy7.calculateCost(0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 2600.0d + "'", double9 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 50.0d + "'", double11 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + 2600.0d + "'", double13 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double15 + "' != '" + 0.0d + "'", double15 == 0.0d);
    }

    @Test
    public void test069() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test069");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getEmail();
        java.lang.String str10 = user6.toString();
        java.lang.String str11 = user6.getEmail();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "User[  type= verified=true]" + "'", str10.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "" + "'", str11.equals(""));
    }

    @Test
    public void test070() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test070");
        scheduler.model.User user6 = new scheduler.model.User("Booking[ room=hi! user= 52-0]", "hi!", "Booking[ room=hi! user= 52-0]", "Booking[ room=hi! user= 52-0]", "", true);
        java.lang.String str7 = user6.getAccountType();
        java.lang.String str8 = user6.getAccountType();
        java.lang.String str9 = user6.getId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str7.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str8.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str9.equals("Booking[ room=hi! user= 52-0]"));
    }

    @Test
    public void test071() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test071");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.register(bookingObserver1);
        scheduler.booking.BookingObserver bookingObserver3 = null;
        bookingManager0.unregister(bookingObserver3);
        scheduler.booking.BookingObserver bookingObserver5 = null;
        bookingManager0.register(bookingObserver5);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
    }

    @Test
    public void test072() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test072");
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy0 = new scheduler.strategy.PartnerPricingStrategy();
        double double2 = partnerPricingStrategy0.calculateCost((int) '4');
        double double4 = partnerPricingStrategy0.calculateCost((int) 'a');
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 2600.0d + "'", double2 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 4850.0d + "'", double4 == 4850.0d);
    }

    @Test
    public void test073() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test073");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getId();
        java.lang.String str10 = user6.toString();
        java.lang.String str11 = user6.toString();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "User[  type= verified=true]" + "'", str10.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "User[  type= verified=true]" + "'", str11.equals("User[  type= verified=true]"));
    }

    @Test
    public void test074() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test074");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getPassword();
        java.lang.String str10 = user6.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "hi!" + "'", str9.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "hi!" + "'", str10.equals("hi!"));
    }

    @Test
    public void test075() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test075");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule18 = new scheduler.rules.NoOverlapRule();
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository17, (scheduler.rules.IConflictRules) noOverlapRule18);
        boolean boolean21 = bookingManager0.cancelBooking("b-aa890e84");
        scheduler.model.Booking booking23 = bookingManager0.findById("Booking[b-aa890e84 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]");
        scheduler.strategy.PricingStrategy pricingStrategy29 = null;
        scheduler.model.Booking booking30 = new scheduler.model.Booking("Booking[ room=hi! user= 52-0]", "hi!", "hi!", (int) (short) -1, (int) (short) 10, pricingStrategy29);
        boolean boolean31 = bookingManager0.addBooking(booking30);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(booking23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + true + "'", boolean31 == true);
    }

    @Test
    public void test076() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test076");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        boolean boolean7 = room5.isBookable();
        java.lang.String str8 = room5.toString();
        java.lang.String str9 = room5.toString();
        int int10 = room5.getCapacity();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str8.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str9.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 10 + "'", int10 == 10);
    }

    @Test
    public void test077() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test077");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getOrgOrStudentId();
        java.lang.String str10 = user6.getPassword();
        java.lang.String str11 = user6.getEmail();
        java.lang.String str12 = user6.getId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "hi!" + "'", str10.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "" + "'", str11.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
    }

    @Test
    public void test078() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test078");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        boolean boolean7 = room5.isBookable();
        int int8 = room5.getCapacity();
        java.lang.Class<?> wildcardClass9 = room5.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 10 + "'", int8 == 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test079() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test079");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getAccountType();
        boolean boolean10 = user6.isVerified();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
    }

    @Test
    public void test080() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test080");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule18 = new scheduler.rules.NoOverlapRule();
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository17, (scheduler.rules.IConflictRules) noOverlapRule18);
        boolean boolean21 = bookingManager0.cancelBooking("User[  type= verified=true]");
        scheduler.strategy.PricingStrategy pricingStrategy27 = null;
        scheduler.model.Booking booking28 = new scheduler.model.Booking("", "hi!", "Booking[ room=hi! user= 52-0]", 10, 0, pricingStrategy27);
        boolean boolean29 = bookingManager0.addBooking(booking28);
        // The following exception was thrown during execution in test generation
        try {
            double double30 = booking28.getUpfrontDeposit();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"scheduler.strategy.PricingStrategy.getHourlyRate()\" because \"this.pricingStrategy\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean29 + "' != '" + true + "'", boolean29 == true);
    }

    @Test
    public void test081() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test081");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy13 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking14 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy13);
        double double15 = staffPricingStrategy13.getHourlyRate();
        scheduler.model.Booking booking16 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy13);
        scheduler.model.Booking booking17 = scheduler.model.BookingFactory.createBooking("hi!", "User[  type= verified=true]", (int) '#', (int) (short) 10, (scheduler.strategy.PricingStrategy) staffPricingStrategy13);
        double double19 = staffPricingStrategy13.calculateCost(100);
        double double20 = staffPricingStrategy13.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double15 + "' != '" + 40.0d + "'", double15 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double19 + "' != '" + 4000.0d + "'", double19 == 4000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double20 + "' != '" + 40.0d + "'", double20 == 40.0d);
    }

    @Test
    public void test082() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test082");
        scheduler.strategy.PricingStrategy pricingStrategy5 = null;
        scheduler.model.Booking booking6 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy5);
        scheduler.strategy.PricingStrategy pricingStrategy7 = null;
        booking6.setPricingStrategy(pricingStrategy7);
        java.lang.String str9 = booking6.toString();
        java.lang.String str10 = booking6.getId();
        int int11 = booking6.getStartHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str9.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "" + "'", str10.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 52 + "'", int11 == 52);
    }

    @Test
    public void test083() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test083");
        scheduler.strategy.PricingStrategy pricingStrategy5 = null;
        scheduler.model.Booking booking6 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy5);
        int int7 = booking6.getEndHour();
        java.lang.String str8 = booking6.getRoomId();
        java.lang.String str9 = booking6.getId();
        scheduler.strategy.StudentPricingStrategy studentPricingStrategy10 = new scheduler.strategy.StudentPricingStrategy();
        double double12 = studentPricingStrategy10.calculateCost(10);
        booking6.setPricingStrategy((scheduler.strategy.PricingStrategy) studentPricingStrategy10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str9.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 200.0d + "'", double12 == 200.0d);
    }

    @Test
    public void test084() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test084");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule18 = new scheduler.rules.NoOverlapRule();
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository17, (scheduler.rules.IConflictRules) noOverlapRule18);
        boolean boolean21 = bookingManager0.cancelBooking("User[  type= verified=true]");
        bookingManager0.notifyObservers();
        scheduler.booking.BookingManager bookingManager23 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver24 = null;
        bookingManager23.unregister(bookingObserver24);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository26 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList27 = inMemoryBookingRepository26.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule28 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy34 = null;
        scheduler.model.Booking booking35 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy34);
        scheduler.booking.BookingManager bookingManager36 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList37 = bookingManager36.getBookings();
        boolean boolean38 = noOverlapRule28.isAllowed(booking35, bookingList37);
        bookingManager23.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository26, (scheduler.rules.IConflictRules) noOverlapRule28);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository40 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList41 = inMemoryBookingRepository40.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy47 = null;
        scheduler.model.Booking booking48 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy47);
        scheduler.strategy.PricingStrategy pricingStrategy49 = null;
        booking48.setPricingStrategy(pricingStrategy49);
        java.lang.String str51 = booking48.toString();
        inMemoryBookingRepository40.save(booking48);
        inMemoryBookingRepository26.save(booking48);
        scheduler.rules.NoOverlapRule noOverlapRule54 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy60 = null;
        scheduler.model.Booking booking61 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy60);
        scheduler.booking.BookingManager bookingManager62 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList63 = bookingManager62.getBookings();
        boolean boolean64 = noOverlapRule54.isAllowed(booking61, bookingList63);
        java.lang.String str65 = booking61.toString();
        inMemoryBookingRepository26.save(booking61);
        boolean boolean67 = bookingManager0.addBooking(booking61);
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy77 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking78 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy77);
        double double79 = staffPricingStrategy77.getHourlyRate();
        scheduler.model.Booking booking80 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy77);
        booking61.setPricingStrategy((scheduler.strategy.PricingStrategy) staffPricingStrategy77);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList27);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager36);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList37);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + true + "'", boolean38 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str51 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str51.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking61);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager62);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList63);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean64 + "' != '" + true + "'", boolean64 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str65 + "' != '" + "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]" + "'", str65.equals("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean67 + "' != '" + true + "'", boolean67 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking78);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double79 + "' != '" + 40.0d + "'", double79 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking80);
    }

    @Test
    public void test085() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test085");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getId();
        java.lang.String str10 = user6.toString();
        boolean boolean11 = user6.isVerified();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "User[  type= verified=true]" + "'", str10.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean11 + "' != '" + true + "'", boolean11 == true);
    }

    @Test
    public void test086() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test086");
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy10 = new scheduler.strategy.PartnerPricingStrategy();
        double double12 = partnerPricingStrategy10.calculateCost((int) '4');
        double double14 = partnerPricingStrategy10.calculateCost((int) (byte) -1);
        scheduler.model.Booking booking15 = scheduler.model.BookingFactory.createBooking("hi!", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) '#', (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy10);
        scheduler.model.Booking booking16 = new scheduler.model.Booking("Booking[ room=hi! user= 52-0]", "35-100", "hi!", (int) (byte) 1, (int) (short) -1, (scheduler.strategy.PricingStrategy) partnerPricingStrategy10);
        int int17 = booking16.getEndHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 2600.0d + "'", double12 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + (-50.0d) + "'", double14 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + (-1) + "'", int17 == (-1));
    }

    @Test
    public void test087() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test087");
        scheduler.rules.NoOverlapRule noOverlapRule0 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository1 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList2 = inMemoryBookingRepository1.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy8 = null;
        scheduler.model.Booking booking9 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy8);
        scheduler.strategy.PricingStrategy pricingStrategy10 = null;
        booking9.setPricingStrategy(pricingStrategy10);
        java.lang.String str12 = booking9.toString();
        inMemoryBookingRepository1.save(booking9);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository14 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList15 = inMemoryBookingRepository14.findAll();
        boolean boolean16 = noOverlapRule0.isAllowed(booking9, bookingList15);
        int int17 = booking9.getEndHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str12.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
    }

    @Test
    public void test088() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test088");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[b-aa890e84 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "", (int) (byte) 10, "Booking[ room=hi! user= 52-0]", "Booking[b-aa890e84 room=Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35] user=35-100 35--1]");
    }

    @Test
    public void test089() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test089");
        scheduler.strategy.PricingStrategy pricingStrategy5 = null;
        scheduler.model.Booking booking6 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy5);
        int int7 = booking6.getEndHour();
        java.lang.String str8 = booking6.getRoomId();
        // The following exception was thrown during execution in test generation
        try {
            double double9 = booking6.calculateTotalCost();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"scheduler.strategy.PricingStrategy.calculateCost(int)\" because \"this.pricingStrategy\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
    }

    @Test
    public void test090() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test090");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getId();
        int int10 = user6.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 50 + "'", int10 == 50);
    }

    @Test
    public void test091() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test091");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.booking.BookingManager bookingManager17 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver18 = null;
        bookingManager17.unregister(bookingObserver18);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository20 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList21 = inMemoryBookingRepository20.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule22 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy28 = null;
        scheduler.model.Booking booking29 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy28);
        scheduler.booking.BookingManager bookingManager30 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList31 = bookingManager30.getBookings();
        boolean boolean32 = noOverlapRule22.isAllowed(booking29, bookingList31);
        bookingManager17.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository20, (scheduler.rules.IConflictRules) noOverlapRule22);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository34 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule35 = new scheduler.rules.NoOverlapRule();
        bookingManager17.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository34, (scheduler.rules.IConflictRules) noOverlapRule35);
        scheduler.strategy.PricingStrategy pricingStrategy41 = null;
        scheduler.model.Booking booking42 = scheduler.model.BookingFactory.createBooking("", "User[  type= verified=true]", 0, (int) (byte) 100, pricingStrategy41);
        inMemoryBookingRepository34.save(booking42);
        scheduler.rules.NoOverlapRule noOverlapRule44 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository45 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList46 = inMemoryBookingRepository45.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy52 = null;
        scheduler.model.Booking booking53 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy52);
        scheduler.strategy.PricingStrategy pricingStrategy54 = null;
        booking53.setPricingStrategy(pricingStrategy54);
        java.lang.String str56 = booking53.toString();
        inMemoryBookingRepository45.save(booking53);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository58 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList59 = inMemoryBookingRepository58.findAll();
        boolean boolean60 = noOverlapRule44.isAllowed(booking53, bookingList59);
        scheduler.rules.NoOverlapRule noOverlapRule61 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository62 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList63 = inMemoryBookingRepository62.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy69 = null;
        scheduler.model.Booking booking70 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy69);
        scheduler.strategy.PricingStrategy pricingStrategy71 = null;
        booking70.setPricingStrategy(pricingStrategy71);
        java.lang.String str73 = booking70.toString();
        inMemoryBookingRepository62.save(booking70);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository75 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList76 = inMemoryBookingRepository75.findAll();
        boolean boolean77 = noOverlapRule61.isAllowed(booking70, bookingList76);
        scheduler.rules.NoOverlapRule noOverlapRule78 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy84 = null;
        scheduler.model.Booking booking85 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy84);
        scheduler.booking.BookingManager bookingManager86 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList87 = bookingManager86.getBookings();
        boolean boolean88 = noOverlapRule78.isAllowed(booking85, bookingList87);
        boolean boolean89 = noOverlapRule44.isAllowed(booking70, bookingList87);
        boolean boolean90 = noOverlapRule5.isAllowed(booking42, bookingList87);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking29);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager30);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList31);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean32 + "' != '" + true + "'", boolean32 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList46);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str56 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str56.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList59);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean60 + "' != '" + true + "'", boolean60 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList63);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str73 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str73.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList76);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean77 + "' != '" + true + "'", boolean77 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking85);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager86);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList87);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean88 + "' != '" + true + "'", boolean88 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean89 + "' != '" + true + "'", boolean89 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean90 + "' != '" + true + "'", boolean90 == true);
    }

    @Test
    public void test092() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test092");
        scheduler.strategy.PricingStrategy pricingStrategy5 = null;
        scheduler.model.Booking booking6 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy5);
        scheduler.strategy.PricingStrategy pricingStrategy7 = null;
        booking6.setPricingStrategy(pricingStrategy7);
        java.lang.String str9 = booking6.toString();
        int int10 = booking6.getEndHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str9.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 0 + "'", int10 == 0);
    }

    @Test
    public void test093() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test093");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy5 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking6 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy5);
        double double7 = staffPricingStrategy5.getHourlyRate();
        double double8 = staffPricingStrategy5.getHourlyRate();
        double double9 = staffPricingStrategy5.getHourlyRate();
        double double11 = staffPricingStrategy5.calculateCost(52);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double7 + "' != '" + 40.0d + "'", double7 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 40.0d + "'", double8 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 40.0d + "'", double9 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 2080.0d + "'", double11 == 2080.0d);
    }

    @Test
    public void test094() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test094");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        boolean boolean7 = room5.isBookable();
        int int8 = room5.getCapacity();
        int int9 = room5.getCapacity();
        java.lang.String str10 = room5.toString();
        java.lang.String str11 = room5.toString();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 10 + "'", int8 == 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 10 + "'", int9 == 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str10.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str11.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
    }

    @Test
    public void test095() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test095");
        scheduler.model.User user6 = new scheduler.model.User("Booking[ room=hi! user= 52-0]", "hi!", "Booking[ room=hi! user= 52-0]", "Booking[ room=hi! user= 52-0]", "", true);
        java.lang.String str7 = user6.getAccountType();
        java.lang.String str8 = user6.getOrgOrStudentId();
        scheduler.strategy.PricingStrategy pricingStrategy9 = user6.getPricingStrategy();
        java.lang.Class<?> wildcardClass10 = user6.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str7.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "" + "'", str8.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass10);
    }

    @Test
    public void test096() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test096");
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy10 = new scheduler.strategy.PartnerPricingStrategy();
        double double12 = partnerPricingStrategy10.calculateCost((int) '4');
        scheduler.model.Booking booking13 = new scheduler.model.Booking("35-100", "hi!", "", (int) (byte) 0, (int) ' ', (scheduler.strategy.PricingStrategy) partnerPricingStrategy10);
        scheduler.model.Booking booking14 = scheduler.model.BookingFactory.createBooking("User[  type= verified=true]", "Booking[ room=hi! user= 52-0]", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", (int) (byte) -1, 50, (scheduler.strategy.PricingStrategy) partnerPricingStrategy10);
        double double15 = partnerPricingStrategy10.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 2600.0d + "'", double12 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double15 + "' != '" + 50.0d + "'", double15 == 50.0d);
    }

    @Test
    public void test097() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test097");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getEmail();
        java.lang.String str10 = user6.toString();
        scheduler.strategy.PricingStrategy pricingStrategy11 = user6.getPricingStrategy();
        java.lang.String str12 = user6.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "User[  type= verified=true]" + "'", str10.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "hi!" + "'", str12.equals("hi!"));
    }

    @Test
    public void test098() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test098");
        scheduler.model.User user6 = new scheduler.model.User("35-100", "Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]", "hi!", "Booking[b-aa890e84 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "", false);
        java.lang.String str7 = user6.getEmail();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]" + "'", str7.equals("Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]"));
    }

    @Test
    public void test099() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test099");
        scheduler.strategy.PricingStrategy pricingStrategy10 = null;
        scheduler.model.Booking booking11 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy10);
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy12 = new scheduler.strategy.PartnerPricingStrategy();
        double double14 = partnerPricingStrategy12.calculateCost((int) '4');
        booking11.setPricingStrategy((scheduler.strategy.PricingStrategy) partnerPricingStrategy12);
        double double16 = partnerPricingStrategy12.getHourlyRate();
        double double18 = partnerPricingStrategy12.calculateCost((int) '4');
        scheduler.model.Booking booking19 = new scheduler.model.Booking("Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]", "35-100", 0, 0, (scheduler.strategy.PricingStrategy) partnerPricingStrategy12);
        java.lang.String str20 = booking19.getId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 2600.0d + "'", double14 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 50.0d + "'", double16 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double18 + "' != '" + 2600.0d + "'", double18 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str20 + "' != '" + "Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]" + "'", str20.equals("Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]"));
    }

    @Test
    public void test100() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test100");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule18 = new scheduler.rules.NoOverlapRule();
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository17, (scheduler.rules.IConflictRules) noOverlapRule18);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository20 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList21 = inMemoryBookingRepository20.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy27 = null;
        scheduler.model.Booking booking28 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy27);
        scheduler.strategy.PricingStrategy pricingStrategy29 = null;
        booking28.setPricingStrategy(pricingStrategy29);
        java.lang.String str31 = booking28.toString();
        inMemoryBookingRepository20.save(booking28);
        boolean boolean33 = bookingManager0.addBooking(booking28);
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy43 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking44 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy43);
        double double45 = staffPricingStrategy43.getHourlyRate();
        scheduler.model.Booking booking46 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy43);
        java.lang.String str47 = booking46.getUserId();
        java.lang.String str48 = booking46.getUserId();
        boolean boolean49 = bookingManager0.addBooking(booking46);
        int int50 = booking46.getStartHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str31 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str31.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking44);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double45 + "' != '" + 40.0d + "'", double45 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking46);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str47 + "' != '" + "" + "'", str47.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str48 + "' != '" + "" + "'", str48.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + true + "'", boolean49 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int50 + "' != '" + 1 + "'", int50 == 1);
    }

    @Test
    public void test101() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test101");
        scheduler.model.TimeSlot timeSlot2 = new scheduler.model.TimeSlot((int) '#', (int) (short) 100);
        java.lang.String str3 = timeSlot2.toString();
        java.lang.String str4 = timeSlot2.toString();
        int int5 = timeSlot2.getEndHour();
        int int6 = timeSlot2.getEndHour();
        int int7 = timeSlot2.getEndHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "35-100" + "'", str3.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "35-100" + "'", str4.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 100 + "'", int6 == 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 100 + "'", int7 == 100);
    }

    @Test
    public void test102() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test102");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.register(bookingObserver1);
        scheduler.booking.BookingObserver bookingObserver3 = null;
        bookingManager0.register(bookingObserver3);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository5 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList6 = inMemoryBookingRepository5.findAll();
        scheduler.booking.BookingManager bookingManager7 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver8 = null;
        bookingManager7.unregister(bookingObserver8);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository10 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList11 = inMemoryBookingRepository10.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule12 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy18 = null;
        scheduler.model.Booking booking19 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy18);
        scheduler.booking.BookingManager bookingManager20 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList21 = bookingManager20.getBookings();
        boolean boolean22 = noOverlapRule12.isAllowed(booking19, bookingList21);
        bookingManager7.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository10, (scheduler.rules.IConflictRules) noOverlapRule12);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository24 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule25 = new scheduler.rules.NoOverlapRule();
        bookingManager7.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository24, (scheduler.rules.IConflictRules) noOverlapRule25);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository5, (scheduler.rules.IConflictRules) noOverlapRule25);
        bookingManager0.notifyObservers();
        java.util.List<scheduler.model.Booking> bookingList29 = bookingManager0.getBookings();
        boolean boolean31 = bookingManager0.cancelBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]");
        bookingManager0.notifyObservers();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking19);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList29);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean31 + "' != '" + false + "'", boolean31 == false);
    }

    @Test
    public void test103() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test103");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        bookingManager0.notifyObservers();
        scheduler.booking.BookingObserver bookingObserver4 = null;
        bookingManager0.register(bookingObserver4);
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy11 = new scheduler.strategy.PartnerPricingStrategy();
        double double13 = partnerPricingStrategy11.calculateCost((int) '4');
        scheduler.model.Booking booking14 = new scheduler.model.Booking("35-100", "hi!", "", (int) (byte) 0, (int) ' ', (scheduler.strategy.PricingStrategy) partnerPricingStrategy11);
        boolean boolean15 = bookingManager0.addBooking(booking14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + 2600.0d + "'", double13 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
    }

    @Test
    public void test104() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test104");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getOrgOrStudentId();
        java.lang.String str9 = user6.getAccountType();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "" + "'", str8.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
    }

    @Test
    public void test105() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test105");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule18 = new scheduler.rules.NoOverlapRule();
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository17, (scheduler.rules.IConflictRules) noOverlapRule18);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository20 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList21 = inMemoryBookingRepository20.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy27 = null;
        scheduler.model.Booking booking28 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy27);
        scheduler.strategy.PricingStrategy pricingStrategy29 = null;
        booking28.setPricingStrategy(pricingStrategy29);
        java.lang.String str31 = booking28.toString();
        inMemoryBookingRepository20.save(booking28);
        boolean boolean33 = bookingManager0.addBooking(booking28);
        scheduler.booking.BookingObserver bookingObserver34 = null;
        bookingManager0.unregister(bookingObserver34);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str31 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str31.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
    }

    @Test
    public void test106() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test106");
        scheduler.model.User user6 = new scheduler.model.User("Booking[ room=hi! user= 52-0]", "hi!", "Booking[ room=hi! user= 52-0]", "Booking[ room=hi! user= 52-0]", "", true);
        java.lang.String str7 = user6.getAccountType();
        java.lang.String str8 = user6.getOrgOrStudentId();
        java.lang.String str9 = user6.getOrgOrStudentId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str7.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "" + "'", str8.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
    }

    @Test
    public void test107() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test107");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        bookingManager0.notifyObservers();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
    }

    @Test
    public void test108() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test108");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy13 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking14 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy13);
        double double15 = staffPricingStrategy13.getHourlyRate();
        scheduler.model.Booking booking16 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy13);
        scheduler.model.Booking booking17 = scheduler.model.BookingFactory.createBooking("hi!", "User[  type= verified=true]", (int) '#', (int) (short) 10, (scheduler.strategy.PricingStrategy) staffPricingStrategy13);
        java.lang.String str18 = booking17.toString();
        int int19 = booking17.getEndHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double15 + "' != '" + 40.0d + "'", double15 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking17);
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertTrue("'" + str18 + "' != '" + "Booking[b-e336b375 room=hi! user=User[  type= verified=true] 35-10]" + "'", str18.equals("Booking[b-e336b375 room=hi! user=User[  type= verified=true] 35-10]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int19 + "' != '" + 10 + "'", int19 == 10);
    }

    @Test
    public void test109() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test109");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.register(bookingObserver1);
        scheduler.model.Booking booking4 = bookingManager0.findById("hi!");
        scheduler.model.Booking booking6 = bookingManager0.findById("");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(booking4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(booking6);
    }

    @Test
    public void test110() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test110");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy5 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking6 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy5);
        double double7 = staffPricingStrategy5.getHourlyRate();
        double double8 = staffPricingStrategy5.getHourlyRate();
        double double9 = staffPricingStrategy5.getHourlyRate();
        double double10 = staffPricingStrategy5.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double7 + "' != '" + 40.0d + "'", double7 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 40.0d + "'", double8 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 40.0d + "'", double9 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 40.0d + "'", double10 == 40.0d);
    }

    @Test
    public void test111() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test111");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.register(bookingObserver1);
        scheduler.booking.BookingObserver bookingObserver3 = null;
        bookingManager0.register(bookingObserver3);
        scheduler.booking.BookingManager bookingManager5 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver6 = null;
        bookingManager5.register(bookingObserver6);
        scheduler.booking.BookingObserver bookingObserver8 = null;
        bookingManager5.register(bookingObserver8);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository10 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList11 = inMemoryBookingRepository10.findAll();
        scheduler.booking.BookingManager bookingManager12 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver13 = null;
        bookingManager12.unregister(bookingObserver13);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository15 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList16 = inMemoryBookingRepository15.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule17 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy23 = null;
        scheduler.model.Booking booking24 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy23);
        scheduler.booking.BookingManager bookingManager25 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList26 = bookingManager25.getBookings();
        boolean boolean27 = noOverlapRule17.isAllowed(booking24, bookingList26);
        bookingManager12.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository15, (scheduler.rules.IConflictRules) noOverlapRule17);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository29 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule30 = new scheduler.rules.NoOverlapRule();
        bookingManager12.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository29, (scheduler.rules.IConflictRules) noOverlapRule30);
        bookingManager5.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository10, (scheduler.rules.IConflictRules) noOverlapRule30);
        scheduler.booking.BookingManager bookingManager33 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver34 = null;
        bookingManager33.unregister(bookingObserver34);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository36 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList37 = inMemoryBookingRepository36.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule38 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy44 = null;
        scheduler.model.Booking booking45 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy44);
        scheduler.booking.BookingManager bookingManager46 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList47 = bookingManager46.getBookings();
        boolean boolean48 = noOverlapRule38.isAllowed(booking45, bookingList47);
        bookingManager33.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository36, (scheduler.rules.IConflictRules) noOverlapRule38);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository50 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule51 = new scheduler.rules.NoOverlapRule();
        bookingManager33.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository50, (scheduler.rules.IConflictRules) noOverlapRule51);
        scheduler.booking.BookingManager bookingManager53 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver54 = null;
        bookingManager53.register(bookingObserver54);
        scheduler.booking.BookingObserver bookingObserver56 = null;
        bookingManager53.register(bookingObserver56);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository58 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList59 = inMemoryBookingRepository58.findAll();
        scheduler.booking.BookingManager bookingManager60 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver61 = null;
        bookingManager60.unregister(bookingObserver61);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository63 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList64 = inMemoryBookingRepository63.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule65 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy71 = null;
        scheduler.model.Booking booking72 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy71);
        scheduler.booking.BookingManager bookingManager73 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList74 = bookingManager73.getBookings();
        boolean boolean75 = noOverlapRule65.isAllowed(booking72, bookingList74);
        bookingManager60.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository63, (scheduler.rules.IConflictRules) noOverlapRule65);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository77 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule78 = new scheduler.rules.NoOverlapRule();
        bookingManager60.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository77, (scheduler.rules.IConflictRules) noOverlapRule78);
        bookingManager53.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository58, (scheduler.rules.IConflictRules) noOverlapRule78);
        bookingManager5.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository50, (scheduler.rules.IConflictRules) noOverlapRule78);
        scheduler.rules.IConflictRules iConflictRules82 = null;
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository50, iConflictRules82);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager5);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking24);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager25);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList26);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + true + "'", boolean27 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager33);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList37);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking45);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager46);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList47);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean48 + "' != '" + true + "'", boolean48 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager53);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList59);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager60);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList64);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking72);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager73);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList74);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean75 + "' != '" + true + "'", boolean75 == true);
    }

    @Test
    public void test112() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test112");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.model.Booking booking4 = bookingManager0.findById("");
        scheduler.model.Booking booking6 = bookingManager0.findById("Booking[b-aa890e84 room=Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35] user=35-100 35--1]");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(booking4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(booking6);
    }

    @Test
    public void test113() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test113");
        scheduler.strategy.FacultyPricingStrategy facultyPricingStrategy0 = new scheduler.strategy.FacultyPricingStrategy();
        double double2 = facultyPricingStrategy0.calculateCost(1);
        double double3 = facultyPricingStrategy0.getHourlyRate();
        double double4 = facultyPricingStrategy0.getHourlyRate();
        double double5 = facultyPricingStrategy0.getHourlyRate();
        double double7 = facultyPricingStrategy0.calculateCost((int) (byte) 0);
        double double9 = facultyPricingStrategy0.calculateCost((int) (byte) 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 30.0d + "'", double2 == 30.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double3 + "' != '" + 30.0d + "'", double3 == 30.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 30.0d + "'", double4 == 30.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double5 + "' != '" + 30.0d + "'", double5 == 30.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double7 + "' != '" + 0.0d + "'", double7 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 3000.0d + "'", double9 == 3000.0d);
    }

    @Test
    public void test114() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test114");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.register(bookingObserver1);
        scheduler.booking.BookingObserver bookingObserver3 = null;
        bookingManager0.register(bookingObserver3);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository5 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList6 = inMemoryBookingRepository5.findAll();
        scheduler.booking.BookingManager bookingManager7 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver8 = null;
        bookingManager7.unregister(bookingObserver8);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository10 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList11 = inMemoryBookingRepository10.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule12 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy18 = null;
        scheduler.model.Booking booking19 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy18);
        scheduler.booking.BookingManager bookingManager20 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList21 = bookingManager20.getBookings();
        boolean boolean22 = noOverlapRule12.isAllowed(booking19, bookingList21);
        bookingManager7.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository10, (scheduler.rules.IConflictRules) noOverlapRule12);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository24 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule25 = new scheduler.rules.NoOverlapRule();
        bookingManager7.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository24, (scheduler.rules.IConflictRules) noOverlapRule25);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository5, (scheduler.rules.IConflictRules) noOverlapRule25);
        inMemoryBookingRepository5.delete("");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking19);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
    }

    @Test
    public void test115() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test115");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.register(bookingObserver1);
        scheduler.booking.BookingObserver bookingObserver3 = null;
        bookingManager0.register(bookingObserver3);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository5 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList6 = inMemoryBookingRepository5.findAll();
        scheduler.booking.BookingManager bookingManager7 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver8 = null;
        bookingManager7.unregister(bookingObserver8);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository10 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList11 = inMemoryBookingRepository10.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule12 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy18 = null;
        scheduler.model.Booking booking19 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy18);
        scheduler.booking.BookingManager bookingManager20 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList21 = bookingManager20.getBookings();
        boolean boolean22 = noOverlapRule12.isAllowed(booking19, bookingList21);
        bookingManager7.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository10, (scheduler.rules.IConflictRules) noOverlapRule12);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository24 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule25 = new scheduler.rules.NoOverlapRule();
        bookingManager7.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository24, (scheduler.rules.IConflictRules) noOverlapRule25);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository5, (scheduler.rules.IConflictRules) noOverlapRule25);
        scheduler.booking.BookingManager bookingManager28 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver29 = null;
        bookingManager28.unregister(bookingObserver29);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository31 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList32 = inMemoryBookingRepository31.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule33 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy39 = null;
        scheduler.model.Booking booking40 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy39);
        scheduler.booking.BookingManager bookingManager41 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList42 = bookingManager41.getBookings();
        boolean boolean43 = noOverlapRule33.isAllowed(booking40, bookingList42);
        bookingManager28.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository31, (scheduler.rules.IConflictRules) noOverlapRule33);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository45 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule46 = new scheduler.rules.NoOverlapRule();
        bookingManager28.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository45, (scheduler.rules.IConflictRules) noOverlapRule46);
        scheduler.booking.BookingManager bookingManager48 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver49 = null;
        bookingManager48.register(bookingObserver49);
        scheduler.booking.BookingObserver bookingObserver51 = null;
        bookingManager48.register(bookingObserver51);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository53 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList54 = inMemoryBookingRepository53.findAll();
        scheduler.booking.BookingManager bookingManager55 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver56 = null;
        bookingManager55.unregister(bookingObserver56);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository58 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList59 = inMemoryBookingRepository58.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule60 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy66 = null;
        scheduler.model.Booking booking67 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy66);
        scheduler.booking.BookingManager bookingManager68 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList69 = bookingManager68.getBookings();
        boolean boolean70 = noOverlapRule60.isAllowed(booking67, bookingList69);
        bookingManager55.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository58, (scheduler.rules.IConflictRules) noOverlapRule60);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository72 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule73 = new scheduler.rules.NoOverlapRule();
        bookingManager55.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository72, (scheduler.rules.IConflictRules) noOverlapRule73);
        bookingManager48.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository53, (scheduler.rules.IConflictRules) noOverlapRule73);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository45, (scheduler.rules.IConflictRules) noOverlapRule73);
        scheduler.booking.BookingObserver bookingObserver77 = null;
        bookingManager0.unregister(bookingObserver77);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking19);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager28);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList32);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + true + "'", boolean43 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager48);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList54);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList59);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking67);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager68);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList69);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean70 + "' != '" + true + "'", boolean70 == true);
    }

    @Test
    public void test116() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test116");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getId();
        java.lang.String str10 = user6.getAccountType();
        int int11 = user6.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "" + "'", str10.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 50 + "'", int11 == 50);
    }

    @Test
    public void test117() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test117");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        boolean boolean7 = room5.isBookable();
        int int8 = room5.getCapacity();
        int int9 = room5.getCapacity();
        java.lang.String str10 = room5.toString();
        java.lang.String str11 = room5.getId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 10 + "'", int8 == 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int9 + "' != '" + 10 + "'", int9 == 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str10.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str11.equals("Booking[ room=hi! user= 52-0]"));
    }

    @Test
    public void test118() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test118");
        scheduler.model.User user6 = new scheduler.model.User("Booking[ room=hi! user= 52-0]", "hi!", "Booking[ room=hi! user= 52-0]", "Booking[ room=hi! user= 52-0]", "", true);
        scheduler.strategy.PricingStrategy pricingStrategy7 = user6.getPricingStrategy();
        java.lang.String str8 = user6.getAccountType();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str8.equals("Booking[ room=hi! user= 52-0]"));
    }

    @Test
    public void test119() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test119");
        scheduler.rules.NoOverlapRule noOverlapRule0 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy6 = null;
        scheduler.model.Booking booking7 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy6);
        scheduler.booking.BookingManager bookingManager8 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList9 = bookingManager8.getBookings();
        boolean boolean10 = noOverlapRule0.isAllowed(booking7, bookingList9);
        int int11 = booking7.getEndHour();
        java.lang.String str12 = booking7.getUserId();
        java.lang.String str13 = booking7.getUserId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + true + "'", boolean10 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + (-1) + "'", int11 == (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "" + "'", str13.equals(""));
    }

    @Test
    public void test120() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test120");
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy9 = new scheduler.strategy.PartnerPricingStrategy();
        double double11 = partnerPricingStrategy9.calculateCost((int) '4');
        double double13 = partnerPricingStrategy9.calculateCost((int) (byte) -1);
        scheduler.model.Booking booking14 = scheduler.model.BookingFactory.createBooking("hi!", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) '#', (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy9);
        double double16 = partnerPricingStrategy9.calculateCost((int) (short) -1);
        scheduler.model.Booking booking17 = scheduler.model.BookingFactory.createBooking("Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "Booking[ room=hi! user= 52-0]", 35, (int) (short) 100, (scheduler.strategy.PricingStrategy) partnerPricingStrategy9);
        int int18 = booking17.getStartHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 2600.0d + "'", double11 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + (-50.0d) + "'", double13 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + (-50.0d) + "'", double16 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int18 + "' != '" + 35 + "'", int18 == 35);
    }

    @Test
    public void test121() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test121");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        bookingManager0.notifyObservers();
        scheduler.booking.BookingObserver bookingObserver4 = null;
        bookingManager0.register(bookingObserver4);
        scheduler.booking.BookingObserver bookingObserver6 = null;
        bookingManager0.register(bookingObserver6);
        scheduler.model.Booking booking9 = bookingManager0.findById("Booking[ room=hi! user= 52-0]");
        scheduler.data.IBookingRepository iBookingRepository10 = null;
        scheduler.booking.BookingManager bookingManager11 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver12 = null;
        bookingManager11.register(bookingObserver12);
        scheduler.booking.BookingObserver bookingObserver14 = null;
        bookingManager11.register(bookingObserver14);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository16 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList17 = inMemoryBookingRepository16.findAll();
        scheduler.booking.BookingManager bookingManager18 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver19 = null;
        bookingManager18.unregister(bookingObserver19);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository21 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList22 = inMemoryBookingRepository21.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule23 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy29 = null;
        scheduler.model.Booking booking30 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy29);
        scheduler.booking.BookingManager bookingManager31 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList32 = bookingManager31.getBookings();
        boolean boolean33 = noOverlapRule23.isAllowed(booking30, bookingList32);
        bookingManager18.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository21, (scheduler.rules.IConflictRules) noOverlapRule23);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository35 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule36 = new scheduler.rules.NoOverlapRule();
        bookingManager18.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository35, (scheduler.rules.IConflictRules) noOverlapRule36);
        bookingManager11.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository16, (scheduler.rules.IConflictRules) noOverlapRule36);
        scheduler.booking.BookingManager bookingManager39 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver40 = null;
        bookingManager39.unregister(bookingObserver40);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository42 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList43 = inMemoryBookingRepository42.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule44 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy50 = null;
        scheduler.model.Booking booking51 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy50);
        scheduler.booking.BookingManager bookingManager52 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList53 = bookingManager52.getBookings();
        boolean boolean54 = noOverlapRule44.isAllowed(booking51, bookingList53);
        bookingManager39.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository42, (scheduler.rules.IConflictRules) noOverlapRule44);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository56 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule57 = new scheduler.rules.NoOverlapRule();
        bookingManager39.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository56, (scheduler.rules.IConflictRules) noOverlapRule57);
        scheduler.booking.BookingManager bookingManager59 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver60 = null;
        bookingManager59.register(bookingObserver60);
        scheduler.booking.BookingObserver bookingObserver62 = null;
        bookingManager59.register(bookingObserver62);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository64 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList65 = inMemoryBookingRepository64.findAll();
        scheduler.booking.BookingManager bookingManager66 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver67 = null;
        bookingManager66.unregister(bookingObserver67);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository69 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList70 = inMemoryBookingRepository69.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule71 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy77 = null;
        scheduler.model.Booking booking78 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy77);
        scheduler.booking.BookingManager bookingManager79 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList80 = bookingManager79.getBookings();
        boolean boolean81 = noOverlapRule71.isAllowed(booking78, bookingList80);
        bookingManager66.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository69, (scheduler.rules.IConflictRules) noOverlapRule71);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository83 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule84 = new scheduler.rules.NoOverlapRule();
        bookingManager66.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository83, (scheduler.rules.IConflictRules) noOverlapRule84);
        bookingManager59.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository64, (scheduler.rules.IConflictRules) noOverlapRule84);
        bookingManager11.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository56, (scheduler.rules.IConflictRules) noOverlapRule84);
        // The following exception was thrown during execution in test generation
        try {
            bookingManager0.initialize(iBookingRepository10, (scheduler.rules.IConflictRules) noOverlapRule84);
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"scheduler.data.IBookingRepository.findAll()\" because \"repo\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(booking9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager18);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking30);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager31);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList32);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager39);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList43);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking51);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager52);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList53);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + true + "'", boolean54 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager59);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList65);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager66);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList70);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking78);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager79);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList80);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean81 + "' != '" + true + "'", boolean81 == true);
    }

    @Test
    public void test122() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test122");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy14 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking15 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy14);
        double double16 = staffPricingStrategy14.getHourlyRate();
        scheduler.model.Booking booking17 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy14);
        double double18 = staffPricingStrategy14.getHourlyRate();
        scheduler.model.Booking booking19 = new scheduler.model.Booking("User[  type= verified=true]", "Booking[b-d3a065e4 room=hi! user=User[  type= verified=true] 35-10]", "35-100", (int) '4', (int) (byte) 1, (scheduler.strategy.PricingStrategy) staffPricingStrategy14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 40.0d + "'", double16 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double18 + "' != '" + 40.0d + "'", double18 == 40.0d);
    }

    @Test
    public void test123() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test123");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        int int7 = room5.getCapacity();
        boolean boolean8 = room5.isBookable();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 10 + "'", int7 == 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test124() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test124");
        scheduler.model.User user6 = new scheduler.model.User("Booking[b-aa890e84 room=Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35] user=35-100 35--1]", "Booking[b-e336b375 room=hi! user=User[  type= verified=true] 35-10]", "User[  type= verified=true]", "Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]", "Booking[User[  type= verified=true] room=35-100 user= 50-100]", false);
    }

    @Test
    public void test125() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test125");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        boolean boolean7 = room5.isBookable();
        java.lang.String str8 = room5.toString();
        java.lang.String str9 = room5.toString();
        java.lang.String str10 = room5.getId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str8.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str9.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str10.equals("Booking[ room=hi! user= 52-0]"));
    }

    @Test
    public void test126() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test126");
        scheduler.strategy.PricingStrategy pricingStrategy5 = null;
        scheduler.model.Booking booking6 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy5);
        scheduler.strategy.PricingStrategy pricingStrategy7 = null;
        booking6.setPricingStrategy(pricingStrategy7);
        java.lang.String str9 = booking6.toString();
        java.lang.String str10 = booking6.getUserId();
        java.lang.String str11 = booking6.toString();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str9.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "" + "'", str10.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str11.equals("Booking[ room=hi! user= 52-0]"));
    }

    @Test
    public void test127() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test127");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy5 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking6 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy5);
        double double7 = staffPricingStrategy5.getHourlyRate();
        double double9 = staffPricingStrategy5.calculateCost((int) (short) 0);
        double double10 = staffPricingStrategy5.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double7 + "' != '" + 40.0d + "'", double7 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 0.0d + "'", double9 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 40.0d + "'", double10 == 40.0d);
    }

    @Test
    public void test128() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test128");
        scheduler.strategy.PricingStrategy pricingStrategy5 = null;
        scheduler.model.Booking booking6 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy5);
        int int7 = booking6.getEndHour();
        java.lang.String str8 = booking6.toString();
        java.lang.String str9 = booking6.getId();
        int int10 = booking6.getEndHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]" + "'", str8.equals("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str9.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + (-1) + "'", int10 == (-1));
    }

    @Test
    public void test129() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test129");
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy9 = new scheduler.strategy.PartnerPricingStrategy();
        double double11 = partnerPricingStrategy9.calculateCost((int) '4');
        double double13 = partnerPricingStrategy9.calculateCost((int) (byte) -1);
        scheduler.model.Booking booking14 = scheduler.model.BookingFactory.createBooking("hi!", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) '#', (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy9);
        double double16 = partnerPricingStrategy9.calculateCost((int) (short) -1);
        scheduler.model.Booking booking17 = scheduler.model.BookingFactory.createBooking("Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "Booking[ room=hi! user= 52-0]", 35, (int) (short) 100, (scheduler.strategy.PricingStrategy) partnerPricingStrategy9);
        java.lang.String str18 = booking17.getRoomId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 2600.0d + "'", double11 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + (-50.0d) + "'", double13 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + (-50.0d) + "'", double16 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str18 + "' != '" + "Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]" + "'", str18.equals("Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]"));
    }

    @Test
    public void test130() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test130");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        boolean boolean7 = room5.isBookable();
        int int8 = room5.getCapacity();
        java.lang.String str9 = room5.getBuilding();
        java.lang.String str10 = room5.getStatus();
        int int11 = room5.getCapacity();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 10 + "'", int8 == 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "hi!" + "'", str9.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "35-100" + "'", str10.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 10 + "'", int11 == 10);
    }

    @Test
    public void test131() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test131");
        // The following exception was thrown during execution in test generation
        try {
            scheduler.model.TimeSlot timeSlot2 = new scheduler.model.TimeSlot(52, 0);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: endHour must be after startHour (got 52-0)");
        } catch (java.lang.IllegalArgumentException e) {
        // Expected exception.
        }
    }

    @Test
    public void test132() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test132");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        boolean boolean7 = user6.isVerified();
        int int8 = user6.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 50 + "'", int8 == 50);
    }

    @Test
    public void test133() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test133");
        scheduler.model.User user6 = new scheduler.model.User("Booking[ room=hi! user= 52-0]", "hi!", "Booking[ room=hi! user= 52-0]", "Booking[ room=hi! user= 52-0]", "", true);
        scheduler.strategy.PricingStrategy pricingStrategy7 = user6.getPricingStrategy();
        java.lang.String str8 = user6.toString();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "User[Booking[ room=hi! user= 52-0] hi! type=Booking[ room=hi! user= 52-0] verified=true]" + "'", str8.equals("User[Booking[ room=hi! user= 52-0] hi! type=Booking[ room=hi! user= 52-0] verified=true]"));
    }

    @Test
    public void test134() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test134");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        java.lang.String str7 = room5.getName();
        int int8 = room5.getCapacity();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 10 + "'", int8 == 10);
    }

    @Test
    public void test135() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test135");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.register(bookingObserver1);
        scheduler.booking.BookingObserver bookingObserver3 = null;
        bookingManager0.unregister(bookingObserver3);
        boolean boolean6 = false; // flaky: bookingManager0.cancelBooking("35-100");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean6 + "' != '" + false + "'", boolean6 == false);
    }

    @Test
    public void test136() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test136");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.booking.BookingObserver bookingObserver17 = null;
        bookingManager0.unregister(bookingObserver17);
        scheduler.model.Booking booking20 = bookingManager0.findById("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]");
        scheduler.booking.BookingObserver bookingObserver21 = null;
        bookingManager0.unregister(bookingObserver21);
        scheduler.booking.BookingObserver bookingObserver23 = null;
        bookingManager0.unregister(bookingObserver23);
        bookingManager0.notifyObservers();
        boolean boolean27 = bookingManager0.cancelBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(booking20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + false + "'", boolean27 == false);
    }

    @Test
    public void test137() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test137");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        bookingManager0.notifyObservers();
        scheduler.booking.BookingObserver bookingObserver4 = null;
        bookingManager0.register(bookingObserver4);
        scheduler.booking.BookingObserver bookingObserver6 = null;
        bookingManager0.register(bookingObserver6);
        scheduler.booking.BookingManager bookingManager8 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver9 = null;
        bookingManager8.unregister(bookingObserver9);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository11 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList12 = inMemoryBookingRepository11.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule13 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy19 = null;
        scheduler.model.Booking booking20 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy19);
        scheduler.booking.BookingManager bookingManager21 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList22 = bookingManager21.getBookings();
        boolean boolean23 = noOverlapRule13.isAllowed(booking20, bookingList22);
        bookingManager8.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository11, (scheduler.rules.IConflictRules) noOverlapRule13);
        inMemoryBookingRepository11.delete("Booking[ room=hi! user= 52-0]");
        scheduler.rules.NoOverlapRule noOverlapRule27 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository28 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList29 = inMemoryBookingRepository28.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy35 = null;
        scheduler.model.Booking booking36 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy35);
        scheduler.strategy.PricingStrategy pricingStrategy37 = null;
        booking36.setPricingStrategy(pricingStrategy37);
        java.lang.String str39 = booking36.toString();
        inMemoryBookingRepository28.save(booking36);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository41 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList42 = inMemoryBookingRepository41.findAll();
        boolean boolean43 = noOverlapRule27.isAllowed(booking36, bookingList42);
        scheduler.rules.NoOverlapRule noOverlapRule44 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository45 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList46 = inMemoryBookingRepository45.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy52 = null;
        scheduler.model.Booking booking53 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy52);
        scheduler.strategy.PricingStrategy pricingStrategy54 = null;
        booking53.setPricingStrategy(pricingStrategy54);
        java.lang.String str56 = booking53.toString();
        inMemoryBookingRepository45.save(booking53);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository58 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList59 = inMemoryBookingRepository58.findAll();
        boolean boolean60 = noOverlapRule44.isAllowed(booking53, bookingList59);
        scheduler.rules.NoOverlapRule noOverlapRule61 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy67 = null;
        scheduler.model.Booking booking68 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy67);
        scheduler.booking.BookingManager bookingManager69 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList70 = bookingManager69.getBookings();
        boolean boolean71 = noOverlapRule61.isAllowed(booking68, bookingList70);
        boolean boolean72 = noOverlapRule27.isAllowed(booking53, bookingList70);
        scheduler.strategy.PricingStrategy pricingStrategy78 = null;
        scheduler.model.Booking booking79 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy78);
        int int80 = booking79.getEndHour();
        scheduler.booking.BookingManager bookingManager81 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver82 = null;
        bookingManager81.register(bookingObserver82);
        scheduler.model.Booking booking85 = bookingManager81.findById("hi!");
        java.util.List<scheduler.model.Booking> bookingList86 = bookingManager81.getBookings();
        boolean boolean87 = noOverlapRule27.isAllowed(booking79, bookingList86);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository11, (scheduler.rules.IConflictRules) noOverlapRule27);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean23 + "' != '" + true + "'", boolean23 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList29);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str39 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str39.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + true + "'", boolean43 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList46);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str56 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str56.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList59);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean60 + "' != '" + true + "'", boolean60 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking68);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager69);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList70);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean71 + "' != '" + true + "'", boolean71 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean72 + "' != '" + true + "'", boolean72 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking79);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int80 + "' != '" + (-1) + "'", int80 == (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager81);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(booking85);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList86);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean87 + "' != '" + true + "'", boolean87 == true);
    }

    @Test
    public void test138() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test138");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        int int8 = user6.getHourlyRate();
        java.lang.String str9 = user6.getId();
        java.lang.String str10 = user6.toString();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 50 + "'", int8 == 50);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "User[  type= verified=true]" + "'", str10.equals("User[  type= verified=true]"));
    }

    @Test
    public void test139() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test139");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        java.lang.String str7 = room5.getStatus();
        java.lang.String str8 = room5.toString();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "35-100" + "'", str7.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str8.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
    }

    @Test
    public void test140() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test140");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        boolean boolean7 = room5.isBookable();
        int int8 = room5.getCapacity();
        java.lang.String str9 = room5.getBuilding();
        boolean boolean10 = room5.isBookable();
        java.lang.String str11 = room5.getId();
        boolean boolean12 = room5.isBookable();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 10 + "'", int8 == 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "hi!" + "'", str9.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str11.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + false + "'", boolean12 == false);
    }

    @Test
    public void test141() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test141");
        scheduler.strategy.PricingStrategy pricingStrategy19 = null;
        scheduler.model.Booking booking20 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy19);
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy21 = new scheduler.strategy.PartnerPricingStrategy();
        double double23 = partnerPricingStrategy21.calculateCost((int) '4');
        booking20.setPricingStrategy((scheduler.strategy.PricingStrategy) partnerPricingStrategy21);
        scheduler.model.Booking booking25 = scheduler.model.BookingFactory.createBooking("", "", (int) (short) 0, (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy21);
        double double26 = partnerPricingStrategy21.getHourlyRate();
        scheduler.model.Booking booking27 = scheduler.model.BookingFactory.createBooking("b-aa890e84", "Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "35-100", 35, (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy21);
        double double29 = partnerPricingStrategy21.calculateCost(0);
        scheduler.model.Booking booking30 = new scheduler.model.Booking("User[  type= verified=true]", "Booking[b-62cf4af2 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "35-100", 10, (int) (byte) 100, (scheduler.strategy.PricingStrategy) partnerPricingStrategy21);
        double double31 = partnerPricingStrategy21.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double23 + "' != '" + 2600.0d + "'", double23 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking25);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double26 + "' != '" + 50.0d + "'", double26 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking27);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double29 + "' != '" + 0.0d + "'", double29 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double31 + "' != '" + 50.0d + "'", double31 == 50.0d);
    }

    @Test
    public void test142() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test142");
        scheduler.model.User user6 = new scheduler.model.User("Booking[ room=hi! user= 52-0]", "hi!", "Booking[ room=hi! user= 52-0]", "Booking[ room=hi! user= 52-0]", "", true);
        java.lang.String str7 = user6.getAccountType();
        java.lang.String str8 = user6.getAccountType();
        boolean boolean9 = user6.isVerified();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str7.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str8.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean9 + "' != '" + true + "'", boolean9 == true);
    }

    @Test
    public void test143() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test143");
        scheduler.model.TimeSlot timeSlot2 = new scheduler.model.TimeSlot((int) '#', (int) (short) 100);
        java.lang.String str3 = timeSlot2.toString();
        int int4 = timeSlot2.getEndHour();
        int int5 = timeSlot2.getEndHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "35-100" + "'", str3.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 100 + "'", int4 == 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
    }

    @Test
    public void test144() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test144");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getEmail();
        scheduler.strategy.PricingStrategy pricingStrategy10 = user6.getPricingStrategy();
        java.lang.String str11 = user6.toString();
        java.lang.String str12 = user6.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "User[  type= verified=true]" + "'", str11.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "hi!" + "'", str12.equals("hi!"));
    }

    @Test
    public void test145() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test145");
        scheduler.model.User user6 = new scheduler.model.User("Booking[ room=hi! user= 52-0]", "hi!", "Booking[ room=hi! user= 52-0]", "Booking[ room=hi! user= 52-0]", "", true);
        java.lang.String str7 = user6.getAccountType();
        java.lang.String str8 = user6.getOrgOrStudentId();
        java.lang.String str9 = user6.getId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str7.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "" + "'", str8.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str9.equals("Booking[ room=hi! user= 52-0]"));
    }

    @Test
    public void test146() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test146");
        scheduler.model.TimeSlot timeSlot2 = new scheduler.model.TimeSlot((int) '#', (int) (short) 100);
        java.lang.String str3 = timeSlot2.toString();
        java.lang.String str4 = timeSlot2.toString();
        int int5 = timeSlot2.getEndHour();
        int int6 = timeSlot2.getStartHour();
        int int7 = timeSlot2.getStartHour();
        int int8 = timeSlot2.getEndHour();
        java.lang.String str9 = timeSlot2.toString();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "35-100" + "'", str3.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "35-100" + "'", str4.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 35 + "'", int6 == 35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 35 + "'", int7 == 35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 100 + "'", int8 == 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "35-100" + "'", str9.equals("35-100"));
    }

    @Test
    public void test147() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test147");
        scheduler.strategy.PricingStrategy pricingStrategy5 = null;
        scheduler.model.Booking booking6 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy5);
        scheduler.strategy.PricingStrategy pricingStrategy7 = null;
        booking6.setPricingStrategy(pricingStrategy7);
        java.lang.String str9 = booking6.toString();
        java.lang.String str10 = booking6.getRoomId();
        scheduler.model.User user22 = new scheduler.model.User("Booking[ room=hi! user= 52-0]", "hi!", "Booking[ room=hi! user= 52-0]", "Booking[ room=hi! user= 52-0]", "", true);
        java.lang.String str23 = user22.getAccountType();
        java.lang.String str24 = user22.getOrgOrStudentId();
        scheduler.strategy.PricingStrategy pricingStrategy25 = user22.getPricingStrategy();
        scheduler.model.Booking booking26 = new scheduler.model.Booking("", "Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]", 100, 0, pricingStrategy25);
        booking6.setPricingStrategy(pricingStrategy25);
        int int28 = booking6.getEndHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str9.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "hi!" + "'", str10.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str23 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str23.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str24 + "' != '" + "" + "'", str24.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy25);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int28 + "' != '" + 0 + "'", int28 == 0);
    }

    @Test
    public void test148() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test148");
        scheduler.strategy.PricingStrategy pricingStrategy14 = null;
        scheduler.model.Booking booking15 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy14);
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy16 = new scheduler.strategy.PartnerPricingStrategy();
        double double18 = partnerPricingStrategy16.calculateCost((int) '4');
        booking15.setPricingStrategy((scheduler.strategy.PricingStrategy) partnerPricingStrategy16);
        scheduler.model.Booking booking20 = scheduler.model.BookingFactory.createBooking("", "", (int) (short) 0, (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy16);
        double double21 = partnerPricingStrategy16.getHourlyRate();
        scheduler.model.Booking booking22 = scheduler.model.BookingFactory.createBooking("b-aa890e84", "Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "35-100", 35, (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy16);
        java.lang.String str23 = booking22.toString();
        java.lang.String str24 = booking22.getUserId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double18 + "' != '" + 2600.0d + "'", double18 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double21 + "' != '" + 50.0d + "'", double21 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str23 + "' != '" + "Booking[b-aa890e84 room=Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35] user=35-100 35--1]" + "'", str23.equals("Booking[b-aa890e84 room=Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35] user=35-100 35--1]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str24 + "' != '" + "35-100" + "'", str24.equals("35-100"));
    }

    @Test
    public void test149() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test149");
        scheduler.strategy.PricingStrategy pricingStrategy5 = null;
        scheduler.model.Booking booking6 = scheduler.model.BookingFactory.createBooking("b-aa890e84", "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]", "", 1, (int) 'a', pricingStrategy5);
        java.lang.String str7 = booking6.toString();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Booking[b-aa890e84 room=Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100] user= 1-97]" + "'", str7.equals("Booking[b-aa890e84 room=Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100] user= 1-97]"));
    }

    @Test
    public void test150() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test150");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getEmail();
        scheduler.strategy.PricingStrategy pricingStrategy10 = user6.getPricingStrategy();
        java.lang.String str11 = user6.toString();
        int int12 = user6.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "User[  type= verified=true]" + "'", str11.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int12 + "' != '" + 50 + "'", int12 == 50);
    }

    @Test
    public void test151() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test151");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy13 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking14 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy13);
        double double15 = staffPricingStrategy13.getHourlyRate();
        scheduler.model.Booking booking16 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy13);
        scheduler.model.Booking booking17 = scheduler.model.BookingFactory.createBooking("hi!", "User[  type= verified=true]", (int) '#', (int) (short) 10, (scheduler.strategy.PricingStrategy) staffPricingStrategy13);
        java.lang.String str18 = booking17.toString();
        double double19 = booking17.calculateTotalCost();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double15 + "' != '" + 40.0d + "'", double15 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking17);
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertTrue("'" + str18 + "' != '" + "Booking[b-cb9dd374 room=hi! user=User[  type= verified=true] 35-10]" + "'", str18.equals("Booking[b-cb9dd374 room=hi! user=User[  type= verified=true] 35-10]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double19 + "' != '" + (-1000.0d) + "'", double19 == (-1000.0d));
    }

    @Test
    public void test152() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test152");
        scheduler.rules.NoOverlapRule noOverlapRule0 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository1 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList2 = inMemoryBookingRepository1.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy8 = null;
        scheduler.model.Booking booking9 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy8);
        scheduler.strategy.PricingStrategy pricingStrategy10 = null;
        booking9.setPricingStrategy(pricingStrategy10);
        java.lang.String str12 = booking9.toString();
        inMemoryBookingRepository1.save(booking9);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository14 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList15 = inMemoryBookingRepository14.findAll();
        boolean boolean16 = noOverlapRule0.isAllowed(booking9, bookingList15);
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy27 = new scheduler.strategy.PartnerPricingStrategy();
        double double29 = partnerPricingStrategy27.calculateCost((int) '4');
        double double31 = partnerPricingStrategy27.calculateCost((int) (byte) -1);
        scheduler.model.Booking booking32 = scheduler.model.BookingFactory.createBooking("hi!", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) '#', (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy27);
        scheduler.model.Booking booking33 = new scheduler.model.Booking("Booking[ room=hi! user= 52-0]", "35-100", "hi!", (int) (byte) 1, (int) (short) -1, (scheduler.strategy.PricingStrategy) partnerPricingStrategy27);
        scheduler.booking.BookingManager bookingManager34 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver35 = null;
        bookingManager34.register(bookingObserver35);
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy47 = new scheduler.strategy.PartnerPricingStrategy();
        double double49 = partnerPricingStrategy47.calculateCost((int) '4');
        double double51 = partnerPricingStrategy47.calculateCost((int) (byte) -1);
        scheduler.model.Booking booking52 = scheduler.model.BookingFactory.createBooking("hi!", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) '#', (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy47);
        scheduler.model.Booking booking53 = scheduler.model.BookingFactory.createBooking("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]", "Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]", "User[  type= verified=true]", 10, 35, (scheduler.strategy.PricingStrategy) partnerPricingStrategy47);
        boolean boolean54 = bookingManager34.addBooking(booking53);
        java.util.List<scheduler.model.Booking> bookingList55 = bookingManager34.getBookings();
        boolean boolean56 = noOverlapRule0.isAllowed(booking33, bookingList55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str12.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double29 + "' != '" + 2600.0d + "'", double29 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double31 + "' != '" + (-50.0d) + "'", double31 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking32);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager34);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double49 + "' != '" + 2600.0d + "'", double49 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double51 + "' != '" + (-50.0d) + "'", double51 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking52);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking53);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean54 + "' != '" + true + "'", boolean54 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean56 + "' != '" + true + "'", boolean56 == true);
    }

    @Test
    public void test153() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test153");
        scheduler.model.TimeSlot timeSlot2 = new scheduler.model.TimeSlot((int) (short) 10, 35);
    }

    @Test
    public void test154() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test154");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getOrgOrStudentId();
        scheduler.strategy.PricingStrategy pricingStrategy10 = user6.getPricingStrategy();
        java.lang.String str11 = user6.getEmail();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "" + "'", str11.equals(""));
    }

    @Test
    public void test155() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test155");
        scheduler.strategy.StudentPricingStrategy studentPricingStrategy0 = new scheduler.strategy.StudentPricingStrategy();
        double double1 = studentPricingStrategy0.getHourlyRate();
        double double3 = studentPricingStrategy0.calculateCost(50);
        double double5 = studentPricingStrategy0.calculateCost((int) 'a');
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double1 + "' != '" + 20.0d + "'", double1 == 20.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double3 + "' != '" + 1000.0d + "'", double3 == 1000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double5 + "' != '" + 1940.0d + "'", double5 == 1940.0d);
    }

    @Test
    public void test156() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test156");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        bookingManager0.notifyObservers();
        scheduler.booking.BookingObserver bookingObserver4 = null;
        bookingManager0.register(bookingObserver4);
        scheduler.booking.BookingObserver bookingObserver6 = null;
        bookingManager0.unregister(bookingObserver6);
        scheduler.rules.NoOverlapRule noOverlapRule8 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository9 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList10 = inMemoryBookingRepository9.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy16 = null;
        scheduler.model.Booking booking17 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy16);
        scheduler.strategy.PricingStrategy pricingStrategy18 = null;
        booking17.setPricingStrategy(pricingStrategy18);
        java.lang.String str20 = booking17.toString();
        inMemoryBookingRepository9.save(booking17);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository22 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList23 = inMemoryBookingRepository22.findAll();
        boolean boolean24 = noOverlapRule8.isAllowed(booking17, bookingList23);
        scheduler.rules.NoOverlapRule noOverlapRule25 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository26 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList27 = inMemoryBookingRepository26.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy33 = null;
        scheduler.model.Booking booking34 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy33);
        scheduler.strategy.PricingStrategy pricingStrategy35 = null;
        booking34.setPricingStrategy(pricingStrategy35);
        java.lang.String str37 = booking34.toString();
        inMemoryBookingRepository26.save(booking34);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository39 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList40 = inMemoryBookingRepository39.findAll();
        boolean boolean41 = noOverlapRule25.isAllowed(booking34, bookingList40);
        scheduler.rules.NoOverlapRule noOverlapRule42 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy48 = null;
        scheduler.model.Booking booking49 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy48);
        scheduler.booking.BookingManager bookingManager50 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList51 = bookingManager50.getBookings();
        boolean boolean52 = noOverlapRule42.isAllowed(booking49, bookingList51);
        boolean boolean53 = noOverlapRule8.isAllowed(booking34, bookingList51);
        scheduler.strategy.PricingStrategy pricingStrategy59 = null;
        scheduler.model.Booking booking60 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy59);
        int int61 = booking60.getEndHour();
        scheduler.booking.BookingManager bookingManager62 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver63 = null;
        bookingManager62.register(bookingObserver63);
        scheduler.model.Booking booking66 = bookingManager62.findById("hi!");
        java.util.List<scheduler.model.Booking> bookingList67 = bookingManager62.getBookings();
        boolean boolean68 = noOverlapRule8.isAllowed(booking60, bookingList67);
        boolean boolean69 = bookingManager0.addBooking(booking60);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str20 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str20.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean24 + "' != '" + true + "'", boolean24 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList27);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str37 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str37.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking49);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager50);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList51);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean52 + "' != '" + true + "'", boolean52 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean53 + "' != '" + true + "'", boolean53 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking60);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int61 + "' != '" + (-1) + "'", int61 == (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager62);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(booking66);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList67);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean68 + "' != '" + true + "'", boolean68 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean69 + "' != '" + true + "'", boolean69 == true);
    }

    @Test
    public void test157() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test157");
        scheduler.strategy.PricingStrategy pricingStrategy5 = null;
        scheduler.model.Booking booking6 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy5);
        int int7 = booking6.getEndHour();
        java.lang.String str8 = booking6.getRoomId();
        java.lang.Class<?> wildcardClass9 = booking6.getClass();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + (-1) + "'", int7 == (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(wildcardClass9);
    }

    @Test
    public void test158() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test158");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy17 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking18 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy17);
        double double19 = staffPricingStrategy17.getHourlyRate();
        scheduler.model.Booking booking20 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy17);
        scheduler.model.Booking booking21 = scheduler.model.BookingFactory.createBooking("hi!", "User[  type= verified=true]", (int) '#', (int) (short) 10, (scheduler.strategy.PricingStrategy) staffPricingStrategy17);
        scheduler.model.Booking booking22 = scheduler.model.BookingFactory.createBooking("User[Booking[ room=hi! user= 52-0] hi! type=Booking[ room=hi! user= 52-0] verified=true]", "Booking[b-aa890e84 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", 1, 100, (scheduler.strategy.PricingStrategy) staffPricingStrategy17);
        double double24 = staffPricingStrategy17.calculateCost((int) '4');
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking18);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double19 + "' != '" + 40.0d + "'", double19 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double24 + "' != '" + 2080.0d + "'", double24 == 2080.0d);
    }

    @Test
    public void test159() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test159");
        scheduler.strategy.FacultyPricingStrategy facultyPricingStrategy5 = new scheduler.strategy.FacultyPricingStrategy();
        double double7 = facultyPricingStrategy5.calculateCost(1);
        double double8 = facultyPricingStrategy5.getHourlyRate();
        double double9 = facultyPricingStrategy5.getHourlyRate();
        double double10 = facultyPricingStrategy5.getHourlyRate();
        scheduler.model.Booking booking11 = scheduler.model.BookingFactory.createBooking("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]", "Booking[b-aa890e84 room=Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35] user=35-100 35--1]", "User[Booking[ room=hi! user= 52-0] hi! type=Booking[ room=hi! user= 52-0] verified=true]", 100, 50, (scheduler.strategy.PricingStrategy) facultyPricingStrategy5);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double7 + "' != '" + 30.0d + "'", double7 == 30.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 30.0d + "'", double8 == 30.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 30.0d + "'", double9 == 30.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 30.0d + "'", double10 == 30.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking11);
    }

    @Test
    public void test160() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test160");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule18 = new scheduler.rules.NoOverlapRule();
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository17, (scheduler.rules.IConflictRules) noOverlapRule18);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository20 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList21 = inMemoryBookingRepository20.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy27 = null;
        scheduler.model.Booking booking28 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy27);
        scheduler.strategy.PricingStrategy pricingStrategy29 = null;
        booking28.setPricingStrategy(pricingStrategy29);
        java.lang.String str31 = booking28.toString();
        inMemoryBookingRepository20.save(booking28);
        boolean boolean33 = bookingManager0.addBooking(booking28);
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy43 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking44 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy43);
        double double45 = staffPricingStrategy43.getHourlyRate();
        scheduler.model.Booking booking46 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy43);
        java.lang.String str47 = booking46.getUserId();
        java.lang.String str48 = booking46.getUserId();
        boolean boolean49 = bookingManager0.addBooking(booking46);
        double double50 = booking46.getUpfrontDeposit();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str31 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str31.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking44);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double45 + "' != '" + 40.0d + "'", double45 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking46);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str47 + "' != '" + "" + "'", str47.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str48 + "' != '" + "" + "'", str48.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + true + "'", boolean49 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double50 + "' != '" + 40.0d + "'", double50 == 40.0d);
    }

    @Test
    public void test161() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test161");
        scheduler.strategy.PricingStrategy pricingStrategy10 = null;
        scheduler.model.Booking booking11 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy10);
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy12 = new scheduler.strategy.PartnerPricingStrategy();
        double double14 = partnerPricingStrategy12.calculateCost((int) '4');
        booking11.setPricingStrategy((scheduler.strategy.PricingStrategy) partnerPricingStrategy12);
        double double16 = partnerPricingStrategy12.getHourlyRate();
        double double18 = partnerPricingStrategy12.calculateCost((int) '4');
        scheduler.model.Booking booking19 = new scheduler.model.Booking("Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]", "35-100", 0, 0, (scheduler.strategy.PricingStrategy) partnerPricingStrategy12);
        scheduler.model.User user26 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str27 = user26.getId();
        java.lang.String str28 = user26.getPassword();
        java.lang.String str29 = user26.getEmail();
        java.lang.String str30 = user26.toString();
        scheduler.strategy.PricingStrategy pricingStrategy31 = user26.getPricingStrategy();
        booking19.setPricingStrategy(pricingStrategy31);
        java.lang.String str33 = booking19.getRoomId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 2600.0d + "'", double14 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 50.0d + "'", double16 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double18 + "' != '" + 2600.0d + "'", double18 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str27 + "' != '" + "" + "'", str27.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str28 + "' != '" + "hi!" + "'", str28.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str29 + "' != '" + "" + "'", str29.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str30 + "' != '" + "User[  type= verified=true]" + "'", str30.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy31);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str33 + "' != '" + "Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]" + "'", str33.equals("Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]"));
    }

    @Test
    public void test162() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test162");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule18 = new scheduler.rules.NoOverlapRule();
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository17, (scheduler.rules.IConflictRules) noOverlapRule18);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository20 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList21 = inMemoryBookingRepository20.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy27 = null;
        scheduler.model.Booking booking28 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy27);
        scheduler.strategy.PricingStrategy pricingStrategy29 = null;
        booking28.setPricingStrategy(pricingStrategy29);
        java.lang.String str31 = booking28.toString();
        inMemoryBookingRepository20.save(booking28);
        boolean boolean33 = bookingManager0.addBooking(booking28);
        scheduler.strategy.PricingStrategy pricingStrategy58 = null;
        scheduler.model.Booking booking59 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy58);
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy60 = new scheduler.strategy.PartnerPricingStrategy();
        double double62 = partnerPricingStrategy60.calculateCost((int) '4');
        booking59.setPricingStrategy((scheduler.strategy.PricingStrategy) partnerPricingStrategy60);
        scheduler.model.Booking booking64 = scheduler.model.BookingFactory.createBooking("", "", (int) (short) 0, (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy60);
        double double65 = partnerPricingStrategy60.getHourlyRate();
        scheduler.model.Booking booking66 = scheduler.model.BookingFactory.createBooking("b-aa890e84", "Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "35-100", 35, (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy60);
        double double68 = partnerPricingStrategy60.calculateCost(0);
        scheduler.model.Booking booking69 = new scheduler.model.Booking("User[  type= verified=true]", "Booking[b-62cf4af2 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "35-100", 10, (int) (byte) 100, (scheduler.strategy.PricingStrategy) partnerPricingStrategy60);
        scheduler.model.Booking booking70 = new scheduler.model.Booking("35-100", "", "User[  type= verified=true]", (int) '4', (int) 'a', (scheduler.strategy.PricingStrategy) partnerPricingStrategy60);
        booking28.setPricingStrategy((scheduler.strategy.PricingStrategy) partnerPricingStrategy60);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str31 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str31.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking59);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double62 + "' != '" + 2600.0d + "'", double62 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking64);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double65 + "' != '" + 50.0d + "'", double65 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking66);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double68 + "' != '" + 0.0d + "'", double68 == 0.0d);
    }

    @Test
    public void test163() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test163");
        scheduler.strategy.StudentPricingStrategy studentPricingStrategy4 = new scheduler.strategy.StudentPricingStrategy();
        double double5 = studentPricingStrategy4.getHourlyRate();
        double double7 = studentPricingStrategy4.calculateCost(50);
        double double8 = studentPricingStrategy4.getHourlyRate();
        scheduler.model.Booking booking9 = scheduler.model.BookingFactory.createBooking("Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]", "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]", (int) 'a', (int) ' ', (scheduler.strategy.PricingStrategy) studentPricingStrategy4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double5 + "' != '" + 20.0d + "'", double5 == 20.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double7 + "' != '" + 1000.0d + "'", double7 == 1000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 20.0d + "'", double8 == 20.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking9);
    }

    @Test
    public void test164() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test164");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy13 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking14 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy13);
        double double15 = staffPricingStrategy13.getHourlyRate();
        scheduler.model.Booking booking16 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy13);
        scheduler.model.Booking booking17 = scheduler.model.BookingFactory.createBooking("hi!", "User[  type= verified=true]", (int) '#', (int) (short) 10, (scheduler.strategy.PricingStrategy) staffPricingStrategy13);
        java.lang.String str18 = booking17.toString();
        java.lang.String str19 = booking17.getUserId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double15 + "' != '" + 40.0d + "'", double15 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking17);
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertTrue("'" + str18 + "' != '" + "Booking[b-e3ef2bb1 room=hi! user=User[  type= verified=true] 35-10]" + "'", str18.equals("Booking[b-e3ef2bb1 room=hi! user=User[  type= verified=true] 35-10]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str19 + "' != '" + "User[  type= verified=true]" + "'", str19.equals("User[  type= verified=true]"));
    }

    @Test
    public void test165() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test165");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy5 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking6 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy5);
        double double8 = staffPricingStrategy5.calculateCost(100);
        double double9 = staffPricingStrategy5.getHourlyRate();
        double double11 = staffPricingStrategy5.calculateCost((int) (byte) 10);
        double double13 = staffPricingStrategy5.calculateCost((int) (short) 1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 4000.0d + "'", double8 == 4000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double9 + "' != '" + 40.0d + "'", double9 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 400.0d + "'", double11 == 400.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + 40.0d + "'", double13 == 40.0d);
    }

    @Test
    public void test166() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test166");
        scheduler.model.TimeSlot timeSlot2 = new scheduler.model.TimeSlot((int) '#', (int) (short) 100);
        java.lang.String str3 = timeSlot2.toString();
        java.lang.String str4 = timeSlot2.toString();
        int int5 = timeSlot2.getEndHour();
        int int6 = timeSlot2.getStartHour();
        java.lang.String str7 = timeSlot2.toString();
        int int8 = timeSlot2.getEndHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "35-100" + "'", str3.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "35-100" + "'", str4.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 35 + "'", int6 == 35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "35-100" + "'", str7.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 100 + "'", int8 == 100);
    }

    @Test
    public void test167() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test167");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getOrgOrStudentId();
        java.lang.String str9 = user6.toString();
        java.lang.String str10 = user6.getPassword();
        java.lang.String str11 = user6.toString();
        scheduler.strategy.PricingStrategy pricingStrategy12 = user6.getPricingStrategy();
        java.lang.String str13 = user6.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "" + "'", str8.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "User[  type= verified=true]" + "'", str9.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "hi!" + "'", str10.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "User[  type= verified=true]" + "'", str11.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "hi!" + "'", str13.equals("hi!"));
    }

    @Test
    public void test168() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test168");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.model.Booking booking4 = bookingManager0.findById("");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy10 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking11 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy10);
        boolean boolean12 = bookingManager0.addBooking(booking11);
        java.util.List<scheduler.model.Booking> bookingList13 = bookingManager0.getBookings();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager0.getBookings();
        java.util.List<scheduler.model.Booking> bookingList15 = bookingManager0.getBookings();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList15);
    }

    @Test
    public void test169() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test169");
        scheduler.rules.NoOverlapRule noOverlapRule0 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository1 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList2 = inMemoryBookingRepository1.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy8 = null;
        scheduler.model.Booking booking9 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy8);
        scheduler.strategy.PricingStrategy pricingStrategy10 = null;
        booking9.setPricingStrategy(pricingStrategy10);
        java.lang.String str12 = booking9.toString();
        inMemoryBookingRepository1.save(booking9);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository14 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList15 = inMemoryBookingRepository14.findAll();
        boolean boolean16 = noOverlapRule0.isAllowed(booking9, bookingList15);
        scheduler.rules.NoOverlapRule noOverlapRule17 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository18 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList19 = inMemoryBookingRepository18.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy25 = null;
        scheduler.model.Booking booking26 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy25);
        scheduler.strategy.PricingStrategy pricingStrategy27 = null;
        booking26.setPricingStrategy(pricingStrategy27);
        java.lang.String str29 = booking26.toString();
        inMemoryBookingRepository18.save(booking26);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository31 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList32 = inMemoryBookingRepository31.findAll();
        boolean boolean33 = noOverlapRule17.isAllowed(booking26, bookingList32);
        scheduler.rules.NoOverlapRule noOverlapRule34 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy40 = null;
        scheduler.model.Booking booking41 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy40);
        scheduler.booking.BookingManager bookingManager42 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList43 = bookingManager42.getBookings();
        boolean boolean44 = noOverlapRule34.isAllowed(booking41, bookingList43);
        boolean boolean45 = noOverlapRule0.isAllowed(booking26, bookingList43);
        scheduler.strategy.PricingStrategy pricingStrategy51 = null;
        scheduler.model.Booking booking52 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy51);
        int int53 = booking52.getEndHour();
        scheduler.booking.BookingManager bookingManager54 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver55 = null;
        bookingManager54.register(bookingObserver55);
        scheduler.model.Booking booking58 = bookingManager54.findById("hi!");
        java.util.List<scheduler.model.Booking> bookingList59 = bookingManager54.getBookings();
        boolean boolean60 = noOverlapRule0.isAllowed(booking52, bookingList59);
        scheduler.strategy.PricingStrategy pricingStrategy66 = null;
        scheduler.model.Booking booking67 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy66);
        scheduler.strategy.PricingStrategy pricingStrategy68 = null;
        booking67.setPricingStrategy(pricingStrategy68);
        scheduler.rules.NoOverlapRule noOverlapRule70 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy76 = null;
        scheduler.model.Booking booking77 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy76);
        scheduler.booking.BookingManager bookingManager78 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList79 = bookingManager78.getBookings();
        boolean boolean80 = noOverlapRule70.isAllowed(booking77, bookingList79);
        boolean boolean81 = noOverlapRule0.isAllowed(booking67, bookingList79);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str12.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList19);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str29 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str29.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList32);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList43);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + true + "'", boolean44 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + true + "'", boolean45 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking52);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int53 + "' != '" + (-1) + "'", int53 == (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager54);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(booking58);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList59);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean60 + "' != '" + true + "'", boolean60 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking77);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager78);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList79);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean80 + "' != '" + true + "'", boolean80 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean81 + "' != '" + true + "'", boolean81 == true);
    }

    @Test
    public void test170() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test170");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        int int8 = user6.getHourlyRate();
        java.lang.String str9 = user6.getEmail();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 50 + "'", int8 == 50);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
    }

    @Test
    public void test171() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test171");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.register(bookingObserver1);
        scheduler.booking.BookingObserver bookingObserver3 = null;
        bookingManager0.register(bookingObserver3);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository5 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList6 = inMemoryBookingRepository5.findAll();
        scheduler.booking.BookingManager bookingManager7 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver8 = null;
        bookingManager7.unregister(bookingObserver8);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository10 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList11 = inMemoryBookingRepository10.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule12 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy18 = null;
        scheduler.model.Booking booking19 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy18);
        scheduler.booking.BookingManager bookingManager20 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList21 = bookingManager20.getBookings();
        boolean boolean22 = noOverlapRule12.isAllowed(booking19, bookingList21);
        bookingManager7.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository10, (scheduler.rules.IConflictRules) noOverlapRule12);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository24 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule25 = new scheduler.rules.NoOverlapRule();
        bookingManager7.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository24, (scheduler.rules.IConflictRules) noOverlapRule25);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository5, (scheduler.rules.IConflictRules) noOverlapRule25);
        scheduler.booking.BookingManager bookingManager28 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver29 = null;
        bookingManager28.unregister(bookingObserver29);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository31 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList32 = inMemoryBookingRepository31.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule33 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy39 = null;
        scheduler.model.Booking booking40 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy39);
        scheduler.booking.BookingManager bookingManager41 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList42 = bookingManager41.getBookings();
        boolean boolean43 = noOverlapRule33.isAllowed(booking40, bookingList42);
        bookingManager28.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository31, (scheduler.rules.IConflictRules) noOverlapRule33);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository45 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule46 = new scheduler.rules.NoOverlapRule();
        bookingManager28.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository45, (scheduler.rules.IConflictRules) noOverlapRule46);
        scheduler.booking.BookingManager bookingManager48 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver49 = null;
        bookingManager48.register(bookingObserver49);
        scheduler.booking.BookingObserver bookingObserver51 = null;
        bookingManager48.register(bookingObserver51);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository53 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList54 = inMemoryBookingRepository53.findAll();
        scheduler.booking.BookingManager bookingManager55 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver56 = null;
        bookingManager55.unregister(bookingObserver56);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository58 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList59 = inMemoryBookingRepository58.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule60 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy66 = null;
        scheduler.model.Booking booking67 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy66);
        scheduler.booking.BookingManager bookingManager68 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList69 = bookingManager68.getBookings();
        boolean boolean70 = noOverlapRule60.isAllowed(booking67, bookingList69);
        bookingManager55.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository58, (scheduler.rules.IConflictRules) noOverlapRule60);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository72 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule73 = new scheduler.rules.NoOverlapRule();
        bookingManager55.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository72, (scheduler.rules.IConflictRules) noOverlapRule73);
        bookingManager48.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository53, (scheduler.rules.IConflictRules) noOverlapRule73);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository45, (scheduler.rules.IConflictRules) noOverlapRule73);
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy87 = new scheduler.strategy.PartnerPricingStrategy();
        double double89 = partnerPricingStrategy87.calculateCost((int) '4');
        double double91 = partnerPricingStrategy87.calculateCost((int) (byte) -1);
        scheduler.model.Booking booking92 = scheduler.model.BookingFactory.createBooking("hi!", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) '#', (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy87);
        scheduler.model.Booking booking93 = scheduler.model.BookingFactory.createBooking("User[  type= verified=true]", "User[  type= verified=true]", "hi!", (int) (byte) 10, (int) 'a', (scheduler.strategy.PricingStrategy) partnerPricingStrategy87);
        boolean boolean94 = bookingManager0.addBooking(booking93);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager7);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking19);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean22 + "' != '" + true + "'", boolean22 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager28);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList32);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean43 + "' != '" + true + "'", boolean43 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager48);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList54);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList59);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking67);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager68);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList69);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean70 + "' != '" + true + "'", boolean70 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double89 + "' != '" + 2600.0d + "'", double89 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double91 + "' != '" + (-50.0d) + "'", double91 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking92);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking93);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean94 + "' != '" + true + "'", boolean94 == true);
    }

    @Test
    public void test172() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test172");
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy14 = new scheduler.strategy.PartnerPricingStrategy();
        double double16 = partnerPricingStrategy14.calculateCost((int) '4');
        double double18 = partnerPricingStrategy14.calculateCost((int) (byte) -1);
        scheduler.model.Booking booking19 = scheduler.model.BookingFactory.createBooking("hi!", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) '#', (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy14);
        double double21 = partnerPricingStrategy14.calculateCost((int) (short) -1);
        scheduler.model.Booking booking22 = scheduler.model.BookingFactory.createBooking("Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "Booking[ room=hi! user= 52-0]", 35, (int) (short) 100, (scheduler.strategy.PricingStrategy) partnerPricingStrategy14);
        scheduler.model.Booking booking23 = new scheduler.model.Booking("", "Booking[b-62cf4af2 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "hi!", (int) (short) 0, 1, (scheduler.strategy.PricingStrategy) partnerPricingStrategy14);
        double double24 = partnerPricingStrategy14.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 2600.0d + "'", double16 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double18 + "' != '" + (-50.0d) + "'", double18 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking19);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double21 + "' != '" + (-50.0d) + "'", double21 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double24 + "' != '" + 50.0d + "'", double24 == 50.0d);
    }

    @Test
    public void test173() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test173");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        bookingManager0.notifyObservers();
        scheduler.booking.BookingObserver bookingObserver4 = null;
        bookingManager0.register(bookingObserver4);
        scheduler.booking.BookingObserver bookingObserver6 = null;
        bookingManager0.register(bookingObserver6);
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy21 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking22 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy21);
        double double23 = staffPricingStrategy21.getHourlyRate();
        scheduler.model.Booking booking24 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy21);
        scheduler.model.Booking booking25 = scheduler.model.BookingFactory.createBooking("hi!", "User[  type= verified=true]", (int) '#', (int) (short) 10, (scheduler.strategy.PricingStrategy) staffPricingStrategy21);
        java.lang.String str26 = booking25.toString();
        boolean boolean27 = bookingManager0.addBooking(booking25);
        java.lang.String str28 = booking25.getId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double23 + "' != '" + 40.0d + "'", double23 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking24);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking25);
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertTrue("'" + str26 + "' != '" + "Booking[b-c9930830 room=hi! user=User[  type= verified=true] 35-10]" + "'", str26.equals("Booking[b-c9930830 room=hi! user=User[  type= verified=true] 35-10]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + true + "'", boolean27 == true);
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertTrue("'" + str28 + "' != '" + "b-c9930830" + "'", str28.equals("b-c9930830"));
    }

    @Test
    public void test174() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test174");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.model.Booking booking4 = bookingManager0.findById("");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy10 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking11 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy10);
        boolean boolean12 = bookingManager0.addBooking(booking11);
        java.lang.String str13 = booking11.getRoomId();
        double double14 = booking11.getUpfrontDeposit();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(booking4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean12 + "' != '" + true + "'", boolean12 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str13.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + 40.0d + "'", double14 == 40.0d);
    }

    @Test
    public void test175() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test175");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getId();
        java.lang.String str10 = user6.toString();
        java.lang.String str11 = user6.getOrgOrStudentId();
        java.lang.String str12 = user6.getOrgOrStudentId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "User[  type= verified=true]" + "'", str10.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "" + "'", str11.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
    }

    @Test
    public void test176() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test176");
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy10 = new scheduler.strategy.PartnerPricingStrategy();
        double double12 = partnerPricingStrategy10.calculateCost((int) '4');
        double double14 = partnerPricingStrategy10.calculateCost((int) (byte) -1);
        scheduler.model.Booking booking15 = scheduler.model.BookingFactory.createBooking("hi!", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) '#', (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy10);
        scheduler.model.Booking booking16 = new scheduler.model.Booking("Booking[ room=hi! user= 52-0]", "35-100", "hi!", (int) (byte) 1, (int) (short) -1, (scheduler.strategy.PricingStrategy) partnerPricingStrategy10);
        int int17 = booking16.getStartHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 2600.0d + "'", double12 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + (-50.0d) + "'", double14 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 1 + "'", int17 == 1);
    }

    @Test
    public void test177() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test177");
        scheduler.strategy.PricingStrategy pricingStrategy29 = null;
        scheduler.model.Booking booking30 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy29);
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy31 = new scheduler.strategy.PartnerPricingStrategy();
        double double33 = partnerPricingStrategy31.calculateCost((int) '4');
        booking30.setPricingStrategy((scheduler.strategy.PricingStrategy) partnerPricingStrategy31);
        scheduler.model.Booking booking35 = scheduler.model.BookingFactory.createBooking("", "", (int) (short) 0, (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy31);
        double double36 = partnerPricingStrategy31.getHourlyRate();
        scheduler.model.Booking booking37 = scheduler.model.BookingFactory.createBooking("b-aa890e84", "Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "35-100", 35, (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy31);
        double double39 = partnerPricingStrategy31.calculateCost(0);
        scheduler.model.Booking booking40 = new scheduler.model.Booking("User[  type= verified=true]", "Booking[b-62cf4af2 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "35-100", 10, (int) (byte) 100, (scheduler.strategy.PricingStrategy) partnerPricingStrategy31);
        scheduler.model.Booking booking41 = new scheduler.model.Booking("35-100", "", "User[  type= verified=true]", (int) '4', (int) 'a', (scheduler.strategy.PricingStrategy) partnerPricingStrategy31);
        double double42 = partnerPricingStrategy31.getHourlyRate();
        scheduler.model.Booking booking43 = new scheduler.model.Booking("", "Booking[b-e336b375 room=hi! user=User[  type= verified=true] 35-10]", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", 1, (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy31);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking30);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double33 + "' != '" + 2600.0d + "'", double33 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double36 + "' != '" + 50.0d + "'", double36 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking37);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double39 + "' != '" + 0.0d + "'", double39 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double42 + "' != '" + 50.0d + "'", double42 == 50.0d);
    }

    @Test
    public void test178() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test178");
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy10 = new scheduler.strategy.PartnerPricingStrategy();
        double double12 = partnerPricingStrategy10.calculateCost((int) '4');
        double double14 = partnerPricingStrategy10.calculateCost((int) (byte) -1);
        scheduler.model.Booking booking15 = scheduler.model.BookingFactory.createBooking("hi!", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) '#', (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy10);
        scheduler.model.Booking booking16 = scheduler.model.BookingFactory.createBooking("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]", "Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]", "User[  type= verified=true]", 10, 35, (scheduler.strategy.PricingStrategy) partnerPricingStrategy10);
        java.lang.String str17 = booking16.getRoomId();
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy27 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking28 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy27);
        double double29 = staffPricingStrategy27.getHourlyRate();
        scheduler.model.Booking booking30 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy27);
        double double31 = staffPricingStrategy27.getHourlyRate();
        double double32 = staffPricingStrategy27.getHourlyRate();
        double double34 = staffPricingStrategy27.calculateCost((int) (short) 1);
        booking16.setPricingStrategy((scheduler.strategy.PricingStrategy) staffPricingStrategy27);
        java.lang.String str36 = booking16.getUserId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 2600.0d + "'", double12 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double14 + "' != '" + (-50.0d) + "'", double14 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str17 + "' != '" + "Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]" + "'", str17.equals("Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking28);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double29 + "' != '" + 40.0d + "'", double29 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking30);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double31 + "' != '" + 40.0d + "'", double31 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double32 + "' != '" + 40.0d + "'", double32 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double34 + "' != '" + 40.0d + "'", double34 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str36 + "' != '" + "User[  type= verified=true]" + "'", str36.equals("User[  type= verified=true]"));
    }

    @Test
    public void test179() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test179");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        int int6 = room5.getCapacity();
        java.lang.String str7 = room5.toString();
        boolean boolean8 = room5.isBookable();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 10 + "'", int6 == 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str7.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
    }

    @Test
    public void test180() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test180");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList18 = inMemoryBookingRepository17.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy24 = null;
        scheduler.model.Booking booking25 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy24);
        scheduler.strategy.PricingStrategy pricingStrategy26 = null;
        booking25.setPricingStrategy(pricingStrategy26);
        java.lang.String str28 = booking25.toString();
        inMemoryBookingRepository17.save(booking25);
        inMemoryBookingRepository3.save(booking25);
        scheduler.rules.NoOverlapRule noOverlapRule31 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy37 = null;
        scheduler.model.Booking booking38 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy37);
        scheduler.booking.BookingManager bookingManager39 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList40 = bookingManager39.getBookings();
        boolean boolean41 = noOverlapRule31.isAllowed(booking38, bookingList40);
        java.lang.String str42 = booking38.toString();
        inMemoryBookingRepository3.save(booking38);
        java.util.List<scheduler.model.Booking> bookingList44 = inMemoryBookingRepository3.findAll();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList18);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str28 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str28.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking38);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager39);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str42 + "' != '" + "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]" + "'", str42.equals("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList44);
    }

    @Test
    public void test181() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test181");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.register(bookingObserver1);
        scheduler.booking.BookingObserver bookingObserver3 = null;
        bookingManager0.unregister(bookingObserver3);
        java.util.List<scheduler.model.Booking> bookingList5 = bookingManager0.getBookings();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList5);
    }

    @Test
    public void test182() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test182");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        bookingManager0.notifyObservers();
        scheduler.booking.BookingObserver bookingObserver4 = null;
        bookingManager0.register(bookingObserver4);
        scheduler.booking.BookingObserver bookingObserver6 = null;
        bookingManager0.register(bookingObserver6);
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy21 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking22 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy21);
        double double23 = staffPricingStrategy21.getHourlyRate();
        scheduler.model.Booking booking24 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy21);
        scheduler.model.Booking booking25 = scheduler.model.BookingFactory.createBooking("hi!", "User[  type= verified=true]", (int) '#', (int) (short) 10, (scheduler.strategy.PricingStrategy) staffPricingStrategy21);
        java.lang.String str26 = booking25.toString();
        boolean boolean27 = bookingManager0.addBooking(booking25);
        double double28 = booking25.getUpfrontDeposit();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double23 + "' != '" + 40.0d + "'", double23 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking24);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking25);
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertTrue("'" + str26 + "' != '" + "Booking[b-94049c36 room=hi! user=User[  type= verified=true] 35-10]" + "'", str26.equals("Booking[b-94049c36 room=hi! user=User[  type= verified=true] 35-10]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean27 + "' != '" + true + "'", boolean27 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double28 + "' != '" + 40.0d + "'", double28 == 40.0d);
    }

    @Test
    public void test183() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test183");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getAccountType();
        scheduler.strategy.PricingStrategy pricingStrategy8 = user6.getPricingStrategy();
        java.lang.String str9 = user6.getEmail();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy8);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
    }

    @Test
    public void test184() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test184");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.getName();
        java.lang.String str7 = room5.getId();
        java.lang.String str8 = room5.getId();
        java.lang.String str9 = room5.toString();
        java.lang.String str10 = room5.getName();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "" + "'", str6.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str7.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str8.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str9.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "" + "'", str10.equals(""));
    }

    @Test
    public void test185() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test185");
        scheduler.model.TimeSlot timeSlot2 = new scheduler.model.TimeSlot((int) '#', (int) (short) 100);
        int int3 = timeSlot2.getStartHour();
        int int4 = timeSlot2.getEndHour();
        int int5 = timeSlot2.getStartHour();
        int int6 = timeSlot2.getEndHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 35 + "'", int3 == 35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 100 + "'", int4 == 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 35 + "'", int5 == 35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 100 + "'", int6 == 100);
    }

    @Test
    public void test186() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test186");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        int int7 = room5.getCapacity();
        java.lang.String str8 = room5.getBuilding();
        java.lang.String str9 = room5.getName();
        int int10 = room5.getCapacity();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 10 + "'", int7 == 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int10 + "' != '" + 10 + "'", int10 == 10);
    }

    @Test
    public void test187() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test187");
        scheduler.strategy.PricingStrategy pricingStrategy34 = null;
        scheduler.model.Booking booking35 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy34);
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy36 = new scheduler.strategy.PartnerPricingStrategy();
        double double38 = partnerPricingStrategy36.calculateCost((int) '4');
        booking35.setPricingStrategy((scheduler.strategy.PricingStrategy) partnerPricingStrategy36);
        scheduler.model.Booking booking40 = scheduler.model.BookingFactory.createBooking("", "", (int) (short) 0, (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy36);
        double double41 = partnerPricingStrategy36.getHourlyRate();
        scheduler.model.Booking booking42 = scheduler.model.BookingFactory.createBooking("b-aa890e84", "Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "35-100", 35, (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy36);
        double double44 = partnerPricingStrategy36.calculateCost(0);
        scheduler.model.Booking booking45 = new scheduler.model.Booking("User[  type= verified=true]", "Booking[b-62cf4af2 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "35-100", 10, (int) (byte) 100, (scheduler.strategy.PricingStrategy) partnerPricingStrategy36);
        scheduler.model.Booking booking46 = new scheduler.model.Booking("35-100", "", "User[  type= verified=true]", (int) '4', (int) 'a', (scheduler.strategy.PricingStrategy) partnerPricingStrategy36);
        double double48 = partnerPricingStrategy36.calculateCost((int) (short) -1);
        scheduler.model.Booking booking49 = scheduler.model.BookingFactory.createBooking("35-100", "Booking[b-e336b375 room=hi! user=User[  type= verified=true] 35-10]", "hi!", 0, (int) '4', (scheduler.strategy.PricingStrategy) partnerPricingStrategy36);
        scheduler.model.Booking booking50 = scheduler.model.BookingFactory.createBooking("", "Booking[b-e3ef2bb1 room=hi! user=User[  type= verified=true] 35-10]", "User[  type= verified=true]", 1, (int) (byte) 1, (scheduler.strategy.PricingStrategy) partnerPricingStrategy36);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double38 + "' != '" + 2600.0d + "'", double38 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double41 + "' != '" + 50.0d + "'", double41 == 50.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double44 + "' != '" + 0.0d + "'", double44 == 0.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double48 + "' != '" + (-50.0d) + "'", double48 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking49);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking50);
    }

    @Test
    public void test188() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test188");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        boolean boolean7 = room5.isBookable();
        java.lang.String str8 = room5.toString();
        java.lang.String str9 = room5.getBuilding();
        boolean boolean10 = room5.isBookable();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str8.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "hi!" + "'", str9.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean10 + "' != '" + false + "'", boolean10 == false);
    }

    @Test
    public void test189() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test189");
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy9 = new scheduler.strategy.PartnerPricingStrategy();
        double double11 = partnerPricingStrategy9.calculateCost((int) '4');
        double double13 = partnerPricingStrategy9.calculateCost((int) (byte) -1);
        scheduler.model.Booking booking14 = scheduler.model.BookingFactory.createBooking("hi!", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) '#', (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy9);
        double double16 = partnerPricingStrategy9.calculateCost((int) (short) -1);
        scheduler.model.Booking booking17 = scheduler.model.BookingFactory.createBooking("Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "Booking[ room=hi! user= 52-0]", 35, (int) (short) 100, (scheduler.strategy.PricingStrategy) partnerPricingStrategy9);
        double double18 = partnerPricingStrategy9.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 2600.0d + "'", double11 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + (-50.0d) + "'", double13 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + (-50.0d) + "'", double16 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double18 + "' != '" + 50.0d + "'", double18 == 50.0d);
    }

    @Test
    public void test190() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test190");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getEmail();
        scheduler.strategy.PricingStrategy pricingStrategy10 = user6.getPricingStrategy();
        java.lang.String str11 = user6.getId();
        java.lang.String str12 = user6.getOrgOrStudentId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "" + "'", str11.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
    }

    @Test
    public void test191() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test191");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "hi!" + "'", str7.equals("hi!"));
    }

    @Test
    public void test192() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test192");
        scheduler.strategy.PricingStrategy pricingStrategy5 = null;
        scheduler.model.Booking booking6 = new scheduler.model.Booking("Booking[ room=hi! user= 52-0]", "hi!", "hi!", (int) (short) -1, (int) (short) 10, pricingStrategy5);
        java.lang.String str7 = booking6.toString();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Booking[Booking[ room=hi! user= 52-0] room=hi! user=hi! -1-10]" + "'", str7.equals("Booking[Booking[ room=hi! user= 52-0] room=hi! user=hi! -1-10]"));
    }

    @Test
    public void test193() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test193");
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy10 = new scheduler.strategy.PartnerPricingStrategy();
        double double12 = partnerPricingStrategy10.calculateCost((int) '4');
        scheduler.model.Booking booking13 = new scheduler.model.Booking("35-100", "hi!", "", (int) (byte) 0, (int) ' ', (scheduler.strategy.PricingStrategy) partnerPricingStrategy10);
        scheduler.model.Booking booking14 = scheduler.model.BookingFactory.createBooking("User[  type= verified=true]", "Booking[ room=hi! user= 52-0]", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", (int) (byte) -1, 50, (scheduler.strategy.PricingStrategy) partnerPricingStrategy10);
        java.lang.String str15 = booking14.getId();
        scheduler.strategy.FacultyPricingStrategy facultyPricingStrategy16 = new scheduler.strategy.FacultyPricingStrategy();
        double double18 = facultyPricingStrategy16.calculateCost(1);
        booking14.setPricingStrategy((scheduler.strategy.PricingStrategy) facultyPricingStrategy16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double12 + "' != '" + 2600.0d + "'", double12 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str15 + "' != '" + "User[  type= verified=true]" + "'", str15.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double18 + "' != '" + 30.0d + "'", double18 == 30.0d);
    }

    @Test
    public void test194() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test194");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule18 = new scheduler.rules.NoOverlapRule();
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository17, (scheduler.rules.IConflictRules) noOverlapRule18);
        boolean boolean21 = bookingManager0.cancelBooking("b-aa890e84");
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository22 = new scheduler.data.InMemoryBookingRepository();
        scheduler.booking.BookingManager bookingManager23 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver24 = null;
        bookingManager23.unregister(bookingObserver24);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository26 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList27 = inMemoryBookingRepository26.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule28 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy34 = null;
        scheduler.model.Booking booking35 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy34);
        scheduler.booking.BookingManager bookingManager36 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList37 = bookingManager36.getBookings();
        boolean boolean38 = noOverlapRule28.isAllowed(booking35, bookingList37);
        bookingManager23.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository26, (scheduler.rules.IConflictRules) noOverlapRule28);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository40 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule41 = new scheduler.rules.NoOverlapRule();
        bookingManager23.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository40, (scheduler.rules.IConflictRules) noOverlapRule41);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository22, (scheduler.rules.IConflictRules) noOverlapRule41);
        java.util.List<scheduler.model.Booking> bookingList44 = bookingManager0.getBookings();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList27);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager36);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList37);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + true + "'", boolean38 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList44);
    }

    @Test
    public void test195() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test195");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getOrgOrStudentId();
        java.lang.String str9 = user6.toString();
        java.lang.String str10 = user6.getPassword();
        java.lang.String str11 = user6.toString();
        java.lang.String str12 = user6.getPassword();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "" + "'", str8.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "User[  type= verified=true]" + "'", str9.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "hi!" + "'", str10.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "User[  type= verified=true]" + "'", str11.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "hi!" + "'", str12.equals("hi!"));
    }

    @Test
    public void test196() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test196");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getEmail();
        java.lang.String str10 = user6.toString();
        scheduler.strategy.PricingStrategy pricingStrategy11 = user6.getPricingStrategy();
        java.lang.String str12 = user6.getOrgOrStudentId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "User[  type= verified=true]" + "'", str10.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy11);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
    }

    @Test
    public void test197() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test197");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        java.lang.String str7 = room5.getStatus();
        boolean boolean8 = room5.isBookable();
        java.lang.String str9 = room5.getStatus();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "35-100" + "'", str7.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + false + "'", boolean8 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "35-100" + "'", str9.equals("35-100"));
    }

    @Test
    public void test198() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test198");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy5 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking6 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy5);
        double double8 = staffPricingStrategy5.calculateCost(100);
        double double10 = staffPricingStrategy5.calculateCost((int) '4');
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 4000.0d + "'", double8 == 4000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double10 + "' != '" + 2080.0d + "'", double10 == 2080.0d);
    }

    @Test
    public void test199() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test199");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.model.Booking booking4 = bookingManager0.findById("");
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository5 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule6 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy12 = null;
        scheduler.model.Booking booking13 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy12);
        scheduler.booking.BookingManager bookingManager14 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList15 = bookingManager14.getBookings();
        boolean boolean16 = noOverlapRule6.isAllowed(booking13, bookingList15);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository5, (scheduler.rules.IConflictRules) noOverlapRule6);
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy31 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking32 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy31);
        double double33 = staffPricingStrategy31.getHourlyRate();
        scheduler.model.Booking booking34 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy31);
        scheduler.model.Booking booking35 = scheduler.model.BookingFactory.createBooking("hi!", "User[  type= verified=true]", (int) '#', (int) (short) 10, (scheduler.strategy.PricingStrategy) staffPricingStrategy31);
        int int36 = booking35.getStartHour();
        scheduler.booking.BookingManager bookingManager37 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver38 = null;
        bookingManager37.register(bookingObserver38);
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy50 = new scheduler.strategy.PartnerPricingStrategy();
        double double52 = partnerPricingStrategy50.calculateCost((int) '4');
        double double54 = partnerPricingStrategy50.calculateCost((int) (byte) -1);
        scheduler.model.Booking booking55 = scheduler.model.BookingFactory.createBooking("hi!", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) '#', (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy50);
        scheduler.model.Booking booking56 = scheduler.model.BookingFactory.createBooking("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]", "Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]", "User[  type= verified=true]", 10, 35, (scheduler.strategy.PricingStrategy) partnerPricingStrategy50);
        boolean boolean57 = bookingManager37.addBooking(booking56);
        java.util.List<scheduler.model.Booking> bookingList58 = bookingManager37.getBookings();
        boolean boolean60 = bookingManager37.cancelBooking("Booking[ room=hi! user= 52-0]");
        java.util.List<scheduler.model.Booking> bookingList61 = bookingManager37.getBookings();
        boolean boolean62 = noOverlapRule6.isAllowed(booking35, bookingList61);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(booking4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking32);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double33 + "' != '" + 40.0d + "'", double33 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking34);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int36 + "' != '" + 35 + "'", int36 == 35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager37);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double52 + "' != '" + 2600.0d + "'", double52 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double54 + "' != '" + (-50.0d) + "'", double54 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking55);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean57 + "' != '" + true + "'", boolean57 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList58);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean60 + "' != '" + false + "'", boolean60 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList61);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean62 + "' != '" + true + "'", boolean62 == true);
    }

    @Test
    public void test200() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test200");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        java.util.List<scheduler.model.Booking> bookingList17 = inMemoryBookingRepository3.findAll();
        inMemoryBookingRepository3.delete("Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList17);
    }

    @Test
    public void test201() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test201");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule18 = new scheduler.rules.NoOverlapRule();
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository17, (scheduler.rules.IConflictRules) noOverlapRule18);
        scheduler.booking.BookingManager bookingManager20 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver21 = null;
        bookingManager20.unregister(bookingObserver21);
        scheduler.model.Booking booking24 = bookingManager20.findById("");
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository25 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule26 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy32 = null;
        scheduler.model.Booking booking33 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy32);
        scheduler.booking.BookingManager bookingManager34 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList35 = bookingManager34.getBookings();
        boolean boolean36 = noOverlapRule26.isAllowed(booking33, bookingList35);
        bookingManager20.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository25, (scheduler.rules.IConflictRules) noOverlapRule26);
        java.util.List<scheduler.model.Booking> bookingList38 = inMemoryBookingRepository25.findAll();
        scheduler.rules.IConflictRules iConflictRules39 = null;
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository25, iConflictRules39);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager20);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(booking24);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking33);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager34);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean36 + "' != '" + true + "'", boolean36 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList38);
    }

    @Test
    public void test202() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test202");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[b-94049c36 room=hi! user=User[  type= verified=true] 35-10]", "Booking[b-62cf4af2 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", (int) '#', "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]", "Booking[Booking[ room=hi! user= 52-0] room=hi! user=hi! -1-10]");
    }

    @Test
    public void test203() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test203");
        scheduler.rules.NoOverlapRule noOverlapRule0 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository1 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList2 = inMemoryBookingRepository1.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy8 = null;
        scheduler.model.Booking booking9 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy8);
        scheduler.strategy.PricingStrategy pricingStrategy10 = null;
        booking9.setPricingStrategy(pricingStrategy10);
        java.lang.String str12 = booking9.toString();
        inMemoryBookingRepository1.save(booking9);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository14 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList15 = inMemoryBookingRepository14.findAll();
        boolean boolean16 = noOverlapRule0.isAllowed(booking9, bookingList15);
        scheduler.rules.NoOverlapRule noOverlapRule17 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository18 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList19 = inMemoryBookingRepository18.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy25 = null;
        scheduler.model.Booking booking26 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy25);
        scheduler.strategy.PricingStrategy pricingStrategy27 = null;
        booking26.setPricingStrategy(pricingStrategy27);
        java.lang.String str29 = booking26.toString();
        inMemoryBookingRepository18.save(booking26);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository31 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList32 = inMemoryBookingRepository31.findAll();
        boolean boolean33 = noOverlapRule17.isAllowed(booking26, bookingList32);
        scheduler.rules.NoOverlapRule noOverlapRule34 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository35 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList36 = inMemoryBookingRepository35.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy42 = null;
        scheduler.model.Booking booking43 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy42);
        scheduler.strategy.PricingStrategy pricingStrategy44 = null;
        booking43.setPricingStrategy(pricingStrategy44);
        java.lang.String str46 = booking43.toString();
        inMemoryBookingRepository35.save(booking43);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository48 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList49 = inMemoryBookingRepository48.findAll();
        boolean boolean50 = noOverlapRule34.isAllowed(booking43, bookingList49);
        scheduler.rules.NoOverlapRule noOverlapRule51 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy57 = null;
        scheduler.model.Booking booking58 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy57);
        scheduler.booking.BookingManager bookingManager59 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList60 = bookingManager59.getBookings();
        boolean boolean61 = noOverlapRule51.isAllowed(booking58, bookingList60);
        boolean boolean62 = noOverlapRule17.isAllowed(booking43, bookingList60);
        scheduler.booking.BookingManager bookingManager63 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver64 = null;
        bookingManager63.unregister(bookingObserver64);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository66 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList67 = inMemoryBookingRepository66.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule68 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy74 = null;
        scheduler.model.Booking booking75 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy74);
        scheduler.booking.BookingManager bookingManager76 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList77 = bookingManager76.getBookings();
        boolean boolean78 = noOverlapRule68.isAllowed(booking75, bookingList77);
        bookingManager63.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository66, (scheduler.rules.IConflictRules) noOverlapRule68);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository80 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule81 = new scheduler.rules.NoOverlapRule();
        bookingManager63.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository80, (scheduler.rules.IConflictRules) noOverlapRule81);
        boolean boolean84 = bookingManager63.cancelBooking("User[  type= verified=true]");
        scheduler.strategy.PricingStrategy pricingStrategy90 = null;
        scheduler.model.Booking booking91 = new scheduler.model.Booking("", "hi!", "Booking[ room=hi! user= 52-0]", 10, 0, pricingStrategy90);
        boolean boolean92 = bookingManager63.addBooking(booking91);
        java.util.List<scheduler.model.Booking> bookingList93 = bookingManager63.getBookings();
        boolean boolean94 = noOverlapRule0.isAllowed(booking43, bookingList93);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str12.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList19);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str29 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str29.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList32);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList36);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str46 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str46.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList49);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean50 + "' != '" + true + "'", boolean50 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking58);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager59);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList60);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean61 + "' != '" + true + "'", boolean61 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean62 + "' != '" + true + "'", boolean62 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager63);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList67);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking75);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager76);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList77);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean78 + "' != '" + true + "'", boolean78 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean84 + "' != '" + false + "'", boolean84 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean92 + "' != '" + true + "'", boolean92 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList93);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean94 + "' != '" + true + "'", boolean94 == true);
    }

    @Test
    public void test204() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test204");
        scheduler.model.TimeSlot timeSlot2 = new scheduler.model.TimeSlot((int) '#', (int) (short) 100);
        int int3 = timeSlot2.getStartHour();
        int int4 = timeSlot2.getStartHour();
        int int5 = timeSlot2.getStartHour();
        int int6 = timeSlot2.getEndHour();
        int int7 = timeSlot2.getStartHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int3 + "' != '" + 35 + "'", int3 == 35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int4 + "' != '" + 35 + "'", int4 == 35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 35 + "'", int5 == 35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 100 + "'", int6 == 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 35 + "'", int7 == 35);
    }

    @Test
    public void test205() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test205");
        scheduler.model.Room room5 = new scheduler.model.Room("User[Booking[ room=hi! user= 52-0] hi! type=Booking[ room=hi! user= 52-0] verified=true]", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", (int) (byte) 0, "", "Booking[Booking[ room=hi! user= 52-0] room=hi! user=hi! -1-10]");
    }

    @Test
    public void test206() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test206");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule18 = new scheduler.rules.NoOverlapRule();
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository17, (scheduler.rules.IConflictRules) noOverlapRule18);
        boolean boolean21 = bookingManager0.cancelBooking("User[  type= verified=true]");
        scheduler.booking.BookingObserver bookingObserver22 = null;
        bookingManager0.unregister(bookingObserver22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
    }

    @Test
    public void test207() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test207");
        scheduler.strategy.StudentPricingStrategy studentPricingStrategy0 = new scheduler.strategy.StudentPricingStrategy();
        double double1 = studentPricingStrategy0.getHourlyRate();
        double double3 = studentPricingStrategy0.calculateCost(35);
        double double4 = studentPricingStrategy0.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double1 + "' != '" + 20.0d + "'", double1 == 20.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double3 + "' != '" + 700.0d + "'", double3 == 700.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 20.0d + "'", double4 == 20.0d);
    }

    @Test
    public void test208() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test208");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList18 = inMemoryBookingRepository17.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy24 = null;
        scheduler.model.Booking booking25 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy24);
        scheduler.strategy.PricingStrategy pricingStrategy26 = null;
        booking25.setPricingStrategy(pricingStrategy26);
        java.lang.String str28 = booking25.toString();
        inMemoryBookingRepository17.save(booking25);
        inMemoryBookingRepository3.save(booking25);
        scheduler.rules.NoOverlapRule noOverlapRule31 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy37 = null;
        scheduler.model.Booking booking38 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy37);
        scheduler.booking.BookingManager bookingManager39 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList40 = bookingManager39.getBookings();
        boolean boolean41 = noOverlapRule31.isAllowed(booking38, bookingList40);
        java.lang.String str42 = booking38.toString();
        inMemoryBookingRepository3.save(booking38);
        scheduler.booking.BookingManager bookingManager44 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver45 = null;
        bookingManager44.unregister(bookingObserver45);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository47 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList48 = inMemoryBookingRepository47.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule49 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy55 = null;
        scheduler.model.Booking booking56 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy55);
        scheduler.booking.BookingManager bookingManager57 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList58 = bookingManager57.getBookings();
        boolean boolean59 = noOverlapRule49.isAllowed(booking56, bookingList58);
        bookingManager44.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository47, (scheduler.rules.IConflictRules) noOverlapRule49);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository61 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule62 = new scheduler.rules.NoOverlapRule();
        bookingManager44.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository61, (scheduler.rules.IConflictRules) noOverlapRule62);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository64 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList65 = inMemoryBookingRepository64.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy71 = null;
        scheduler.model.Booking booking72 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy71);
        scheduler.strategy.PricingStrategy pricingStrategy73 = null;
        booking72.setPricingStrategy(pricingStrategy73);
        java.lang.String str75 = booking72.toString();
        inMemoryBookingRepository64.save(booking72);
        boolean boolean77 = bookingManager44.addBooking(booking72);
        inMemoryBookingRepository3.save(booking72);
        java.util.List<scheduler.model.Booking> bookingList79 = inMemoryBookingRepository3.findAll();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList18);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str28 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str28.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking38);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager39);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str42 + "' != '" + "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]" + "'", str42.equals("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager44);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList48);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager57);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList58);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean59 + "' != '" + true + "'", boolean59 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList65);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str75 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str75.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean77 + "' != '" + true + "'", boolean77 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList79);
    }

    @Test
    public void test209() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test209");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule18 = new scheduler.rules.NoOverlapRule();
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository17, (scheduler.rules.IConflictRules) noOverlapRule18);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository20 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList21 = inMemoryBookingRepository20.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy27 = null;
        scheduler.model.Booking booking28 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy27);
        scheduler.strategy.PricingStrategy pricingStrategy29 = null;
        booking28.setPricingStrategy(pricingStrategy29);
        java.lang.String str31 = booking28.toString();
        inMemoryBookingRepository20.save(booking28);
        boolean boolean33 = bookingManager0.addBooking(booking28);
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy43 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking44 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy43);
        double double45 = staffPricingStrategy43.getHourlyRate();
        scheduler.model.Booking booking46 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy43);
        java.lang.String str47 = booking46.getUserId();
        java.lang.String str48 = booking46.getUserId();
        boolean boolean49 = bookingManager0.addBooking(booking46);
        boolean boolean51 = bookingManager0.cancelBooking("Booking[b-62cf4af2 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str31 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str31.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking44);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double45 + "' != '" + 40.0d + "'", double45 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking46);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str47 + "' != '" + "" + "'", str47.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str48 + "' != '" + "" + "'", str48.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean49 + "' != '" + true + "'", boolean49 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean51 + "' != '" + false + "'", boolean51 == false);
    }

    @Test
    public void test210() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test210");
        scheduler.model.User user6 = new scheduler.model.User("Booking[ room=hi! user= 52-0]", "hi!", "Booking[ room=hi! user= 52-0]", "Booking[ room=hi! user= 52-0]", "", true);
        java.lang.String str7 = user6.getAccountType();
        java.lang.String str8 = user6.toString();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str7.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "User[Booking[ room=hi! user= 52-0] hi! type=Booking[ room=hi! user= 52-0] verified=true]" + "'", str8.equals("User[Booking[ room=hi! user= 52-0] hi! type=Booking[ room=hi! user= 52-0] verified=true]"));
    }

    @Test
    public void test211() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test211");
        scheduler.model.TimeSlot timeSlot2 = new scheduler.model.TimeSlot((-1), 50);
        java.lang.String str3 = timeSlot2.toString();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "-1-50" + "'", str3.equals("-1-50"));
    }

    @Test
    public void test212() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test212");
        scheduler.strategy.FacultyPricingStrategy facultyPricingStrategy0 = new scheduler.strategy.FacultyPricingStrategy();
        double double2 = facultyPricingStrategy0.calculateCost(1);
        double double4 = facultyPricingStrategy0.calculateCost((int) (byte) 1);
        double double5 = facultyPricingStrategy0.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 30.0d + "'", double2 == 30.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 30.0d + "'", double4 == 30.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double5 + "' != '" + 30.0d + "'", double5 == 30.0d);
    }

    @Test
    public void test213() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test213");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        boolean boolean7 = room5.isBookable();
        java.lang.String str8 = room5.toString();
        java.lang.String str9 = room5.getStatus();
        java.lang.String str10 = room5.getId();
        int int11 = room5.getCapacity();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str8.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "35-100" + "'", str9.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str10.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 10 + "'", int11 == 10);
    }

    @Test
    public void test214() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test214");
        scheduler.strategy.StudentPricingStrategy studentPricingStrategy0 = new scheduler.strategy.StudentPricingStrategy();
        double double1 = studentPricingStrategy0.getHourlyRate();
        double double3 = studentPricingStrategy0.calculateCost(50);
        double double4 = studentPricingStrategy0.getHourlyRate();
        double double5 = studentPricingStrategy0.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double1 + "' != '" + 20.0d + "'", double1 == 20.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double3 + "' != '" + 1000.0d + "'", double3 == 1000.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 20.0d + "'", double4 == 20.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double5 + "' != '" + 20.0d + "'", double5 == 20.0d);
    }

    @Test
    public void test215() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test215");
        scheduler.model.User user6 = new scheduler.model.User("Booking[ room=hi! user= 52-0]", "hi!", "Booking[ room=hi! user= 52-0]", "Booking[ room=hi! user= 52-0]", "", true);
        java.lang.String str7 = user6.getAccountType();
        java.lang.String str8 = user6.getOrgOrStudentId();
        scheduler.strategy.PricingStrategy pricingStrategy9 = user6.getPricingStrategy();
        java.lang.String str10 = user6.getId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str7.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "" + "'", str8.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy9);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str10.equals("Booking[ room=hi! user= 52-0]"));
    }

    @Test
    public void test216() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test216");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        java.util.List<scheduler.model.Booking> bookingList17 = inMemoryBookingRepository3.findAll();
        inMemoryBookingRepository3.delete("hi!");
        scheduler.strategy.PricingStrategy pricingStrategy25 = null;
        scheduler.model.Booking booking26 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy25);
        int int27 = booking26.getEndHour();
        java.lang.String str28 = booking26.getRoomId();
        java.lang.String str29 = booking26.getId();
        inMemoryBookingRepository3.save(booking26);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking26);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int27 + "' != '" + (-1) + "'", int27 == (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str28 + "' != '" + "hi!" + "'", str28.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str29 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str29.equals("Booking[ room=hi! user= 52-0]"));
    }

    @Test
    public void test217() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test217");
        scheduler.rules.NoOverlapRule noOverlapRule0 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository1 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList2 = inMemoryBookingRepository1.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy8 = null;
        scheduler.model.Booking booking9 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy8);
        scheduler.strategy.PricingStrategy pricingStrategy10 = null;
        booking9.setPricingStrategy(pricingStrategy10);
        java.lang.String str12 = booking9.toString();
        inMemoryBookingRepository1.save(booking9);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository14 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList15 = inMemoryBookingRepository14.findAll();
        boolean boolean16 = noOverlapRule0.isAllowed(booking9, bookingList15);
        scheduler.rules.NoOverlapRule noOverlapRule17 = new scheduler.rules.NoOverlapRule();
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository18 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList19 = inMemoryBookingRepository18.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy25 = null;
        scheduler.model.Booking booking26 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy25);
        scheduler.strategy.PricingStrategy pricingStrategy27 = null;
        booking26.setPricingStrategy(pricingStrategy27);
        java.lang.String str29 = booking26.toString();
        inMemoryBookingRepository18.save(booking26);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository31 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList32 = inMemoryBookingRepository31.findAll();
        boolean boolean33 = noOverlapRule17.isAllowed(booking26, bookingList32);
        scheduler.rules.NoOverlapRule noOverlapRule34 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy40 = null;
        scheduler.model.Booking booking41 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy40);
        scheduler.booking.BookingManager bookingManager42 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList43 = bookingManager42.getBookings();
        boolean boolean44 = noOverlapRule34.isAllowed(booking41, bookingList43);
        boolean boolean45 = noOverlapRule0.isAllowed(booking26, bookingList43);
        scheduler.strategy.PricingStrategy pricingStrategy51 = null;
        scheduler.model.Booking booking52 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy51);
        int int53 = booking52.getEndHour();
        scheduler.booking.BookingManager bookingManager54 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver55 = null;
        bookingManager54.register(bookingObserver55);
        scheduler.model.Booking booking58 = bookingManager54.findById("hi!");
        java.util.List<scheduler.model.Booking> bookingList59 = bookingManager54.getBookings();
        boolean boolean60 = noOverlapRule0.isAllowed(booking52, bookingList59);
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy71 = new scheduler.strategy.PartnerPricingStrategy();
        double double73 = partnerPricingStrategy71.calculateCost((int) '4');
        double double75 = partnerPricingStrategy71.calculateCost((int) (byte) -1);
        scheduler.model.Booking booking76 = scheduler.model.BookingFactory.createBooking("hi!", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) '#', (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy71);
        scheduler.model.Booking booking77 = scheduler.model.BookingFactory.createBooking("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]", "Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]", "User[  type= verified=true]", 10, 35, (scheduler.strategy.PricingStrategy) partnerPricingStrategy71);
        java.lang.String str78 = booking77.getRoomId();
        scheduler.booking.BookingManager bookingManager79 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver80 = null;
        bookingManager79.unregister(bookingObserver80);
        bookingManager79.notifyObservers();
        scheduler.booking.BookingObserver bookingObserver83 = null;
        bookingManager79.register(bookingObserver83);
        scheduler.booking.BookingObserver bookingObserver85 = null;
        bookingManager79.register(bookingObserver85);
        java.util.List<scheduler.model.Booking> bookingList87 = bookingManager79.getBookings();
        boolean boolean88 = noOverlapRule0.isAllowed(booking77, bookingList87);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList2);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str12.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList15);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean16 + "' != '" + true + "'", boolean16 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList19);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str29 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str29.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList32);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean33 + "' != '" + true + "'", boolean33 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking41);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager42);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList43);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean44 + "' != '" + true + "'", boolean44 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean45 + "' != '" + true + "'", boolean45 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking52);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int53 + "' != '" + (-1) + "'", int53 == (-1));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager54);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNull(booking58);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList59);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean60 + "' != '" + true + "'", boolean60 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double73 + "' != '" + 2600.0d + "'", double73 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double75 + "' != '" + (-50.0d) + "'", double75 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking76);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking77);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str78 + "' != '" + "Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]" + "'", str78.equals("Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager79);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList87);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean88 + "' != '" + true + "'", boolean88 == true);
    }

    @Test
    public void test218() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test218");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy9 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking10 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy9);
        double double11 = staffPricingStrategy9.getHourlyRate();
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy9);
        java.lang.String str13 = booking12.getUserId();
        java.lang.String str14 = booking12.getUserId();
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy20 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking21 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy20);
        double double22 = staffPricingStrategy20.getHourlyRate();
        booking12.setPricingStrategy((scheduler.strategy.PricingStrategy) staffPricingStrategy20);
        java.lang.String str24 = booking12.getId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 40.0d + "'", double11 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "" + "'", str13.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str14 + "' != '" + "" + "'", str14.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking21);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double22 + "' != '" + 40.0d + "'", double22 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertTrue("'" + str24 + "' != '" + "b-126dd492" + "'", str24.equals("b-126dd492"));
    }

    @Test
    public void test219() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test219");
        scheduler.strategy.FacultyPricingStrategy facultyPricingStrategy0 = new scheduler.strategy.FacultyPricingStrategy();
        double double2 = facultyPricingStrategy0.calculateCost(1);
        double double3 = facultyPricingStrategy0.getHourlyRate();
        double double5 = facultyPricingStrategy0.calculateCost((int) (short) -1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 30.0d + "'", double2 == 30.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double3 + "' != '" + 30.0d + "'", double3 == 30.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double5 + "' != '" + (-30.0d) + "'", double5 == (-30.0d));
    }

    @Test
    public void test220() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test220");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getOrgOrStudentId();
        java.lang.String str9 = user6.toString();
        java.lang.String str10 = user6.toString();
        int int11 = user6.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "" + "'", str8.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "User[  type= verified=true]" + "'", str9.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "User[  type= verified=true]" + "'", str10.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int11 + "' != '" + 50 + "'", int11 == 50);
    }

    @Test
    public void test221() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test221");
        scheduler.strategy.FacultyPricingStrategy facultyPricingStrategy0 = new scheduler.strategy.FacultyPricingStrategy();
        double double2 = facultyPricingStrategy0.calculateCost(1);
        double double4 = facultyPricingStrategy0.calculateCost((int) (byte) 1);
        double double6 = facultyPricingStrategy0.calculateCost((int) (byte) 10);
        double double8 = facultyPricingStrategy0.calculateCost(0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double2 + "' != '" + 30.0d + "'", double2 == 30.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double4 + "' != '" + 30.0d + "'", double4 == 30.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double6 + "' != '" + 300.0d + "'", double6 == 300.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double8 + "' != '" + 0.0d + "'", double8 == 0.0d);
    }

    @Test
    public void test222() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test222");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        java.util.List<scheduler.model.Booking> bookingList17 = inMemoryBookingRepository3.findAll();
        inMemoryBookingRepository3.delete("hi!");
        java.util.List<scheduler.model.Booking> bookingList20 = inMemoryBookingRepository3.findAll();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList20);
    }

    @Test
    public void test223() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test223");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.getStatus();
        java.lang.String str7 = room5.getBuilding();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "35-100" + "'", str6.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "hi!" + "'", str7.equals("hi!"));
    }

    @Test
    public void test224() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test224");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList18 = inMemoryBookingRepository17.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy24 = null;
        scheduler.model.Booking booking25 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy24);
        scheduler.strategy.PricingStrategy pricingStrategy26 = null;
        booking25.setPricingStrategy(pricingStrategy26);
        java.lang.String str28 = booking25.toString();
        inMemoryBookingRepository17.save(booking25);
        inMemoryBookingRepository3.save(booking25);
        scheduler.rules.NoOverlapRule noOverlapRule31 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy37 = null;
        scheduler.model.Booking booking38 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy37);
        scheduler.booking.BookingManager bookingManager39 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList40 = bookingManager39.getBookings();
        boolean boolean41 = noOverlapRule31.isAllowed(booking38, bookingList40);
        java.lang.String str42 = booking38.toString();
        inMemoryBookingRepository3.save(booking38);
        // The following exception was thrown during execution in test generation
        try {
            double double44 = booking38.getUpfrontDeposit();
            org.junit.Assert.fail("Expected exception of type java.lang.NullPointerException; message: Cannot invoke \"scheduler.strategy.PricingStrategy.getHourlyRate()\" because \"this.pricingStrategy\" is null");
        } catch (java.lang.NullPointerException e) {
        // Expected exception.
        }
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList18);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str28 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str28.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking38);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager39);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str42 + "' != '" + "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]" + "'", str42.equals("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]"));
    }

    @Test
    public void test225() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test225");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        int int7 = room5.getCapacity();
        java.lang.String str8 = room5.getId();
        java.lang.String str9 = room5.getBuilding();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 10 + "'", int7 == 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str8.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "hi!" + "'", str9.equals("hi!"));
    }

    @Test
    public void test226() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test226");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList18 = inMemoryBookingRepository17.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy24 = null;
        scheduler.model.Booking booking25 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy24);
        scheduler.strategy.PricingStrategy pricingStrategy26 = null;
        booking25.setPricingStrategy(pricingStrategy26);
        java.lang.String str28 = booking25.toString();
        inMemoryBookingRepository17.save(booking25);
        inMemoryBookingRepository3.save(booking25);
        scheduler.rules.NoOverlapRule noOverlapRule31 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy37 = null;
        scheduler.model.Booking booking38 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy37);
        scheduler.booking.BookingManager bookingManager39 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList40 = bookingManager39.getBookings();
        boolean boolean41 = noOverlapRule31.isAllowed(booking38, bookingList40);
        java.lang.String str42 = booking38.toString();
        inMemoryBookingRepository3.save(booking38);
        scheduler.booking.BookingManager bookingManager44 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver45 = null;
        bookingManager44.unregister(bookingObserver45);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository47 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList48 = inMemoryBookingRepository47.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule49 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy55 = null;
        scheduler.model.Booking booking56 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy55);
        scheduler.booking.BookingManager bookingManager57 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList58 = bookingManager57.getBookings();
        boolean boolean59 = noOverlapRule49.isAllowed(booking56, bookingList58);
        bookingManager44.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository47, (scheduler.rules.IConflictRules) noOverlapRule49);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository61 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule62 = new scheduler.rules.NoOverlapRule();
        bookingManager44.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository61, (scheduler.rules.IConflictRules) noOverlapRule62);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository64 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList65 = inMemoryBookingRepository64.findAll();
        scheduler.strategy.PricingStrategy pricingStrategy71 = null;
        scheduler.model.Booking booking72 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy71);
        scheduler.strategy.PricingStrategy pricingStrategy73 = null;
        booking72.setPricingStrategy(pricingStrategy73);
        java.lang.String str75 = booking72.toString();
        inMemoryBookingRepository64.save(booking72);
        boolean boolean77 = bookingManager44.addBooking(booking72);
        inMemoryBookingRepository3.save(booking72);
        scheduler.strategy.PricingStrategy pricingStrategy84 = null;
        scheduler.model.Booking booking85 = new scheduler.model.Booking("", "hi!", "", (int) '4', 0, pricingStrategy84);
        scheduler.strategy.PricingStrategy pricingStrategy86 = null;
        booking85.setPricingStrategy(pricingStrategy86);
        inMemoryBookingRepository3.save(booking85);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList18);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str28 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str28.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking38);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager39);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList40);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean41 + "' != '" + true + "'", boolean41 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str42 + "' != '" + "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]" + "'", str42.equals("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager44);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList48);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking56);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager57);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList58);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean59 + "' != '" + true + "'", boolean59 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList65);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str75 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str75.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean77 + "' != '" + true + "'", boolean77 == true);
    }

    @Test
    public void test227() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test227");
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy14 = new scheduler.strategy.PartnerPricingStrategy();
        double double16 = partnerPricingStrategy14.calculateCost((int) '4');
        double double18 = partnerPricingStrategy14.calculateCost((int) (byte) -1);
        scheduler.model.Booking booking19 = scheduler.model.BookingFactory.createBooking("hi!", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) '#', (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy14);
        double double21 = partnerPricingStrategy14.calculateCost((int) (short) -1);
        scheduler.model.Booking booking22 = scheduler.model.BookingFactory.createBooking("Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "Booking[ room=hi! user= 52-0]", 35, (int) (short) 100, (scheduler.strategy.PricingStrategy) partnerPricingStrategy14);
        double double24 = partnerPricingStrategy14.calculateCost(1);
        scheduler.model.Booking booking25 = new scheduler.model.Booking("Booking[b-aa890e84 room=Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100] user= 1-97]", "", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", (int) (short) -1, (int) (short) 100, (scheduler.strategy.PricingStrategy) partnerPricingStrategy14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + 2600.0d + "'", double16 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double18 + "' != '" + (-50.0d) + "'", double18 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking19);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double21 + "' != '" + (-50.0d) + "'", double21 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking22);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double24 + "' != '" + 50.0d + "'", double24 == 50.0d);
    }

    @Test
    public void test228() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test228");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.register(bookingObserver1);
        scheduler.booking.BookingObserver bookingObserver3 = null;
        bookingManager0.unregister(bookingObserver3);
        scheduler.booking.BookingObserver bookingObserver5 = null;
        bookingManager0.unregister(bookingObserver5);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
    }

    @Test
    public void test229() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test229");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy13 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking14 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy13);
        double double15 = staffPricingStrategy13.getHourlyRate();
        scheduler.model.Booking booking16 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy13);
        scheduler.model.Booking booking17 = scheduler.model.BookingFactory.createBooking("hi!", "User[  type= verified=true]", (int) '#', (int) (short) 10, (scheduler.strategy.PricingStrategy) staffPricingStrategy13);
        double double18 = staffPricingStrategy13.getHourlyRate();
        double double19 = staffPricingStrategy13.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double15 + "' != '" + 40.0d + "'", double15 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking16);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double18 + "' != '" + 40.0d + "'", double18 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double19 + "' != '" + 40.0d + "'", double19 == 40.0d);
    }

    @Test
    public void test230() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test230");
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository0 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList1 = inMemoryBookingRepository0.findAll();
        java.util.List<scheduler.model.Booking> bookingList2 = inMemoryBookingRepository0.findAll();
        inMemoryBookingRepository0.delete("b-aa890e84");
        inMemoryBookingRepository0.delete("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]");
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList1);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList2);
    }

    @Test
    public void test231() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test231");
        scheduler.strategy.StudentPricingStrategy studentPricingStrategy5 = new scheduler.strategy.StudentPricingStrategy();
        scheduler.model.Booking booking6 = scheduler.model.BookingFactory.createBooking("User[  type= verified=true]", "hi!", "Booking[b-62cf4af2 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", (-1), (int) (byte) 100, (scheduler.strategy.PricingStrategy) studentPricingStrategy5);
        double double7 = studentPricingStrategy5.getHourlyRate();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking6);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double7 + "' != '" + 20.0d + "'", double7 == 20.0d);
    }

    @Test
    public void test232() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test232");
        scheduler.model.Room room5 = new scheduler.model.Room("Booking[ room=hi! user= 52-0]", "", (int) (byte) 10, "hi!", "35-100");
        java.lang.String str6 = room5.toString();
        boolean boolean7 = room5.isBookable();
        int int8 = room5.getCapacity();
        java.lang.String str9 = room5.getBuilding();
        java.lang.String str10 = room5.getStatus();
        java.lang.String str11 = room5.toString();
        java.lang.String str12 = room5.toString();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str6 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str6.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + false + "'", boolean7 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 10 + "'", int8 == 10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "hi!" + "'", str9.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "35-100" + "'", str10.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str11.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str12.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
    }

    @Test
    public void test233() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test233");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getId();
        java.lang.String str10 = user6.toString();
        java.lang.String str11 = user6.getOrgOrStudentId();
        java.lang.String str12 = user6.getId();
        java.lang.String str13 = user6.getId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "User[  type= verified=true]" + "'", str10.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "" + "'", str11.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "" + "'", str12.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "" + "'", str13.equals(""));
    }

    @Test
    public void test234() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test234");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getId();
        java.lang.String str10 = user6.toString();
        java.lang.String str11 = user6.getOrgOrStudentId();
        java.lang.String str12 = user6.toString();
        java.lang.String str13 = user6.toString();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "User[  type= verified=true]" + "'", str10.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str11 + "' != '" + "" + "'", str11.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "User[  type= verified=true]" + "'", str12.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "User[  type= verified=true]" + "'", str13.equals("User[  type= verified=true]"));
    }

    @Test
    public void test235() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test235");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository17 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule18 = new scheduler.rules.NoOverlapRule();
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository17, (scheduler.rules.IConflictRules) noOverlapRule18);
        boolean boolean21 = bookingManager0.cancelBooking("b-aa890e84");
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository22 = new scheduler.data.InMemoryBookingRepository();
        scheduler.booking.BookingManager bookingManager23 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver24 = null;
        bookingManager23.unregister(bookingObserver24);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository26 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList27 = inMemoryBookingRepository26.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule28 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy34 = null;
        scheduler.model.Booking booking35 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy34);
        scheduler.booking.BookingManager bookingManager36 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList37 = bookingManager36.getBookings();
        boolean boolean38 = noOverlapRule28.isAllowed(booking35, bookingList37);
        bookingManager23.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository26, (scheduler.rules.IConflictRules) noOverlapRule28);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository40 = new scheduler.data.InMemoryBookingRepository();
        scheduler.rules.NoOverlapRule noOverlapRule41 = new scheduler.rules.NoOverlapRule();
        bookingManager23.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository40, (scheduler.rules.IConflictRules) noOverlapRule41);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository22, (scheduler.rules.IConflictRules) noOverlapRule41);
        bookingManager0.notifyObservers();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean21 + "' != '" + false + "'", boolean21 == false);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager23);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList27);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager36);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList37);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean38 + "' != '" + true + "'", boolean38 == true);
    }

    @Test
    public void test236() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test236");
        scheduler.model.TimeSlot timeSlot2 = new scheduler.model.TimeSlot((int) '#', (int) (short) 100);
        java.lang.String str3 = timeSlot2.toString();
        java.lang.String str4 = timeSlot2.toString();
        int int5 = timeSlot2.getEndHour();
        int int6 = timeSlot2.getEndHour();
        int int7 = timeSlot2.getStartHour();
        int int8 = timeSlot2.getEndHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str3 + "' != '" + "35-100" + "'", str3.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str4 + "' != '" + "35-100" + "'", str4.equals("35-100"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int5 + "' != '" + 100 + "'", int5 == 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int6 + "' != '" + 100 + "'", int6 == 100);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 35 + "'", int7 == 35);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 100 + "'", int8 == 100);
    }

    @Test
    public void test237() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test237");
        // The following exception was thrown during execution in test generation
        try {
            scheduler.model.TimeSlot timeSlot2 = new scheduler.model.TimeSlot((int) ' ', (int) (byte) 10);
            org.junit.Assert.fail("Expected exception of type java.lang.IllegalArgumentException; message: endHour must be after startHour (got 32-10)");
        } catch (java.lang.IllegalArgumentException e) {
        // Expected exception.
        }
    }

    @Test
    public void test238() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test238");
        scheduler.model.User user6 = new scheduler.model.User("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "35-100", "35-100", true);
        int int7 = user6.getHourlyRate();
        boolean boolean8 = user6.isVerified();
        java.lang.String str9 = user6.getId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int7 + "' != '" + 50 + "'", int7 == 50);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean8 + "' != '" + true + "'", boolean8 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]" + "'", str9.equals("Room[Booking[ room=hi! user= 52-0]  cap=10 hi! status=35-100]"));
    }

    @Test
    public void test239() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test239");
        scheduler.strategy.PartnerPricingStrategy partnerPricingStrategy9 = new scheduler.strategy.PartnerPricingStrategy();
        double double11 = partnerPricingStrategy9.calculateCost((int) '4');
        double double13 = partnerPricingStrategy9.calculateCost((int) (byte) -1);
        scheduler.model.Booking booking14 = scheduler.model.BookingFactory.createBooking("hi!", "Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) '#', (-1), (scheduler.strategy.PricingStrategy) partnerPricingStrategy9);
        double double16 = partnerPricingStrategy9.calculateCost((int) (short) -1);
        scheduler.model.Booking booking17 = scheduler.model.BookingFactory.createBooking("Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "Booking[ room=hi! user= 52-0]", 35, (int) (short) 100, (scheduler.strategy.PricingStrategy) partnerPricingStrategy9);
        java.lang.String str18 = booking17.getUserId();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 2600.0d + "'", double11 == 2600.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double13 + "' != '" + (-50.0d) + "'", double13 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + (-50.0d) + "'", double16 == (-50.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking17);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str18 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str18.equals("Booking[ room=hi! user= 52-0]"));
    }

    @Test
    public void test240() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test240");
        scheduler.model.User user11 = new scheduler.model.User("Booking[ room=hi! user= 52-0]", "hi!", "Booking[ room=hi! user= 52-0]", "Booking[ room=hi! user= 52-0]", "", true);
        java.lang.String str12 = user11.getAccountType();
        java.lang.String str13 = user11.getOrgOrStudentId();
        scheduler.strategy.PricingStrategy pricingStrategy14 = user11.getPricingStrategy();
        scheduler.model.Booking booking15 = new scheduler.model.Booking("", "Booking[b-fb3963da room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]", "Booking[b-f6e85a35 room=hi! user=User[  type= verified=true] 35-10]", 100, 0, pricingStrategy14);
        double double16 = booking15.calculateTotalCost();
        int int17 = booking15.getEndHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str12 + "' != '" + "Booking[ room=hi! user= 52-0]" + "'", str12.equals("Booking[ room=hi! user= 52-0]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "" + "'", str13.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double16 + "' != '" + (-5000.0d) + "'", double16 == (-5000.0d));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int17 + "' != '" + 0 + "'", int17 == 0);
    }

    @Test
    public void test241() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test241");
        scheduler.strategy.StaffPricingStrategy staffPricingStrategy9 = new scheduler.strategy.StaffPricingStrategy();
        scheduler.model.Booking booking10 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "Booking[ room=hi! user= 52-0]", "hi!", (int) 'a', (int) '4', (scheduler.strategy.PricingStrategy) staffPricingStrategy9);
        double double11 = staffPricingStrategy9.getHourlyRate();
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1]", "", (int) (short) 1, 35, (scheduler.strategy.PricingStrategy) staffPricingStrategy9);
        java.lang.String str13 = booking12.getUserId();
        java.lang.String str14 = booking12.toString();
        int int15 = booking12.getStartHour();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking10);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + double11 + "' != '" + 40.0d + "'", double11 == 40.0d);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str13 + "' != '" + "" + "'", str13.equals(""));
        // Regression assertion (captures the current behavior of the code)
// flaky:         org.junit.Assert.assertTrue("'" + str14 + "' != '" + "Booking[b-1c57a721 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]" + "'", str14.equals("Booking[b-1c57a721 room=Booking[Booking[ room=hi! user= 52-0] room=hi! user= -1--1] user= 1-35]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + int15 + "' != '" + 1 + "'", int15 == 1);
    }

    @Test
    public void test242() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test242");
        scheduler.booking.BookingManager bookingManager0 = scheduler.booking.BookingManager.getInstance();
        scheduler.booking.BookingObserver bookingObserver1 = null;
        bookingManager0.unregister(bookingObserver1);
        scheduler.data.InMemoryBookingRepository inMemoryBookingRepository3 = new scheduler.data.InMemoryBookingRepository();
        java.util.List<scheduler.model.Booking> bookingList4 = inMemoryBookingRepository3.findAll();
        scheduler.rules.NoOverlapRule noOverlapRule5 = new scheduler.rules.NoOverlapRule();
        scheduler.strategy.PricingStrategy pricingStrategy11 = null;
        scheduler.model.Booking booking12 = scheduler.model.BookingFactory.createBooking("Booking[ room=hi! user= 52-0]", "hi!", "", (int) (short) -1, (int) (byte) -1, pricingStrategy11);
        scheduler.booking.BookingManager bookingManager13 = scheduler.booking.BookingManager.getInstance();
        java.util.List<scheduler.model.Booking> bookingList14 = bookingManager13.getBookings();
        boolean boolean15 = noOverlapRule5.isAllowed(booking12, bookingList14);
        bookingManager0.initialize((scheduler.data.IBookingRepository) inMemoryBookingRepository3, (scheduler.rules.IConflictRules) noOverlapRule5);
        inMemoryBookingRepository3.delete("");
        java.util.List<scheduler.model.Booking> bookingList19 = inMemoryBookingRepository3.findAll();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager0);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList4);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(booking12);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingManager13);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList14);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + boolean15 + "' != '" + true + "'", boolean15 == true);
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(bookingList19);
    }

    @Test
    public void test243() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest0.test243");
        scheduler.model.User user6 = new scheduler.model.User("", "", "hi!", "", "", true);
        java.lang.String str7 = user6.getId();
        java.lang.String str8 = user6.getPassword();
        java.lang.String str9 = user6.getAccountType();
        java.lang.String str10 = user6.toString();
        scheduler.strategy.PricingStrategy pricingStrategy11 = user6.getPricingStrategy();
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str7 + "' != '" + "" + "'", str7.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str8 + "' != '" + "hi!" + "'", str8.equals("hi!"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str9 + "' != '" + "" + "'", str9.equals(""));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertTrue("'" + str10 + "' != '" + "User[  type= verified=true]" + "'", str10.equals("User[  type= verified=true]"));
        // Regression assertion (captures the current behavior of the code)
        org.junit.Assert.assertNotNull(pricingStrategy11);
    }
}
