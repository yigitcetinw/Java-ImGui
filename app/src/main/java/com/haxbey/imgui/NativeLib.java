package com.haxbey.imgui;

public class NativeLib {
    static {
        System.loadLibrary("native-lib");
    }

    public static native void startImGui();
}
