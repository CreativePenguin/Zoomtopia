package com.stuypulse.stuylib.input.keyboard.robot;

import com.stuypulse.stuylib.input.keyboard.NetKeyboardInfo;
import com.stuypulse.stuylib.network.NetworkTableWrapper;

/**
 * This class lets you recieve keyboard
 * presses from a computer on the robot
 * 
 * @author Sam (sam.belliveau@gmail.com)
 */

public class NetKeyboard {

    /**
     * Table where key information is stored
     */
    private NetworkTableWrapper mKeyboardTable;

    /**
     * Creates NetworkKeyboard on custom table
     * @param table
     */
    public NetKeyboard(int port) {
        mKeyboardTable = new NetworkTableWrapper(NetKeyboardInfo.getTabelName(port));
    }

    /**
     * Gets Key Info
     * @param key name of key
     * @return if key is pressed
     */
    public boolean isKeyPressed(String key) {
        return mKeyboardTable.getBoolean(NetKeyboardInfo.sanatize(key));
    }
}