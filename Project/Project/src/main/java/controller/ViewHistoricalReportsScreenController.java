package controller;

import javafx.fxml.FXML;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ValueAxis;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ViewHistoricalReportsScreenController extends DialogScreenController {

    @FXML
    private LineChart<Number, Number> virusPPMChart;
    @FXML
    private LineChart<Number, Number> contaminantPPMChart;

    private class DateAxis extends Axis<LocalDateTime> {

        private int year;

        /**
         * This calculates the upper and lower bound based on the data provided to invalidateRange() method. This must not
         * effect the state of the axis, changing any properties of the axis. Any results of the auto-ranging should be
         * returned in the range object. This will we passed to setRange() if it has been decided to adopt this range for
         * this axis.
         *
         * @param length The length of the axis in screen coordinates
         * @return Range information, this is implementation dependent
         */
        @Override
        protected Object autoRange(double length) {
            return year;
        }

        /**
         * Called to set the current axis range to the given range. If isAnimating() is true then this method should
         * animate the range to the new range.
         *
         * @param range   A range object returned from autoRange()
         * @param animate If true animate the change in range
         */
        @Override
        protected void setRange(Object range, boolean animate) {
            // ???????? TODO
        }

        /**
         * Called to get the current axis range.
         *
         * @return A range object that can be passed to setRange() and calculateTickValues()
         */
        @Override
        protected Object getRange() {
            return year;
        }

        /**
         * Get the display position of the zero line along this axis.
         *
         * @return display position or Double.NaN if zero is not in current range;
         */
        @Override
        public double getZeroPosition() {
            // ?????? TODO
            return 0;
        }

        /**
         * Get the display position along this axis for a given value.
         * If the value is not in the current range, the returned value will be an extrapolation of the display
         * position.
         * <p>
         * If the value is not valid for this Axis and the axis cannot display such value in any range,
         * Double.NaN is returned
         *
         * @param value The data value to work out display position for
         * @return display position or Double.NaN if value not valid
         */
        @Override
        public double getDisplayPosition(LocalDateTime value) {
            double val = toNumericValue(value);
            // TODO
        }

        /**
         * Get the data value for the given display position on this axis. If the axis
         * is a CategoryAxis this will be the nearest value.
         *
         * @param displayPosition A pixel position on this axis
         * @return the nearest data value to the given pixel position or
         * null if not on axis;
         */
        @Override
        public LocalDateTime getValueForDisplay(double displayPosition) {
            return null;
        }

        /**
         * Checks if the given value is plottable on this axis
         *
         * @param value The value to check if its on axis
         * @return true if the given value is plottable on this axis
         */
        @Override
        public boolean isValueOnAxis(LocalDateTime value) {
            return (value.getYear() == year);
        }

        /**
         * All axis values must be representable by some numeric value. This gets the numeric value for a given data value.
         *
         * @param value The data value to convert
         * @return Numeric value for the given data value
         */
        @Override
        public double toNumericValue(LocalDateTime value) {
            int val = value.getDayOfMonth();
            for (int i = 1; i < value.getMonthValue(); i++) {
                val += (year % 4 == 0 ? Month.of(i).maxLength() : Month.of(i).minLength());
            }
            return val;
        }

        /**
         * All axis values must be representable by some numeric value. This gets the data value for a given numeric value.
         *
         * @param value The numeric value to convert
         * @return Data value for given numeric value
         */
        @Override
        public LocalDateTime toRealValue(double value) {
            int val = 0;
            int i = 0;
            int yearReduce = 0;
            while (value < 0) {
                value += (year-yearReduce-1 % 4 == 0 ? 366 : 365);
                yearReduce++;
            }
            while (value > val) {
                int add = (year-yearReduce+(i/12) % 4 == 0 ? Month.of((i%12)+1).maxLength() : Month.of((i%12)+1).minLength());
                if (val + add > value) {
                    double reduction = value-(int)value;
                    double secondReduction = (reduction*24)-(int)(reduction*24);
                    return LocalDateTime.of(year-yearReduce+(i/12), Month.of((i%12)+1), ((int)value)-val,
                            (int)(reduction*24), (int)(secondReduction*60));
                } else {
                    val += add;
                    i++;
                }
            }
            return null;
        }

        /**
         * Calculate a list of all the data values for each tick mark in range
         *
         * @param length The length of the axis in display units
         * @param range  A range object returned from autoRange()
         * @return A list of tick marks that fit along the axis if it was the given length
         */
        @Override
        protected List<LocalDateTime> calculateTickValues(double length, Object range) {
            List<LocalDateTime> ticks = new ArrayList<>();
            for (int i = 1; i <= 12; i++) {
                Month m = Month.of(i);
                ticks.add(LocalDateTime.of((int)range, m, ((int)range % 4 == 0 ? m.maxLength() : m.minLength()) / 2, 0, 0));
            }
            return ticks;
        }

        /**
         * Get the string label name for a tick mark with the given value
         *
         * @param value The value to format into a tick label string
         * @return A formatted string for the given value
         */
        @Override
        protected String getTickMarkLabel(LocalDateTime value) {
            return value.getMonth().toString();
        }
    }

    public void init() {
        DateAxis xaxis = new DateAxis();
    }
}
