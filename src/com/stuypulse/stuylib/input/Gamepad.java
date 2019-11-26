package com.stuypulse.stuylib.input;

import com.stuypulse.stuylib.input.LambdaButton;

/**
 * An class for using gamepads with different interfaces. You can
 * implement this class in another file, and then use it with a standard
 * interface.
 * 
 * Any unimplemented buttons will never be triggered, so if a certain controller
 * is missing one, dont worry about it.
 * 
 * The button type that is used in OI.java is automatically generated by this
 * class, as long as you implement the getRaw...() function, the get...()
 * function will work.
 * 
 * This class does not come with a constructor because by itself, the class does
 * not do anything. You need to extend this class inorder to use it.
 * 
 * @author Sam (sam.belliveau@gmail.com)
 */

public class Gamepad {

    /*******************************/
    /*** IMPLEMENTABLE FUNCTIONS ***/
    /*******************************/

    // Left Stick //
    public double getLeftX()    { return 0.0; }
    public double getLeftY()    { return 0.0; }

    // Right Stick //
    public double getRightX()   { return 0.0; }
    public double getRightY()   { return 0.0; }

    // D-Pad //
    public boolean getRawDPadUp()       { return false; }
    public boolean getRawDPadDown()     { return false; }
    public boolean getRawDPadLeft()     { return false; }
    public boolean getRawDPadRight()    { return false; }

    // Bumpers //
    public boolean getRawLeftBumper()   { return false; }
    public boolean getRawRightBumper()  { return false; }
    
    // Triggers //
    public double getRawLeftTriggerAxis()   { return 0.0; }
    public double getRawRightTriggerAxis()  { return 0.0; }

    // Face Buttons //
    public boolean getRawLeftButton()   { return false; }
    public boolean getRawRightButton()  { return false; }
    public boolean getRawTopButton()    { return false; }
    public boolean getRawBottomButton() { return false; }

    // Start / Select / Option //
    public boolean getRawSelectButton() { return false; }
    public boolean getRawStartButton()  { return false; }
    public boolean getRawOptionButton() { return false; }
    
    // Analog Stick Buttons // 
    public boolean getRawLeftAnalogButton()     { return false; }
    public boolean getRawRightAnalogButton()    { return false; }

    // Rumble //
    public void setRumble(double intensity)     { return; }

    
    /**************************************************/
    /*** BUTTONS BASED OFF OF IMPLEMENTED FUNCTIONS ***/
    /**************************************************/

    // D-Pad //
    public final LambdaButton getDPadUp()       { return new LambdaButton(() -> this.getRawDPadUp()); }
    public final LambdaButton getDPadDown()     { return new LambdaButton(() -> this.getRawDPadDown()); }
    public final LambdaButton getDPadLeft()     { return new LambdaButton(() -> this.getRawDPadLeft()); }
    public final LambdaButton getDPadRight()    { return new LambdaButton(() -> this.getRawDPadRight()); }

    // Bumpers //
    public final LambdaButton getLeftBumper()   { return new LambdaButton(() -> this.getRawLeftBumper()); }
    public final LambdaButton getRightBumper()  { return new LambdaButton(() -> this.getRawRightBumper()); }

    // Triggers //
    protected static final double TRIGGER_AXIS_THRESHOLD = 2.0 / 16.0;

    public final boolean getRawLeftTrigger()    { return getRawLeftTriggerAxis() > TRIGGER_AXIS_THRESHOLD; }
    public final LambdaButton getLeftTrigger()  { return new LambdaButton(() -> this.getRawLeftTrigger()); }

    public final boolean getRawRightTrigger()   { return getRawRightTriggerAxis() > TRIGGER_AXIS_THRESHOLD; }
    public final LambdaButton getRightTrigger() { return new LambdaButton(() -> this.getRawRightTrigger()); }

    // Face Buttons // 
    public final LambdaButton getLeftButton()   { return new LambdaButton(() -> this.getRawLeftButton()); }
    public final LambdaButton getRightButton()  { return new LambdaButton(() -> this.getRawRightButton()); }
    public final LambdaButton getTopButton()    { return new LambdaButton(() -> this.getRawTopButton()); }
    public final LambdaButton getBottomButton() { return new LambdaButton(() -> this.getRawBottomButton()); }

    // Select / Start / Option //
    public final LambdaButton getSelectButton() { return new LambdaButton(() -> this.getRawSelectButton()); }
    public final LambdaButton getStartButton()  { return new LambdaButton(() -> this.getRawStartButton()); }
    public final LambdaButton getOptionButton() { return new LambdaButton(() -> this.getRawOptionButton()); }

    // Analog Stick Buttons // 
    public final LambdaButton getLeftAnalogButton()     { return new LambdaButton(() -> this.getRawLeftAnalogButton()); }
    public final LambdaButton getRightAnalogButton()    { return new LambdaButton(() -> this.getRawRightAnalogButton()); }
}
